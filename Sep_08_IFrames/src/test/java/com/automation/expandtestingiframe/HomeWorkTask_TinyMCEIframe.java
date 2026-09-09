package com.automation.expandtestingiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_TinyMCEIframe {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/iframe");

		// TinyMCE rich text editor renders its own editable area inside an iframe
		WebElement editorFrame = driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe, iframe[id$='_ifr']"));
		driver.switchTo().frame(editorFrame);

		WebElement editorBody = driver.findElement(By.id("tinymce"));
		editorBody.clear();
		editorBody.sendKeys("Kiran Academy - practice text");

		System.out.println("Typed fake text into the TinyMCE editor: " + editorBody.getText());

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
