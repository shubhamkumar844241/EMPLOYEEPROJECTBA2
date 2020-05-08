package com.cts.ba2.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//this class used globally 
public class GlobalResource {

	//this is used to get logger of that particular class
	public static Logger getLogger(Class className) {
		
		return LoggerFactory.getLogger(className);
	}
	
}
