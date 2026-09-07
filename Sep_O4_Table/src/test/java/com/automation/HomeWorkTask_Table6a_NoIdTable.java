package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table6a_NoIdTable {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/tables");

		// Example 1 : table has no class/id on its rows/cells
		WebElement table1 = driver.findElement(By.id("table1"));

		// table1.findElements (not driver.findElements) so <tr> search stays inside table1 only
		List<WebElement> rows = table1.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Table 1 row count - " + rows.size());

		for (WebElement rr : rows) {
			List<WebElement> columns = rr.findElements(By.tagName("td"));
			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}
			System.out.println();
		}

		driver.quit();
	}
}
