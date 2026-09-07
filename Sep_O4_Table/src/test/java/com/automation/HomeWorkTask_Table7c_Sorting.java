package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table7c_Sorting {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

		WebElement table7 = driver.findElement(By.id("example"));

		WebElement nameHeader = table7.findElement(By.xpath(".//thead/tr/th[text()='Student Name']"));

		// click once = sort ascending, click again = sort descending (DataTables default sort toggle)
		nameHeader.click();
		nameHeader.click();

		List<WebElement> rows = table7.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Table sorted by Student Name (descending)");

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
