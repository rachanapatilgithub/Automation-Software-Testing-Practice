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

public class ExcelSheetReadTest {
    public static void main(String[] args) throws Exception {

        FileInputStream fp = new FileInputStream("H:\\Java By Kiran Recording\\Recording\\Selenium Testing\\Recording Selenium Module\\Day22ExelSheetReading\\ExcelSheetRead.xlsx");

        Workbook ww = new XSSFWorkbook(fp);
        Sheet sh = ww.getSheet("ExeclSheetRead");

        Row rr = sh.getRow(1);

        String usename = rr.getCell(0).getStringCellValue();
        String pwd = rr.getCell(1).getStringCellValue();

        System.out.println("Username is - " + usename);
        System.out.println("Password is - " + pwd);

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");

        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys(usename);

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(pwd);

        WebElement siginbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div[1]/button"));
        siginbutton.click();
    }
}