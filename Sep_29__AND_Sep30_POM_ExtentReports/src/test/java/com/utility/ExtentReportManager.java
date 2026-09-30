package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    
    public static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getReporter() {
        if (extent == null) {
            String path = System.getProperty("user.dir") + "\\reports\\index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Web Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Rachana");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}