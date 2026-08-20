package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BasicAutomationusingJSexecuter {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement username = driver.findElement(By.id("email"));
        js.executeScript("arguments[0].value='kiran@gmail.com'", username);

        WebElement pwd = driver.findElement(By.id("password"));
        js.executeScript("arguments[0].value='123456'", pwd);

        WebElement signinbutton = driver.findElement(
            By.xpath("//*[@id=\"form\"]/div[3]/div/button")
        );
        js.executeScript("arguments[0].click();", signinbutton);

        //window.scrollBy(0,0);
    }
}