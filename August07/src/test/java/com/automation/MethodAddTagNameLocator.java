
package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MethodAddTagNameLocator {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		System.out.println("Total Links : " + allLinks.size());

		System.out.println();

		for (WebElement links : allLinks) {

			System.out.println("--------------------------------");

			System.out.println("Link Text : " + links.getText());

			System.out.println("Tag Name : " + links.getTagName());

			System.out.println("Href : " + links.getAttribute("href"));

			System.out.println("Displayed : " + links.isDisplayed());

			System.out.println("Enabled : " + links.isEnabled());

			System.out.println("Location : " + links.getLocation());

			System.out.println("Size : " + links.getSize());

			System.out.println("Rectangle : " + links.getRect());

			System.out.println("Color : " + links.getCssValue("color"));

		}

		driver.quit();

	}

}