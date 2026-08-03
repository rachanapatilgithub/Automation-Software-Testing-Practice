package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class July31FullTestDropDown3HomeWork {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://qaplayground.com/practice/dropdowns");

        // 1) Select Fruit by Visible Text (Normal HTML Select - Single Select)
        WebElement dropdown1 = driver.findElement(By.id("fruitSelect"));

        Select ss = new Select(dropdown1);

        ss.selectByVisibleText("Banana");

        // 2) Select Country by Value Attribute (Normal HTML Select - Single Select)
        WebElement dropdown2 = driver.findElement(By.id("countrySelect"));

        Select ss1 = new Select(dropdown2);

        ss1.selectByValue("india");

        // 3) Select Last Language and Read All Options (Normal HTML Select - Single Select)
        WebElement dropdown3 = driver.findElement(By.id("languageSelect"));

        Select ss2 = new Select(dropdown3);

        List<WebElement> allLanguages = ss2.getOptions();

        System.out.println("Total languages available = " + allLanguages.size());

        int lastIndex = allLanguages.size() - 1;

        ss2.selectByIndex(lastIndex);

        System.out.println("Last language selected = " + ss2.getFirstSelectedOption().getText());

        // 4) Multi-Select Superheroes (Normal HTML Select - Multi Select)
        WebElement dropdown4 = driver.findElement(By.id("heroSelect"));

        Select ss3 = new Select(dropdown4);

        System.out.println(ss3.isMultiple());

        ss3.selectByVisibleText("Ant-Man");
        ss3.selectByVisibleText("Aquaman");
        ss3.selectByVisibleText("Batman");

        WebElement first = ss3.getFirstSelectedOption();

        System.out.println("First selected hero = " + first.getText());

        List<WebElement> listitems = ss3.getAllSelectedOptions();

        System.out.println("----Selected heroes----\n");

        System.out.println(listitems.get(0).getText());
        System.out.println(listitems.get(1).getText());
        System.out.println(listitems.get(2).getText());

        // 5) Custom Dropdown Listbox - Priority (not a real <select>, click based)
        driver.findElement(By.id("priorityDropdownTrigger")).click();

        driver.findElement(By.cssSelector("button[data-priority-id='priority-medium']")).click();

        // 6) Searchable City Combobox (not a real <select>, type + click based)
        WebElement citySearch = driver.findElement(By.id("citySearch"));

        citySearch.click();
        citySearch.sendKeys("Mumbai");

        driver.findElement(By.cssSelector("button[data-city-id='city-mumbai']")).click();

    }
}