package com.automation.qaplaygroundiframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_Scenario2_CheckboxAndSelect {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/iframes");

		// switch by title attribute this time
		WebElement formFrame = driver.findElement(By.cssSelector("iframe[title='Form Iframe']"));
		driver.switchTo().frame(formFrame);

		Select languageSelect = new Select(driver.findElement(By.id("iframe-lang-select")));
		languageSelect.selectByValue("java");

		driver.findElement(By.id("iframe-agree-chk")).click();

		driver.findElement(By.id("iframe-save-btn")).click();

		String result = driver.findElement(By.id("result")).getText();
		System.out.println("Scenario 2 result: " + result);

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
