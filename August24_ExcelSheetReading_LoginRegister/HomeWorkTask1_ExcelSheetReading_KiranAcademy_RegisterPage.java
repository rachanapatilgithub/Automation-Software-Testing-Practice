package com.automation;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask1_ExcelSheetReading_KiranAcademy_RegisterPage {
    public static void main(String[] args) throws Exception {

        FileInputStream fp = new FileInputStream("HomeWorkTask1_ExcelSheetReading_KiranAcademy_RegisterPage.xlsx");

        Workbook ww = new XSSFWorkbook(fp);
        Sheet sh = ww.getSheet("Sheet1");

        Row rr = sh.getRow(1);

        String name = rr.getCell(0).getStringCellValue();
        String mobile = rr.getCell(1).getStringCellValue();
        String email = rr.getCell(2).getStringCellValue();
        String pwd = rr.getCell(3).getStringCellValue();

        System.out.println("Name is - " + name);
        System.out.println("Mobile is - " + mobile);
        System.out.println("Email is - " + email);
        System.out.println("Password is - " + pwd);

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys(name);

        WebElement mobileField = driver.findElement(By.id("mobile"));
        mobileField.sendKeys(mobile);

        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);

        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys(pwd);

        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[5]/div/button"));
        registerButton.click();
    }
}
