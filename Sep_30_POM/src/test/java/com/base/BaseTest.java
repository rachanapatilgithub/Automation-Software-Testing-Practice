package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/selenium/index.html");
    }

    public void closeBrowser() {
        driver.quit();
    }
}