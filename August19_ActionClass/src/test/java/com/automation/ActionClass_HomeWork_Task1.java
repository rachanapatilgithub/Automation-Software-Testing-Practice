//Task1 — drag-and-drop circles using clickAndHold + moveToElement (instead of dragAndDrop())

package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task1 {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        Actions act = new Actions(driver);

        WebElement container = driver.findElement(By.id("target"));
        WebElement red = driver.findElement(By.xpath("//*[@id='source']/div[@class='red']"));
        WebElement green = driver.findElement(By.xpath("//*[@id='source']/div[@class='green']"));
        WebElement blue = driver.findElement(By.xpath("//*[@id='source']/div[@class='blue']"));

        // clickAndHold + moveToElement + release instead of dragAndDrop()
        act.clickAndHold(red).moveToElement(container).release()
           .clickAndHold(green).moveToElement(container).release()
           .clickAndHold(blue).moveToElement(container).release()
           .perform();

        driver.quit();
    }
}
