package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class July29HeadingANDlinkTest {






	static WebDriver driver;

	// Open Browser
	public static void openBrowser() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://javabykiran.com/liveproject/index.html");

		Thread.sleep(2000);

		System.out.println("Browser Opened");
	}


	// Check Heading
	public static void checkHeading() {

		// Find heading
		WebElement heading = driver.findElement(By.tagName("h3"));

		// Check heading is displayed
		if (heading.isDisplayed()) {

			System.out.println("Heading is Displayed");
			System.out.println("Heading Name : " + heading.getText());

		} else {

			System.out.println("Heading is Not Displayed");
		}
	}


	// Check Link
	public static void checkLink() {

		// Find link
		WebElement link = driver.findElement(By.tagName("a"));

		// Check link is displayed
		if (link.isDisplayed()) {

			System.out.println("Link is Displayed");
			System.out.println("Link Name : " + link.getText());

		} else {

			System.out.println("Link is Not Displayed");
		}
	}


	// Close Browser
	public static void closeBrowser() {

		driver.quit();

		System.out.println("Browser Closed");
	}


	// Main Method
	public static void main(String[] args) throws InterruptedException {


		openBrowser();

		checkHeading();

		checkLink();

		closeBrowser();

	}

}