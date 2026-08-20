package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class_Task4_Hover {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice-automation.com/hover/");

        Actions act = new Actions(driver);

        WebElement heading = driver.findElement(By.id("mouse_over"));

        System.out.println("Before hover: " + heading.getText());

        act.moveToElement(heading).perform();

        System.out.println("After hover: " + heading.getText());

        driver.quit();
    }
}
