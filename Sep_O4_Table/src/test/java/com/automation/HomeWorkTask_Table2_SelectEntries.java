package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkTask_Table2_SelectEntries {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/tables/");

		WebElement table2 = driver.findElement(By.id("tablepress-1"));

		// select "100" from the entries-per-page dropdown at the top of Table 2 so all 25 rows load on one page
		WebElement entriesDropdown = driver.findElement(By.name("tablepress-1_length"));
		Select select = new Select(entriesDropdown);
		select.selectByValue("100");

		// table2.findElements (not driver.findElements) so <tr> search stays inside table2 only
		List<WebElement> rows = table2.findElements(By.xpath(".//tbody/tr"));

		System.out.println("Printing first 10 rows of Table 2 after selecting 100 entries");

		for (int i = 0; i < 10; i++) {
			WebElement rr = rows.get(i);
			List<WebElement> columns = rr.findElements(By.tagName("td"));

			for (WebElement cc : columns) {
				String contents = cc.getText();
				System.out.print(contents + "\t\t");
			}

			System.out.println();
		}

		driver.quit();
	}
}
