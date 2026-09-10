package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class29_GlobalsqaDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.globalsqa.com/demo-site/datepicker/");

        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@data-src,'datepicker')]"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//a[text()='10']")).click();

        System.out.println("Class 29 Completed: GlobalSQA DatePicker Handled!");
        driver.quit();
    }
}