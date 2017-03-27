package com.bithealth.sdk.client.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PlatformClientUtils {
	private static Log LOG = LogFactory.getLog(PlatformClientUtils.class);

	/**
	 * 获得机器的第一个IP地址，忽略VMware虚拟的网卡，忽略127.0.0.1
	 * 
	 * @return
	 */
	public static String getFirstIPAddress() {
		try {
			Set<String> ipv4Addresses = new HashSet<String>();
			Set<String> ipv6Addresses = new HashSet<String>();

			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {

				NetworkInterface item = interfaces.nextElement();

				if (item.getDisplayName().contains("VMware")) continue;

				Enumeration<InetAddress> addresses = item.getInetAddresses();
				while (addresses.hasMoreElements()) {
					while (addresses.hasMoreElements()) {
						InetAddress addr = addresses.nextElement();
						if (addr.isLoopbackAddress()) continue;

						String hostAddress = addr.getHostAddress();
						if (hostAddress.indexOf(':') != -1) {
							ipv6Addresses.add(hostAddress);
						} else {
							ipv4Addresses.add(hostAddress);
						}
					}
				}
			}

			if (ipv4Addresses.size() != 0) return ipv4Addresses.iterator().next();

			if (ipv6Addresses.size() != 0) return ipv6Addresses.iterator().next();

		} catch (SocketException e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
		}

		return null;
	}

	public static void close(Closeable x) {
		if (x == null) return;

		try {
			x.close();
		} catch (Exception e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
		}
	}

	public static String getEnvAppName() {
		final String propertyName = "zkhk-env";

		Properties properties = new Properties();

		InputStream in = null;
		try {
			String propertyFile = System.getProperty(propertyName);
			if (propertyFile == null || propertyFile.length() == 0) {
				propertyFile = "zkhk-env.properties";
			}

			in = PlatformClientUtils.class.getClassLoader().getResourceAsStream(propertyFile);
			if (in == null) {
				in = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertyFile);
			}

			if (in != null) {
				properties.load(in);
			} else {
				if (LOG.isWarnEnabled()) LOG.warn("property file '" + propertyFile + "' not found.");
			}

			return properties.getProperty("zkhk.env.appName");
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
			return null;
		} finally {
			close(in);
		}
	}

	public static void registerJMX(Object mbean, String serviceName) {
		registerJMX(mbean, serviceName, getEnvAppName());
	}

	public static void registerJMX(Object mbean, String serviceName, String appName) {
		try {
			String mbeanName = "com.kingdee.zkhk.platform.service:name=" + serviceName + "-";

			if (appName != null && appName.length() != 0) {
				mbeanName += appName;
			} else {
				mbeanName += System.identityHashCode(mbean);
			}

			ObjectName objectName = new ObjectName(mbeanName);
			MBeanServer mbeanServer = ManagementFactory.getPlatformMBeanServer();
			mbeanServer.registerMBean(mbean, objectName);
		} catch (Exception e) {
			LOG.error("register MBean error", e);
		}
	}
	
    public static List<String> readLines(Reader input) throws IOException {
        BufferedReader reader = new BufferedReader(input);
        List<String> list = new ArrayList<String>();
        String line = reader.readLine();
        while (line != null) {
            list.add(line);
            line = reader.readLine();
        }
        return list;
    }
    
    public static List<String> readLines(InputStream input) throws IOException {
        InputStreamReader reader = new InputStreamReader(input);
        return readLines(reader);
    }
    
    public static List<String> readLines(InputStream input, String encoding) throws IOException {
        InputStreamReader reader = new InputStreamReader(input, encoding);
        return readLines(reader);
    }
    
    public static FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canRead() == false) {
                throw new IOException("File '" + file + "' cannot be read");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        return new FileInputStream(file);
    }
    
    public static List<String> readLines(File file, String encoding) throws IOException {
        InputStream in = null;
        try {
            in = openInputStream(file);
            return readLines(in, encoding);
        } finally {
            close(in);
        }
    }
    
    public static List<String> readLines(File file) throws IOException {
        return readLines(file, null);
    }
}
