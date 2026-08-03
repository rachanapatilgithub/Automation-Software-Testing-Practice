//https://practice-automation.com/popups/


//package com.pp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.edge.EdgeDriver;

public class SimpleAlertTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/popups/");

		WebElement button1 = driver.findElement(By.id("alert"));
		button1.click();

		Thread.sleep(1000);

		Alert al = driver.switchTo().alert();

		String alerttext = al.getText();
		System.out.println(alerttext);

		al.accept();
	}
}