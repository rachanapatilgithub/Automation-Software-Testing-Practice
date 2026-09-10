package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class50_AirBnbDateRangePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.airbnb.com/");

        driver.findElement(By.xpath("//div[text()='Check in']")).click();

        WebElement checkInDate = driver.findElement(By.xpath("(//td[contains(@class,'') and not(contains(@class,'_12bf372'))])[10]"));
        checkInDate.click();

        System.out.println("Class 50 Completed: Airbnb Range Calendar Handled!");
        driver.quit();
    }
}