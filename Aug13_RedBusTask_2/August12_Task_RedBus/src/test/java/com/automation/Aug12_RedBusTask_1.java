package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.LocalDate;
import java.util.List;

public class Aug12_RedBusTask_1 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("==========================================");
		System.out.println("   REDBUS AUTOMATION - SHIRPUR TO PUNE");
		System.out.println("==========================================");

		System.out.println("Step 1: Opening Edge Driver...");
		WebDriver driver = new EdgeDriver();

		System.out.println("Step 2: Maximizing the window...");
		driver.manage().window().maximize();

		System.out.println("Step 3: Opening redBus website...");
		driver.get("https://www.redbus.in/");
		Thread.sleep(6000);

		System.out.println("Step 4: Finding From box using ID 'srcinput' and typing 'Shirpur'...");
		WebElement fromBox = driver.findElement(By.id("srcinput"));
		fromBox.sendKeys("Shirpur");
		Thread.sleep(2000);

		System.out.println("Step 5: Selecting Shirpur from the dropdown list...");
		fromBox.sendKeys(Keys.ARROW_DOWN);
		fromBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		System.out.println("Step 6: Finding To box using ID 'destinput' and typing 'Pune'...");
		WebElement toBox = driver.findElement(By.id("destinput"));
		toBox.sendKeys("Pune");
		Thread.sleep(2000);

		System.out.println("Step 7: Selecting Pune from the dropdown list...");
		toBox.sendKeys(Keys.ARROW_DOWN);
		toBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		System.out.println("Step 8: Checking Today button...");
		try {
			driver.findElement(By.xpath("//button[text()='Today']")).click();
			System.out.println("   -> Today button clicked.");
		} catch (Exception e) {
			System.out.println("   -> Today button not shown, date is already Today by default.");
		}
		Thread.sleep(1000);

		System.out.println("Step 9: Clicking Search buses button...");
		driver.findElement(By.cssSelector("button[class*='searchButtonWrapper']")).click();

		System.out.println("Step 10: Waiting for the bus list page to open...");
		Thread.sleep(6000);

		System.out.println("Step 11: Scrolling down to load all the buses...");
		WebElement body = driver.findElement(By.tagName("body"));
		for (int i = 1; i <= 15; i++) {
			body.sendKeys(Keys.PAGE_DOWN);
			System.out.println("   -> Scroll " + i + "/15 done...");
			Thread.sleep(1000);
		}

		System.out.println("Step 12: Reading the 'buses found' text from the website...");
		String websiteResult;
		try {
			WebElement busesFoundText = driver.findElement(By.xpath("//*[contains(text(),'buses found')]"));
			websiteResult = busesFoundText.getText();
			System.out.println("   -> Found: " + websiteResult);
		} catch (Exception e) {
			websiteResult = "Not shown on this page layout";
			System.out.println("   -> 'buses found' text not shown, skipping this and using our own count instead.");
		}

		System.out.println("Step 13: Collecting names of all buses...");
		List<WebElement> busNames = driver.findElements(By.cssSelector("div[class*='travelsName']"));

		System.out.println("------------------------------------------");
		System.out.println("           BUS LIST (Shirpur -> Pune)");
		System.out.println("------------------------------------------");
		for (int i = 0; i < busNames.size(); i++) {
			System.out.println((i + 1) + ". " + busNames.get(i).getText());
		}

		System.out.println("==========================================");
		System.out.println("               FINAL REPORT");
		System.out.println("==========================================");
		System.out.println("Route          : Shirpur -> Pune");
		System.out.println("Date           : " + LocalDate.now());
		System.out.println("Website says   : " + websiteResult);
		System.out.println("Buses counted  : " + busNames.size());
		System.out.println("==========================================");

		System.out.println("Closing the browser...");
		driver.quit();

		System.out.println("==========================================");
		System.out.println("        PROGRAM FINISHED SUCCESSFULLY");
		System.out.println("==========================================");
	}
}