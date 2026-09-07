package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table7d_Search {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

		WebElement table7 = driver.findElement(By.id("example"));

		// Search box above the table (id = example_filter) - typing here filters the table rows live
		WebElement searchBox = driver.findElement(By.cssSelector("#example_filter input[type='search']"));
		searchBox.sendKeys("Alice");

		List<WebElement> rows = table7.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Row(s) after searching 'Alice' - " + rows.size());

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
