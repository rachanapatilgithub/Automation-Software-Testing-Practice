package com.automation.expandtestingiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_AllInOne {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/iframe");

		// ---------- External iframe : YouTube video ----------
		WebElement youtubeFrame = driver.findElement(By.id("iframe-youtube"));
		driver.switchTo().frame(youtubeFrame);
		driver.findElement(By.className("ytp-large-play-button")).click();
		System.out.println("Clicked the YouTube play button inside the iframe");
		driver.switchTo().defaultContent();

		// ---------- TinyMCE rich text editor iframe ----------
		WebElement editorFrame = driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe, iframe[id$='_ifr']"));
		driver.switchTo().frame(editorFrame);
		WebElement editorBody = driver.findElement(By.id("tinymce"));
		editorBody.clear();
		editorBody.sendKeys("Kiran Academy - practice text");
		System.out.println("Typed fake text into the TinyMCE editor: " + editorBody.getText());
		driver.switchTo().defaultContent();

		// ---------- Internal iframe : email subscription ----------
		WebElement emailFrame = driver.findElement(By.id("email-subscribe"));
		driver.switchTo().frame(emailFrame);
		driver.findElement(By.id("email")).sendKeys("test.user@example.com");
		driver.findElement(By.id("btn-subscribe")).click();
		System.out.println("Submitted the email subscription form with fake data");
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
