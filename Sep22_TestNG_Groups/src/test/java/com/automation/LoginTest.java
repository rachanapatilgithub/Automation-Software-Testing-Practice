package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters({"brname", "loginurl"})
    public void openbrowser(String brname, String url) {
        if (brname.equals("edge")) {
            driver = new EdgeDriver();
        } else if (brname.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.get(url);
    }

    @Test
    public void login() {
        System.out.println("login successfull");
    }
}