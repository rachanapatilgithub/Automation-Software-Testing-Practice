package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_Table1_SimpleTable {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/tables/");

		WebElement table1 = driver.findElement(By.xpath("//*[@id=\"post-1076\"]/div/figure/table"));

		// table1.findElements (not driver.findElements) so <tr> search stays inside table1 only
		List<WebElement> rows = table1.findElements(By.tagName("tr"));

		int size = rows.size();

		System.out.println("Row Size of Table 1 - " + size);

		for (WebElement rr : rows) {
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
