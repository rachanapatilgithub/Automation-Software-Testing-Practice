package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class09_HTML5DateInput {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/inputs");

        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("2026");

        System.out.println("Class 09 Completed: Native HTML Input Field");
        driver.quit();
    }
}