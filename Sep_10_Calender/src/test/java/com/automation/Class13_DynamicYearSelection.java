package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Class13_DynamicYearSelection {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        driver.findElement(By.id("datePickerMonthYearInput")).click();

        Select yearSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByVisibleText("2030");

        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--001')]")).click();

        System.out.println("Class 13 Completed: Future Year Selected");
        driver.quit();
    }
}