package com.automation;

import com.microsoft.playwright.Browser;


import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywriteFirst {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false));

        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080));

        Page page = context.newPage();

        // Open Login Page
        page.navigate("https://javabykiran.com/liveproject/index.html");

        // Enter Username
        page.locator("#email").fill("Rachana");

        // Enter Password
        page.locator("#password").fill("123456");

        // Click Login Button
        page.locator("#loginBtn").click();

        // Close Browser
        browser.close();
        playwright.close();
    }
}
