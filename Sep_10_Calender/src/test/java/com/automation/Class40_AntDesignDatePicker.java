package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Class40_AntDesignDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ant.design/components/date-picker");

        driver.findElement(By.xpath("(//input[@placeholder='Select date'])[1]")).click();
        driver.findElement(By.xpath("//div[@class='ant-picker-cell-inner' and text()='15']")).click();

        System.out.println("Class 40 Completed: Ant Design Enterprise Calendar Handled!");
        driver.quit();
    }
}