package com.automation;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FileUploadTest {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/file-upload");

		WebElement fileupload = driver.findElement(By.id("fu-single-input"));
		// fileupload.click();
		fileupload.sendKeys(new File("src/test/resources/upload/SampleUploadFile.txt").getAbsolutePath());

		System.out.println("File Uploaded Successfully");

		driver.quit();
	}
}
