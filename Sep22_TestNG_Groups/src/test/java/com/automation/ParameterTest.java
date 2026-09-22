package com.automation;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Test
    @Parameters({"value1", "value2"})
    public void addition(int n1, int n2) {
        System.out.println("Addition of two numbers - " + (n1 + n2));
    }

    @Test
    @Parameters({"val1", "val2"})
    public void substraction(@Optional("50") int a, int b) {
        System.out.println("Subtraction of two numbers - " + (a - b));
    }
}