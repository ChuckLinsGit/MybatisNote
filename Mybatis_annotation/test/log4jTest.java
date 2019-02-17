package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log4jTest {
	private static Logger logger = Logger.getLogger(log4jTest.class);
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("src/log4j.properties");
		logger.fatal("fatal msg");
	}

}
