package com.revature.tests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


import com.revature.util.Driver;

public class AustinTests {
  Driver browser = Driver.getInstance();
  
  @Test(groups="negativeTests", priority=1)
  public void loginNoPassword(){
	  
	  browser.get("https://dev.assignforce.revaturelabs.com");
	  
	  browser.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<5; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getCurrentUrl());
		}
		
		// Acquire the relevant input objects:
		WebElement usernameField = browser.findElement(By.id("username"));
		WebElement submitButton = browser.findElement(By.id("Login"));

		// Perform the login actions without entering password:
		usernameField.sendKeys("test.trainer@revature.com.int1");
		
		submitButton.click();
		
		//wait
		for(int j=0; j<25; j++)
		{
			sourceCode = browser.getPageSource();
		}
		
		WebElement errorField = browser.findElement(By.id("error"));
		Assert.assertEquals("Please enter your password.", errorField.getText());
  }
  
  @Test(groups="negativeTests", priority=1)
  public void vpLoginWrongPassword(){
	  
	  browser.get("https://dev.assignforce.revaturelabs.com");
	  
	  browser.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<5; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getCurrentUrl());
		}
		
		// Acquire the relevant input objects:
		WebElement usernameField = browser.findElement(By.id("username"));
		WebElement passwordField = browser.findElement(By.id("password"));
		WebElement submitButton = browser.findElement(By.id("Login"));

		// Perform the login actions without entering password:
		usernameField.sendKeys("test.vpoftech@revature.com.int1");
		passwordField.sendKeys("blah");
		submitButton.click();
		
		//wait
		for(int j=0; j<25; j++)
		{
			sourceCode = browser.getPageSource();
		}
		
		WebElement errorField = browser.findElement(By.id("error"));
		System.out.println(errorField.getText());
		Assert.assertEquals("Please check your username and password. If you "
				+ "still can't log in, contact your Salesforce administrator.", 
				errorField.getText());
  }
  
  @Test(groups="negativeTests", priority=1)
  public void trainerLoginWrongPassword(){
	  
	  browser.get("https://dev.assignforce.revaturelabs.com");
	  
	  browser.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<5; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getCurrentUrl());
		}
		
		// Acquire the relevant input objects:
		WebElement usernameField = browser.findElement(By.id("username"));
		WebElement passwordField = browser.findElement(By.id("password"));
		WebElement submitButton = browser.findElement(By.id("Login"));

		// Perform the login actions without entering password:
		usernameField.sendKeys("test.trainer@revature.com.int1");
		passwordField.sendKeys("blah");
		submitButton.click();
		
		//wait
		for(int j=0; j<25; j++)
		{
			sourceCode = browser.getPageSource();
		}
		
		WebElement errorField = browser.findElement(By.id("error"));
		Assert.assertEquals("Please check your username and password. If you "
				+ "still can't log in, contact your Salesforce administrator.", 
				errorField.getText());
  }
  
  @Test(groups="negativeTests", priority=1)
  public void noInput() {
	  
	  browser.get("https://dev.assignforce.revaturelabs.com");
	  
	  browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<5; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getCurrentUrl());
		}
		
		// Acquire the relevant input objects:
		WebElement submitButton = browser.findElement(By.id("Login"));

		// Perform the login actions without entering password:
		submitButton.click();
		
		//wait
		for(int j=0; j<25; j++)
		{
			sourceCode = browser.getPageSource();
		}
		
	
		try {
			WebElement errorField = browser.findElement(By.id("error"));
			System.out.println(errorField.getText());
			Assert.assertTrue(false);
		} catch (NoSuchElementException nsee) {
			Assert.assertTrue(true);
		} catch (NullPointerException e) {
			Assert.assertTrue(true);
		}
		
		return;
  }
  
  @Test(groups="negativeTests", priority=1)
  public void noUsername() {
	  
	  browser.get("https://dev.assignforce.revaturelabs.com");
	  
	  browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<5; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getCurrentUrl());
		}
		
		// Acquire the relevant input objects:
		WebElement passwordField = browser.findElement(By.id("password"));
		WebElement submitButton = browser.findElement(By.id("Login"));

		// Perform the login actions without entering password:
		passwordField.sendKeys("asdf");
		submitButton.click();
		
		//wait
		for(int j=0; j<25; j++)
		{
			sourceCode = browser.getPageSource();
		}
		
	
		try {
			WebElement errorField = browser.findElement(By.id("error"));
			System.out.println(errorField.getText());
			Assert.assertTrue(false);
		} catch (NoSuchElementException nsee) {
			Assert.assertTrue(true);
		} catch (NullPointerException e) {
			Assert.assertTrue(true);
		}
		
		return;
  }
  
  /*@Test(priority=2)
  public void stressTest() {
	  browser.get("https://dev.assignforce.revaturelabs.com");
	  
	  browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  
	  WebElement submitButton; 
	  
	  testloop: for (int i = 0; i < 10000; i++) {
		  submitButton = browser.findElement(By.id("Login"));
		  submitButton.click();
		  
		  try {
				WebElement errorField = browser.findElement(By.id("error"));
				System.out.println(errorField.getText());
				Assert.assertTrue(false);
				break testloop;
			} catch (NoSuchElementException nsee) {
				Assert.assertTrue(true);
			} catch (NullPointerException e) {
				Assert.assertTrue(true);
			}
	  }
  }*/
  
  @AfterTest
  public void quitBrowser()
  {
	System.out.println("About to quit the browser...");
	browser.quit();
	System.out.println("Quit the browser.");
  }
}
