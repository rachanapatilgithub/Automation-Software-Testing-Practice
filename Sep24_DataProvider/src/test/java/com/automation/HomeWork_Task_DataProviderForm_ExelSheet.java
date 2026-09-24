package com.automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeWork_Task_DataProviderForm_ExelSheet {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://javabykiran.com/liveproject/index.html");
    }

    @Test(dataProvider = "logindata")
    public void login(String username, String password) {
        WebElement uname = driver.findElement(By.id("email"));
        uname.clear();
        uname.sendKeys(username);

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys(password);

        WebElement signinbutton = driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button"));
        signinbutton.click();

        String url = driver.getCurrentUrl();
        if (url.contains("dashboard.html")) {
            System.out.println("Login SUCCESS - with " + username + " and " + password);
        } else {
            System.out.println("Login FAILED - with " + username + " and " + password);
        }
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "logindata")
    public Object[][] logindata() throws IOException {
        FileInputStream file = new FileInputStream("src/test/resources/LoginData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        
        Object[][] data = new Object[rowCount][colCount];
        
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        
        wb.close();
        file.close();
        return data;
    }
}