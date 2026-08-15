package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class August15_RedBusHomeWorkTask_03 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting RedBus Automation - Shirpur to Pune");

		System.out.println("Opening browser...");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		System.out.println("Opening redBus results page...");
		driver.get("https://www.redbus.in/bus-tickets/shirpur-to-pune");
		Thread.sleep(8000);

		System.out.println("Scrolling until no more new buses load...");
		WebElement body = driver.findElement(By.tagName("body"));
		int previousCount = -1;
		int currentCount = driver.findElements(By.xpath("//*[text()='View seats']")).size();
		int sameCountInRow = 0;
		int safetyLimit = 0;

		while (sameCountInRow < 3 && safetyLimit < 50) {
			body.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1200);
			previousCount = currentCount;
			currentCount = driver.findElements(By.xpath("//*[text()='View seats']")).size();
			if (currentCount == previousCount) {
				sameCountInRow++;
			} else {
				sameCountInRow = 0;
				System.out.println("Buses loaded so far: " + currentCount);
			}
			safetyLimit++;
		}

		System.out.println("Counting View Seats buttons...");
		List<WebElement> viewSeatsButtons = driver.findElements(By.xpath("//*[text()='View seats']"));
		int totalBuses = viewSeatsButtons.size();

		System.out.println("Checking rating of every bus...");
		List<WebElement> ratings = driver.findElements(By.cssSelector("div[class*='rating']"));
		int busesAboveFour = 0;
		int busesBelowFour = 0;
		for (int i = 0; i < ratings.size(); i++) {
			String ratingText = ratings.get(i).getText().trim();
			try {
				double ratingValue = Double.parseDouble(ratingText);
				System.out.println((i + 1) + ". Rating: " + ratingValue);
				if (ratingValue > 4.0) {
					busesAboveFour++;
				} else if (ratingValue < 4.0) {
					busesBelowFour++;
				}
			} catch (Exception e) {
				// text was not a plain number, skip it
			}
		}

		System.out.println("==========================================");
		System.out.println("               FINAL REPORT");
		System.out.println("==========================================");
		System.out.println("Total buses (View seats)  : " + totalBuses);
		System.out.println("Buses with rating above 4 : " + busesAboveFour);
		System.out.println("Buses with rating below 4 : " + busesBelowFour);
		System.out.println("==========================================");

		driver.quit();
		System.out.println("Program Finished!");
	}
}