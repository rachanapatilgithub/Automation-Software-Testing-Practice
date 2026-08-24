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

public class HomeWorkTask2_ExcelSheetMultipleDataReading_KiranAcademy_LoginPage {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");

        FileInputStream fp = new FileInputStream("HomeWorkTask2_ExcelSheetMultipleDataReading_KiranAcademy_LoginPage.xlsx");

        Workbook ww = new XSSFWorkbook(fp);
        Sheet sh = ww.getSheet("Sheet1");

        int rowcount = sh.getPhysicalNumberOfRows();

        for (int i = 1; i < rowcount; i++) {

            Row rr = sh.getRow(i);

            String usename = rr.getCell(0).getStringCellValue();
            String pwd = rr.getCell(1).getStringCellValue();

            System.out.println("Username is - " + usename);
            System.out.println("Password is - " + pwd);

            WebElement username = driver.findElement(By.id("email"));
            username.sendKeys(usename);

            WebElement pass = driver.findElement(By.id("password"));
            pass.sendKeys(pwd);

            WebElement siginbutton = driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button"));
            siginbutton.click();

            String url = driver.getCurrentUrl();
            if (url.contains("dashboard.html")) {
                System.out.println("Login SUCCESS - with " + usename + " and " + pwd);
            } else {
                System.out.println("Login FAILED - with " + usename + " and " + pwd);
            }

            username.clear();
            pass.clear();
        }
    }
}
