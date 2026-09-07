package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_Table7b_SelectEntries {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

		WebElement table7 = driver.findElement(By.id("example"));

		// select "All" from the Show entries dropdown so all 10 rows load on one page
		WebElement entriesDropdown = driver.findElement(By.name("example_length"));
		Select select = new Select(entriesDropdown);
		select.selectByValue("-1");

		// table7.findElements (not driver.findElements) so <tr> search stays inside table7 only
		List<WebElement> rows = table7.findElements(By.xpath(".//tbody/tr"));
		System.out.println("Row count after selecting All entries - " + rows.size());

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
