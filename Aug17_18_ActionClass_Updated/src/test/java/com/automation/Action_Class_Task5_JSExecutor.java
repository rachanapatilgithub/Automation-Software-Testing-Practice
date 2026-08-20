package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Action_Class_Task5_JSExecutor {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://javabykiran.com/liveproject/index.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement username = driver.findElement(By.id("email"));
        js.executeScript("arguments[0].value='kiran@gmail.com'", username);

        WebElement pwd = driver.findElement(By.id("password"));
        js.executeScript("arguments[0].value='123456'", pwd);

        WebElement signinbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
        js.executeScript("arguments[0].click();", signinbutton);

        String title = (String) js.executeScript("return document.title");
        System.out.println("Page title: " + title);

        driver.quit();
    }
}
