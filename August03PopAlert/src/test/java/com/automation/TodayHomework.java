//https://www.hyrtutorials.com/p/alertsdemo.html

package com.automation;

// Importing required Selenium classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.edge.EdgeDriver;

public class TodayHomework {

	public static void main(String[] args) throws InterruptedException {

		// Step 1: Create EdgeDriver object to launch Edge browser
		WebDriver driver = new EdgeDriver();

		// Step 2: Maximize the browser window
		driver.manage().window().maximize();

		// Step 3: Open the homework practice page given by mam
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

		System.out.println("Page opened successfully. Starting Alert practice...");

		// ---------------------------------------------------------
		// PART 1: Simple ALERT box
		// ---------------------------------------------------------

		// On this page all 3 buttons show same text "Click me"
		// So we use xpath with index position:
		// (1) = Alert button, (2) = Confirm button, (3) = Prompt button
		WebElement alertButton = driver.findElement(By.xpath("(//button[text()='Click me'])[1]"));
		alertButton.click();

		// Wait 1 second so alert box has time to appear on screen
		Thread.sleep(1000);

		// Switch driver control from webpage to the alert popup
		Alert simpleAlert = driver.switchTo().alert();

		// Get the text written inside the alert box
		String alertText = simpleAlert.getText();
		System.out.println("Alert box text is: " + alertText);

		// Click OK button on the alert box
		simpleAlert.accept();
		System.out.println("Alert box closed by clicking OK. PART 1 done.");

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 2: CONFIRM box (has OK and Cancel buttons)
		// ---------------------------------------------------------

		WebElement confirmButton = driver.findElement(By.xpath("(//button[text()='Click me'])[2]"));
		confirmButton.click();

		Thread.sleep(1000);

		Alert confirmAlert = driver.switchTo().alert();

		String confirmText = confirmAlert.getText();
		System.out.println("Confirm box text is: " + confirmText);

		// dismiss() clicks Cancel button
		// accept() clicks OK button (just remove comment below to try OK instead)
		confirmAlert.dismiss();
		System.out.println("Cancel button clicked on confirm box. PART 2 done.");

		System.out.println("---------------------------------------------------");

		// ---------------------------------------------------------
		// PART 3: PROMPT box (has a text input field)
		// ---------------------------------------------------------

		WebElement promptButton = driver.findElement(By.xpath("(//button[text()='Click me'])[3]"));
		promptButton.click();

		Thread.sleep(1000);

		Alert promptAlert = driver.switchTo().alert();

		// Type our name inside the prompt input box
		promptAlert.sendKeys("Sumesh Academy");

		// Click OK to submit the entered text
		promptAlert.accept();
		System.out.println("Name typed and OK clicked on prompt box. PART 3 done.");

		System.out.println("---------------------------------------------------");
		System.out.println("All 3 popups (alert, confirm, prompt) handled successfully!");

		// Step 4: Close the browser at the end
		driver.quit();
	}
}
