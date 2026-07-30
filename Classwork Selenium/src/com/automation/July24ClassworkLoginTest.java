package com.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;




	public class July24ClassworkLoginTest {
		public static void main(String[] args)throws InterruptedException {
			WebDriver driver=new EdgeDriver();//open browser
			System.out.println("Browse open");
			
			Thread.sleep(2000);
			
			driver.manage().window().maximize();
			System.out.println("window maximize");
			
			Thread.sleep(2000);
			
			
			 driver.get("https://javabykiran.com/liveproject/index.html");
			 System.out.println("url is open");
			 
			Thread.sleep(2000);
			 
			 
			 WebElement username=driver.findElement(By.id("email"));
			 username.sendKeys("kiran@gmail.com");
			 System.out.println("email field find");
			 Thread.sleep(2000);
			 
			 
			 
			 WebElement password=driver.findElement(By.id("password"));
			 password.sendKeys("123456");
			 System.out.println("password field find");
			 Thread.sleep(2000);
			 
			 
			 
			 WebElement sign=driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
			 sign.click();
			 System.out.println("button click");
			 Thread.sleep(2000);
			 
			 String title=driver.getTitle()	 ;
			 if(title.equals("JavaByKiran | Dashboard")) {
				 System.out.println("Testcase is passed with valid login Details");
			 }else {
				 System.out.println("testcase is failed1");
			 }
			 
			 String currenturl=driver.getCurrentUrl();
			if(currenturl.equals("https://javabykiran.com/liveproject/index.html"))
			{
				System.out.println("Testcase passed");
			}else {
				System.out.println("failed2");
			}
			 
			Thread.sleep(2000); 
			 
			 
			 
			 driver.quit();
			 System.out.println("browser close");
			
		}

	}



