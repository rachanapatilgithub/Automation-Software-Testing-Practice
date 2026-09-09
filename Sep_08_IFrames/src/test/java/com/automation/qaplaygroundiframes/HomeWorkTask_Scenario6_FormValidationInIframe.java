package com.automation.qaplaygroundiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Scenario6_FormValidationInIframe {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/iframes");

		WebElement validationFrame = driver.findElement(By.cssSelector("[data-testid='iframe-validation']"));
		driver.switchTo().frame(validationFrame);

		// submit with empty required fields to trigger validation errors
		driver.findElement(By.id("iframe-val-submit")).click();

		// error spans have no data-testid - located here by role="alert"
		String nameError = driver.findElement(By.id("err-name")).getText();
		String emailError = driver.findElement(By.id("err-email")).getText();
		System.out.println("Name error: " + nameError);
		System.out.println("Email error: " + emailError);

		// now fill valid fake data and the Company field (also has no testid) and resubmit
		driver.findElement(By.id("val-name")).sendKeys("Kiran Student");
		driver.findElement(By.id("val-email")).sendKeys("kiran.student@example.com");
		driver.findElement(By.id("val-company")).sendKeys("Kiran Academy");
		driver.findElement(By.id("iframe-val-submit")).click();

		System.out.println("Success message: " + driver.findElement(By.id("form-success")).getText());

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
