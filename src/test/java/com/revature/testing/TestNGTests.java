//John Eifert
package com.revature.testing;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;



public class TestNGTests
{
	//Get a WebDriver object for use in the tests:
	WebDriver browser = TestingMethods.getDriver();
	
	
	@Test
	public void trainerLoginTest()
	{
		//Perform the login actions:
		TestingMethods.trainerLogin(browser);
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/";
		String actualURL = browser.getCurrentUrl();
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(dependsOnMethods="trainerLoginTest")
	public void trainerNavButtonTest()
	{
		//Perform the login actions:
			//Login has already been performed by the previous test.
		
		//Test each of the nav buttons:
		String expectedURL = "";
		String actualURL = "";
		
		ArrayList<String> buttonNames = new ArrayList<String>();
		buttonNames.add("overview");
		buttonNames.add("batches");
		buttonNames.add("locations");
		buttonNames.add("curricula");
		buttonNames.add("trainers");
		buttonNames.add("profile");
		buttonNames.add("reports");
		buttonNames.add("settings");
		
		for(int i=0; i<buttonNames.size(); i++)
		{
			TestingMethods.pushButtonFromNavBar(browser, buttonNames.get(i));
			expectedURL = "https://dev.assignforce.revaturelabs.com/" + buttonNames.get(i);
			if(i == 0)
				expectedURL = "https://dev.assignforce.revaturelabs.com/home";
			if(i == 3)
				expectedURL = "https://dev.assignforce.revaturelabs.com/curriculum";
			actualURL = browser.getCurrentUrl();
			System.out.println(actualURL);
			Assert.assertEquals(actualURL, expectedURL);
		}
		
			//Logout button:
		TestingMethods.pushButtonFromNavBar(browser, "logout");
		expectedURL = "https://dev.assignforce.revaturelabs.com/reports";
		actualURL = browser.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertNotEquals(actualURL, expectedURL);
	}
	
	@Test(dependsOnMethods="trainerNavButtonTest")
	public void homeSortByNameTest()
	{
		
		
		
		browser.quit();
	}
	
	
	
}
