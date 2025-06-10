package Utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private Properties prop;

    public configReader() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("/amztddproject/src/test/java/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            System.out.println(" Failed to load config.properties file.");
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public String getEmail() {
        return prop.getProperty("email");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}