package com.automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestExecution {

	public static void main(String[] args) throws Exception {

		ConfigReader config = new ConfigReader();
		WebDriver driver = null;

		if (config.getBrowser().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (config.getBrowser().equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// LOGIN Test
		driver.get(config.getLoginURL());

		System.out.println("Positive Login");
		Login.login(driver,
				ExcelReader.getData("Login", 1, 1),
				ExcelReader.getData("Login", 1, 2));
		Thread.sleep(3000);

		driver.navigate().back();

		System.out.println("Negative Login");
		Login.login(driver,
				ExcelReader.getData("Login", 2, 1),
				ExcelReader.getData("Login", 2, 2));
		Thread.sleep(3000);

		// REGISTER Test
		driver.get(config.getRegisterURL());

		System.out.println("Positive Registration");
		Register.register(driver,
				ExcelReader.getData("Register", 1, 1),
				ExcelReader.getData("Register", 1, 2),
				ExcelReader.getData("Register", 1, 3),
				ExcelReader.getData("Register", 1, 4));
		Thread.sleep(3000);

		driver.get(config.getRegisterURL());

		System.out.println("Negative Registration");
		Register.register(driver,
				ExcelReader.getData("Register", 2, 1),
				ExcelReader.getData("Register", 2, 2),
				ExcelReader.getData("Register", 2, 3),
				ExcelReader.getData("Register", 2, 4));
		Thread.sleep(3000);

		// ADD USER Test
		driver.get(config.getAddUserURL());

		System.out.println("Positive Add User");
		AddUser.addUser(driver,
				ExcelReader.getData("AddUser", 1, 1),
				ExcelReader.getData("AddUser", 1, 2),
				ExcelReader.getData("AddUser", 1, 3),
				ExcelReader.getData("AddUser", 1, 4),
				ExcelReader.getData("AddUser", 1, 5),
				ExcelReader.getData("AddUser", 1, 6),
				ExcelReader.getData("AddUser", 1, 7));
		Thread.sleep(3000);

		driver.get(config.getAddUserURL());

		System.out.println("Negative Add User");
		AddUser.addUser(driver,
				ExcelReader.getData("AddUser", 2, 1),
				ExcelReader.getData("AddUser", 2, 2),
				ExcelReader.getData("AddUser", 2, 3),
				ExcelReader.getData("AddUser", 2, 4),
				ExcelReader.getData("AddUser", 2, 5),
				ExcelReader.getData("AddUser", 2, 6),
				ExcelReader.getData("AddUser", 2, 7));
		Thread.sleep(3000);

		// CLOSE BROWSER
		System.out.println("Execution Completed Successfully");
		driver.quit();
	}
}
