package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class17_RelativeXpathDateSelection {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tr[3]//td[4]//a")).click();

        System.out.println("Class 17 Completed: Relative Index-based XPath Selection");
        driver.quit();
    }
}