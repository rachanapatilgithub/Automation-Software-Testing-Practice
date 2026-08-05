
package com.automation;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FinalHomeWorkWindowHandlesPractice {


	public static void main(String[] args) throws Exception {

		// Open Browser
		WebDriver driver = new EdgeDriver();
		System.out.println("Browser Opened");

		// Maximize Browser
		driver.manage().window().maximize();
		System.out.println("Browser Maximized");

		// Open Website
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		System.out.println("Website Opened");

		// Parent Window
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window ID : " + parent);

		// ==========================
		// 1. Open New Tab
		// ==========================
		System.out.println("Clicking Open New Tab");
		driver.findElement(By.id("newTabBtn")).click();
		handleWindows(driver, parent);

		// ==========================
		// 2. Open New Window
		// ==========================
		System.out.println("Clicking Open New Window");
		driver.findElement(By.id("newWindowBtn")).click();
		handleWindows(driver, parent);

		// ==========================
		// 3. Open Multiple Tabs
		// ==========================
		System.out.println("Clicking Open Multiple Tabs");
		driver.findElement(By.id("newTabsBtn")).click();
		handleWindows(driver, parent);

		// ==========================
		// 4. Open Multiple Windows
		// ==========================
		System.out.println("Clicking Open Multiple Windows");
		driver.findElement(By.id("newWindowsBtn")).click();
		handleWindows(driver, parent);

		// ==========================
		// 5. Open Multiple Tabs and Windows
		// ==========================
		System.out.println("Clicking Open Multiple Tabs and Windows");
		driver.findElement(By.id("newTabsWindowsBtn")).click();
		handleWindows(driver, parent);

		// Close Browser
		driver.quit();
		System.out.println("Browser Closed");
	}

	// Common Method
	public static void handleWindows(WebDriver driver, String parent) throws Exception {

		Thread.sleep(2000);

		Set<String> windows = driver.getWindowHandles();

		for (String w : windows) {

			if (!w.equals(parent)) {

				driver.switchTo().window(w);
				System.out.println("--------------------------------");
				System.out.println("Child Window ID : " + w);
				System.out.println("Title : " + driver.getTitle());

				driver.close();
				System.out.println("Child Window Closed");

				driver.switchTo().window(parent);
				System.out.println("Back to Parent Window");
			}
		}
	}
}