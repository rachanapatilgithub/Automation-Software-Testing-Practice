package com.automation;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class10_CustomCalendarTable {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

        driver.findElement(By.id("datepicker")).click();

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
        for (WebElement ele : dates) {
            if (ele.getText().equals("18")) {
                ele.click();
                break;
            }
        }

        System.out.println("Class 10 Completed: Calendar Table Iteration");
        driver.quit();
    }
}