package com.automation.expandtestingiframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_YoutubeIframeClick {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/iframe");

		// this iframe embeds a YouTube video (a different origin) - Selenium can still switch into it
		WebElement youtubeFrame = driver.findElement(By.id("iframe-youtube"));
		driver.switchTo().frame(youtubeFrame);

		driver.findElement(By.className("ytp-large-play-button")).click();
		System.out.println("Clicked the YouTube play button inside the iframe");

		driver.switchTo().defaultContent();

		driver.quit();
	}
}
