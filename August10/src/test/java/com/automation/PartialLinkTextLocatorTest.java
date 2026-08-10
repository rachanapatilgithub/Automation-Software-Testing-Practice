package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class PartialLinkTextLocatorTest {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

		//driver.findElement(By.partialLinkText("Kiran")).click();

		driver.findElement(By.partialLinkText("alr")).click();
	}
}