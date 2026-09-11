package com.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGDemo {

    @Test(dataProvider = "dp")
    public void f(Integer n, String s) {
        System.out.println("Test Method is Running");
        System.out.println("Number: " + n);
        System.out.println("String: " + s);
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method is Running");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method is Running");
    }

    @DataProvider
    public Object[][] dp() {
        System.out.println("Data Provider is Running");

        return new Object[][] {
            new Object[] { 1, "a" },
            new Object[] { 2, "b" }
        };
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class is Running");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class is Running");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test is Running");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test is Running");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite is Running");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite is Running");
    }
}