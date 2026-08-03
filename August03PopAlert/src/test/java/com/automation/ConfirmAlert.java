package com.automation;




	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;

	public class ConfirmAlert {

		public static void main(String[] args) throws InterruptedException {

			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://practice-automation.com/popups/");

			WebElement button2 = driver.findElement(By.id("confirm"));
			button2.click();

			Alert al = driver.switchTo().alert();

			Thread.sleep(1000);

			System.out.println(al.getText());

			al.dismiss(); // to click on cancel button
			// al.accept(); // to click on OK button

			WebElement msgtext = driver.findElement(By.id("confirmResult"));

			String text = msgtext.getText();

			if (text.contains("OK")) {
				System.out.println("OK button is clicked from alert");
			} else if (text.contains("Cancel")) {
				System.out.println("Cancel button is clicked from alert");
			}
		}
	}

