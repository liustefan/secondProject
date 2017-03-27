package com.bithealth.sdk.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class KDConfigFileSystem extends KDConfigPropertyImpl {
	public KDConfigFileSystem(String cfgFile) {
		super(cfgFile);
	}

	@Override
	protected void configure() {
		InputStream ins = null;
		try {
			ins = new FileInputStream(configFile);
			pro.load(ins);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getMessage(),e);
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {}
				ins = null;
			}
		}
	}

	private static final Log LOG = LogFactory.getLog(KDConfigFileSystem.class);
}
