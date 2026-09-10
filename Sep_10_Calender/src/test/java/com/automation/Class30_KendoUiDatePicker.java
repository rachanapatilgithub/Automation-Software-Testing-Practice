package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class30_KendoUiDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demos.telerik.com/kendo-ui/datepicker/index");

        WebElement calendarBtn = driver.findElement(By.xpath("//button[@aria-label='Toggle calendar']"));
        calendarBtn.click();

        WebElement targetCell = driver.findElement(By.xpath("//a[contains(@class,'k-link') and text()='12']"));
        targetCell.click();

        System.out.println("Class 30 Completed: Kendo UI Advanced Calendar Handled!");
        driver.quit();
    }
}