package com.bithealth.sdk.client.http;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import com.bithealth.sdk.client.utils.Base64DecoderException;
import com.bithealth.sdk.client.utils.Hex;
 

public class SignUtils {
	/**
	 * Returns the signature algorithm to be used for the provided private key.
	 */
	public static SignatureAlgorithm getSigAlg(PrivateKey key) {
		String algorithm = key.getAlgorithm();
		if ("dsa".equalsIgnoreCase(algorithm)) {
			return SignatureAlgorithm.DSA_SHA1;
		} else if ("rsa".equalsIgnoreCase(algorithm)) {
			return SignatureAlgorithm.RSA_SHA1;
		} else {
			throw new IllegalArgumentException("Unknown algorithm in private key.");
		}
	}

	public static byte[] sign(PrivateKey key, String data, SignatureAlgorithm algorithm) throws GeneralSecurityException {
		Signature signature = Signature.getInstance(algorithm.getJCAName());
		signature.initSign(key);
		signature.update(data.getBytes());
		return signature.sign();
	}

	public static PrivateKey getPrivateKey(String privateKeyString) throws Base64DecoderException, GeneralSecurityException {
		if (privateKeyString == null || privateKeyString.length() == 0) {
			return null;
		}

		KeyFactory fac = KeyFactory.getInstance("RSA");
		byte[] privateKeyBase64 = Hex.decodeHex(privateKeyString.toCharArray());
		EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(privateKeyBase64);
		return fac.generatePrivate(privKeySpec);
	}
}
