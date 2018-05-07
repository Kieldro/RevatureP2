//John Eifert
package com.revature.Application;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutoTesting //extends TestCase
{
	public static void main(String args[])
	{
		AutoTesting instance = new AutoTesting();
		instance.trainerLoginTest();
	}
	
	
	//@Test
	public void trainerLoginTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\firen\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		
		WebDriver browser = new ChromeDriver();
		
		//Navigate to the login page:
		browser.get("https://dev.assignforce.revaturelabs.com");
		
		//Acquire the relevant input objects:
		WebElement usernameField = browser.findElement(By.id("username"));
		WebElement passwordField = browser.findElement(By.id("password"));
		WebElement submitButton = browser.findElement(By.id("Login"));
		
		//Perform the login actions:
		usernameField.sendKeys("test.trainer@revature.com.int1");
		passwordField.sendKeys("trainer123");
		submitButton.click();
		
		//assertTrue("trainerLoginTest() failed.",
		//		browser.getCurrentUrl().equals("https://dev.assignforce.revaturelabs.com/home"));
		
		System.out.println("Current URL = " + browser.getCurrentUrl());
	}
}