package com.bithealth.sdk.client.pref.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.StringRefAddr;

import com.bithealth.sdk.client.YoushangClientException;
import com.bithealth.sdk.client.pref.Preferences;
import com.bithealth.sdk.client.pref.PreferencesFactory;
import com.bithealth.sdk.client.utils.PlatformClientUtils;
 

public class FileSystemPreferencesFactory implements PreferencesFactory {
	private final String filePath;

	private Map<String, Item> items = new LinkedHashMap<String, Item>();

	public FileSystemPreferencesFactory(String filePath) {
		this.filePath = filePath;

		try {
			load();
		} catch (IOException e) {
			throw new YoushangClientException("load preferences error", e);
		}
	}

	public Reference getReference() throws NamingException {
		String factoryName = "com.bithealth.sdk.client.pref.jndi.JndiRemotePreferencesObjectFactory";
		Reference ref = new Reference(getClass().getName(), factoryName, null);
		ref.add(new StringRefAddr("path", filePath));
		return ref;
	}

	private void load() throws IOException {
		if (filePath.startsWith("http://")) {

			if (filePath.endsWith("zip") || filePath.endsWith("jar")) {
				URL url = new URL(filePath);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.connect();
				InputStream in = null;

				try {
					in = (InputStream) conn.getContent();
					loadZip(in);
					conn.disconnect();
				} finally {
					PlatformClientUtils.close(in);
				}
				return;
			}
		}

		File file = new File(filePath);

		if (file == null) {
			throw new IllegalStateException("file is null");
		}

		if (!file.exists()) {
			throw new IllegalStateException("file not extists");
		}

		if (file.isDirectory()) {
			for (File itemFile : file.listFiles()) {
				if (itemFile.isDirectory()) {
					loadItem(itemFile);
				}
			}
		}

		if (file.isFile() && file.getName().endsWith(".zip")) {
			InputStream in = null;
			try {
				in = new FileInputStream(file);
				loadZip(in);
			} finally {
				PlatformClientUtils.close(in);
			}
		}
	}

	private void loadZip(InputStream in) throws FileNotFoundException, IOException {
		ZipInputStream zipIn = null;
		try {
			zipIn = new ZipInputStream(in);
			for (;;) {
				ZipEntry zipEntry = zipIn.getNextEntry();
				if (zipEntry == null) break;

				String entryName = zipEntry.getName();

				int level = 0;
				for (int i = 0; i < entryName.length(); ++i) {
					char ch = entryName.charAt(i);
					if (ch == '/') {
						level++;
					}
				}

				if (level > 1) {
					continue;
				}

				String itemName = entryName.substring(0, entryName.indexOf('/'));

				if (zipEntry.isDirectory()) {
					Item item = new Item();
					item.name = itemName;
					items.put(item.name, item);

				} else {
					String fileName = entryName.substring(entryName.indexOf('/') + 1);

					Item item = items.get(itemName);

					int size = (int) zipEntry.getSize();
					byte[] bytes = new byte[size];
					int rest = size;
					int len = 0;
					while (rest > 0) {
						len = zipIn.read(bytes, size - rest, rest);
						if (len == -1) {
							break;
						}
						rest -= len;
					}

					ByteArrayInputStream entryIn = null;

					try {
						entryIn = new ByteArrayInputStream(bytes);

						if ("include".equals(fileName)) {
							List<String> lines = PlatformClientUtils.readLines(entryIn, "UTF-8");
							for (String line : lines) {
								if (line != null && line.length() > 0) {
									item.includes.add(line.trim());
								}
							}
						} else if (fileName.endsWith(".properties")) {
							item.properties.load(entryIn);
						}
					} finally {
						PlatformClientUtils.close(entryIn);
					}
				}
			}
		} finally {
			PlatformClientUtils.close(zipIn);
		}
	}

	private void loadItem(File itemDir) throws IOException {
		Item item = new Item();
		for (File file : itemDir.listFiles()) {
			String fileName = file.getName();

			if ("include".equals(fileName)) {
				List<String> lines = PlatformClientUtils.readLines(file, "UTF-8");
				for (String line : lines) {
					if (line != null && line.length() > 0) {
						item.includes.add(line.trim());
					}
				}
			}

			if (file.isFile() && fileName.endsWith(".properties")) {
				FileInputStream in = null;
				try {
					in = new FileInputStream(file);
					item.properties.load(in);
				} finally {
					PlatformClientUtils.close(in);
				}
			}
		}

		items.put(itemDir.getName(), item);
	}

	private static class Item {
		Properties properties = new Properties();
		String name;
		String description;
		List<String> includes = new ArrayList<String>();
	}

	@SuppressWarnings("unchecked")
	private void loadProperties(String name, Map<String, Object> map) {
		Item item = items.get(name);
		if (item == null) {
			return;
		}

		for (Entry entry : item.properties.entrySet()) {
			map.put((String) entry.getKey(), entry.getValue());
		}

		for (String include : item.includes) {
			int index = include.indexOf('!');

			if (index == -1) {
				loadProperties(include, map);
				continue;
			}

			String fileName = include.substring(0, index);
			String extIncludeName = include.substring(index + 1);

			FileSystemPreferencesFactory extFactory = new FileSystemPreferencesFactory(fileName);
			extFactory.loadProperties(extIncludeName, map);
		}
	}

	@SuppressWarnings("unchecked")
	public Preferences getPreferences(String name) {
		Item item = items.get(name);
		if (item == null) {
			return null;
		}

		Preferences pref = new Preferences();

		pref.setName(item.name);
		pref.setDescription(item.description);

		Map<String, Object> map = new HashMap<String, Object>();
		loadProperties(name, map);

		for (Entry entry : map.entrySet()) {
			pref.put((String) entry.getKey(), entry.getValue());
		}

		return pref;
	}
}
