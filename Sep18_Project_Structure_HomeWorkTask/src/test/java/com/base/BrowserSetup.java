package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSetup {
    public static WebDriver driver;

    public static void startBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
}