package com.automation;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_FileUpload_QAPlayground_MultipleFiles {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaplayground.com/practice/file-upload");

		String filePath1 = new File("src/test/resources/upload/SampleUploadFile.txt").getAbsolutePath();
		String filePath2 = new File("src/test/resources/upload/SampleUploadFile2.txt").getAbsolutePath();

		WebElement fileupload = driver.findElement(By.id("fu-multi-input"));
		fileupload.sendKeys(filePath1 + "\n" + filePath2);

		Thread.sleep(1000);

		WebElement result = driver.findElement(By.id("result-s02"));
		System.out.println("Multiple File Upload Result: " + result.getText());

		driver.quit();
	}
}
