package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task11 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/slider/");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.id("slideMe"));
        WebElement valueLabel = driver.findElement(By.id("value"));

        System.out.println("Starting value: " + valueLabel.getText());

        // moveToElement(element) - move the mouse onto the slider handle
        act.moveToElement(slider).perform();
        System.out.println("Moved mouse to slider");

        // moveToElement(element, xOffset, yOffset) - move onto the slider, then 20px further right
        act.moveToElement(slider, 20, 0).perform();
        System.out.println("Moved mouse to slider + 20px offset");

        // click(element) - press and release the mouse; jumps the handle to that point
        act.click(slider).perform();
        System.out.println("Value after click: " + valueLabel.getText());

        // doubleClick(element) - shown for completeness; a slider has no special
        // double-click behaviour, so it just behaves like a second click
        act.doubleClick(slider).perform();
        System.out.println("Value after doubleClick: " + valueLabel.getText());

        // pause(Duration) - wait between steps so the movement is easy to see
        act.pause(Duration.ofMillis(500)).perform();

        // clickAndHold(element) + moveByOffset(x, y) + release() - manual drag, 3 separate steps
        act.clickAndHold(slider).moveByOffset(100, 0).release().perform();
        System.out.println("Value after clickAndHold + moveByOffset + release: " + valueLabel.getText());

        // dragAndDropBy(element, x, y) - shortcut that does clickAndHold + moveByOffset + release
        // in a single call
        act.dragAndDropBy(slider, 50, 0).perform();
        System.out.println("Value after dragAndDropBy: " + valueLabel.getText());

        // keyDown(key) + keyUp(key) - press and hold a modifier key around another action
        // (normally used for combinations like Shift+Click); shown here around an arrow key
        act.keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_RIGHT).keyUp(Keys.SHIFT).perform();
        System.out.println("Value after keyDown(SHIFT) + arrow key + keyUp(SHIFT): " + valueLabel.getText());

        // sendKeys(element, keys) - focus the slider first, then move it with the keyboard
        act.sendKeys(slider, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
        System.out.println("Value after sendKeys arrow keys: " + valueLabel.getText());

        // Not used on purpose:
        // - contextClick(element): right-click opens the browser's real native menu, which
        //   Selenium cannot reliably close again, so it's normally avoided in test scripts
        // - dragAndDrop(source, target): needs two different elements (see the drag-and-drop
        //   circles exercise); this page only has one slider, so there is no target to use

        System.out.println("Final value: " + valueLabel.getText());

        driver.quit();
    }
}
