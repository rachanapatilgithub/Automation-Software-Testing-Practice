package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionclassShortcutMethod {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://thekiranacademy.com/");
        
        Actions act = new Actions(driver);
        
        WebElement allcourses = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/div/button"));
        WebElement specialcourse = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/div/div[1]/div[1]/button[3]"));
        WebElement pythoncourse = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/div/div[1]/div"));
        
        // Shortcut Method: Chaining the moveToElement actions together
        act.moveToElement(allcourses).moveToElement(specialcourse).moveToElement(pythoncourse).perform();
        
        pythoncourse.click();
    }
}