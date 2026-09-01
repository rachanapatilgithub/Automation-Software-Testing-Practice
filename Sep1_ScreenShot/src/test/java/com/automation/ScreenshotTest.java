package com.automation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

// This is mam's exact class from today's live session - unchanged, kept as
// reference. HomeWorkTask1/2/3 reuse the same logic through ScreenshotUtil
// instead of repeating this code.
public class ScreenshotTest {
	public static void main(String[] args) throws Exception {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://javabykiran.com/liveproject/index.html");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourceimage = ts.getScreenshotAs(OutputType.FILE);

		File destinationimage = new File("src/test/resources/screenshot/image.png");

		FileUtils.copyFile(sourceimage, destinationimage);

		System.out.println("Screenshot Taken");
	}
}
