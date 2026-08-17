package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_DragAndDrop {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        Actions act = new Actions(driver);

        WebElement container = driver.findElement(By.id("target"));

        // Drag and drop Red
        WebElement red = driver.findElement(By.xpath("//*[@id='source']/div[@class='red']"));
        act.dragAndDrop(red, container).release().perform();

        // Drag and drop Green
        WebElement green = driver.findElement(By.xpath("//*[@id='source']/div[@class='green']"));
        act.dragAndDrop(green, container).release().perform();

        // Drag and drop Blue
        WebElement blue = driver.findElement(By.xpath("//*[@id='source']/div[@class='blue']"));
        act.dragAndDrop(blue, container).release().perform();
    }
}