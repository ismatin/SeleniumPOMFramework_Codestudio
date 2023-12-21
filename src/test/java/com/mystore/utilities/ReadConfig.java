package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig() {

		prop=new Properties();

		//D:\Eclipse Workspace\SeleniumFrameworkByMam\Configuration\config.properties
		String path=System.getProperty("user.dir")+"//Configuration//config.properties";

		try {

			FileInputStream fis=new FileInputStream(path);
			prop.load(fis);

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


	}

	// Accessing values of baseurl and browser mentioned in config.properties file
	public String getBaseUrl() {
		
		String baseurl=prop.getProperty("baseurl");
		
		if(baseurl!=null) {
			
			return baseurl;
		}
		else {
			
			throw new RuntimeException("Base Url is not specified in config.properties file");
		}
		
		
	}
	
	public String getBrowser() {
		
		String browserName=prop.getProperty("browser");
		if(browserName!=null) {
			
			return browserName;
		}
		else {
			
			throw new RuntimeException("Browser is not specified in config.properties file");
		}
		
	}
	
	
}
