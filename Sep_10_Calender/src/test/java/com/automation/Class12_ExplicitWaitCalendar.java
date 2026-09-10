package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class12_ExplicitWaitCalendar {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/date-picker");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("datePickerMonthYearInput")));
        input.click();

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class,'react-datepicker__day--012') and not(contains(@class,'outside-month'))]")
        ));
        date.click();

        System.out.println("Class 12 Completed: Explicit Wait Integration");
        driver.quit();
    }
}