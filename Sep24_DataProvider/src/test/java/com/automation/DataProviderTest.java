package com.automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "studentData")
    public void Display(String name, long number) {
        System.out.println("Student Name : " + name);
        System.out.println("Student Number : " + number);
    }

    @DataProvider
    public Object[][] studentData() {
        Object[][] data = {
            {"Rachna", 1234567},
            {"Sumesh", 332434},
            {"Manisha", 54767},
            {"Sunjay", 6586}
        };
        return data;
    }
}