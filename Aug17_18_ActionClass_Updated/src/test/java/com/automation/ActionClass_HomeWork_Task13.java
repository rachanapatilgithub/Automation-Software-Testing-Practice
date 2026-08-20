package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_HomeWork_Task13 {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice-automation.com/slider/");

        Actions act = new Actions(driver);

        WebElement slider = driver.findElement(By.xpath("//*[@id='slideMe']"));

        WebElement value = driver.findElement(By.xpath("//*[@id='value']"));

        // X = 100, Y = 0
        act.clickAndHold(slider)
           .moveByOffset(100, 0)
           .release()
           .perform();

        System.out.println("Slider value: " + value.getText());

        driver.quit();
    }
}
