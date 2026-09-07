package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_Table7_AllInOne {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

		WebElement table7 = driver.findElement(By.id("example"));

		// ---------- select "All" entries ----------
		Select select = new Select(driver.findElement(By.name("example_length")));
		select.selectByValue("-1");
		System.out.println("After selecting All entries");
		printRows(table7.findElements(By.xpath(".//tbody/tr")));

		// ---------- pagination : back to default 3 per page, click through all pages ----------
		select.selectByValue("3");
		int totalPages = 4;
		for (int page = 1; page <= totalPages; page++) {
			System.out.println("\n---- Page " + page + " ----");
			printRows(table7.findElements(By.xpath(".//tbody/tr")));

			if (page < totalPages) {
				driver.findElement(By.id("example_next")).click();
			}
		}

		// ---------- sorting ----------
		WebElement nameHeader = table7.findElement(By.xpath(".//thead/tr/th[text()='Student Name']"));
		nameHeader.click();
		nameHeader.click();
		System.out.println("\nAfter sorting by Student Name (descending)");
		printRows(table7.findElements(By.xpath(".//tbody/tr")));

		// ---------- search ----------
		WebElement searchBox = driver.findElement(By.cssSelector("#example_filter input[type='search']"));
		searchBox.sendKeys("Alice");
		System.out.println("\nAfter searching 'Alice'");
		printRows(table7.findElements(By.xpath(".//tbody/tr")));

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
