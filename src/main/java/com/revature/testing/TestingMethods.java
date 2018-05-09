//John Eifert
package com.revature.testing;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;



public class TestingMethods
{
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
	
	
	
}
