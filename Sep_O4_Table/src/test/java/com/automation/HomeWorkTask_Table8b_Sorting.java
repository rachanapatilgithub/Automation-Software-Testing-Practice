package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table8b_Sorting {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/data-table");

		WebElement table8 = driver.findElement(By.id("dataTable"));

		// click the "Book Name" column header to sort the table
		WebElement bookNameHeader = table8.findElement(By.cssSelector("th[data-col='book-name']"));
		bookNameHeader.click();

		List<WebElement> rows = table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']"));
		System.out.println("After sorting by Book Name");

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
