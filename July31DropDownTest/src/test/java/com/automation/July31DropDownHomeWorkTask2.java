package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class July31DropDownHomeWorkTask2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://qaplayground.com/practice/dropdowns");

        WebElement dropdown1 = driver.findElement(By.id("languageSelect"));

        Select ss = new Select(dropdown1);

        ss.selectByVisibleText("Java");

        WebElement dropdown2 = driver.findElement(By.id("heroSelect"));

        Select ss1 = new Select(dropdown2);

        System.out.println(ss1.isMultiple());

        ss1.selectByVisibleText("Ant-Man");
        ss1.selectByVisibleText("Aquaman");
        ss1.selectByVisibleText("Batman");

        WebElement first = ss1.getFirstSelectedOption();

        String firstelementtext = first.getText();

        System.out.println("First selected option from List = " + firstelementtext);

        List<WebElement> listitems = ss1.getAllSelectedOptions();

        System.out.println("----Selected items----\n");

        System.out.println(listitems.get(0).getText());
        System.out.println(listitems.get(1).getText());
        System.out.println(listitems.get(2).getText());

    }
}