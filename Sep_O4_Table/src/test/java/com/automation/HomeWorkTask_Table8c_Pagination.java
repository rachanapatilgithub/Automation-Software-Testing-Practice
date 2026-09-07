package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table8c_Pagination {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/data-table");

		WebElement table8 = driver.findElement(By.id("dataTable"));

		// 25 books, 5 per page, so there are 5 pages of pagination buttons
		int totalPages = 5;

		for (int page = 1; page <= totalPages; page++) {
			System.out.println("---- Page " + page + " ----");

			List<WebElement> rows = table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']"));
			for (WebElement rr : rows) {
				List<WebElement> columns = rr.findElements(By.tagName("td"));
				for (WebElement cc : columns) {
					System.out.print(cc.getText() + "\t\t");
				}
				System.out.println();
			}

			if (page < totalPages) {
				driver.findElement(By.cssSelector("button[data-testid='pagination-page-" + (page + 1) + "']")).click();
			}
		}

		driver.quit();
	}
}
