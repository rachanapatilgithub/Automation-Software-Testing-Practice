package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table3_Pagination {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/tables/");

		WebElement table3 = driver.findElement(By.id("tablepress-1"));

		// default is 10 entries per page, and Table 2 has 25 rows total, so pagination gives us 3 pages
		int totalPages = 3;

		for (int page = 1; page <= totalPages; page++) {
			System.out.println("---- Page " + page + " ----");

			// table3.findElements (not driver.findElements) so <tr> search stays inside table3 only
			List<WebElement> rows = table3.findElements(By.xpath(".//tbody/tr"));

			for (WebElement rr : rows) {
				List<WebElement> columns = rr.findElements(By.tagName("td"));

				for (WebElement cc : columns) {
					String contents = cc.getText();
					System.out.print(contents + "\t\t");
				}

				System.out.println();
			}

			if (page < totalPages) {
				WebElement nextButton = driver.findElement(By.id("tablepress-1_next"));
				nextButton.click();
			}
		}

		driver.quit();
	}
}
