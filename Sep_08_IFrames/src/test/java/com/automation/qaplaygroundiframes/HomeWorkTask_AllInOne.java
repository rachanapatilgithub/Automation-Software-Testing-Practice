package com.automation.qaplaygroundiframes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_AllInOne {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/iframes");

		// ---------- Scenario 1 : basic iframe fill and submit ----------
		WebElement basicFrame = driver.findElement(By.cssSelector("[data-testid='iframe-basic']"));
		driver.switchTo().frame(basicFrame);
		driver.findElement(By.cssSelector("[data-testid='iframe-name-input']")).sendKeys("Kiran Student");
		driver.findElement(By.cssSelector("[data-testid='iframe-submit-btn']")).click();
		System.out.println("Scenario 1: " + driver.findElement(By.id("result")).getText());
		driver.switchTo().defaultContent();

		// ---------- Scenario 2 : checkbox and select ----------
		WebElement formFrame = driver.findElement(By.cssSelector("iframe[title='Form Iframe']"));
		driver.switchTo().frame(formFrame);
		new Select(driver.findElement(By.id("iframe-lang-select"))).selectByValue("java");
		driver.findElement(By.id("iframe-agree-chk")).click();
		driver.findElement(By.id("iframe-save-btn")).click();
		System.out.println("Scenario 2: " + driver.findElement(By.id("result")).getText());
		driver.switchTo().defaultContent();

		// ---------- Scenario 3 : multiple iframes, each located differently ----------
		WebElement frame1 = driver.findElement(By.cssSelector("[data-testid='iframe-frame-1']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.cssSelector("[data-testid='iframe-f1-action-btn']")).click();
		System.out.println("Scenario 3, Frame 1: " + driver.findElement(By.id("f1-result")).getText());
		driver.switchTo().defaultContent();

		WebElement frame2 = driver.findElement(By.cssSelector("iframe[name='frame-two']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.cssSelector("button[aria-label='Activate Frame Two']")).click();
		System.out.println("Scenario 3, Frame 2: " + driver.findElement(By.id("f2-result")).getText());
		driver.switchTo().defaultContent();

		WebElement frame3 = driver.findElement(By.cssSelector("iframe[title='Frame Three']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//button[normalize-space()='Confirm Action']")).click();
		System.out.println("Scenario 3, Frame 3: " + driver.findElement(By.id("f3-result")).getText());
		driver.switchTo().defaultContent();

		// ---------- Scenario 4 : nested iframes, 2 levels deep ----------
		WebElement outerFrame = driver.findElement(By.cssSelector("[data-testid='iframe-outer']"));
		driver.switchTo().frame(outerFrame);
		WebElement innerFrame = driver.findElement(By.cssSelector("iframe[title='Inner Frame']"));
		driver.switchTo().frame(innerFrame);
		driver.findElement(By.cssSelector("[data-testid='iframe-inner-input']")).sendKeys("kiran-secret");
		driver.findElement(By.cssSelector("[data-testid='iframe-inner-submit']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		// ---------- Scenario 5 : dynamic content, explicit wait ----------
		WebElement dynamicFrame = driver.findElement(By.cssSelector("[data-testid='iframe-dynamic']"));
		driver.switchTo().frame(dynamicFrame);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement revealButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Reveal Secret']")));
		driver.findElement(By.id("dyn-code-input")).sendKeys("kiran123");
		revealButton.click();
		System.out.println("Scenario 5: " + driver.findElement(By.id("dyn-result")).getText());
		driver.switchTo().defaultContent();

		// ---------- Scenario 6 : form validation inside iframe ----------
		WebElement validationFrame = driver.findElement(By.cssSelector("[data-testid='iframe-validation']"));
		driver.switchTo().frame(validationFrame);
		driver.findElement(By.id("iframe-val-submit")).click();
		System.out.println("Scenario 6, name error: " + driver.findElement(By.id("err-name")).getText());
		System.out.println("Scenario 6, email error: " + driver.findElement(By.id("err-email")).getText());
		driver.findElement(By.id("val-name")).sendKeys("Kiran Student");
		driver.findElement(By.id("val-email")).sendKeys("kiran.student@example.com");
		driver.findElement(By.id("val-company")).sendKeys("Kiran Academy");
		driver.findElement(By.id("iframe-val-submit")).click();
		System.out.println("Scenario 6: " + driver.findElement(By.id("form-success")).getText());
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
