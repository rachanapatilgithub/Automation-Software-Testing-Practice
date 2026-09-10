package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Class11_ActionsClassCalendar {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        WebElement input = driver.findElement(By.id("datePickerMonthYearInput"));
        Actions act = new Actions(driver);
        act.moveToElement(input).click().perform();

        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--010')]")).click();

        System.out.println("Class 11 Completed: Actions Class Click");
        driver.quit();
    }
}