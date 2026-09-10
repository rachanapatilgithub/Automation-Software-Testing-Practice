package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class25_JQueryDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        WebElement demoFrame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(demoFrame);

        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//a[text()='22']")).click();

        System.out.println("Class 25 Completed: JQuery UI Frame Calendar Handled!");
        driver.quit();
    }
}