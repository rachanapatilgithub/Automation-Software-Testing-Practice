package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utility.ExtentReportManager;

public class BaseTest {
    
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void startReport() {
        extent = ExtentReportManager.getReporter(); // रिपोर्ट सुरू करण्यासाठी
    }

    public void openBrowser() {
       
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.thetestingworld.com/testings/"); // तुमची प्रोजेक्ट URL
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush(); 
        }
    }
}