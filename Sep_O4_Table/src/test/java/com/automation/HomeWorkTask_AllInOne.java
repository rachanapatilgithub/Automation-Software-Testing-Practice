package com.automation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_AllInOne {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/tables/");

		// ---------- Table 1 : Simple Table - print all data ----------
		WebElement table1 = driver.findElement(By.xpath("//*[@id=\"post-1076\"]/div/figure/table"));

		// table1.findElements (not driver.findElements) so <tr> search stays inside table1 only
		List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
		System.out.println("Row Size of Table 1 - " + rows1.size());

		for (WebElement rr : rows1) {
			List<WebElement> columns = rr.findElements(By.tagName("td"));
			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}
			System.out.println();
		}

		WebElement table2 = driver.findElement(By.id("tablepress-1"));

		// ---------- Table 2 : select 100 entries, print first 10 rows ----------
		WebElement entriesDropdown = driver.findElement(By.name("tablepress-1_length"));
		Select entriesSelect = new Select(entriesDropdown);
		entriesSelect.selectByValue("100");

		// table2.findElements (not driver.findElements) so <tr> search stays inside table2 only
		List<WebElement> rows2 = table2.findElements(By.xpath(".//tbody/tr"));
		System.out.println("\nFirst 10 rows of Table 2 after selecting 100 entries");
		for (int i = 0; i < 10; i++) {
			List<WebElement> columns = rows2.get(i).findElements(By.tagName("td"));
			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}
			System.out.println();
		}

		// ---------- Table 2 : Pagination ----------
		entriesSelect.selectByValue("10");

		int totalPages = 3;
		for (int page = 1; page <= totalPages; page++) {
			System.out.println("\n---- Page " + page + " ----");

			List<WebElement> pageRows = table2.findElements(By.xpath(".//tbody/tr"));
			for (WebElement rr : pageRows) {
				List<WebElement> columns = rr.findElements(By.tagName("td"));
				for (WebElement cc : columns) {
					System.out.print(cc.getText() + "\t\t");
				}
				System.out.println();
			}

			if (page < totalPages) {
				driver.findElement(By.id("tablepress-1_next")).click();
			}
		}

		// ---------- Table 2 : Sorting + screenshot ----------
		WebElement rankHeader = table2.findElement(By.xpath(".//thead/tr/th[text()='Rank']"));
		rankHeader.click();
		rankHeader.click();

		System.out.println("\nTable 2 sorted by Rank (descending)");
		List<WebElement> sortedRows = table2.findElements(By.xpath(".//tbody/tr"));
		for (WebElement rr : sortedRows) {
			List<WebElement> columns = rr.findElements(By.tagName("td"));
			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}
			System.out.println();
		}

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src.toPath(), new File("SortedTableScreenshot_AllInOne.png").toPath());
		System.out.println("Screenshot saved as SortedTableScreenshot_AllInOne.png");

		// ---------- Table 2 : Search box with sendKeys ----------
		WebElement searchBox = driver.findElement(By.cssSelector("#tablepress-1_filter input[type='search']"));
		searchBox.sendKeys("India");

		List<WebElement> searchRows = table2.findElements(By.xpath(".//tbody/tr"));
		System.out.println("\nRow(s) after searching 'India' - " + searchRows.size());
		for (WebElement rr : searchRows) {
			List<WebElement> columns = rr.findElements(By.tagName("td"));
			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}
			System.out.println();
		}

		driver.quit();
	}
}
