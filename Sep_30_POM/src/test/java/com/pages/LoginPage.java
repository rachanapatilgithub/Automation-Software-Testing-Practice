package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement Email;

    @FindBy(id = "password")
    WebElement pwd;

    @FindBy(xpath = "//*[@id=\"form\"]/div[3]/button")
    WebElement signinbutton;

    public void enterEmail(String username) {
        Email.clear();
        Email.sendKeys(username);
    }

    public void enterPassword(String pw) {
        pwd.clear();
        pwd.sendKeys(pw);
    }

    public void Login(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        signinbutton.click();
    }
}