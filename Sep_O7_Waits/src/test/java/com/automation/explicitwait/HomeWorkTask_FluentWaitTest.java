package com.automation.explicitwait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HomeWorkTask_FluentWaitTest {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/javascript-delays/");

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(12))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		driver.findElement(By.id("start")).click();

		wait.until(dd -> driver.findElement(By.id("delay")).getText().contains("Liftoff!"));

		WebElement text = driver.findElement(By.id("delay"));

		System.out.println(text.getText());

		driver.quit();
	}
}
