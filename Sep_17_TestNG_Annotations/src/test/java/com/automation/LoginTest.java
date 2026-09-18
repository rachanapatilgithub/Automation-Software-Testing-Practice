package com.automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new EdgeDriver(); // browser open
        driver.manage().window().maximize(); // window maximize
        driver.get("https://javabykiran.com/liveproject/index.html"); // url open
    }

    @Test(priority = 1)
    public void loginPositiveTest() {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("kiran@gmail.com");

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("123456");

        WebElement signbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/div/button"));
        signbutton.click();
    }

    @Test(priority = 2)
    public void loginIncorrectemailTest() throws Exception {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("kiran@gmai");

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("123456");

        WebElement signbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/div/button"));
        signbutton.click();
        
        username.clear();
        pwd.clear();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void loginIncorrectpwdTest() throws Exception {
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("kiran@gmail.com");

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("123");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}