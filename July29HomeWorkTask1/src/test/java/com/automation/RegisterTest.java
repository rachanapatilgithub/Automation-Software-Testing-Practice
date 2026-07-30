package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Chrome browser opened");

        // 2. Open the login page of the live project
        driver.get("https://javabykiran.com/liveproject/index.html");
        Thread.sleep(2000);
        System.out.println("Login page opened");

        // 3. Click on "Register a new membership" link
        driver.findElement(By.xpath("//a[text()='Register a new membership']")).click();
        Thread.sleep(1000);
        System.out.println("Register page opened");

        // 4. Fill the registration form
        driver.findElement(By.id("name")).sendKeys("Rachana Patil");
        Thread.sleep(1000);
        System.out.println("Name entered");

        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        Thread.sleep(1000);
        System.out.println("Mobile entered");

        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        Thread.sleep(1000);
        System.out.println("Email entered");

        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(1000);
        System.out.println("Password entered");

        // 5. Click on Register button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
        System.out.println("Register button clicked");

        // This page shows a popup message
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        System.out.println("Registration completed");

        // 6. Go back to login page 
        driver.findElement(By.xpath("//a[text()='I already have a membership']")).click();
        Thread.sleep(1000);
        System.out.println("Back on login page");

        driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
        Thread.sleep(1000);
        System.out.println("Login email entered");

        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(1000);
        System.out.println("Login password entered");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        System.out.println("Login completed, Dashboard opened");

        // 7. Click Dashboard
        driver.findElement(By.xpath("//a[@href='dashboard.html']")).click();
        Thread.sleep(1000);
        System.out.println("Dashboard page opened");

        // 8. Click Operators
        driver.findElement(By.xpath("//a[@href='operators.html']")).click();
        Thread.sleep(1000);
        System.out.println("Operators page opened");

        // 9. Click Useful Links
        driver.findElement(By.xpath("//a[@href='links.html']")).click();
        Thread.sleep(1000);
        System.out.println("Useful Links page opened");

        // 10. Click Downloads
        driver.findElement(By.xpath("//a[@href='downloads.html']")).click();
        Thread.sleep(1000);
        System.out.println("Downloads page opened");

        // 11. Go to Users page
        driver.findElement(By.xpath("//a[@href='users.html']")).click();
        Thread.sleep(3000);
        System.out.println("Users page opened");

        // 12. Click "Add User"
        driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click();
        Thread.sleep(1000);
        System.out.println("Add User page opened");

        // 13. Fill the Add User form
        driver.findElement(By.id("username")).sendKeys("Rachana Patil");
        Thread.sleep(1000);
        System.out.println("Username entered");

        driver.findElement(By.id("mobile")).sendKeys("9876543210");
        Thread.sleep(1000);
        System.out.println("Mobile entered");

        driver.findElement(By.id("email")).sendKeys("rachana@gmail.com");
        Thread.sleep(1000);
        System.out.println("Email entered");

        driver.findElement(By.id("course")).sendKeys("Selenium");
        Thread.sleep(1000);
        System.out.println("Course entered");

        driver.findElement(By.id("Female")).click();
        Thread.sleep(1000);
        System.out.println("Female radio button selected");

        driver.findElement(By.xpath("//select[@class='form-control']")).sendKeys("Maharashtra");
        Thread.sleep(1000);
        System.out.println("State selected");

        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(1000);
        System.out.println("Password entered");

        // 14. Click Submit
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        System.out.println("Submit button clicked");

        // This page also shows a popup message
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        System.out.println("New user added");

        // 15. Finally click Logout
        driver.findElement(By.xpath("//a[@href='logout.html']")).click();
        Thread.sleep(2000);
        System.out.println("Logout completed. Project flow finished");

        // 16. Close the browser
        driver.quit();
    }
}