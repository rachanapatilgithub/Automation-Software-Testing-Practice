package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table6b_WithIdTable {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/tables");

		// Example 2 : table has class/id on its rows/cells
		WebElement table2 = driver.findElement(By.id("table2"));

		// table2.findElements (not driver.findElements) so <tr> search stays inside table2 only
		List<WebElement> rows = table2.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Table 2 row count - " + rows.size());

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
