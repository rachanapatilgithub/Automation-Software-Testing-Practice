package com.automation.demoautomationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_SwitchFrameByIndex {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");

		// switch by index - the Single Iframe section has only one iframe on the page, so index 0
		driver.switchTo().frame(0);

		String frametext = driver.findElement(By.xpath("/html/body/section/div/h5")).getText();
		System.out.println(frametext);

		driver.quit();
	}
}
