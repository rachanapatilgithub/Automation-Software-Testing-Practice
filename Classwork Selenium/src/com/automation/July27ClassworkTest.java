package com.automation;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class July27ClassworkTest {


	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/index.html");
		
		System.out.println("-----1. Negative Scenario with incorrect username-----");

		Thread.sleep(1000);

		WebElement username1 = driver.findElement(By.id("email"));
		username1.sendKeys("kiran@gmail");
		System.out.println("email field is find");

		Thread.sleep(1000);

		WebElement pwd1 = driver.findElement(By.id("password"));
		pwd1.sendKeys("123456");
		System.out.println("Password field is find");

		Thread.sleep(1000);

		WebElement signbutton1 = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
		signbutton1.click();
		System.out.println("Sigin is clicked");
		
       String pagecode1 = driver.getPageSource();
		
		if(pagecode1.contains("TheKiranAcademy")) {
			System.out.println("Testcase is Passed with incorrect username and correct password");
		}
		else {
			System.out.println("Testcase is Failed");
		}

		username1.clear();
		pwd1.clear();

		System.out.println("-----2. Negative Scenario with incorrect Password-----");

		WebElement username2 = driver.findElement(By.id("email"));
		username2.sendKeys("kiran@gmail.com");
		System.out.println("email field is find");

		Thread.sleep(1000);

		WebElement pwd2 = driver.findElement(By.id("password"));
		pwd2.sendKeys("1234");
		System.out.println("Password field is find");

		Thread.sleep(1000);

		WebElement signbutton3 = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
		signbutton3.click();
		System.out.println("Sigin is clicked");
		
		username2.clear();
		pwd2.clear();
		
		System.out.println("-----3. Positive Scenario-----");
		Thread.sleep(1000);

		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("kiran@gmail.com");
		System.out.println("email field is find");

		Thread.sleep(1000);

		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("123456");
		System.out.println("Password field is find");

		Thread.sleep(1000);

		WebElement signbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
		signbutton.click();
		System.out.println("Sigin is clicked");
		
		String pagecode = driver.getPageSource();
		
		if(pagecode.contains("Java / J2EE")) {
			System.out.println("Testcase is Passed with correct username and correct password");
		}
		else {
			System.out.println("Testcase is Failed");
		}

	}

}