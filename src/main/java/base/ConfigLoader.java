package base;


import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigLoader {
	Properties property;
	
	ConfigLoader() throws IOException, FileNotFoundException{
		FileInputStream fis = new FileInputStream("config/config.properties");
		property = new Properties();
		property.load(fis);
	}
	
	public String getProperty(String key) {
		return property.getProperty(key);
	}
	
	
}
