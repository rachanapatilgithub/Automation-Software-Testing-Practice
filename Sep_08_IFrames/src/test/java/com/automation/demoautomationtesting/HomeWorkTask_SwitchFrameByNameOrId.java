package com.automation.demoautomationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_SwitchFrameByNameOrId {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");

		// switch by id (this iframe's id="singleframe", name="SingleFrame" - either string works)
		driver.switchTo().frame("singleframe");

		String frametext = driver.findElement(By.xpath("/html/body/section/div/h5")).getText();
		System.out.println(frametext);

		driver.quit();
	}
}
