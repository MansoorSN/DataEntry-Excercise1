package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jtester {

	 private static Logger logger = LogManager.getLogger(Log4jtester.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println( "Hello, user!" );
		
		//logger.configure("log4j2.xml");
        logger.trace("We've just greeted the user frm trace!");
        logger.debug("We've just greeted the user frm debug!");
        logger.info("We've just greeted the user frm info!");
        logger.warn("We've just greeted the user! frm warn");
        logger.error("We've just greeted the user frm error!");
        logger.fatal("We've just greeted the user! frm fatal");
		
		
		
	}

}
