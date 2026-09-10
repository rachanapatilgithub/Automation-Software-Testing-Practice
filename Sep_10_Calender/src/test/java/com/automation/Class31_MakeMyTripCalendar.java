package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class31_MakeMyTripCalendar {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.makemytrip.com/");

        try {
            driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
        } catch (Exception e) {
            System.out.println("No modal displayed.");
        }

        driver.findElement(By.xpath("//label[@for='departure']")).click();

        WebElement targetDate = driver.findElement(By.xpath("//div[contains(@class,'DayPicker-Day') and not(contains(@class,'disabled'))]//p[text()='15']"));
        targetDate.click();

        System.out.println("Class 31 Completed: MakeMyTrip Flight Departure Date Selected!");
        driver.quit();
    }
}