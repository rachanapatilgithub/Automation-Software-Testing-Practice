package com.automation.allinone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkTask_AllInOne_AllSites {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// ==================== Site 1 : demo.automationtesting.in/Frames.html ====================
		driver.get("https://demo.automationtesting.in/Frames.html");

		WebElement frameelement = driver.findElement(By.xpath("//*[@id=\"singleframe\"]"));
		driver.switchTo().frame(frameelement);
		System.out.println(driver.findElement(By.xpath("/html/body/section/div/h5")).getText());
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("kiran academy");
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();

		WebElement outerframe = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
		driver.switchTo().frame(outerframe);
		System.out.println(driver.findElement(By.xpath("/html/body/section/div/div/h5")).getText());

		WebElement innerframe = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
		driver.switchTo().frame(innerframe);
		System.out.println(driver.findElement(By.xpath("/html/body/section/div/h5")).getText());
		driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("kiran academy");

		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.xpath("/html/body/section/div/div/h5")).getText());

		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/h1")).getText());

		// ==================== Site 2 : practice.expandtesting.com/iframe ====================
		driver.get("https://practice.expandtesting.com/iframe");

		WebElement youtubeFrame = driver.findElement(By.id("iframe-youtube"));
		driver.switchTo().frame(youtubeFrame);
		driver.findElement(By.className("ytp-large-play-button")).click();
		System.out.println("Clicked the YouTube play button inside the iframe");
		driver.switchTo().defaultContent();

		WebElement editorFrame = driver.findElement(By.cssSelector("iframe.tox-edit-area__iframe, iframe[id$='_ifr']"));
		driver.switchTo().frame(editorFrame);
		WebElement editorBody = driver.findElement(By.id("tinymce"));
		editorBody.clear();
		editorBody.sendKeys("Kiran Academy - practice text");
		System.out.println("Typed fake text into the TinyMCE editor: " + editorBody.getText());
		driver.switchTo().defaultContent();

		WebElement emailFrame = driver.findElement(By.id("email-subscribe"));
		driver.switchTo().frame(emailFrame);
		driver.findElement(By.id("email")).sendKeys("test.user@example.com");
		driver.findElement(By.id("btn-subscribe")).click();
		System.out.println("Submitted the email subscription form with fake data");
		driver.switchTo().defaultContent();

		// ==================== Site 3 : practice-automation.com/iframes ====================
		driver.get("https://practice-automation.com/iframes/");

		WebElement topFrame = driver.findElement(By.id("iframe-1"));
		driver.switchTo().frame(topFrame);
		System.out.println("Top iframe heading: " + driver.findElement(By.tagName("h1")).getText());
		driver.switchTo().defaultContent();

		WebElement bottomFrame = driver.findElement(By.id("iframe-2"));
		driver.switchTo().frame(bottomFrame);
		System.out.println("Bottom iframe heading: " + driver.findElement(By.tagName("h1")).getText());
		driver.switchTo().defaultContent();

		// ==================== Site 4 : qaplayground.com/practice/iframes ====================
		driver.get("https://qaplayground.com/practice/iframes");

		WebElement basicFrame = driver.findElement(By.cssSelector("[data-testid='iframe-basic']"));
		driver.switchTo().frame(basicFrame);
		driver.findElement(By.cssSelector("[data-testid='iframe-name-input']")).sendKeys("Kiran Student");
		driver.findElement(By.cssSelector("[data-testid='iframe-submit-btn']")).click();
		System.out.println("QAPlayground S1: " + driver.findElement(By.id("result")).getText());
		driver.switchTo().defaultContent();

		WebElement formFrame = driver.findElement(By.cssSelector("iframe[title='Form Iframe']"));
		driver.switchTo().frame(formFrame);
		new Select(driver.findElement(By.id("iframe-lang-select"))).selectByValue("java");
		driver.findElement(By.id("iframe-agree-chk")).click();
		driver.findElement(By.id("iframe-save-btn")).click();
		System.out.println("QAPlayground S2: " + driver.findElement(By.id("result")).getText());
		driver.switchTo().defaultContent();

		WebElement outerFrame = driver.findElement(By.cssSelector("[data-testid='iframe-outer']"));
		driver.switchTo().frame(outerFrame);
		WebElement innerFrame = driver.findElement(By.cssSelector("iframe[title='Inner Frame']"));
		driver.switchTo().frame(innerFrame);
		driver.findElement(By.cssSelector("[data-testid='iframe-inner-input']")).sendKeys("kiran-secret");
		driver.findElement(By.cssSelector("[data-testid='iframe-inner-submit']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();

		WebElement dynamicFrame = driver.findElement(By.cssSelector("[data-testid='iframe-dynamic']"));
		driver.switchTo().frame(dynamicFrame);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement revealButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Reveal Secret']")));
		driver.findElement(By.id("dyn-code-input")).sendKeys("kiran123");
		revealButton.click();
		System.out.println("QAPlayground S5: " + driver.findElement(By.id("dyn-result")).getText());
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
