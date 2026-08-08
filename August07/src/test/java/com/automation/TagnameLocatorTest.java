package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TagnameLocatorTest {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

		// driver.findElement(By.tagName("input")).sendKeys("TKa");
		// driver.findElement(By.tagName("input")).sendKeys("1234325345");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println(allLinks.size());

		for (WebElement links : allLinks) {

			System.out.println(links.getText());

		}

		driver.quit();

	}

}