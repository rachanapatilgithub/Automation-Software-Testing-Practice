package com.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class July27ClassworkTEST1 {


	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/index.html");

		WebElement username = driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("password"));
		WebElement signbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
		String pagecode;

		System.out.println("-----1. Positive Scenario-----");
		Thread.sleep(1000);

		username.sendKeys("kiran@gmail.com"); // already variable is declared and has stores element values here we have
												// only send the input data
		pwd.sendKeys("123456");
		signbutton.click();

		pagecode = driver.getPageSource();

		if (pagecode.contains("Java / J2EE")) {
			System.out.println("Testcase is Passed with correct username and correct password");
		} else {
			System.out.println("Testcase is Failed");
		}

		driver.navigate().back();
		username.clear();
		pwd.clear();
		
		System.out.println("-----2. Negative Scenario with incorrect username-----");
		Thread.sleep(1000);

		username.sendKeys("kiran");
		pwd.sendKeys("123456");
		signbutton.click();

		pagecode = driver.getPageSource();

		if (pagecode.contains("TheKiranAcademy")) {
			System.out.println("Testcase is Passed with incorrect username and correct password");
		} else {
			System.out.println("Testcase is Failed");
		}

	}

}