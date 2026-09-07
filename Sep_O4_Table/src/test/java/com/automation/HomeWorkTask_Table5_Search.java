package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table5_Search {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/tables/");

		WebElement table5 = driver.findElement(By.id("tablepress-1"));

		// Search box above Table 2 (id = tablepress-1_filter) - typing here filters the table rows live
		WebElement searchBox = driver.findElement(By.cssSelector("#tablepress-1_filter input[type='search']"));
		searchBox.sendKeys("India");

		// table5.findElements (not driver.findElements) so <tr> search stays inside table5 only
		List<WebElement> rows = table5.findElements(By.xpath(".//tbody/tr"));

		System.out.println("Row(s) after searching 'India' - " + rows.size());

		for (WebElement rr : rows) {
			List<WebElement> columns = rr.findElements(By.tagName("td"));

			for (WebElement cc : columns) {
				String contents = cc.getText();
				System.out.print(contents + "\t\t");
			}

			System.out.println();
		}

		driver.quit();
	}
}
