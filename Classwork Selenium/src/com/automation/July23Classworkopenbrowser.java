package com.automation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class July23Classworkopenbrowser {

public static void main(String[] args)throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		System.out.println("Browser Open");
		Thread.sleep(3000);
		
		driver.get("https://www.google.com/"); 
		System.out.println("Google Open");
		Thread.sleep(3000);
		
	driver.manage().window().minimize();
		System.out.println("Minimize window");
		Thread.sleep(3000);
		
		
		driver.manage().window().maximize();
		System.out.println("maximize window"); 
		Thread.sleep(2000);
		
		driver.get("https://www.facebook.com/"); 
		System.out.println("facebook Open");
		Thread.sleep(2000);
		
		
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(2000);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		String page=driver.getPageSource();
		System.out.println(page);
		
		
		driver.quit();
	
	}

}
