package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_Table8e_GenreFilter {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/data-table");

		WebElement table8 = driver.findElement(By.id("dataTable"));

		WebElement genreDropdown = driver.findElement(By.id("genre-filter-select"));
		Select select = new Select(genreDropdown);
		select.selectByVisibleText("Fantasy");

		List<WebElement> rows = table8.findElements(By.cssSelector("tbody tr[data-testid='book-row']"));
		System.out.println("Row(s) after filtering genre = Fantasy - " + rows.size());

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
