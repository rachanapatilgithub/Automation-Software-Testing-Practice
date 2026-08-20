package com.automation;
//Task9 — tutorialspoint slider.php (enabled + disabled slider)
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task9 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.id("ageInputId"));
        WebElement output = driver.findElement(By.id("ageOutputId"));

        System.out.println("Starting age value: " + output.getText());

        // moveToElement - hover onto the slider
        act.moveToElement(slider).perform();

        // click - jumps the handle to the clicked point
        act.click(slider).perform();
        System.out.println("Age value after click: " + output.getText());

        // pause - small wait so the movement is visible
        act.pause(Duration.ofMillis(500)).perform();

        // clickAndHold + moveByOffset + release - drag the handle
        act.clickAndHold(slider).moveByOffset(60, 0).release().perform();
        System.out.println("Age value after drag: " + output.getText());

        // dragAndDropBy - shortcut for clickAndHold + moveByOffset + release
        act.dragAndDropBy(slider, 30, 0).perform();
        System.out.println("Age value after dragAndDropBy: " + output.getText());

        // sendKeys - move the focused slider using the keyboard
        act.sendKeys(slider, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
        System.out.println("Age value after arrow keys: " + output.getText());

        // The second slider on this page is disabled - check instead of interacting
        WebElement disabledSlider = driver.findElement(By.id("disabledRange"));
        System.out.println("Disabled slider enabled? " + disabledSlider.isEnabled());

        driver.quit();
    }
}
