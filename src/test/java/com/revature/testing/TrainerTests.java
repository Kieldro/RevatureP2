package com.revature.testing;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrainerTests 
{
	WebDriver browser = TestingMethods.getDriver();
	
	
	@Given("^the url in chrome$")
	public void trainerLoginTest() throws Throwable 
	{

		TestingMethods.trainerLogin(browser);
	}

	@When("^I am logged in$")
	public void trainerNavTesting() throws Throwable 
	{
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
	}

	@Then("^I am done$")
	public void trainerExit() throws Throwable 
	{
		browser.quit();
	}
}