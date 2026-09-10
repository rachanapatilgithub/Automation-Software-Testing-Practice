package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class32_GoibiboDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.goibibo.com/");

        try {
            driver.findElement(By.xpath("//span[contains(@class,'logSprite icClose')]")).click();
        } catch (Exception e) {
            System.out.println("No popup found.");
        }

        driver.findElement(By.xpath("//span[text()='Departure']")).click();

        while (true) {
            WebElement monthHeader = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]"));
            if (monthHeader.getText().contains("December")) {
                break;
            } else {
                driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            }
        }

        driver.findElement(By.xpath("//div[@class='DayPicker-Day']//p[text()='25']")).click();

        System.out.println("Class 32 Completed: Goibibo Calendar Handled!");
        driver.quit();
    }
}