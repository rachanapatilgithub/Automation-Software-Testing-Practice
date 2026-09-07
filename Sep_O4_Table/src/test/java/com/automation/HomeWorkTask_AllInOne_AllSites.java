package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_AllInOne_AllSites {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// ================= Site 1 : practice-automation.com/tables =================
		driver.get("https://practice-automation.com/tables/");

		WebElement table1 = driver.findElement(By.xpath("//*[@id=\"post-1076\"]/div/figure/table"));
		System.out.println("===== Site 1 : Simple Table =====");
		printRows(table1.findElements(By.tagName("tr")), "td");

		WebElement table2 = driver.findElement(By.id("tablepress-1"));
		new Select(driver.findElement(By.name("tablepress-1_length"))).selectByValue("100");
		System.out.println("\n===== Site 1 : Sortable Table (first 10 of 100 entries) =====");
		List<WebElement> countryRows = table2.findElements(By.xpath(".//tbody/tr"));
		printRows(countryRows.subList(0, 10), "td");

		// ================= Site 2 : practice.expandtesting.com/tables =================
		driver.get("https://practice.expandtesting.com/tables");

		WebElement expTable2 = driver.findElement(By.id("table2"));
		System.out.println("\n===== Site 2 : ExpandTesting Table 2 =====");
		printRows(expTable2.findElements(By.xpath(".//tbody/tr")), "td");

		// ================= Site 3 : practice.expandtesting.com/dynamic-pagination-table =================
		driver.get("https://practice.expandtesting.com/dynamic-pagination-table");

		WebElement pagTable = driver.findElement(By.id("example"));
		System.out.println("\n===== Site 3 : Dynamic Pagination Table - Page 1 =====");
		printRows(pagTable.findElements(By.xpath(".//tbody/tr")), "td");

		driver.findElement(By.id("example_next")).click();
		System.out.println("\n===== Site 3 : Dynamic Pagination Table - Page 2 =====");
		printRows(pagTable.findElements(By.xpath(".//tbody/tr")), "td");

		// ================= Site 4 : qaplayground.com/practice/data-table =================
		driver.get("https://qaplayground.com/practice/data-table");

		WebElement bookTable = driver.findElement(By.id("dataTable"));
		System.out.println("\n===== Site 4 : QA Playground Book Table - Page 1 =====");
		printRows(bookTable.findElements(By.cssSelector("tbody tr[data-testid='book-row']")), "td");

		driver.findElement(By.cssSelector("button[data-testid='pagination-page-2']")).click();
		System.out.println("\n===== Site 4 : QA Playground Book Table - Page 2 =====");
		printRows(bookTable.findElements(By.cssSelector("tbody tr[data-testid='book-row']")), "td");

		driver.quit();
	}

	private static void printRows(List<WebElement> rows, String cellTag) {
		for (WebElement rr : rows) {
			List<WebElement> columns = rr.findElements(By.tagName(cellTag));
			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}
			System.out.println();
		}
	}
}
