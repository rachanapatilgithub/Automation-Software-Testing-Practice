package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.LocalDate;
import java.util.List;

public class Aug13_RedBusTask_2 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting RedBus Automation - Shirpur to Pune");

		// open browser
		System.out.println("Opening browser...");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// open redBus site
		System.out.println("Opening redBus website...");
		driver.get("https://www.redbus.in/");
		Thread.sleep(6000);

		// type From city and pick it from dropdown
		System.out.println("Entering From city: Shirpur");
		WebElement fromBox = driver.findElement(By.id("srcinput"));
		fromBox.sendKeys("Shirpur");
		Thread.sleep(2000);
		fromBox.sendKeys(Keys.ARROW_DOWN);
		fromBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		// type To city and pick it from dropdown
		System.out.println("Entering To city: Pune");
		WebElement toBox = driver.findElement(By.id("destinput"));
		toBox.sendKeys("Pune");
		Thread.sleep(2000);
		toBox.sendKeys(Keys.ARROW_DOWN);
		toBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		// close any leftover popup before clicking Search
		toBox.sendKeys(Keys.ESCAPE);
		Thread.sleep(1000);
		WebElement pageBody = driver.findElement(By.tagName("body"));
		pageBody.click();
		Thread.sleep(1000);

		// click Today if it is showing, otherwise date is already Today
		try {
			driver.findElement(By.xpath("//button[text()='Today']")).click();
		} catch (Exception e) {
			System.out.println("Date already set to Today");
		}
		Thread.sleep(1000);

		// click Search buses, try again if something blocks the click
		System.out.println("Searching buses...");
		int searchAttempts = 0;
		boolean searchClicked = false;
		while (searchAttempts < 3 && !searchClicked) {
			try {
				driver.findElement(By.cssSelector("button[class*='searchButtonWrapper']")).click();
				searchClicked = true;
			} catch (Exception e) {
				searchAttempts++;
				Thread.sleep(2000);
			}
		}
		Thread.sleep(6000);

		// scroll down many times so all buses get loaded
		System.out.println("Loading all buses...");
		WebElement resultsBody = driver.findElement(By.tagName("body"));
		for (int i = 1; i <= 25; i++) {
			resultsBody.sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(1200);
		}

		// read the count text shown on the website itself
		String websiteResult;
		try {
			websiteResult = driver.findElement(By.xpath("//*[contains(text(),'buses found')]")).getText();
		} catch (Exception e) {
			websiteResult = "Not shown on this page layout";
		}

		// collect and print name of every bus
		System.out.println("Collecting bus names...");
		List<WebElement> busNames = driver.findElements(By.cssSelector("div[class*='travelsName']"));

		System.out.println("------------------------------------------");
		System.out.println("           BUS LIST (Shirpur -> Pune)");
		System.out.println("------------------------------------------");
		for (int i = 0; i < busNames.size(); i++) {
			System.out.println((i + 1) + ". " + busNames.get(i).getText());
		}

		// read Primo, AC and Non-AC counts from the filter list
		System.out.println("Checking bus types...");
		String primoText;
		try {
			primoText = driver.findElement(By.xpath("//div[starts-with(text(),'Primo')]")).getText();
		} catch (Exception e) {
			primoText = "Not shown on this page";
		}
		String acText;
		try {
			acText = driver.findElement(By.xpath("//div[starts-with(text(),'AC (')]")).getText();
		} catch (Exception e) {
			acText = "Not shown on this page";
		}
		String nonAcText;
		try {
			nonAcText = driver.findElement(By.xpath("//div[starts-with(text(),'NONAC')]")).getText();
		} catch (Exception e) {
			nonAcText = "Not shown on this page";
		}
		String sleeperText;
		try {
			sleeperText = driver.findElement(By.xpath("//div[starts-with(text(),'SLEEPER')]")).getText();
		} catch (Exception e) {
			sleeperText = "Not shown on this page";
		}
		String seaterText;
		try {
			seaterText = driver.findElement(By.xpath("//div[starts-with(text(),'SEATER')]")).getText();
		} catch (Exception e) {
			seaterText = "Not shown on this page";
		}

		// print final report
		System.out.println("==========================================");
		System.out.println("               FINAL REPORT");
		System.out.println("==========================================");
		System.out.println("Route          : Shirpur -> Pune");
		System.out.println("Date           : " + LocalDate.now());
		System.out.println("Website says   : " + websiteResult);
		System.out.println("Total buses    : " + busNames.size());
		System.out.println("Primo Bus      : " + primoText);
		System.out.println("AC buses       : " + acText);
		System.out.println("Non-AC buses   : " + nonAcText);
		System.out.println("Sleeper buses  : " + sleeperText);
		System.out.println("Seater buses   : " + seaterText);
		System.out.println("==========================================");

		driver.quit();
		System.out.println("Program Finished!");
	}
}