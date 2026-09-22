package com.automation;

import org.testng.annotations.Test;

public class TestNGroups {

    @Test(groups = "smoke")
    void login() {
        System.out.println("This is smoke testing for login module");
    }

    @Test(groups = "sanity")
    void Logout() {
        System.out.println("This is Sanity Testing for logout module");
    }

    @Test(groups = "sanity")
    void Displayusers() {
        System.out.println("This is Sanity Testing for Display users module");
    }
}