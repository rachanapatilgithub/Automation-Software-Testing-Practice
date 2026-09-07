package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_Table8_AllInOne {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/data-table");

		WebElement table8 = driver.findElement(By.id("dataTable"));

		// ---------- print page 1 ----------
		System.out.println("Page 1");
		printRows(table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']")));

		// ---------- sorting ----------
		table8.findElement(By.cssSelector("th[data-col='book-name']")).click();
		System.out.println("\nAfter sorting by Book Name");
		printRows(table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']")));

		// ---------- pagination ----------
		driver.findElement(By.cssSelector("button[data-testid='pagination-page-2']")).click();
		System.out.println("\nPage 2");
		printRows(table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']")));

		// ---------- search ----------
		driver.findElement(By.id("table-search-input")).sendKeys("Dune");
		System.out.println("\nAfter searching 'Dune'");
		printRows(table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']")));

		// clear search before filtering by genre
		WebElement searchBox = driver.findElement(By.id("table-search-input"));
		searchBox.clear();

		// ---------- genre filter ----------
		Select genreSelect = new Select(driver.findElement(By.id("genre-filter-select")));
		genreSelect.selectByVisibleText("Fantasy");
		System.out.println("\nAfter filtering genre = Fantasy");
		printRows(table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']")));

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
