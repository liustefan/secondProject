package com.bithealth.sdk.  client.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 

import com.bithealth.sdk.client.YoushangClientException;
import com.bithealth.sdk.client.http.SignUtils;
import com.bithealth.sdk.client.http.SignatureAlgorithm;
import com.bithealth.sdk.client.utils.Base64;
import com.bithealth.sdk.client.utils.Hex;
import com.bithealth.sdk.client.utils.PlatformClientUtils;
 

public class PlatformClientService implements PlatformClientServiceMBean, Serializable, Referenceable {
	private static final long serialVersionUID = -493202041993622847L;

	private static Log LOG = LogFactory.getLog(PlatformClientService.class);

	private String url;
	private PrivateKey privateKey;

	private HttpClient httpClient;

	protected AtomicLong invokeCounter = new AtomicLong(0);

	protected AtomicLong invokeSuccessCounter = new AtomicLong(0);

	protected AtomicLong invokeFailedCounter = new AtomicLong(0);

	protected AtomicLong invokeTotalTimespanCounter = new AtomicLong(0);

	protected String vendor;

	protected String application;

	protected Date invokeLastTime;

	public HttpClient getHttpClient() {
		return httpClient;
	}

	public PlatformClientService(String url) {
		this.url = url;

		this.httpClient = new HttpClient();
		this.httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

		loadConfig();
	}

	public String getURL() {
		if (url == null) {
			return null;
		}

		return url.toString();
	}

	public void setURL(String url) {
		this.url = url;
	}

	protected void loadConfig() {
		try {
			String privateKeyString = (String) PlatformClientServiceConfig.getProperties().get("zkhk.platform.service.security.privateKey");
			if (privateKeyString != null && privateKeyString.length() != 0) {
				privateKey = SignUtils.getPrivateKey(privateKeyString);
			}
		} catch (Exception e) {
			LOG.error("load properites error", e);
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	@SuppressWarnings("unchecked")
	public Object invoke(String method, Object args) {
		InputStream in = null;
		long startTime = System.currentTimeMillis();
		try {
			invokeCounter.incrementAndGet();
			invokeLastTime = new Date();

			PrivateKey privateKey = getPrivateKey();

			String dataToSign = String.format("%s %s", method, args);
			SignatureAlgorithm sigAlg = SignUtils.getSigAlg(privateKey);
			byte[] signature = SignUtils.sign(privateKey, dataToSign, sigAlg);
			String encodedSignature = Base64.encode(signature);

			String app = this.application;
			if (app == null || app.length() == 0) {
				app = PlatformClientUtils.getEnvAppName();
			}

			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("vendor", vendor);
			parameters.put("app", app);
			parameters.put("m", method);
			parameters.put("args", DataTransferOjectUtils.output(args));
			parameters.put("sig", encodedSignature);
			parameters.put("sigalg", sigAlg.getAuthSubName());

			PostMethod httpMethod = new PostMethod(url);

			NameValuePair[] data = new NameValuePair[parameters.size()];

			int paramIndex = 0;
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				data[paramIndex] = new NameValuePair(entry.getKey(), entry.getValue());
				paramIndex++;
			}

			httpMethod.setRequestBody(data);

			int statusCode = this.getHttpClient().executeMethod(httpMethod);

			if (statusCode != HttpStatus.SC_OK) {
				throw new YoushangClientException("http server reponse code not OK. " + statusCode);
			}

			in = httpMethod.getResponseBodyAsStream();

			DocumentBuilder docBuilder = newDocumentBuilder();
			Document doc = docBuilder.parse(in);

			Map<String, Object> result = (Map<String, Object>) DataTransferOjectUtils.parse(doc.getDocumentElement());
			String error = (String) result.get("error");
			if (error != null && error.length() != 0) {
				throw new YoushangClientException("invoke method error, method '" + method + "', server error ：" + error);
			}

			invokeSuccessCounter.getAndIncrement();

			return result.get("value");
		} catch (YoushangClientException e) {
			invokeFailedCounter.getAndIncrement();
			throw e;
		} catch (Exception e) {
			invokeFailedCounter.getAndIncrement();
			throw new YoushangClientException("invoke method error, method '" + method + "'", e);
		} finally {
			long timespan = System.currentTimeMillis() - startTime;
			invokeTotalTimespanCounter.getAndAdd(timespan);
		}
	}

	public Date getInvokeLastTime() {
		return invokeLastTime;
	}

	public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 提高解析效率
		builder.setEntityResolver(new EntityResolver() {
			public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
				return new InputSource(new ByteArrayInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes("UTF-8")));
			}
		});
		return builder;
	}

	public long getInvokeCount() {
		return invokeCounter.get();
	}

	public long getInvokeFailedCount() {
		return invokeFailedCounter.get();
	}

	public long getInvokeSuccessCount() {
		return invokeSuccessCounter.get();
	}

	public long getInvokeTotalTimespan() {
		return invokeTotalTimespanCounter.get();
	}

	public Reference getReference() throws NamingException {
		String factoryName = "com.bithealth.sdk.client.common.PlatformClientServiceObjectFactory";
		Reference ref = new Reference(getClass().getName(), factoryName, null);
		ref.add(new StringRefAddr("url", getURL()));
		ref.add(new StringRefAddr("vendor", getVendor()));
		ref.add(new StringRefAddr("application", getApplication()));
		ref.add(new StringRefAddr("privateKey", new String(Hex.encodeHex(getPrivateKey().getEncoded()))));
		return ref;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
}
