package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	 private Properties prop;

	    public configReader() {
	        prop = new Properties();
	        try {
	            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
	            prop.load(ip);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public String getUrl() {
	        return prop.getProperty("url");
	    }

	    public String getEmail() {
	        return prop.getProperty("email");
	    }

	    public String getPassword() {
	        return prop.getProperty("password");
	    }
	}


