package com.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

// 2. Use of Select
public class LocatorsPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://practice.expandtesting.com/locators");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// 1) Locate by Button text (XPath)
		WebElement addItemButton = driver.findElement(By.xpath("//button[text()='Add Item']"));
		System.out.println("Button Text: " + addItemButton.getText());
		Thread.sleep(1000);

		// 2) Locate text by CSS or XPath
		WebElement hotDealText = driver.findElement(By.xpath("//*[contains(text(),'Buy 1 Get 1 Free')]"));
		System.out.println("Hot Deal Text: " + hotDealText.getText());
		Thread.sleep(1000);

		// 3) Locate dropdown and select a country
		WebElement countrySelect = driver.findElement(By.tagName("select"));
		Select select = new Select(countrySelect);
		select.selectByVisibleText("Canada");
		System.out.println("Selected Country: Canada");
		Thread.sleep(1000);

		// 4) Locate textbox and send keys
		WebElement newsletterInput = driver.findElement(By.cssSelector("input[placeholder='Email for newsletter']"));
		newsletterInput.sendKeys("test@example.com");
		System.out.println("Input Entered: " + newsletterInput.getAttribute("value"));
		Thread.sleep(1000);

		// 5) Locate image by alt attribute
		WebElement avatarImage = driver.findElement(By.cssSelector("img[alt='User avatar']"));
		System.out.println("Avatar is displayed? " + avatarImage.isDisplayed());
		Thread.sleep(1000);

		// 6) Locate reload button by title attribute
		WebElement reloadBtn = driver.findElement(By.cssSelector("button[title='Reload']"));
		reloadBtn.click();
		System.out.println("Clicked Reload Button");
		Thread.sleep(2000);

		// ===== getByPlaceholder =====
		WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search the site']"));
		searchBox.sendKeys("Selenium");
		System.out.println("Search entered");

		WebElement filterBox = driver.findElement(By.cssSelector("input[placeholder='Filter by tag']"));
		filterBox.sendKeys("Automation");
		System.out.println("Filter entered");

		// ===== getByText (Buttons) =====
		driver.findElement(By.xpath("//button[text()='Reload']")).click();
		System.out.println("Reload clicked");

		driver.findElement(By.xpath("//button[text()='Settings']")).click();
		System.out.println("Settings clicked");
		Thread.sleep(1000);

		// ===== getByTestId (Badge Text) =====
		WebElement badge = driver.findElement(By.xpath("//*[contains(text(),'Software Testing')]"));
		System.out.println("Badge text: " + badge.getText());

		// ===== Task List =====
		List<WebElement> tasks = driver.findElements(By.cssSelector("ul li"));
		System.out.println("Tasks:");
		for (WebElement task : tasks) {
			System.out.println(task.getText());
		}

		// ===== Table Data =====
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("\nProduct Table:");
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			String product = cols.get(0).getText();
			String status = cols.get(1).getText();
			String stock = cols.get(2).getText();
			System.out.println(product + " | " + status + " | " + stock);
		}

		driver.quit();
	}
}
