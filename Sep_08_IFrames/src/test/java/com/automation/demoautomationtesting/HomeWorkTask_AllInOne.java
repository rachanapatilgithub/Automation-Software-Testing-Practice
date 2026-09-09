package com.automation.demoautomationtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_AllInOne {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Frames.html");

		// ---------- Single iframe ----------
		WebElement frameelement = driver.findElement(By.xpath("//*[@id=\"singleframe\"]"));
		driver.switchTo().frame(frameelement);

		System.out.println(driver.findElement(By.xpath("/html/body/section/div/h5")).getText());

		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("kiran academy");

		driver.switchTo().defaultContent();

		// ---------- Nested iframes ----------
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();

		WebElement outerframe = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(outerframe);

		System.out.println(driver.findElement(By.xpath("/html/body/section/div/div/h5")).getText());

		WebElement innerframe = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(innerframe);

		System.out.println(driver.findElement(By.xpath("/html/body/section/div/h5")).getText());

		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("kiran academy");

		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("/html/body/section/div/div/h5")).getText());

		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/h1")).getText());

		driver.quit();
	}
}
