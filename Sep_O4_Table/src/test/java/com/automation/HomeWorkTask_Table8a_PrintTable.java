package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table8a_PrintTable {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/data-table");

		WebElement table8 = driver.findElement(By.id("dataTable"));

		// table8.findElements (not driver.findElements) so <tr> search stays inside table8 only
		List<WebElement> rows = table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']"));
		System.out.println("Page 1 row count - " + rows.size());

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
