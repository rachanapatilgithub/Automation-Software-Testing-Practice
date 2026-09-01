package com.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// 3. Form Validation Message testing
public class TestProgram {

	public static void main(String[] args) {

		// open chrome browser
		WebDriver driver = new ChromeDriver();

		// open url
		driver.get("https://javabykiran.com/liveproject/index.html");

		// enter username in username field
		WebElement username = driver.findElement(By.xpath("//input[contains(@id,'em')]"));
		username.sendKeys("kiran@gmail.com");

		// enter password in password field
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.sendKeys("123456");

		// click on login button
		WebElement submit = driver.findElement(By.cssSelector("button.btn-flat"));
		submit.click();

		String actualTitle = driver.getTitle();
		String expectedTitle = "JavaByKiran | Dashboard";

		// Testing (to check actual result and expected result)
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("test case pass");
		} else {
			System.out.println("test case failed == title is missmatch");
		}

		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://javabykiran.com/liveproject/pages/examples/dashboard.html";

		if (actualURL.equals(expectedURL)) {
			System.out.println("url is work as expected");
		} else {
			System.out.println("url is missmatch");
		}

		driver.quit();
	}
}
