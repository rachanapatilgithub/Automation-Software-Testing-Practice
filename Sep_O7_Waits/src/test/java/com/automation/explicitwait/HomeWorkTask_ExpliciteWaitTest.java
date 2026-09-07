package com.automation.explicitwait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_ExpliciteWaitTest {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("btn1")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1")));

		WebElement textbox1 = driver.findElement(By.id("txt1"));

		textbox1.sendKeys("tka");

		driver.findElement(By.id("btn2")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));

		driver.findElement(By.id("txt2")).sendKeys("Pune");

		driver.quit();
	}
}
