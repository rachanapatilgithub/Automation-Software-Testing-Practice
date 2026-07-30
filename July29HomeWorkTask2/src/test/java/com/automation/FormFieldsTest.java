package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormFieldsTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Chrome browser opened");

        // 2. Open the practice form page
        driver.get("https://practice-automation.com/form-fields/");
        Thread.sleep(2000);
        System.out.println("Form Fields page opened");

        // 3. Enter Name
        driver.findElement(By.id("name-input")).sendKeys("Rachana Patil");
        Thread.sleep(1000);
        System.out.println("Name entered");

        // 4. Enter Password (this field has no id, so we use xpath)
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        Thread.sleep(1000);
        System.out.println("Password entered");

        // 5. Select drink checkboxes (pressing Space instead of clicking)
        driver.findElement(By.id("drink1")).sendKeys(Keys.SPACE);
        Thread.sleep(1000);
        System.out.println("Water checkbox selected");

        driver.findElement(By.id("drink3")).sendKeys(Keys.SPACE);
        Thread.sleep(1000);
        System.out.println("Coffee checkbox selected");

        // 6. Select color radio button (pressing Space instead of clicking)
        driver.findElement(By.id("color2")).sendKeys(Keys.SPACE);
        Thread.sleep(1000);
        System.out.println("Blue color radio button selected");

        // 7. Select "Do you like automation?" dropdown using xpath (option text = Yes)
        driver.findElement(By.xpath("//select[@id='automation']/option[text()='Yes']")).click();
        Thread.sleep(1000);
        System.out.println("'Yes' selected from automation dropdown");

        // 8. Enter Email
        driver.findElement(By.id("email")).sendKeys("rachana@gmail.com");
        Thread.sleep(1000);
        System.out.println("Email entered");

        // 9. Enter Message
        driver.findElement(By.id("message")).sendKeys("This is a Selenium practice test.");
        Thread.sleep(1000);
        System.out.println("Message entered");

        // 10. Click Submit button (pressing Enter instead of clicking)
        driver.findElement(By.id("submit-btn")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        System.out.println("Submit button clicked");

        System.out.println("Form submitted successfully");

        // 11. Close browser
        driver.quit();
        System.out.println("Browser closed");
    }
}