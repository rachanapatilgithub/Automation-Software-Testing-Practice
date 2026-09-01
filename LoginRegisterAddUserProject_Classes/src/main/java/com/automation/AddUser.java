package com.automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddUser {

	public static void addUser(WebDriver driver, String username, String mobile, String email, String course,
			String gender, String state, String password) {

		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile);

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("course")).clear();
		driver.findElement(By.id("course")).sendKeys(course);

		if (gender.equalsIgnoreCase("Male")) {
			driver.findElement(By.id("Male")).click();
		} else if (gender.equalsIgnoreCase("Female")) {
			driver.findElement(By.id("Female")).click();
		}

		// the state dropdown has no id on this page, so By.id("state") does not work
		if (state != null && !state.isEmpty()) {
			Select s = new Select(driver.findElement(By.xpath("//form[1]//select")));
			s.selectByVisibleText(state);
		}

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.id("submit")).click();

		// same site template as Register - accept the success alert if one shows up
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert - " + alert.getText());
			alert.accept();
		} catch (NoAlertPresentException e) {
			// no alert this time (negative case with blank fields)
		}

		System.out.println("Add User Executed");
	}
}
