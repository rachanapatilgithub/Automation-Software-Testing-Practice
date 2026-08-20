//Task2 — slider: move right by a fixed offset

package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task2 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/slider/");

        System.out.println("Slider Automation");

        // Locate Slider
        WebElement slider = driver.findElement(By.id("slideMe"));

        // Create Actions object
        Actions act = new Actions(driver);

        // Move slider to right
        act.clickAndHold(slider).moveByOffset(100, 0).release().perform();

        WebElement value = driver.findElement(By.id("value"));
        System.out.println("Slider value: " + value.getText());

        driver.quit();
    }
}