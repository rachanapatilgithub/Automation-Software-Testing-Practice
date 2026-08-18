package com.automation;
//Task8 — practice-automation.com/slider
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task8 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/slider/");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.id("slideMe"));
        WebElement valueLabel = driver.findElement(By.id("value"));

        System.out.println("Starting value: " + valueLabel.getText());

        // moveToElement - hover onto the slider
        act.moveToElement(slider).perform();

        // click - jumps the handle to the clicked point
        act.click(slider).perform();
        System.out.println("Value after click: " + valueLabel.getText());

        // pause - small wait so the movement is visible
        act.pause(Duration.ofMillis(500)).perform();

        // clickAndHold + moveByOffset + release - drag the handle
        act.clickAndHold(slider).moveByOffset(100, 0).release().perform();
        System.out.println("Value after drag: " + valueLabel.getText());

        // dragAndDropBy - shortcut for clickAndHold + moveByOffset + release
        act.dragAndDropBy(slider, 50, 0).perform();
        System.out.println("Value after dragAndDropBy: " + valueLabel.getText());

        // sendKeys - move the focused slider using the keyboard
        act.sendKeys(slider, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
        System.out.println("Value after arrow keys: " + valueLabel.getText());

        driver.quit();
    }
}
