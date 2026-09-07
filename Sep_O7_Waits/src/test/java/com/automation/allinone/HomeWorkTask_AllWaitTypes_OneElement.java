package com.automation.allinone;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

// mam's task : apply all 3 wait types on the SAME element ("delay" on javascript-delays page)
public class HomeWorkTask_AllWaitTypes_OneElement {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// ---------- 1) Implicit wait ----------
		driver.get("https://practice-automation.com/javascript-delays/");
		driver.findElement(By.id("start")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
		System.out.println("Implicit wait -> " + driver.findElement(By.id("delay")).getText());

		// reset implicit wait to 0 before using explicit wait (best practice: don't mix the two)
		driver.manage().timeouts().implicitlyWait(Duration.ZERO);

		// ---------- 2) Explicit wait (WebDriverWait + ExpectedConditions) ----------
		driver.get("https://practice-automation.com/javascript-delays/");
		driver.findElement(By.id("start")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("delay"), "Liftoff!"));
		System.out.println("Explicit wait -> " + driver.findElement(By.id("delay")).getText());

		// ---------- 3) Fluent wait (custom polling + ignoring exceptions) ----------
		driver.get("https://practice-automation.com/javascript-delays/");
		driver.findElement(By.id("start")).click();
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(12))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		fluentWait.until(dd -> driver.findElement(By.id("delay")).getText().contains("Liftoff!"));
		WebElement delay = driver.findElement(By.id("delay"));
		System.out.println("Fluent wait -> " + delay.getText());

		driver.quit();
	}
}
