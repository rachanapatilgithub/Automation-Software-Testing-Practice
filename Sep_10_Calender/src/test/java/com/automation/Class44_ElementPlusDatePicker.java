package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class44_ElementPlusDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://element-plus.org/en-US/component/date-picker.html");

        driver.findElement(By.xpath("(//input[@placeholder='Pick a day'])[1]")).click();
        driver.findElement(By.xpath("(//td[contains(@class,'available')]//span[text()='18'])[1]")).click();

        System.out.println("Class 44 Completed: Element Plus Vue DatePicker Handled!");
        driver.quit();
    }
}