package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_DragAndDrop_Shortcut_Method {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        Actions act = new Actions(driver);

        WebElement container = driver.findElement(By.id("target"));

        // Locate all source elements
        WebElement red = driver.findElement(By.xpath("//*[@id='source']/div[@class='red']"));
        WebElement green = driver.findElement(By.xpath("//*[@id='source']/div[@class='green']"));
        WebElement blue = driver.findElement(By.xpath("//*[@id='source']/div[@class='blue']"));

        // Shortcut Method: Chain all actions together and call perform() once
        act.dragAndDrop(red, container).release()
           .dragAndDrop(green, container).release()
           .dragAndDrop(blue, container).release()
           .perform();
    }
}