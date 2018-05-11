//John Eifert
package com.revature.testing;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;



public class TestingMethods
{
	public static ChromeOptions options = new ChromeOptions().addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
	
	
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
		return(new ChromeDriver(options));
	}
	
	
	public static void trainerLogin(WebDriver browser)
	{
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
	}
	
	public static void pushButtonFromNavBar(WebDriver browser, String buttonName)
	{
		/*Declare the name of the button being tested, so that, should the test fail, the button
	 		that it failed on will be easily knowable*/
		System.out.println("Now testing the " + buttonName + " button.");
		
		/*Since the page's JavaScript needs time to create the nav buttons, the browser will
			for an arbitrary, but large amount of time to give the JS time to create the buttons*/
		browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Acquire the button to be tested:
		WebElement Zhalfir = browser.findElement(By.name(buttonName));
		
		System.out.println("Got the " + buttonName + " button.");
		
		//Kills some time while the JS finishes making the buttons interactable:
		String sourceCode = "";
		for(int i=0; i<9; i++)
			sourceCode = browser.getPageSource();
		
		System.out.println("About to push the " + buttonName + " button...");
		
		//Push the button to be tested:
		Zhalfir.click();
		
		System.out.println("Pushed the " + buttonName + " button.");
	}
	
	
	public static void vpLogin(WebDriver browser)
	{
		//Declare the relevant input objects:
		WebElement usernameField;
		WebElement passwordField;
		WebElement submitButton;
		
		//Supports the test even if the trainer tests didn't leave off on a login page:
		try
		{
			//Acquire the relevant input objects:
			usernameField = browser.findElement(By.id("username"));
			passwordField = browser.findElement(By.id("password"));
			submitButton = browser.findElement(By.id("Login"));
		}
		catch(NoSuchElementException e)
		{
			browser.quit();
			browser = getDriver();
			browser.get("https://dev.assignforce.revaturelabs.com");
			
			//Acquire the relevant input objects:
			usernameField = browser.findElement(By.id("username"));
			passwordField = browser.findElement(By.id("password"));
			submitButton = browser.findElement(By.id("Login"));
		}
		
		//Perform the login actions:
		usernameField.sendKeys("test.vpoftech@revature.com.int1");
		passwordField.sendKeys("yuvi1712");
		submitButton.click();
	}
	
	public static void selectFirstOption(WebDriver browser, String menuID, String optionValue)
	{
		//Acquire the desired menu object:
		WebElement menuObject = browser.findElement(By.id(menuID));
		//Click into the menu:
		menuObject.click();
		
		String sourceCode = "";
		for(int i=0; i<50; i++)
			sourceCode = browser.getPageSource();
		//System.gc();
		
		Select menu = new Select(browser.findElement(By.id(menuID)));
		ArrayList<WebElement> allOptions = new ArrayList<WebElement>();
		for(int i=0; i<menu.getOptions().size(); i++)
		{
			allOptions.add(menu.getOptions().get(i));
		}
		
		menuObject.findElement(By.tagName("md-option")).click();
		
		
		//Select menu = new Select(browser.findElement(By.id(menuID)));
		
		//menu.selectByVisibleText(optionValue);
		
		
		//Acquire the desired option object:
		//WebElement optionObject = browser.findElement(By.tagName("md-option"));
				//browser.findElement(By.id(optionID));
		
		//System.out.println("About to push the " + optionObject.getAttribute("id") + " button...");
		
		//Select the desired option:
		//optionObject.click();
	}
	
	public static void selectAnotherOption(WebDriver browser, String optionID)
	{
		//Acquire the desired option object:
		WebElement optionObject = browser.findElement(By.id(optionID));
		//Select the desired option:
		optionObject.click();
	}
	
	public static void enterText(WebDriver browser, WebElement field, String sendInput)
	{
		//Give the desired input text to the desired input object:
		field.sendKeys(sendInput);
	}
	
	public static void makeTheBatch(WebDriver browser, WebElement button)
	{
		//Push the submit button to submit the finished batch:
		button.click();
	}
	
	
	
}
