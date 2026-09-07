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

public class HomeWorkTask_Table4_Sorting {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/tables/");

		WebElement table4 = driver.findElement(By.id("tablepress-1"));

		WebElement rankHeader = table4.findElement(By.xpath(".//thead/tr/th[text()='Rank']"));

		// click once = sort ascending, click again = sort descending (DataTables default sort toggle)
		rankHeader.click();
		rankHeader.click();

		// table4.findElements (not driver.findElements) so <tr> search stays inside table4 only
		List<WebElement> rows = table4.findElements(By.xpath(".//tbody/tr"));

		System.out.println("Table 2 sorted by Rank (descending)");
		for (WebElement rr : rows) {
			List<WebElement> columns = rr.findElements(By.tagName("td"));

			for (WebElement cc : columns) {
				System.out.print(cc.getText() + "\t\t");
			}

			System.out.println();
		}

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src.toPath(), new File("SortedTableScreenshot.png").toPath());
		System.out.println("Screenshot saved as SortedTableScreenshot.png");

		driver.quit();
	}
}
