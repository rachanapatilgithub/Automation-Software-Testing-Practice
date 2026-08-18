//Task3 — slider: click only (no drag), then read where it landed
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task3 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/slider/");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.id("slideMe"));

        // Click without moving - the browser snaps the handle to the click point
        act.clickAndHold(slider).release().perform();

        WebElement currentValue = driver.findElement(By.id("value"));
        String value = currentValue.getText();
        System.out.println("currentValue: " + value);

        driver.quit();
    }
}