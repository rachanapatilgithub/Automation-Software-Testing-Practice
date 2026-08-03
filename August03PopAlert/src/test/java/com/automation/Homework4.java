package com.automation;

// Importing required Selenium classes
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework4 {

	public static void main(String[] args) throws InterruptedException {

		// Step 1: Launch Edge browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Step 2: Open demoqa Select Menu practice page
		driver.get("https://demoqa.com/select-menu");

		System.out.println("Page opened: demoqa.com/select-menu");

		Thread.sleep(1000);

		// NOTE: demoqa select-menu page has SEVERAL dropdowns, but only ONE
		// of them is a real HTML <select> tag with id = "oldSelectMenu".
		// The Select class in Selenium ONLY works on real <select> tags,
		// so that is the one we practice on here.
		WebElement oldSelectElement = driver.findElement(By.id("oldSelectMenu"));

		Select oldSelect = new Select(oldSelectElement);

		// ---------------------------------------------------------
		// PART 1: Get all options and print them
		// ---------------------------------------------------------

		List<WebElement> allOptions = oldSelect.getOptions();
		System.out.println("Total options available in dropdown: " + allOptions.size());

		System.out.println("All option values in this dropdown:");
		for (WebElement option : allOptions) {
			System.out.println(" -> " + option.getText());
		}

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 2: Select an option by INDEX
		// ---------------------------------------------------------
		// selectByIndex starts counting from 0 (0 = first option)
		oldSelect.selectByIndex(3);
		System.out.println("Selected by INDEX 3 -> Currently selected: "
				+ oldSelect.getFirstSelectedOption().getText());

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 3: Select an option by VALUE attribute
		// ---------------------------------------------------------
		// value is the hidden "value" attribute behind each option,
		// it may be different from the text shown on screen
		oldSelect.selectByValue("6");
		System.out.println("Selected by VALUE '6' -> Currently selected: "
				+ oldSelect.getFirstSelectedOption().getText());

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 4: Select an option by VISIBLE TEXT
		// ---------------------------------------------------------
		// visible text is exactly what a real user sees on the dropdown.
		// We reuse the first option's text captured in PART 1 above,
		// this way the code always works even if the option names on
		// the live site change in the future.
		String firstOptionText = allOptions.get(0).getText();
		oldSelect.selectByVisibleText(firstOptionText);
		System.out.println("Selected by VISIBLE TEXT '" + firstOptionText + "' -> Currently selected: "
				+ oldSelect.getFirstSelectedOption().getText());

		System.out.println("---------------------------------------------------");
		System.out.println("Homework4 completed successfully!");
		System.out.println("We practiced all 3 ways: selectByIndex, selectByValue, selectByVisibleText");

		// Step 3: Close browser
		driver.quit();
	}
}
