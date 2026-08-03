package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class July31DropDownHomeWorkTask1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/select-menu");

        WebElement dropdown1 = driver.findElement(By.id("oldSelectMenu"));

        Select ss = new Select(dropdown1);

        ss.selectByVisibleText("Purple");

        WebElement dropdown2 = driver.findElement(By.id("cars"));

        Select ss1 = new Select(dropdown2);

        System.out.println(ss1.isMultiple());

        ss1.selectByVisibleText("Volvo");
        ss1.selectByVisibleText("Saab");
        ss1.selectByVisibleText("Audi");

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