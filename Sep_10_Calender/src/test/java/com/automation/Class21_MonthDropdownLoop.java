package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Class21_MonthDropdownLoop {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/date-picker");

        driver.findElement(By.id("datePickerMonthYearInput")).click();

        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        for (int i = 0; i < month.getOptions().size(); i++) {
            if (month.getOptions().get(i).getText().equals("August")) {
                month.selectByIndex(i);
                break;
            }
        }

        System.out.println("Class 21 Completed: Month Dropdown Iterated and Selected");
        driver.quit();
    }
}