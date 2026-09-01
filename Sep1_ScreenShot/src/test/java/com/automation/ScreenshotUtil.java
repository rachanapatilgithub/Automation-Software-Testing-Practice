package com.automation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenshotUtil {

	// takes a screenshot of the whole page - reused by every task instead of
	// writing the same TakesScreenshot + FileUtils code again and again
	public static void takeScreenshot(WebDriver driver, String fileName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceimage = ts.getScreenshotAs(OutputType.FILE);

		File destinationimage = new File("src/test/resources/screenshot/" + fileName + ".png");
		FileUtils.copyFile(sourceimage, destinationimage);

		System.out.println(fileName + " Screenshot Taken");
	}

	// takes a screenshot of just one element - rather than the whole driver,
	// we take the screenshot on the WebElement itself
	public static void takeElementScreenshot(WebElement element, String fileName) throws Exception {
		File sourceimage = element.getScreenshotAs(OutputType.FILE);

		File destinationimage = new File("src/test/resources/screenshot/" + fileName + ".png");
		FileUtils.copyFile(sourceimage, destinationimage);

		System.out.println(fileName + " Screenshot Taken");
	}
}
