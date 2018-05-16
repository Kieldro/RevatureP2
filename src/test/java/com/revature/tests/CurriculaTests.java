package com.revature.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.util.TestingMethods;

public class CurriculaTests {

	
	//Get a WebDriver object for use in the tests:
		WebDriver browser;
		WebElement tableElement;
		List<WebElement> trList;
			
		@BeforeClass
		public void setUp() {
			browser = TestingMethods.getDriver();
			//Perform the login actions:
			vpLogin(browser);
		}
		
		
		@Test
		public void test() {
			
		}
		
		
		
		
		
		
		@AfterClass
		public void closeBrowser() {
			//close chromedriver and chrome window
			browser.quit();
		}
		
		
		
		public static void vpLogin(WebDriver browser) {
			// Declare the relevant input objects:
			WebElement usernameField;
			WebElement passwordField;
			WebElement submitButton;

			// Supports the test even if the trainer tests didn't leave off on a login page:
			try {
				// Acquire the relevant input objects:
				usernameField = browser.findElement(By.id("username"));
				passwordField = browser.findElement(By.id("password"));
				submitButton = browser.findElement(By.id("Login"));
			} catch (NoSuchElementException e) {
				
				//browser = getDriver();
				browser.navigate().to("https://dev.assignforce.revaturelabs.com");
				//browser.get("https://dev.assignforce.revaturelabs.com");

				// Acquire the relevant input objects:
				usernameField = browser.findElement(By.id("username"));
				passwordField = browser.findElement(By.id("password"));
				submitButton = browser.findElement(By.id("Login"));
			}

			// Perform the login actions:
			usernameField.sendKeys("test.vpoftech@revature.com.int1");
			passwordField.sendKeys("yuvi1712");
			submitButton.click();
		}

}
