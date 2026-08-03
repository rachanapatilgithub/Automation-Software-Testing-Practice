package com.automation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class July31DropDown2MultiplSelect {




    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

        WebElement dropdown2 = driver.findElement(By.id("ide"));

        Select ss1 = new Select(dropdown2);

        System.out.println(ss1.isMultiple());

        ss1.selectByVisibleText("Eclipse");
        ss1.selectByVisibleText("Visual Studio");
        ss1.selectByVisibleText("NetBeans");

        WebElement first = ss1.getFirstSelectedOption();

        String firstelementtext = first.getText();

        System.out.println("First selected option from List = " + firstelementtext);

        List<WebElement> listitems = ss1.getAllSelectedOptions();

        System.out.println("----Before Deselect items----\n");

        System.out.println(listitems.get(0).getText());
        System.out.println(listitems.get(1).getText());
        System.out.println(listitems.get(2).getText());
    }
}