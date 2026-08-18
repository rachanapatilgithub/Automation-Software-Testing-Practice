package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task12 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        Actions act = new Actions(driver);

        WebElement container = driver.findElement(By.id("target"));

        WebElement red = driver.findElement(By.xpath("//*[@id=\"source\"]/div[1]"));

        //act.dragAndDrop(red, container).release().perform();

        act.clickAndHold(red).moveToElement(container).release().perform();
    }
}
