package com.automation;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader() {
		try {
			FileInputStream fis = new FileInputStream("data.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return prop.getProperty("browsername");
	}

	public String getLoginURL() {
		return prop.getProperty("loginurl");
	}

	public String getRegisterURL() {
		return prop.getProperty("registerurl");
	}

	public String getAddUserURL() {
		return prop.getProperty("adduserurl");
	}
}
