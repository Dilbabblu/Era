package com.forsys.revmantra.config;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;
/*
 * AYAR-1801 Added Theread Exception Handler class
 * By Chandra Kota on 05-JAN-2021
 */

@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{
	
	private static final Logger logger = LogManager.getLogger(AsyncExceptionHandler.class);
	
	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... args) {
		
		logger.error("Method Name {} .... {} .... Error Message{}", method.getName(), args, ex.getMessage());
		
	}
}
