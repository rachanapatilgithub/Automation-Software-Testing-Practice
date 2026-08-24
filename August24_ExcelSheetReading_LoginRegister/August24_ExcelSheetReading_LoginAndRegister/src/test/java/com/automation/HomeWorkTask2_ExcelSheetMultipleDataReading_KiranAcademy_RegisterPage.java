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

public class HomeWorkTask2_ExcelSheetMultipleDataReading_KiranAcademy_RegisterPage {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/pages/examples/register.html");

        FileInputStream fp = new FileInputStream("H:\\Java By Kiran Recording\\Recording\\Selenium Testing\\Recording Selenium Module\\Day22ExelSheetReading\\HomeWorkTask2_ExcelSheetMultipleDataReading_KiranAcademy_RegisterPage.xlsx");

        Workbook ww = new XSSFWorkbook(fp);
        Sheet sh = ww.getSheet("Sheet1");

        int rowcount = sh.getPhysicalNumberOfRows();

        for (int i = 1; i < rowcount; i++) {

            Row rr = sh.getRow(i);

            String name = rr.getCell(0).getStringCellValue();
            String mobile = rr.getCell(1).getStringCellValue();
            String email = rr.getCell(2).getStringCellValue();
            String pwd = rr.getCell(3).getStringCellValue();

            System.out.println("Name is - " + name);
            System.out.println("Mobile is - " + mobile);
            System.out.println("Email is - " + email);
            System.out.println("Password is - " + pwd);

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

            String url = driver.getCurrentUrl();
            if (url.contains("dashboard.html")) {
                System.out.println("Register SUCCESS - with " + name + " and " + email);
            } else {
                System.out.println("Register FAILED - with " + name + " and " + email);
            }

            nameField.clear();
            mobileField.clear();
            emailField.clear();
            passField.clear();
        }
    }
}