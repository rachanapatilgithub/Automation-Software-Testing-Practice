package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class20_VerifySelectedDateAttribute {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        WebElement input = driver.findElement(By.id("datePickerMonthYearInput"));
        input.click();

        WebElement day = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--022')]"));
        day.click();

        String value = input.getAttribute("value");
        if (value.contains("22")) {
            System.out.println("Class 20 Completed: Date Verification Passed! Current Value: " + value);
        }

        driver.quit();
    }
}