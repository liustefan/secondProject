package com.bithealth.sdk.config;

import org.apache.commons.pool.impl.GenericObjectPool;

public class BaseCommonClientPoolConfig extends GenericObjectPool.Config{
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxActive() {
		return maxActive;
	}


	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMaxIdle() {
		return maxIdle;
	}


	public void setMaxWait(long maxWait) {
		this.maxWait = maxWait;
	}

	public long getMaxWait() {
		return maxWait;
	}


	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean getTestOnBorrow() {
		return testOnBorrow;
	}
}
