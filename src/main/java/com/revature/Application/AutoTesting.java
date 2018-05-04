////John Eifert
//package com.revature.Application;
//
//import org.junit.Test;
////import org.junit.jupiter.*;
//import junit.framework.TestCase;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//
//public class AutoTesting extends TestCase
//{
//	//Create the browser object that will be used for these tests:
//	WebDriver browser = new ChromeDriver();
//	
//	
//	@Test
//	public void trainerLoginTest()
//	{
//		//Navigate to the login page:
//		browser.get("https://dev.assignforce.revaturelabs.com");
//		
//		//Acquire the relevant input objects:
//		WebElement usernameField = browser.findElement(By.id("username"));
//		WebElement passwordField = browser.findElement(By.id("password"));
//		WebElement submitButton = browser.findElement(By.id("Login"));
//		
//		//Perform the login actions:
//		usernameField.sendKeys("test.trainer@revature.com.int1");
//		passwordField.sendKeys("trainer123");
//		submitButton.click();
//		
//		//Wait for the next page to load:
//		try
//		{
//			wait(5000);
//		}
//		catch(InterruptedException ie)
//		{
//			System.err.println(ie.getMessage() + "\n");
//			ie.printStackTrace();
//			System.err.println("\n" + "Exiting trainerLoginTest()...");
//			return;
//		}
//		
//		assertTrue("trainerLoginTest() failed.",
//				browser.getCurrentUrl().equals("https://dev.assignforce.revaturelabs.com/home"));
//	}
//	
//	
//	
//}
