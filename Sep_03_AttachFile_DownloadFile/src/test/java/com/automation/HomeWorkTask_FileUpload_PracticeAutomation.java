package com.automation;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_FileUpload_PracticeAutomation {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/file-upload/");

		WebElement fileupload = driver.findElement(By.id("file-upload"));
		fileupload.sendKeys(new File("src/test/resources/upload/SampleUploadFile.txt").getAbsolutePath());

		System.out.println("File Selected For Upload Successfully");

		Thread.sleep(1000);

		WebElement uploadButton = driver.findElement(By.id("upload-btn"));
		uploadButton.click();

		Thread.sleep(2000);

		System.out.println("Upload Form Submitted Successfully");

		driver.quit();
	}
}
