package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class July30ClassworkPractice {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://practice-automation.com/form-fields/");

		WebElement nametextbox = driver.findElement(By.id("name-input"));
		nametextbox.sendKeys("kiran Academy");

		WebElement pwdtextbox = driver.findElement(By.xpath("//*[@id=\"feedbackForm\"]/label[2]/input"));
		pwdtextbox.sendKeys("378gvhhb%$");

		WebElement watercheckbox = driver.findElement(By.id("drink1"));
		watercheckbox.click();
		WebElement coffeecheckbox = driver.findElement(By.id("drink3"));
		coffeecheckbox.sendKeys(Keys.PAGE_DOWN);
		coffeecheckbox.click();
		WebElement delightcheckbox = driver.findElement(By.id("drink5"));
		delightcheckbox.sendKeys(Keys.PAGE_DOWN);
		delightcheckbox.click();

		WebElement colorradiobutton = driver.findElement(By.id("color3"));
		colorradiobutton.click();

		WebElement dropdown = driver.findElement(By.id("automation"));
		dropdown.sendKeys("No");

		//WebElement listoption1 = driver.findElement(By.xpath("//*[@id=\"feedbackForm\"]/ul/li[1]"));
		//System.out.println("List item 1 - "+listoption1.getText());

		//WebElement listoption = driver.findElement(By.xpath("//*[@id=\"feedbackForm\"]/ul/li[5]"));
		//listoption.sendKeys(Keys.PAGE_DOWN);

		List<WebElement> listitem = driver.findElements(By.xpath("//*[@id=\"feedbackForm\"]/ul"));
		//System.out.println(listitem.get(0).getText());

		WebElement button = driver.findElement(By.id("submit-btn"));

		button.click();

		//driver.quit();

	}

}