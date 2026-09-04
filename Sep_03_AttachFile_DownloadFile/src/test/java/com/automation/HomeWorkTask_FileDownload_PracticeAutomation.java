package com.automation;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class HomeWorkTask_FileDownload_PracticeAutomation {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-automation.com/file-download/");

		long startTime = System.currentTimeMillis();

		WebElement downloadLink = driver.findElement(By.cssSelector("a.download-on-click"));
		downloadLink.click();

		Thread.sleep(3000);

		String downloadFolder = System.getProperty("user.home") + File.separator + "Downloads";
		File[] pdfFiles = new File(downloadFolder).listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

		File newestPdf = null;
		if (pdfFiles != null) {
			for (File f : pdfFiles) {
				if (f.lastModified() >= startTime
						&& (newestPdf == null || f.lastModified() > newestPdf.lastModified())) {
					newestPdf = f;
				}
			}
		}

		if (newestPdf != null) {
			System.out.println("File Downloaded Successfully: " + newestPdf.getAbsolutePath());
		} else {
			System.out.println("File Not Found In Downloads Folder: " + downloadFolder);
		}

		driver.quit();
	}
}
