package com.automation;

// Same imports as before
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.edge.EdgeDriver;

// EXTRA new things used in this class (not shown by mam yet):
// 1) WebDriverWait -> a "smart wait" that waits ONLY as long as needed
//    (better than Thread.sleep which always waits a fixed time even if not required)
// 2) ExpectedConditions.alertIsPresent() -> tells Selenium "wait until alert appears"
// 3) try-catch -> to safely handle the case if alert is not found (no crash)
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TodayHomeworkExtra2 {

	public static void main(String[] args) {

		// Step 1: Launch Edge browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");

		System.out.println("Page opened. Learning EXTRA new concept: WebDriverWait for alerts.");

		// Step 2: Create a WebDriverWait object
		// This means: "wait maximum 10 seconds before giving error"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// try-catch block: if something goes wrong (like alert not found)
		// program will not crash, it will print the error message nicely
		try {

			// Click the Alert button (1st "Click me" button on page)
			WebElement alertButton = driver.findElement(By.xpath("(//button[text()='Click me'])[1]"));
			alertButton.click();
			System.out.println("Alert button clicked.");

			// Instead of Thread.sleep(1000), we now wait smartly like this:
			// This line waits until the alert actually appears, then continues
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			String text = alert.getText();
			System.out.println("Alert text using smart wait: " + text);

			alert.accept();
			System.out.println("Alert accepted successfully using WebDriverWait method.");

		} catch (NoAlertPresentException e) {
			// This block runs ONLY if no alert was found within 10 seconds
			System.out.println("No alert appeared! Error caught safely: " + e.getMessage());
		}

		System.out.println("---------------------------------------------------");
		System.out.println("Why WebDriverWait is better than Thread.sleep:");
		System.out.println("- Thread.sleep(1000) ALWAYS waits full 1 second, even if alert comes in 200ms (time waste)");
		System.out.println("- WebDriverWait checks again and again quickly, and moves ahead AS SOON AS alert is found");
		System.out.println("- This makes your test script faster and more reliable");

		// Step 3: Close browser
		driver.quit();
	}
}