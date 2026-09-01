package com.practice.loginautomation;

// All Positive + Negative Scenarios Class - this is where real testing logic lives
public class LoginScenarios {

	LoginActions login;

	public LoginScenarios(LoginActions login) {
		this.login = login;
	}

	// Positive Scenario
	public void validLogin() {
		login.login("validUser", "validPass");

		if (login.isDashboardDisplayed()) {
			System.out.println("PASS -> Valid Login");
		} else {
			System.out.println("FAIL -> Valid Login");
		}
	}

	// Invalid username
	public void invalidUsername() {
		login.login("wrongUser", "validPass");

		if (login.getErrorMessage().equals("Invalid credentials")) {
			System.out.println("PASS -> Invalid Username");
		} else {
			System.out.println("FAIL -> Invalid Username");
		}
	}

	// Invalid password
	public void invalidPassword() {
		login.login("validUser", "wrongPass");

		if (login.getErrorMessage().equals("Invalid credentials")) {
			System.out.println("PASS -> Invalid Password");
		} else {
			System.out.println("FAIL -> Invalid Password");
		}
	}

	// Empty username
	public void emptyUsername() {
		login.login("", "password");

		if (login.getErrorMessage().equals("Username required")) {
			System.out.println("PASS -> Empty Username");
		} else {
			System.out.println("FAIL -> Empty Username");
		}
	}

	// Empty password
	public void emptyPassword() {
		login.login("username", "");

		if (login.getErrorMessage().equals("Password required")) {
			System.out.println("PASS -> Empty Password");
		} else {
			System.out.println("FAIL -> Empty Password");
		}
	}

	// Empty fields
	public void emptyFields() {
		login.login("", "");

		if (login.getErrorMessage().equals("All fields required")) {
			System.out.println("PASS -> Empty Fields");
		} else {
			System.out.println("FAIL -> Empty Fields");
		}
	}

	// SQL Injection attempt - a security-style negative test: typing SQL syntax
	// into the username should never log a user in or crash the page, it should
	// just be treated as a normal wrong login
	public void sqlInjectionAttempt() {
		login.login("' OR '1'='1", "' OR '1'='1");

		if (login.getErrorMessage().equals("Invalid credentials")) {
			System.out.println("PASS -> SQL Injection Attempt Blocked");
		} else {
			System.out.println("FAIL -> SQL Injection Attempt");
		}
	}

	// Locked account
	public void lockedUser() {
		login.login("lockedUser", "password");

		if (login.getErrorMessage().equals("User locked")) {
			System.out.println("PASS -> Locked User");
		} else {
			System.out.println("FAIL -> Locked User");
		}
	}
}
