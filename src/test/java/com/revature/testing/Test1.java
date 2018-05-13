package com.revature.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Test1 {
	WebDriver browser = TestingMethods.getDriver();

	@Test
	public void f() {
		browser.get("https://www.wikipedia.org/");
//
//		while (true) {
//			if (false)
//				break;
//		}

		// Acquire the relevant input objects:
		WebElement searchInput = browser.findElement(By.id("searchInput"));
//		WebElement passwordField = browser.findElement(By.id("password"));
		WebElement submitButton = browser.findElement(By.className("pure-button pure-button-primary-progressive"));

		// Perform the login actions:
		searchInput.sendKeys("Andromeda Galaxy");
//		passwordField.sendKeys("trainer123");
		submitButton.click();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("About to quit the browser...");
		browser.quit();
		System.out.println("Quit the browser.");
	}
}
