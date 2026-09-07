package com.automation.allinone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_AllInOne_Waits {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// ================= 1) Implicit wait : practice-automation.com/javascript-delays =================
		driver.get("https://practice-automation.com/javascript-delays/");
		driver.findElement(By.id("start")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
		System.out.println("Site 1 (implicit) -> " + driver.findElement(By.id("delay")).getText());
		driver.manage().timeouts().implicitlyWait(Duration.ZERO);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// ================= 2) Explicit wait : hyrtutorials.com waits demo =================
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.findElement(By.id("btn1")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1")));
		driver.findElement(By.id("txt1")).sendKeys("tka");
		driver.findElement(By.id("btn2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));
		driver.findElement(By.id("txt2")).sendKeys("Pune");
		System.out.println("Site 2 (explicit - visibilityOfElementLocated) done");

		// ================= 3) Explicit wait : expandtesting dynamic-loading (invisibility + presence) =================
		driver.get("https://practice.expandtesting.com/dynamic-loading/1");
		driver.findElement(By.cssSelector("#start button")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		System.out.println("Site 3 example 1 (invisibilityOfElementLocated) -> " + driver.findElement(By.id("finish")).getText());

		driver.get("https://practice.expandtesting.com/dynamic-loading/2");
		driver.findElement(By.cssSelector("#start button")).click();
		System.out.println("Site 3 example 2 (presenceOfElementLocated) -> "
				+ wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish"))).getText());

		// ================= 4) Explicit wait : qaplayground dynamic-waits (elementToBeClickable + textToBePresent) =================
		driver.get("https://qaplayground.com/practice/dynamic-waits");

		driver.findElement(By.cssSelector("[data-testid='dw-trigger-delayed']")).click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("result-s01"), "appeared"));
		System.out.println("Site 4 scenario 1 (textToBePresentInElement) -> " + driver.findElement(By.id("result-s01")).getText());

		driver.findElement(By.cssSelector("[data-testid='dw-arm-enable']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("dw-submit-btn"))).click();
		System.out.println("Site 4 scenario 5 (elementToBeClickable) done");

		driver.quit();
	}
}
