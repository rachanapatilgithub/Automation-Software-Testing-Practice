package com.automation;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Class34_FluentWaitCalendarHandling {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/date-picker");

        driver.findElement(By.id("datePickerMonthYearInput")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement targetDate = wait.until(d -> d.findElement(
            By.xpath("//div[contains(@class,'react-datepicker__day--022') and not(contains(@class,'outside-month'))]")
        ));

        targetDate.click();

        System.out.println("Class 34 Completed: Date Selected via FluentWait!");
        driver.quit();
    }
}