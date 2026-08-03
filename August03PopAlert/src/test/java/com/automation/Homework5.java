package com.automation;

// Importing required Selenium classes
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework5 {

	public static void main(String[] args) throws InterruptedException {

		// Step 1: Launch Edge browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Step 2: Open qaplayground Dropdown practice page
		driver.get("https://qaplayground.com/practice/dropdowns");

		System.out.println("Page opened: qaplayground.com/practice/dropdowns");

		Thread.sleep(1000);

		// ---------------------------------------------------------
		// PART 1: SELECT BY VISIBLE TEXT -> Fruit dropdown (id = fruitSelect)
		// ---------------------------------------------------------

		Select fruitDropdown = new Select(driver.findElement(By.id("fruitSelect")));
		fruitDropdown.selectByVisibleText("Apple");
		System.out.println("Fruit dropdown -> selected by VISIBLE TEXT 'Apple'. Currently selected: "
				+ fruitDropdown.getFirstSelectedOption().getText());

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 2: SELECT BY VALUE -> Country dropdown (id = countrySelect)
		// ---------------------------------------------------------

		Select countryDropdown = new Select(driver.findElement(By.id("countrySelect")));
		countryDropdown.selectByValue("india");
		System.out.println("Country dropdown -> selected by VALUE 'india'. Currently selected: "
				+ countryDropdown.getFirstSelectedOption().getText());

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 3: SELECT LAST OPTION + READ ALL OPTIONS -> Language dropdown
		// ---------------------------------------------------------

		Select languageDropdown = new Select(driver.findElement(By.id("languageSelect")));

		List<WebElement> allLanguages = languageDropdown.getOptions();
		System.out.println("Total languages available: " + allLanguages.size());

		System.out.println("Printing all language options:");
		for (WebElement language : allLanguages) {
			System.out.println(" -> " + language.getText());
		}

		// Selecting the LAST option using index = size - 1
		int lastIndex = allLanguages.size() - 1;
		languageDropdown.selectByIndex(lastIndex);
		System.out.println("Selected the LAST language option -> Currently selected: "
				+ languageDropdown.getFirstSelectedOption().getText());

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 4: MULTI-SELECT -> Superheroes dropdown (id = heroSelect)
		// ---------------------------------------------------------

		Select heroDropdown = new Select(driver.findElement(By.id("heroSelect")));

		System.out.println("Is hero dropdown multi-select? " + heroDropdown.isMultiple());

		// Selecting multiple heroes together using their value attribute
		heroDropdown.selectByValue("batman");
		heroDropdown.selectByValue("aquaman");
		System.out.println("Selected 'Batman' and 'Aquaman' together in multi-select dropdown.");

		// Print all currently selected heroes
		List<WebElement> selectedHeroes = heroDropdown.getAllSelectedOptions();
		System.out.println("Currently selected heroes are:");
		for (WebElement hero : selectedHeroes) {
			System.out.println(" -> " + hero.getText());
		}

		System.out.println("---------------------------------------------------");
		System.out.println("Homework5 completed successfully!");

		// Step 3: Close browser
		driver.quit();
	}
}
