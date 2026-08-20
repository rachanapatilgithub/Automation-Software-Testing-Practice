package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class_Task3_Yesterday {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://thekiranacademy.com/");

        Actions act = new Actions(driver);

        WebElement allcourses = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/div/button"));
        WebElement specialcourse = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/div/div[1]/div[1]/button[3]"));
        WebElement pythoncourse = driver.findElement(By.xpath("/html/body/header/nav/div/div[1]/div/div[1]/div"));

        act.moveToElement(allcourses).moveToElement(specialcourse).moveToElement(pythoncourse).perform();

        pythoncourse.click();

        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");

        WebElement container = driver.findElement(By.id("target"));
        WebElement red = driver.findElement(By.xpath("//*[@id='source']/div[@class='red']"));
        WebElement green = driver.findElement(By.xpath("//*[@id='source']/div[@class='green']"));
        WebElement blue = driver.findElement(By.xpath("//*[@id='source']/div[@class='blue']"));

        act.dragAndDrop(red, container).release()
           .dragAndDrop(green, container).release()
           .dragAndDrop(blue, container).release()
           .perform();

        driver.quit();
    }
}
