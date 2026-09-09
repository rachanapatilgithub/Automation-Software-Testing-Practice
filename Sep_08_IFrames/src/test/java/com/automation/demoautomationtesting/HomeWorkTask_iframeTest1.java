package com.automation.demoautomationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_iframeTest1 {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");

		String footertext = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div[1]/a")).getText();
		System.out.println(footertext);

		// driver.switchTo().frame(0); -- switch by index
		// driver.switchTo().frame("singleframe"); -- switch by id
		// driver.switchTo().frame("SingleFrame"); -- switch by name
		WebElement frameelement = driver.findElement(By.xpath("//*[@id=\"singleframe\"]"));

		// switch by WebElement (most reliable of the four ways above)
		driver.switchTo().frame(frameelement);

		String frametext = driver.findElement(By.xpath("/html/body/section/div/h5")).getText();
		System.out.println(frametext);

		WebElement textbox = driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		textbox.sendKeys("kiran academy");

		driver.quit();
	}
}
