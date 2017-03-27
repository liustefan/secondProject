package com.bithealth.sdk.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.net.URLConnection;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <p>
 * IO Utils
 * <p>
 * <p>
 * 金蝶移动互联有限公司版权所有
 * </p>
 * 
 * @author szujobs
 * @created 2007-10-11 下午02:31:24
 * @since 2.1.15
 */
public class IoUtils {
	private static Log LOG = LogFactory.getLog(IoUtils.class);

	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

	public static void close(InputStream x) {
		if (x == null) return;

		try {
			x.close();
		} catch (Exception e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
		}
	}

	public static void close(OutputStream x) {
		if (x == null) return;

		try {
			x.close();
		} catch (Exception e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
		}
	}

	public static void close(Reader x) {
		if (x == null) return;

		try {
			x.close();
		} catch (Exception e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
		}
	}

	public static void close(URLConnection x) {
		if (x == null) return;

		try {
			x.getInputStream().close();
		} catch (Exception _) {

		}

		try {
			x.getOutputStream().close();
		} catch (Exception _) {

		}
	}

	public static void close(Writer x) {
		if (x == null) return;

		try {
			x.close();
		} catch (Exception e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
		}
	}

	public static void close(RandomAccessFile x) {
		if (x == null) return;

		try {
			x.close();
		} catch (Exception e) {
			if (LOG.isErrorEnabled()) LOG.error(e.getMessage(), e);
		}
	}

	public static String readAll(Reader reader) throws IOException {
		int blockSize = 1024;
		char[] block = new char[blockSize];

		StringBuilder buf = new StringBuilder();

		int len;
		while ((len = reader.read(block)) != -1) {
			if (len != 0) buf.append(block, 0, len);
		}

		return buf.toString();
	}

	public static String readAll(File file, String encoding) throws IOException {
		InputStreamReader reader = null;
		try {
			InputStream in = new FileInputStream(file);
			reader = new InputStreamReader(in, encoding);
			return IoUtils.readAll(reader);
		} finally {
			close(reader);
		}
	}

	public static void copy(File srcFile, File destFile) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			copy(in, out);
		} finally {
			close(in);
			close(out);
		}
	}

	public static int copy(InputStream input, OutputStream output) throws IOException {
		long count = copyLarge(input, output);
		if (count > Integer.MAX_VALUE) {
			return -1;
		}
		return (int) count;
	}

	public static long copyLarge(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		long count = 0;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

	/**
	 * 匹配文件路经
	 * 
	 * @param pattern
	 * @param file
	 * @return
	 */
	public static boolean matches(String pattern, String file) {
		if (file != null) file = file.replace('\\', '/');
		String exprPattern = convertToExprPattern(pattern);
		return Pattern.matches(exprPattern, file);
	}

	/**
	 * 匹配文件路径
	 * 
	 * @param pattern
	 * @param file
	 * @return
	 */
	public static boolean matches(Pattern pattern, String file) {
		if (file != null) file = file.replace('\\', '/');
		return pattern.matcher(file).matches();
	}

	/**
	 * 将文件的matchPattern转换为正则表达式Pattern
	 * 
	 * @param filePattern
	 * @return
	 */
	public static String convertToExprPattern(String filePattern) {
		final char[] charArray = filePattern.toCharArray();

		StringBuffer buf = new StringBuffer();

		buf.append("\\Q");
		for (int i = 0; i < charArray.length; ++i) {
			char ch = charArray[i];
			if (ch == '*') {
				buf.append("\\E");
				buf.append(".*");
				buf.append("\\Q");
			} else {
				buf.append(ch);
			}
		}

		buf.append("\\E");

		return buf.toString();
	}

	/**
	 * 删除文件或目录
	 * @param file
	 * @throws IOException
	 */
	public static void delete(File file) throws IOException {
		if (file.isDirectory()) {
			for (File item : file.listFiles()) {
				delete(item);
			}
		}

		boolean success = file.delete();
		if (!success) {
			throw new IOException("delete file '" + file.getPath() + "' failed");
		}
	}

	public static void fixedUTF8File(File file) throws IOException {
		int length = (int) file.length();

		FileInputStream in = null;

		byte[] bytes = new byte[length];
		try {
			in = new FileInputStream(file);
			in.read(bytes, 0, 3);

			if (bytes[0] == (byte) 0xEE && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xFF) return;

			in.read(bytes, 3, length - 3);
		} finally {
			close(in);
		}

		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			writeUTF8FileHead(out);
			out.write(bytes);
		} finally {
			close(out);
		}
	}

	public static void writeUTF8FileHead(FileOutputStream out) throws IOException {
		out.write(0xEF);
		out.write(0xBB);
		out.write(0xBF);
	}
}
