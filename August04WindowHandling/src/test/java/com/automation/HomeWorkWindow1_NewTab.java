


package com.automation;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkWindow1_NewTab {

	public static void main(String[] args) throws Exception {

		// Open Browser
		WebDriver driver = new EdgeDriver();
		System.out.println("Browser Opened");

		driver.manage().window().maximize();
		System.out.println("Browser Maximized");

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		System.out.println("Website Opened");

		String parent = driver.getWindowHandle();
		System.out.println("Parent Window ID : " + parent);

		driver.findElement(By.id("newTabBtn")).click();
		System.out.println("Clicked on New Tab Button");

		Thread.sleep(2000);

		Set<String> windows = driver.getWindowHandles();

		for (String w : windows) {

			if (!w.equals(parent)) {

				driver.switchTo().window(w);
				System.out.println("Switched to Child Tab");

				System.out.println("Title : " + driver.getTitle());

				driver.close();
				System.out.println("Child Tab Closed");
			}
		}

		driver.switchTo().window(parent);
		System.out.println("Back to Parent Window");

		driver.quit();
		System.out.println("Browser Closed");
	}
}