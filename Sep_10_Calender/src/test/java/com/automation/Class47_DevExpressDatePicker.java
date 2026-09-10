package com.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Class47_DevExpressDatePicker {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://js.devexpress.com/Demos/WidgetsGallery/Demo/DateBox/Overview/");

        try {
            WebElement iframe = driver.findElement(By.id("sampleFrame"));
            driver.switchTo().frame(iframe);
        } catch (Exception e) {
            System.out.println("Frame not present.");
        }

        driver.findElement(By.xpath("(//div[contains(@class,'dx-dropdowneditor-icon')])[1]")).click();
        driver.findElement(By.xpath("//span[text()='14']")).click();

        System.out.println("Class 47 Completed: DevExpress DateBox Handled!");
        driver.quit();
    }
}