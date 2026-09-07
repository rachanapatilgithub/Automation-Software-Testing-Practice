package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table6_AllInOne {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/tables");

		// ---------- Example 1 : no class/id table ----------
		WebElement table1 = driver.findElement(By.id("table1"));
		List<WebElement> rows1 = table1.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Table 1 row count - " + rows1.size());
		printRows(rows1);

		// ---------- Example 2 : class/id table ----------
		WebElement table2 = driver.findElement(By.id("table2"));
		List<WebElement> rows2 = table2.findElements(By.xpath(".//tbody/tr"));
		System.out.println("\nTable 2 row count - " + rows2.size());
		printRows(rows2);

		// ---------- Table 2 : click Edit for Jason Doe's row ----------
		WebElement doeRow = table2.findElement(By.xpath(".//tr[td='jdoe@hotmail.com']"));
		doeRow.findElement(By.linkText("Edit")).click();
		System.out.println("\nClicked Edit for Jason Doe's row");

		driver.quit();
	}

	private static void printRows(List<WebElement> rows) {
		for (WebElement rr : rows) {
			List<WebElement> columns = rr.findElements(By.tagName("td"));
			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}
			System.out.println();
		}
	}
}
