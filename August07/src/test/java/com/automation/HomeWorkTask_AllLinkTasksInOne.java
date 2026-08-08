
package com.automation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_AllLinkTasksInOne {

	public static void main(String[] args) {

		// Setup and Launch Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

		// Fetch all links once to use for all 15 tasks
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links found on page: " + allLinks.size());

		// ---------------------------------------------------------
		System.out.println("\n--- Task 1: Print Non-Empty Links ---");
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (!text.isEmpty()) {
				System.out.println(text);
			}
		}

		// ---------------------------------------------------------
		System.out.println("\n--- Task 2: Print Text and Href ---");
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			String url = link.getAttribute("href");
			System.out.println("Text: " + text + " | URL: " + url);
		}

		// ---------------------------------------------------------
		System.out.println("\n--- Task 3: Count Links ---");
		int withText = 0, withoutText = 0;
		for (WebElement link : allLinks) {
			if (link.getText().trim().isEmpty()) {
				withoutText++;
			} else {
				withText++;
			}
		}
		System.out.println("Total links: " + allLinks.size());
		System.out.println("Links with text: " + withText);
		System.out.println("Links without text: " + withoutText);

		// ---------------------------------------------------------
		System.out.println("\n--- Task 4: Starts with 'R' ---");
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (text.startsWith("R")) {
				System.out.println(text);
			}
		}

		// ---------------------------------------------------------
		System.out.println("\n--- Task 5: Contains 'Login' ---");
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (text.contains("Login")) {
				System.out.println(text);
			}
		}

		// ---------------------------------------------------------
		System.out.println("\n--- Task 6: Longest Link Text ---");
		String longestText = "";
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (text.length() > longestText.length()) {
				longestText = text;
			}
		}
		System.out.println("Longest Text: " + longestText);

		// ---------------------------------------------------------
		System.out.println("\n--- Task 7: Shortest Non-Empty Link Text ---");
		String shortestText = null;
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (!text.isEmpty()) {
				if (shortestText == null || text.length() < shortestText.length()) {
					shortestText = text;
				}
			}
		}
		System.out.println("Shortest Text: " + shortestText);

		// ---------------------------------------------------------
		System.out.println("\n--- Task 8: Store in ArrayList ---");
		ArrayList<String> linkTextsList = new ArrayList<>();
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (!text.isEmpty()) {
				linkTextsList.add(text);
			}
		}
		System.out.println("ArrayList output: " + linkTextsList);

		// ---------------------------------------------------------
		System.out.println("\n--- Task 9: Print with Serial Number ---");
		int serialNumber = 1;
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (!text.isEmpty()) {
				System.out.println(serialNumber + ". " + text);
				serialNumber++;
			}
		}

		// ---------------------------------------------------------
		System.out.println("\n--- Task 10: Duplicate Link Texts ---");
		Set<String> seenTexts = new HashSet<>();
		Set<String> duplicateTexts = new HashSet<>();
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (!text.isEmpty()) {
				if (!seenTexts.add(text)) {
					duplicateTexts.add(text);
				}
			}
		}
		System.out.println("Duplicates: " + duplicateTexts);

		// ---------------------------------------------------------
		System.out.println("\n--- Task 11: Unique Link Texts ---");
		Set<String> uniqueTexts = new LinkedHashSet<>();
		for (WebElement link : allLinks) {
			String text = link.getText().trim();
			if (!text.isEmpty()) {
				uniqueTexts.add(text);
			}
		}
		System.out.println("Unique Texts: " + uniqueTexts);

		// ---------------------------------------------------------
		System.out.println("\n--- Task 12: Href vs No Href Count ---");
		int hasHref = 0, noHref = 0;
		for (WebElement link : allLinks) {
			String hrefValue = link.getAttribute("href");
			if (hrefValue != null && !hrefValue.isEmpty()) {
				hasHref++;
			} else {
				noHref++;
			}
		}
		System.out.println("Links with href: " + hasHref);
		System.out.println("Links without href: " + noHref);

		// ---------------------------------------------------------
		System.out.println("\n--- Task 13: Href starts with HTTP ---");
		for (WebElement link : allLinks) {
			String hrefValue = link.getAttribute("href");
			if (hrefValue != null && hrefValue.startsWith("http")) {
				System.out.println(hrefValue);
			}
		}

		// ---------------------------------------------------------
		System.out.println("\n--- Task 14: Reverse Order ---");
		for (int i = allLinks.size() - 1; i >= 0; i--) {
			String text = allLinks.get(i).getText().trim();
			if (!text.isEmpty()) {
				System.out.println(text);
			}
		}

		// ---------------------------------------------------------
		System.out.println("\n--- Task 15: First and Last Link ---");
		if (!allLinks.isEmpty()) {
			System.out.println("First Link: " + allLinks.get(0).getText());
			System.out.println("Last Link: " + allLinks.get(allLinks.size() - 1).getText());
		}

		// Close the browser
		System.out.println("\nAll tasks completed. Closing browser.");
		driver.quit();
	}
}