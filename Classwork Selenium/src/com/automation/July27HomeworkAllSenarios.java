package com.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class July27HomeworkAllSenarios {



	

	    // Driver
	    static WebDriver driver;

	    // Open Browser
	    public static void openBrowser() throws InterruptedException {

	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://javabykiran.com/liveproject/index.html");

	        Thread.sleep(2000);

	        System.out.println("Browser Opened Successfully");
	    }

	    // Positive Login
	    public static void positiveTestCase() throws InterruptedException {

	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(2000);

	        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();

	        System.out.println("Positive Test Case Executed");

	        Thread.sleep(3000);
	    }

	    // Negative Login Test Cases
	    public static void negativeTestCase() throws InterruptedException {

	        // TC-1 Wrong Username + Correct Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-1 Completed");
	        Thread.sleep(1000);

	        // TC-2 Correct Username + Wrong Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-2 Completed");
	        Thread.sleep(1000);

	        // TC-3 Wrong Username + Wrong Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-3 Completed");
	        Thread.sleep(1000);

	        // TC-4 Blank Username + Blank Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-4 Completed");
	        Thread.sleep(1000);

	        // TC-5 Blank Username + Correct Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-5 Completed");
	        Thread.sleep(1000);

	        // TC-6 Correct Username + Blank Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-6 Completed");
	        Thread.sleep(1000);

	        // TC-7 Wrong Username + Blank Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-7 Completed");
	        Thread.sleep(1000);

	        // TC-8 Blank Username + Wrong Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("password")).sendKeys("123");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-8 Completed");
	        Thread.sleep(1000);

	        // TC-9 Space Username + Correct Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys(" ");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-9 Completed");
	        Thread.sleep(1000);

	        // TC-10 Correct Username + Space Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	        driver.findElement(By.id("password")).sendKeys(" ");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-10 Completed");
	        Thread.sleep(1000);

	        // TC-11 Space Username + Space Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys(" ");
	        driver.findElement(By.id("password")).sendKeys(" ");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-11 Completed");
	        Thread.sleep(1000);

	        // TC-12 Special Username
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("@#$%");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-12 Completed");
	        Thread.sleep(1000);

	        // TC-13 Special Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("@#$%");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-13 Completed");
	        Thread.sleep(1000);

	        // TC-14 SQL Injection
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("' OR '1'='1");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-14 Completed");
	        Thread.sleep(1000);

	        // TC-15 Long Username
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-15 Completed");
	        Thread.sleep(1000);

	        // TC-16 Long Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123456789123456789123456789");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-16 Completed");
	        Thread.sleep(1000);

	        // TC-17 Invalid Email
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("abc");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-17 Completed");
	        Thread.sleep(1000);

	        // TC-18 Password With Space
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123456 ");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-18 Completed");
	        Thread.sleep(1000);

	        // TC-19 Username With Space
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("email")).sendKeys(" kiran@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("123456");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-19 Completed");
	        Thread.sleep(1000);

	        // TC-20 Blank Username + Wrong Password
	        driver.get("https://javabykiran.com/liveproject/index.html");
	        Thread.sleep(1000);
	        driver.findElement(By.id("password")).sendKeys("wrong123");
	        driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button")).click();
	        System.out.println("TC-20 Completed");
	        Thread.sleep(1000);
	    }

	    // Main Method
	    public static void main(String[] args) throws InterruptedException {

	        openBrowser();

	        positiveTestCase();

	        negativeTestCase();

	        driver.quit();

	        System.out.println("Browser Closed Successfully");
	    }
	}

	/*
	=========================
	MANUAL TEST SCENARIOS
	=========================

	Positive Test Case
	------------------
	1. Correct Username + Correct Password

	Negative Test Cases
	-------------------
	TC-1  : Wrong Username + Correct Password
	TC-2  : Correct Username + Wrong Password
	TC-3  : Wrong Username + Wrong Password
	TC-4  : Blank Username + Blank Password
	TC-5  : Blank Username + Correct Password
	TC-6  : Correct Username + Blank Password
	TC-7  : Wrong Username + Blank Password
	TC-8  : Blank Username + Wrong Password
	TC-9  : Space Username + Correct Password
	TC-10 : Correct Username + Space Password
	TC-11 : Space Username + Space Password
	TC-12 : Special Character Username
	TC-13 : Special Character Password
	TC-14 : SQL Injection Input
	TC-15 : Long Username
	TC-16 : Long Password
	TC-17 : Invalid Email Format
	TC-18 : Password With Trailing Space
	TC-19 : Username With Leading Space
	TC-20 : Blank Username + Invalid Password

	*/
