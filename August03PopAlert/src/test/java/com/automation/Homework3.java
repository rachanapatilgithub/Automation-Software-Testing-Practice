package com.automation;

// Importing required Selenium classes
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework3 {

	public static void main(String[] args) throws InterruptedException {

		// Step 1: Launch Edge browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Step 2: Open the Dropdown practice page given by mam
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		System.out.println("Page opened: HTML Dropdown Elements Practice");

		Thread.sleep(1000); // small wait so page loads fully

		// This page has exactly 2 <select> tags:
		// 1st select = Course Name (Single-Selection Dropdown)
		// 2nd select = IDE Name (Multi-Selection Dropdown)
		// Since exact "id" is not visible from outside the page,
		// we find ALL select tags first, then pick by position (0, 1)
		List<WebElement> allDropdowns = driver.findElements(By.tagName("select"));

		System.out.println("Total number of dropdowns found on page: " + allDropdowns.size());

		// ---------------------------------------------------------
		// PART 1: SINGLE SELECTION DROPDOWN -> Course Name
		// ---------------------------------------------------------

		WebElement courseDropdownElement = allDropdowns.get(0);

		// Wrap the WebElement inside Select class to use its special methods
		Select courseDropdown = new Select(courseDropdownElement);

		// Select option by visible text
		courseDropdown.selectByVisibleText("Java");
		System.out.println("Course Name dropdown -> selected 'Java' successfully.");

		// Confirm what is currently selected
		String selectedCourse = courseDropdown.getFirstSelectedOption().getText();
		System.out.println("Currently selected course is: " + selectedCourse);

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 2: MULTI SELECTION DROPDOWN -> IDE Name
		// ---------------------------------------------------------

		WebElement ideDropdownElement = allDropdowns.get(1);

		Select ideDropdown = new Select(ideDropdownElement);

		// isMultiple() tells us if this dropdown allows multiple selections
		System.out.println("Is IDE dropdown multi-select? " + ideDropdown.isMultiple());

		// Select more than one option (only works because isMultiple() = true)
		ideDropdown.selectByVisibleText("Eclipse");
		ideDropdown.selectByVisibleText("IntelliJ IDEA");
		System.out.println("IDE Name dropdown -> selected 'Eclipse' and 'IntelliJ IDEA'.");

		// Get list of ALL currently selected options and print them one by one
		List<WebElement> selectedIdeOptions = ideDropdown.getAllSelectedOptions();
		System.out.println("Currently selected IDE options are:");
		for (WebElement option : selectedIdeOptions) {
			System.out.println(" -> " + option.getText());
		}

		System.out.println("---------------------------------------------------");
		System.out.println("Homework3 completed successfully!");

		// Step 3: Close browser
		driver.quit();
	}
}
