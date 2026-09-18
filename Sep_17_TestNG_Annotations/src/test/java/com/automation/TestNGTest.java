package com.automation;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite annotation");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest annotation");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("@BeforeClass annotation");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("@BeforeMethod annotation");
    }

    @Test
    public void testMethod() {
        System.out.println("Main @Test method executing");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod annotation");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("@AfterClass annotation");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest annotation");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite annotation");
    }
}