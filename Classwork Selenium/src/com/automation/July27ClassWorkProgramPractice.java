package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class July27ClassWorkProgramPractice {

    public static void main(String[] args) throws InterruptedException {

        // =========================================================
        // 1. SETUP: This section must remain UNCOMMENTED 
        // to open the browser and locate elements for any scenario.
        // =========================================================
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://javabykiran.com/liveproject/index.html");
        System.out.println("Browser is Open ..");
        System.out.println("url open");

        WebElement username = driver.findElement(By.id("email"));
        WebElement pwd = driver.findElement(By.id("password"));
        WebElement signbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
        String pagecode;



        // =========================================================
        // SCENARIO 1: Positive Scenario (Correct Email, Correct Password)
        // (Remove the /* and */ below to run this block)
        // =========================================================
        
        /*
        System.out.println("-----1. Positive Scenario-----");
        Thread.sleep(1000);

        username.sendKeys("kiran@gmail.com");
        System.out.println("email field is find");

        Thread.sleep(1000);
        pwd.sendKeys("123456");
        System.out.println("Password field is find");

        signbutton.click();
        System.out.println("Signin is clicked");

        pagecode = driver.getPageSource();
        if (pagecode.contains("Java / J2EE")) {
            System.out.println("Testcase is Passed with correct username and correct password");
        } else {
            System.out.println("Testcase is Failed");
        }

        driver.navigate().back();
        Thread.sleep(1000);
        
        username.clear();
        pwd.clear();
        */



        // =========================================================
        // SCENARIO 2: Negative Scenario (Incorrect Email, Correct Password)
        // (Remove the /* and */ below to run this block)
        // =========================================================
        
        /*
        System.out.println("-----2. Negative Scenario with incorrect username-----");
        Thread.sleep(1000);

        username.sendKeys("ki@gmail.com"); 
        System.out.println("email field is find");

        Thread.sleep(1000);
        pwd.sendKeys("123456");
        System.out.println("Password field is find");

        signbutton.click();
        System.out.println("Signin is clicked");

        username.clear();
        pwd.clear();
        */



        // =========================================================
        // SCENARIO 3: Negative Scenario (Correct Email, Incorrect Password)
        // (Remove the /* and */ below to run this block)
        // =========================================================
        
        /*
        System.out.println("-----3. Negative Scenario with incorrect Password-----");
        Thread.sleep(1000);

        username.sendKeys("kiran@gmail.com");
        System.out.println("email field is find");

        Thread.sleep(1000);
        pwd.sendKeys("1234"); // Incorrect password
        System.out.println("Password field is find");

        signbutton.click();
        System.out.println("Signin is clicked");
        
        username.clear();
        pwd.clear();
        */
        
    }
}