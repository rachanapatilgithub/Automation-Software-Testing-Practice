package com.automation;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Aug13_RedBusTask_02 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("==============================================");
		System.out.println("       REDBUS AUTOMATION STARTED");
		System.out.println("==============================================");

		// Open browser
		System.out.println("Opening Edge browser...");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Open RedBus
		System.out.println("Opening RedBus website...");
		driver.get("https://www.redbus.in/");
		Thread.sleep(5000);

		// Enter From city
		System.out.println("Entering From city: Shirpur");

		WebElement from = driver.findElement(By.id("srcinput"));
		from.sendKeys("Shirpur");

		Thread.sleep(2000);

		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);

		System.out.println("From city selected.");

		// Enter To city
		System.out.println("Entering To city: Pune");

		WebElement to = driver.findElement(By.id("destinput"));
		to.sendKeys("Pune");

		Thread.sleep(2000);

		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);

		System.out.println("To city selected.");

		Thread.sleep(1000);

		// Search buses
		System.out.println("Clicking Search Buses...");

		WebElement searchButton = driver.findElement(
				By.cssSelector("button[class*='searchButtonWrapper']"));

		searchButton.click();

		System.out.println("Search completed.");

		Thread.sleep(6000);

		// Scroll page
		System.out.println("Loading bus results...");

		WebElement body = driver.findElement(By.tagName("body"));

		for (int i = 1; i <= 15; i++) {
			body.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1000);
		}

		System.out.println("Bus results loaded.");

		// Find all buses
		System.out.println("Finding bus names...");

		List<WebElement> buses = driver.findElements(
				By.cssSelector("div[class*='travelsName']"));

		// Display bus results
		System.out.println();
		System.out.println("==============================================");
		System.out.println("             BUS SEARCH RESULTS");
		System.out.println("==============================================");

		System.out.println("Route       : Shirpur -> Pune");
		System.out.println("Date        : " + LocalDate.now());
		System.out.println("Total Buses : " + buses.size());

		System.out.println("----------------------------------------------");
		System.out.println("Bus Names");
		System.out.println("----------------------------------------------");

		for (int i = 0; i < buses.size(); i++) {
			System.out.println((i + 1) + ". " + buses.get(i).getText());
		}

		// Bus type details
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("Bus Type Details");
		System.out.println("----------------------------------------------");

		String primo = driver.findElement(
				By.xpath("//div[starts-with(text(),'Primo')]"))
				.getText();

		String ac = driver.findElement(
				By.xpath("//div[starts-with(text(),'AC (')]"))
				.getText();

		String nonAc = driver.findElement(
				By.xpath("//div[starts-with(text(),'NONAC')]"))
				.getText();

		String sleeper = driver.findElement(
				By.xpath("//div[starts-with(text(),'SLEEPER')]"))
				.getText();

		System.out.println("Primo Bus     : " + primo);
		System.out.println("AC Buses      : " + ac);
		System.out.println("Non-AC Buses  : " + nonAc);
		System.out.println("Sleeper Buses : " + sleeper);

		System.out.println("----------------------------------------------");

		// Close browser
		System.out.println("Closing browser...");
		driver.quit();

		System.out.println("Browser closed.");
		System.out.println();
		System.out.println("==============================================");
		System.out.println("       REDBUS AUTOMATION COMPLETED");
		System.out.println("==============================================");
	}
}