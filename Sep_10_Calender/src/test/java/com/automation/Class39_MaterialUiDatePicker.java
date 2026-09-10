package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class39_MaterialUiDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mui.com/x/react-date-pickers/date-picker/");

        WebElement calendarIcon = driver.findElement(By.xpath("(//button[@aria-label='Choose date'])[1]"));
        calendarIcon.click();
        driver.findElement(By.xpath("//button[text()='20']")).click();

        System.out.println("Class 39 Completed: React Material UI DatePicker Handled!");
        driver.quit();
    }
}