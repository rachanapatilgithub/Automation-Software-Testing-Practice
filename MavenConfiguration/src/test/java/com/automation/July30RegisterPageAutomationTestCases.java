package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class July30RegisterPageAutomationTestCases {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

		// ---------------- Positive Scenario : Valid data ----------------
		driver.findElement(By.id("name")).sendKeys("Rachana");
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(1000);
		String alertText = driver.switchTo().alert().getText();

		if (alertText.equals("User registered successfully.")) {
			System.out.println("PASS : Positive Scenario - Registered successfully");
		} else {
			System.out.println("FAIL : Positive Scenario - Alert text is - " + alertText);
		}
		driver.switchTo().alert().accept();

		// Reload page before next scenario so old values are cleared
		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 1 : All fields blank ----------------
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String nameError = driver.findElement(By.id("name_error")).getText();
		String mobileError = driver.findElement(By.id("mobile_error")).getText();
		String emailError = driver.findElement(By.id("email_error")).getText();
		String passwordError = driver.findElement(By.id("password_error")).getText();

		if (nameError.equals("Please enter Name.")
				&& mobileError.equals("Please enter Mobile.")
				&& emailError.equals("Please enter Email.")
				&& passwordError.equals("Please enter Password.")) {
			System.out.println("PASS : Negative Scenario 1 - Blank field validation messages shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 1 - Validation messages did not match");
		}

		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 2 : Only Name blank ----------------
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		// Name intentionally left blank

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String nameOnlyError = driver.findElement(By.id("name_error")).getText();

		if (nameOnlyError.equals("Please enter Name.")) {
			System.out.println("PASS : Negative Scenario 2 - Name required validation shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 2 - Message shown is - " + nameOnlyError);
		}

		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 3 : Only Mobile blank ----------------
		driver.findElement(By.id("name")).sendKeys("Rachana");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		// Mobile intentionally left blank

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String mobileOnlyError = driver.findElement(By.id("mobile_error")).getText();

		if (mobileOnlyError.equals("Please enter Mobile.")) {
			System.out.println("PASS : Negative Scenario 3 - Mobile required validation shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 3 - Message shown is - " + mobileOnlyError);
		}

		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 4 : Only Email blank ----------------
		driver.findElement(By.id("name")).sendKeys("Rachana");
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("password")).sendKeys("123456");
		// Email intentionally left blank

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String emailOnlyError = driver.findElement(By.id("email_error")).getText();

		if (emailOnlyError.equals("Please enter Email.")) {
			System.out.println("PASS : Negative Scenario 4 - Email required validation shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 4 - Message shown is - " + emailOnlyError);
		}

		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 5 : Only Password blank ----------------
		driver.findElement(By.id("name")).sendKeys("Rachana");
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		// Password intentionally left blank

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String passwordOnlyError = driver.findElement(By.id("password_error")).getText();

		if (passwordOnlyError.equals("Please enter Password.")) {
			System.out.println("PASS : Negative Scenario 5 - Password required validation shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 5 - Message shown is - " + passwordOnlyError);
		}

		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 6 : Name + Email both blank ----------------
		driver.findElement(By.id("mobile")).sendKeys("9876543210");
		driver.findElement(By.id("password")).sendKeys("123456");
		// Name and Email intentionally left blank

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String nameError6 = driver.findElement(By.id("name_error")).getText();
		String emailError6 = driver.findElement(By.id("email_error")).getText();

		if (nameError6.equals("Please enter Name.") && emailError6.equals("Please enter Email.")) {
			System.out.println("PASS : Negative Scenario 6 - Name and Email required validations shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 6 - Validation messages did not match");
		}

		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 7 : Mobile + Password both blank ----------------
		driver.findElement(By.id("name")).sendKeys("Rachana");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		// Mobile and Password intentionally left blank

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String mobileError7 = driver.findElement(By.id("mobile_error")).getText();
		String passwordError7 = driver.findElement(By.id("password_error")).getText();

		if (mobileError7.equals("Please enter Mobile.") && passwordError7.equals("Please enter Password.")) {
			System.out.println("PASS : Negative Scenario 7 - Mobile and Password required validations shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 7 - Validation messages did not match");
		}

		driver.navigate().refresh();
		Thread.sleep(1000);

		// ---------------- Negative Scenario 8 : Invalid email format + Mobile blank ----------------
		driver.findElement(By.id("name")).sendKeys("Rachana");
		driver.findElement(By.id("email")).sendKeys("kirangmail.com"); // invalid - no @
		driver.findElement(By.id("password")).sendKeys("123456");
		// Mobile intentionally left blank

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		String emailError8 = driver.findElement(By.id("email_error")).getText();
		String mobileError8 = driver.findElement(By.id("mobile_error")).getText();

		if (emailError8.equals("Please enter valid email.") && mobileError8.equals("Please enter Mobile.")) {
			System.out.println("PASS : Negative Scenario 8 - Invalid email + Mobile blank validations shown correctly");
		} else {
			System.out.println("FAIL : Negative Scenario 8 - Validation messages did not match");
		}

		Thread.sleep(2000);

		driver.quit();
	}

}