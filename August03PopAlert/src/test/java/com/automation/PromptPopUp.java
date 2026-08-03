package com.automation;




	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.edge.EdgeDriver;

	public class PromptPopUp {

		public static void main(String[] args) throws InterruptedException {

			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://practice-automation.com/popups/");

			WebElement button3 = driver.findElement(By.id("prompt"));
			button3.click();

			Alert al = driver.switchTo().alert();

			Thread.sleep(1000);

			al.sendKeys("kiran academy");

			al.accept();

			WebElement msgtext = driver.findElement(By.id("promptResult"));
			String text = msgtext.getText();

			System.out.println(text);

			if (text.contains("Nice")) {
				System.out.println("OK button is clicked from alert");
			} else if (text.contains("Fine")) {
				System.out.println("Cancel button is clicked from alert");
			}
		}
	}

