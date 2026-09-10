package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class08_DisabledDatesCheck {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        driver.findElement(By.id("datepicker")).click();

        WebElement day = driver.findElement(By.xpath("//a[text()='15']"));
        if (day.isEnabled()) {
            day.click();
            System.out.println("Class 08 Completed: Date Enabled and Clicked!");
        }

        driver.quit();
    }
}