package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class July31FullTestDropDown2HomeWork {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/select-menu");

        // 1) Select Value - with Option Group (custom React dropdown - Single Select)
        driver.findElement(By.id("withOptGroup")).click();
        driver.findElement(By.xpath("//div[text()='Group 2, option 1']")).click();

        // 2) Select One (custom React dropdown - Single Select)
        driver.findElement(By.id("selectOne")).click();
        driver.findElement(By.xpath("//div[text()='Mr.']")).click();

        // 3) Old Style Select Menu (Normal HTML Select - Single Select)
        WebElement dropdown1 = driver.findElement(By.id("oldSelectMenu"));

        Select ss = new Select(dropdown1);

        ss.selectByVisibleText("Purple");

        // 4) Multiselect drop down (custom React dropdown - Multi Select)
        WebElement multiSelectInput = driver.findElement(By.id("react-select-4-input"));

        multiSelectInput.click();
        driver.findElement(By.xpath("//div[text()='Green']")).click();

        multiSelectInput.click();
        driver.findElement(By.xpath("//div[text()='Blue']")).click();

        multiSelectInput.click();
        driver.findElement(By.xpath("//div[text()='Black']")).click();

        // 5) Standard multi select (Normal HTML Select - Multi Select)
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

        System.out.println("----Selected items from Standard multi select----\n");

        System.out.println(listitems.get(0).getText());
        System.out.println(listitems.get(1).getText());
        System.out.println(listitems.get(2).getText());

    }
}