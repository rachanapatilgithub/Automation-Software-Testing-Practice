package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table7_ExpandTestingPagination {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

		WebElement table7 = driver.findElement(By.id("example"));

		// default is 3 entries per page, 10 rows total, so pagination gives us 4 pages
		int totalPages = 4;

		for (int page = 1; page <= totalPages; page++) {
			System.out.println("---- Page " + page + " ----");

			// table7.findElements (not driver.findElements) so <tr> search stays inside table7 only
			List<WebElement> rows = table7.findElements(By.xpath(".//tbody/tr"));

			for (WebElement rr : rows) {
				List<WebElement> columns = rr.findElements(By.tagName("td"));
				for (WebElement cc : columns) {
					System.out.print(cc.getText() + "\t\t");
				}
				System.out.println();
			}

			if (page < totalPages) {
				WebElement nextButton = driver.findElement(By.id("example_next"));
				nextButton.click();
			}
		}

		driver.quit();
	}
}
