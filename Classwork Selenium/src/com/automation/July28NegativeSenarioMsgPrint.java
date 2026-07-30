
/*
 * Task:

 * Create a Negative Login Automation Program.
 *
 * Steps:
 * 1. Open Chrome Browser.
 * 2. Maximize the browser window.
 * 3. Open the application:
 *    https://javabykiran.com/liveproject/index.html
 * 4. Enter an invalid Email ID.
 * 5. Enter an invalid Password.
 * 6. Click on the Sign In button.
 * 7. Inspect the error message displayed on the page.
 * 8. Use getText() to capture the error message.
 * 9. Print the error message on the console.
 * 10. Close the browser.
 */








package com.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class July28NegativeSenarioMsgPrint {
	public static void main(String[] args) throws InterruptedException {

			// Open Chrome Browser
			WebDriver driver = new ChromeDriver();

			// Maximize Browser
			driver.manage().window().maximize();

			// Open Application
			driver.get("https://javabykiran.com/liveproject/index.html");

			Thread.sleep(2000);

			// Enter Invalid Username
			driver.findElement(By.id("email")).sendKeys("abc@gmail.com");

			// Enter Invalid Password
			driver.findElement(By.id("password")).sendKeys("abc123");

			// Click Sign In Button
			driver.findElement(By.xpath("//button[@type='submit']")).click();

			Thread.sleep(2000);

			// Get Error Message
			String errorMsg = driver.findElement(By.id("email_error")).getText();

			// Print Error Message
			System.out.println("Error Message : " + errorMsg);

			// Close Browser
			driver.quit();
		}
	}

