package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class July31DropDown1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

        WebElement dropdown1 = driver.findElement(By.id("course"));

        Select ss = new Select(dropdown1);

        // ss.selectByIndex(1);
        // ss.selectByVisibleText("Java");
        ss.selectByVisibleText("Python");

        //ss.selectByValue("Net");

    }
}