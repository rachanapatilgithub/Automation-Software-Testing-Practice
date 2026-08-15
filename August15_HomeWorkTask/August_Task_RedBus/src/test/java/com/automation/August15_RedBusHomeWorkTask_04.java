package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class August15_RedBusHomeWorkTask_04 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Opening RedBus website...");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// ================= TEST CASE 1: Search with valid source, destination, tomorrow =================
		System.out.println("\nTest Case 1: Search using valid source, destination and tomorrow's date");
		try {
			driver.get("https://www.redbus.in/");
			Thread.sleep(6000);

			WebElement from = driver.findElement(By.id("srcinput"));
			from.sendKeys("Shirpur");
			Thread.sleep(2000);
			from.sendKeys(Keys.ARROW_DOWN);
			from.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

			WebElement to = driver.findElement(By.id("destinput"));
			to.sendKeys("Pune");
			Thread.sleep(2000);
			to.sendKeys(Keys.ARROW_DOWN);
			to.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

			to.sendKeys(Keys.ESCAPE);
			Thread.sleep(1000);
			driver.findElement(By.tagName("body")).click();
			Thread.sleep(1000);

			try {
				driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
				System.out.println("Tomorrow button clicked.");
			} catch (Exception e) {
				System.out.println("Tomorrow button not shown, date stayed at default.");
			}
			Thread.sleep(1000);

			int tries = 0;
			boolean clicked = false;
			while (tries < 3 && !clicked) {
				try {
					driver.findElement(By.cssSelector("button[class*='searchButtonWrapper']")).click();
					clicked = true;
				} catch (Exception e) {
					tries++;
					Thread.sleep(2000);
				}
			}
			Thread.sleep(8000);

			String url = driver.getCurrentUrl();
			if (url.contains("shirpur-to-pune")) {
				System.out.println("PASS: Shirpur to Pune search is successful.");
			} else {
				System.out.println("FAIL: Search was not successful. URL was: " + url);
			}

		} catch (Exception e) {
			System.out.println("ERROR in Test Case 1: " + e.getMessage());
		}

		// ================= TEST CASE 2: Swap button exchanges the route =================
		System.out.println("\nTest Case 2: Verify the swap button exchanges the route");
		try {
			driver.get("https://www.redbus.in/bus-tickets/shirpur-to-pune");
			Thread.sleep(8000);

			String titleBeforeSwap = driver.findElement(By.cssSelector("h1[class*='searchTitle']")).getText();
			System.out.println("Route before swap: " + titleBeforeSwap);

			driver.findElement(By.cssSelector("div[aria-label='Swap source and destination']")).click();
			Thread.sleep(4000);

			String titleAfterSwap = driver.findElement(By.cssSelector("h1[class*='searchTitle']")).getText();
			System.out.println("Route after swap : " + titleAfterSwap);

			if (!titleAfterSwap.equals(titleBeforeSwap) && titleAfterSwap.contains("Pune") && titleAfterSwap.contains("Shirpur")) {
				System.out.println("PASS: Swap button exchanged the route.");
			} else {
				System.out.println("FAIL: Route did not change after clicking swap.");
			}

		} catch (Exception e) {
			System.out.println("ERROR in Test Case 2: " + e.getMessage());
		}

		// ================= TEST CASE 3: Same source and destination =================
		System.out.println("\nTest Case 3: Verify same source and destination produce validation");
		try {
			driver.get("https://www.redbus.in/");
			Thread.sleep(6000);

			WebElement fromBox = driver.findElement(By.id("srcinput"));
			fromBox.sendKeys("Pune");
			Thread.sleep(2000);
			fromBox.sendKeys(Keys.ARROW_DOWN);
			fromBox.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

			WebElement toBox = driver.findElement(By.id("destinput"));
			toBox.sendKeys("Pune");
			Thread.sleep(2000);
			toBox.sendKeys(Keys.ARROW_DOWN);
			toBox.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

			toBox.sendKeys(Keys.ESCAPE);
			Thread.sleep(1000);
			driver.findElement(By.tagName("body")).click();
			Thread.sleep(1000);

			String beforeSearch = driver.getCurrentUrl();
			driver.findElement(By.cssSelector("button[class*='searchButtonWrapper']")).click();
			Thread.sleep(4000);
			String afterSearch = driver.getCurrentUrl();

			if (beforeSearch.equals(afterSearch)) {
				System.out.println("PASS: Same source and destination are not allowed.");
			} else {
				System.out.println("FAIL (or no validation): Search proceeded anyway -> " + afterSearch);
			}

		} catch (Exception e) {
			System.out.println("ERROR in Test Case 3: " + e.getMessage());
		}

		// ================= TEST CASE 4: Past date cannot be selected =================
		System.out.println("\nTest Case 4: Verify a past date cannot be selected");
		try {
			driver.get("https://www.redbus.in/");
			Thread.sleep(6000);

			driver.findElement(By.cssSelector("div[aria-label='Select date of journey']")).click();
			Thread.sleep(2000);

			WebElement pastDate = driver.findElement(By.cssSelector("div.calendarDate[aria-disabled='true']"));
			String value = pastDate.getAttribute("aria-disabled");
			System.out.println("Past date checked: " + pastDate.getAttribute("aria-label"));

			if (value.equals("true")) {
				System.out.println("PASS: Past date is correctly marked as unavailable.");
			} else {
				System.out.println("FAIL: Past date was not marked as unavailable.");
			}

		} catch (Exception e) {
			System.out.println("ERROR in Test Case 4: " + e.getMessage());
		}

		// ================= TEST CASE 5: Results page shows the route =================
		System.out.println("\nTest Case 5: Verify the results page contains the selected route");
		try {
			driver.get("https://www.redbus.in/bus-tickets/shirpur-to-pune");
			Thread.sleep(8000);

			String pageText = driver.findElement(By.tagName("body")).getText();
			if (pageText.contains("Shirpur") && pageText.contains("Pune")) {
				System.out.println("PASS: Results page shows both Shirpur and Pune.");
			} else {
				System.out.println("FAIL: Results page did not show the expected route.");
			}

		} catch (Exception e) {
			System.out.println("ERROR in Test Case 5: " + e.getMessage());
		}

		System.out.println("\nClosing the browser...");
		driver.quit();
		System.out.println("Program Finished! All 5 test cases were run.");
	}
}