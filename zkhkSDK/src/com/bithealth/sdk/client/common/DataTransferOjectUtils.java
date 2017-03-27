package com.bithealth.sdk.  client.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.bithealth.sdk.client.YoushangClientException;
import com.bithealth.sdk.client.utils.PlatformClientUtils;


public class DataTransferOjectUtils {
	public static Object parse(String text) {
		if (text == null || text.length() ==0) {
			return null;
		}
		
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(text.getBytes("UTF-8"));
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(in);
			return parse(doc.getDocumentElement());
		} catch (ParserConfigurationException e) {
			throw new YoushangClientException("parse JSON error", e);
		} catch (UnsupportedEncodingException e) {
			throw new YoushangClientException("parse JSON error", e);
		} catch (SAXException e) {
			throw new YoushangClientException("parse JSON error", e);
		} catch (IOException e) {
			throw new YoushangClientException("parse JSON error", e);
		} finally {
			PlatformClientUtils.close(in);
		}
	}
	
	public static Object parse(Element element) {
		if (element.getNodeName().equals("object") || element.getNodeName().equals("map")) {
			Map<String, Object> object = new LinkedHashMap<String, Object>();

			NodeList nodeList = element.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); ++i) {
				Element entry = (Element) nodeList.item(i);
				String key = entry.getAttribute("key");
				Object value = parse((Element) entry.getFirstChild());
				Object oldValue = object.put(key, value);
				if (oldValue != null) {
					oldValue = null;
				}
			}

			return object;
		}

		if (element.getNodeName().equals("null")) {
			return null;
		}

		if (element.getNodeName().equals("array")) {
			List<Object> list = new ArrayList<Object>();
			NodeList nodeList = element.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); ++i) {
				Element item = (Element) nodeList.item(i);
				list.add(parse(item));
			}
			return list;
		}

		if (element.getNodeName().equals("number")) {
			String text = element.getTextContent().trim();
			BigDecimal decimal = new BigDecimal(text);
			return decimal;
		}

		if (element.getNodeName().equals("string")) {
			return element.getTextContent();
		}

		if (element.getNodeName().equals("date")) {
			long value = Long.parseLong(element.getTextContent().trim());
			return new Date(value);
		}

		throw new RuntimeException("TODO");
	}
	
	public static String output(Object object) throws IOException {
		StringBuffer buf = new StringBuffer();
		output(buf, object);
		return buf.toString();
	}

	@SuppressWarnings("unchecked")
	public static void output(Appendable buf, Object object) throws IOException {
		if (object == null) {
			buf.append("<null/>");
			return;
		}
		
		if (object instanceof Map) {
			buf.append("<map>");
			Map map = (Map) object;
			for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				buf.append("<entry key=\"");
				buf.append(URLEncoder.encode(entry.getKey().toString(), "UTF-8"));
				buf.append("\">");
				output(buf, entry.getValue());
				buf.append("</entry>");
			}
			buf.append("</map>");
			return;
		}
		
		if (object instanceof Iterator) {
			buf.append("<array>");
			Iterator iter = (Iterator) object;
			while (iter.hasNext()) {
				output(buf, iter.next());
			}
			buf.append("</array>");
			return;
		}
		
		if (object instanceof Iterable) {
			buf.append("<array>");
			Iterator iter = ((Iterable) object).iterator();
			while (iter.hasNext()) {
				output(buf, iter.next());
			}
			buf.append("</array>");
			return;
		}
		
		if (object instanceof Number) {
			buf.append("<number>");
			buf.append(object.toString());
			buf.append("</number>");
			return;
		}
		
		if (object instanceof Date) {
			buf.append("<date>");
			buf.append(Long.toString(((Date) object).getTime()));
			buf.append("</date>");
			return;
		}
		
		if (object instanceof String) {
			String str = (String) object;
			buf.append("<string>");

			boolean cdata = false;
			for (char ch : str.toCharArray()) {
				if (ch == '<' || ch == '>') {
					cdata = true;
					break;
				}
			}

			if (cdata) {
				buf.append("<![CDATA[");
				buf.append(str);
				buf.append("]]>");
			} else {
				buf.append(str);
			}

			buf.append("</string>");
			return;
		}
		
		if (object instanceof DataTransferObject) {
			output(buf, ((DataTransferObject) object).toDTO());
			return;
		}
		
		if (object instanceof Throwable) {
			output(buf, toDTO((Throwable) object));
			return;
		}
		
		throw new IOException("not support class " + object.getClass() + ", value : " + object);
	}
	
	public static Map<String, Object> toDTO(Throwable throwable) {
		if (throwable == null) return null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("message", throwable.getMessage());
		map.put("type", throwable.getClass().getName());
		
		List<Object> stackTrace = new ArrayList<Object>();
		for (StackTraceElement element : throwable.getStackTrace()) {
			Map<String, Object> dtoElement = new LinkedHashMap<String, Object>();
			dtoElement.put("className", element.getClassName());
			dtoElement.put("methodName", element.getMethodName());
			dtoElement.put("fileName", element.getFileName());
			dtoElement.put("lineNumber", element.getLineNumber());
			stackTrace.add(dtoElement);
		}
		map.put("stackTrace", stackTrace);
		
		return map;
	}
}
