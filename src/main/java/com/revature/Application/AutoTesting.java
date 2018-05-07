//John Eifert
package com.revature.Application;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		String path = "src/main/resources/chromedriver";
		File tmpDir = new File(path);
		boolean exists = tmpDir.exists();
		// System.out.println(exists);
		
		if(!exists)		// windows path
			path = "src\\main\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
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