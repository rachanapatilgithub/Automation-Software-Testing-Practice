package com.automation;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;

	public ConfigReader() throws Exception {
		FileInputStream fis = new FileInputStream("data.properties");
		properties = new Properties();
		properties.load(fis);
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}

	public String getLoginUrl() {
		return properties.getProperty("loginurl");
	}

	public String getRegisterUrl() {
		return properties.getProperty("registerurl");
	}

	public String getAddUserUrl() {
		return properties.getProperty("adduserurl");
	}
}
