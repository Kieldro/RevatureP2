//John Eifert
package com.revature.testing;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestNGTests
{
	@BeforeTest
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
	
	
	@Test
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
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/";
		String actualURL = browser.getCurrentUrl();
		
		/*
		//Print the new URL:
		System.out.println("Current URL = " + actualURL);
		*/
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
		
		//Close the browser window:
		browser.close();
	}
	
}
