package com.forsys.revmantra.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AyaraCustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(AyaraCustomException.class);
	
	/** private static Log logger = LogFactory.getLog(AyaraCustomException.class); */
	public AyaraCustomException(String message) {
		super(message);
		logger.error(message);
	}
	
	
}
