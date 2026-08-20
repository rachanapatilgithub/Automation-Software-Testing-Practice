
//Task7 — expandtesting horizontal-slider (keyboard method + drag method combined)

package com.automation;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionClass_HomeWork_Task7 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/horizontal-slider");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        WebElement valueLabel = driver.findElement(By.id("range"));

        System.out.println("Starting value: " + valueLabel.getText());

        // Method 1: focus the slider and move it using arrow keys
        slider.click();
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        System.out.println("Value after arrow keys: " + valueLabel.getText());

        // Method 2: clickAndHold + moveByOffset + release - drag it with the mouse
        act.clickAndHold(slider).moveByOffset(40, 0).release().perform();
        System.out.println("Value after drag: " + valueLabel.getText());

        driver.quit();
    }
}
