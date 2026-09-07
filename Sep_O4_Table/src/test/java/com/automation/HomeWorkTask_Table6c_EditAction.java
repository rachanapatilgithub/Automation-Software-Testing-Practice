package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table6c_EditAction {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/tables");

		WebElement table2 = driver.findElement(By.id("table2"));

		// find the row for Jason Doe and click Edit only inside that row (relative locator)
		WebElement doeRow = table2.findElement(By.xpath(".//tr[td='jdoe@hotmail.com']"));
		WebElement editLink = doeRow.findElement(By.linkText("Edit"));
		editLink.click();

		System.out.println("Clicked Edit for Jason Doe's row");

		driver.quit();
	}
}
