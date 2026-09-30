package com.test;

import static org.testng.Assert.assertEquals;
import com.base.BaseTest;
import com.pages.LoginPage;
import com.utility.Utility;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage lp;

    @BeforeClass
    void start() {
        openBrowser();
        lp = new LoginPage(driver);
    }

    @Test
    void validLogin() {
        lp.Login("kiran@gmail.com", "12345");
        String Expectedtitle = driver.getTitle();
        assertEquals(Expectedtitle, "JavaByKiran | Dashboard");
        System.out.println("Testcase Passed");
        Utility.captureScreenshot(driver, "ValidLogin_Pass");
    }

    @Test
    void invalidLogin() {
        lp.Login("KIRAN@GMAIL.COM", "12345");
        String Expectedtitle = driver.getTitle();
        assertEquals(Expectedtitle, "JavaByKiran | Log in");
    }
}