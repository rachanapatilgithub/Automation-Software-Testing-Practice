package com.automation;
//Task6 — tutorialspoint slider (enabled + disabled slider, isEnabled check
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task6 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.id("ageInputId"));
        WebElement output = driver.findElement(By.id("ageOutputId"));

        System.out.println("Starting age value: " + output.getText());

        // moveToElement - hover onto the slider handle first
        act.moveToElement(slider).perform();

        // clickAndHold + moveByOffset + release - drag the handle to the right
        act.clickAndHold(slider).moveByOffset(80, 0).release().perform();
        System.out.println("Age value after drag: " + output.getText());

        // Check the second, disabled slider on the same page
        WebElement disabledSlider = driver.findElement(By.id("disabledRange"));
        if (disabledSlider.isEnabled()) {
            act.clickAndHold(disabledSlider).moveByOffset(50, 0).release().perform();
            System.out.println("Disabled slider was moved");
        } else {
            System.out.println("Disabled slider is not enabled - skipping interaction");
        }

        driver.quit();
    }
}
