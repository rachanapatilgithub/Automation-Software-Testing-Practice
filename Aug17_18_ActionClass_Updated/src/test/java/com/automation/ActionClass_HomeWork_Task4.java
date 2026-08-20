
//Task4 — slider: before/after comparison with Pass/Fail
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task4 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/slider/");

        Actions act = new Actions(driver);

        WebElement value = driver.findElement(By.id("value"));
        String defaultValue = value.getText();
        System.out.println("Default Value - " + defaultValue);

        WebElement slider = driver.findElement(By.id("slideMe"));
        act.clickAndHold(slider).moveByOffset(300, 0).release().perform();

        String currentValue = value.getText();
        System.out.println("Current Value - " + currentValue);

        if (!defaultValue.equals(currentValue)) {
            System.out.println("TestCase Passed - Slider is Moved");
        } else {
            System.out.println("TestCase Failed - Slider is not Moved");
        }

        driver.quit();
    }
}