package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JSExecuter_Highlight_Task {

    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://thekiranacademy.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement footer = driver.findElement(By.xpath("/html/body/footer/div[2]/span[1]"));

        js.executeScript("arguments[0].scrollIntoView();", footer);

        js.executeScript("arguments[0].style.border='4px solid yellow'", footer);

        System.out.println("Footer is visible");
    }
}
