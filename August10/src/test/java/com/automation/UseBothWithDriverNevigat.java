package com.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UseBothWithDriverNevigat {
	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

		// First: LinkText
		driver.findElement(By.linkText("Java By Kiran")).click();

		// Go back to previous page
		driver.navigate().back();

		// Second: PartialLinkText
		//driver.findElement(By.partialLinkText("Kiran")).click();

		driver.findElement(By.partialLinkText("alr")).click();

	}
}

/*
 * Register Page ↓ LinkText → "Java By Kiran" → Click ↓ Java By Kiran Page ↓
 * navigate().back() ↓ Register Page ↓ PartialLinkText → "alr" → Click ↓ Comment
 * Form
 */
