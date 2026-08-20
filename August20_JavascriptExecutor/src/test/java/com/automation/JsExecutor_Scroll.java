package com.automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class JsExecutor_Scroll {
	 public static void main(String[] args) {

	        WebDriver driver = new EdgeDriver();

	        driver.manage().window().maximize();

	        driver.get("https://javabykiran.com/liveproject/index.html");

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript("window.scrollBy(0,500)");

	        System.out.println("Scrolled down 500px");

	        driver.quit();
	    }
	}

