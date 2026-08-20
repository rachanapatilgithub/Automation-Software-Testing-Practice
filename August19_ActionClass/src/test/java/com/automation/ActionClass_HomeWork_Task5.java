
//Task5 — practice-automation.com/slider (moveToElement, clickAndHold, moveByOffset, release, dragAndDropBy)
package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task5 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/slider/");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.id("slideMe"));
        WebElement valueLabel = driver.findElement(By.id("value"));

        System.out.println("Starting value: " + valueLabel.getText());

        // 1) moveToElement - just hover onto the slider first
        act.moveToElement(slider).perform();
        System.out.println("Mouse moved to slider");

        // 2) clickAndHold + moveByOffset + release - drag it to the right
        act.clickAndHold(slider).moveByOffset(150, 0).release().perform();
        System.out.println("Value after drag: " + valueLabel.getText());

        // 3) dragAndDropBy - move it further right in one shortcut call
        act.dragAndDropBy(slider, 50, 0).perform();
        System.out.println("Value after dragAndDropBy: " + valueLabel.getText());

        driver.quit();
    }
}
