package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Scroll_Footer_Task {
	 public static void main(String[] args) {

	        WebDriver driver = new EdgeDriver();

	        driver.manage().window().maximize();

	        driver.get("https://thekiranacademy.com/");

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript("window.scrollBy(0,1000)");

	        WebElement footer = driver.findElement(By.tagName("footer"));

	        js.executeScript("arguments[0].scrollIntoView();", footer);

	        driver.quit();
	    }
	}

