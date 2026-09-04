package com.automation;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_AllInOne {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String uploadFilePath1 = new File("src/test/resources/upload/SampleUploadFile.txt").getAbsolutePath();
		String uploadFilePath2 = new File("src/test/resources/upload/SampleUploadFile2.txt").getAbsolutePath();
		String downloadFolder = System.getProperty("user.home") + File.separator + "Downloads";

		// ---------- 1) QAPlayground - Single File Upload (Mam's Class Logic) ----------
		driver.get("https://qaplayground.com/practice/file-upload");

		WebElement fileupload = driver.findElement(By.id("fu-single-input"));
		fileupload.sendKeys(uploadFilePath1);
		Thread.sleep(1000);
		System.out.println("QAPlayground Single Upload -> " + driver.findElement(By.id("result-s01")).getText());

		// ---------- 2) QAPlayground - Multiple File Upload ----------
		WebElement multiUpload = driver.findElement(By.id("fu-multi-input"));
		multiUpload.sendKeys(uploadFilePath1 + "\n" + uploadFilePath2);
		Thread.sleep(1000);
		System.out.println("QAPlayground Multiple Upload -> " + driver.findElement(By.id("result-s02")).getText());

		// ---------- 3) Practice Automation - File Upload ----------
		driver.get("https://practice-automation.com/file-upload/");
		driver.findElement(By.id("file-upload")).sendKeys(uploadFilePath1);
		Thread.sleep(1000);
		driver.findElement(By.id("upload-btn")).click();
		Thread.sleep(2000);
		System.out.println("PracticeAutomation Upload -> Form Submitted Successfully");

		// ---------- 4) Practice Automation - File Download ----------
		driver.get("https://practice-automation.com/file-download/");

		long pdfStartTime = System.currentTimeMillis();
		driver.findElement(By.cssSelector("a.download-on-click")).click();
		Thread.sleep(3000);

		File newestPdf = findNewestFile(downloadFolder, ".pdf", pdfStartTime);
		System.out.println("PracticeAutomation Download -> "
				+ (newestPdf != null ? "Success: " + newestPdf.getAbsolutePath() : "Not Found"));

		// ---------- 5) DemoQA - Download + Upload ----------
		driver.get("https://demoqa.com/upload-download");

		long imageStartTime = System.currentTimeMillis();
		driver.findElement(By.id("downloadButton")).click();
		Thread.sleep(2000);

		File newestImage = findNewestFile(downloadFolder, ".jpeg", imageStartTime);
		System.out.println("DemoQA Download -> "
				+ (newestImage != null ? "Success: " + newestImage.getAbsolutePath() : "Not Found"));

		driver.findElement(By.id("uploadFile")).sendKeys(uploadFilePath1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadedFilePath")));
		System.out.println("DemoQA Upload -> " + driver.findElement(By.id("uploadedFilePath")).getText());

		System.out.println("All In One - File Upload & Download Homework Completed Successfully");

		driver.quit();
	}

	private static File findNewestFile(String folderPath, String extension, long afterTime) {

		File[] files = new File(folderPath).listFiles((dir, name) -> name.toLowerCase().endsWith(extension));

		File newest = null;
		if (files != null) {
			for (File f : files) {
				if (f.lastModified() >= afterTime && (newest == null || f.lastModified() > newest.lastModified())) {
					newest = f;
				}
			}
		}
		return newest;
	}
}
