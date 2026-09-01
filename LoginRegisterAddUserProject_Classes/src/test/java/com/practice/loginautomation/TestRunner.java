package com.practice.loginautomation;

// Test Runner - Executable Program
public class TestRunner {

	public static void main(String[] args) {

		DriverSetup.startBrowser();

		LoginActions actions = new LoginActions(DriverSetup.driver);
		LoginScenarios tests = new LoginScenarios(actions);

		tests.validLogin();
		tests.invalidUsername();
		tests.invalidPassword();
		tests.emptyUsername();
		tests.emptyPassword();
		tests.emptyFields();
		tests.sqlInjectionAttempt();
		tests.lockedUser();

		DriverSetup.closeBrowser();
	}
}
