package com.automation;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_UploadDownload_DemoQA {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// ---------- Download File ----------
		String downloadFolder = System.getProperty("user.home") + File.separator + "Downloads";
		long startTime = System.currentTimeMillis();

		WebElement downloadButton = driver.findElement(By.id("downloadButton"));
		downloadButton.click();

		Thread.sleep(2000);

		File[] imageFiles = new File(downloadFolder).listFiles((dir, name) -> name.toLowerCase().endsWith(".jpeg"));

		File newestImage = null;
		if (imageFiles != null) {
			for (File f : imageFiles) {
				if (f.lastModified() >= startTime && (newestImage == null || f.lastModified() > newestImage.lastModified())) {
					newestImage = f;
				}
			}
		}

		if (newestImage != null) {
			System.out.println("File Downloaded Successfully: " + newestImage.getAbsolutePath());
		} else {
			System.out.println("File Not Found In Downloads Folder: " + downloadFolder);
		}

		// ---------- Upload File ----------
		WebElement fileupload = driver.findElement(By.id("uploadFile"));
		fileupload.sendKeys(new File("src/test/resources/upload/SampleUploadFile.txt").getAbsolutePath());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));

		WebElement uploadedPath = driver.findElement(By.id("uploadedFilePath"));
		System.out.println("Uploaded File Path Shown On Page: " + uploadedPath.getText());

		driver.quit();
	}
}
