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
		//Create an instance of AutoTesting so that non-static methods can be called:
		AutoTesting instance = new AutoTesting();
		
		//Run trainerLoginTest():
		instance.trainerLoginTest();
	}
	
	
	public static WebDriver getDriver()
	{
		//Multi-OS support:
		String path = "src/main/resources/chromedriver";
		File tmpDir = new File(path);
		boolean exists = tmpDir.exists();
		if(!exists)		// windows path
			path = "src\\main\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		
		//Make and return a ChromeDriver:
		return(new ChromeDriver());
	}
	
	
	public void trainerLoginTest()
	{
		//Get a WebDriver object:
		WebDriver browser = getDriver();
		
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
		
		//Establish what the new URL is:
		String actualURL = browser.getCurrentUrl();
		
		//Print the new URL:
		System.out.println("Current URL = " + actualURL);
	}
	
	
	//This method is made to be called via servlet:
	public static String showURL()
	{
		//Get a WebDriver object:
		WebDriver browser = getDriver();
		
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
		
		//Return the new URL:
		return(browser.getCurrentUrl());
	}
}