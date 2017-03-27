package com.bithealth.sdk.common.utils;

import com.bithealth.web.Env;
 
 


/**
 * web环境工具类
 * @author jason chai
 */
public abstract class EnvUtils {
	
	/**
	 * 获取当前web环境
	 * @return
	 */
    public static Env getEnv() {
        return threadLocal.get();
    }

    /**
     * 移除当前web环境
     */
    public static void removeEnv() {
        threadLocal.remove();
    }

    private static ThreadLocal<Env> threadLocal = new ThreadLocal<Env>() {
        @Override
        protected Env initialValue() {
            return new Env();
        }
    };

}
