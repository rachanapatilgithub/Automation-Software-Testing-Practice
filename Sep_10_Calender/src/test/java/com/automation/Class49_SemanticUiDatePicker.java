package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class49_SemanticUiDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://fomantic-ui.com/modules/calendar.html");

        driver.findElement(By.xpath("(//div[contains(@class,'ui calendar')]//input)[1]")).click();
        driver.findElement(By.xpath("//td[contains(@class,'link') and text()='21']")).click();

        System.out.println("Class 49 Completed: Semantic/Fomantic UI Calendar Handled!");
        driver.quit();
    }
}