//John Eifert
package com.revature.testing;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;



public class TestNGTests
{
	//Get a WebDriver object for use in the tests:
	WebDriver browser = TestingMethods.getDriver();
	
	
	@Test(groups="trainerTests", priority=1)
	public void trainerLoginTest()
	{
		//Perform the login actions:
		TestingMethods.trainerLogin(browser);
		
		String sourceCode = "";
		for(int i=0; i<10; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/home";
		String actualURL = browser.getCurrentUrl();
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerNavButtonTest()
	{
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
		String sourceCode = "";
		for(int i=0; i<9; i++)
		{
			//System.out.println(i);
			sourceCode = browser.getPageSource();
			//System.out.println(browser.getCurrentUrl());
		}
		System.out.println(browser.getCurrentUrl());
		expectedURL = "https://dev.assignforce.revaturelabs.com/settings";
		actualURL = browser.getCurrentUrl();
		
		Assert.assertNotEquals(actualURL, expectedURL);
	}
	
	/*
	@Test(dependsOnMethods="trainerNavButtonTest", groups="trainerTests", priority=1)
	public void homeSortByNameTest()
	{
		
		
		
		//browser.quit();
	}
	*/
	
	
	@Test(groups="vpTests", priority=2)
	public void vpLoginTest()
	{
		//Perform the login actions:
		TestingMethods.vpLogin(browser);
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/home";
		String actualURL = browser.getCurrentUrl();
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=2)
	public void vpOverviewNavTest()
	{
		//Test the overview nav button:
		TestingMethods.pushButtonFromNavBar(browser, "overview");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/home");
	}
	
	@Test(groups= {"vpTests", "batchesTests"}, dependsOnMethods="vpLoginTest", priority=3)
	public void vpBatchesNavTest()
	{
		//Test the batches nav button:
		TestingMethods.pushButtonFromNavBar(browser, "batches");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/batches");
	}
	
	@Test(groups={"vpTests", "batchesTests"}, dependsOnMethods="vpBatchesNavTest", priority=3)
	public void vpBatchCreationTest()
	{
		String CORE_CURRICULUM = "select_9";
		String FOCUS = "select_11";
		String SKILLS = "select_13";
		String START_DATE = "input_16";
		String TRAINER = "select_21";
		String COTRAINER = "select_23";
		String LOCATION = "select_25";
		String BUILDING = "select_27";
		String ROOM = "select_29";
		String CREATE_BATCH_BUTTON = "md-icon-button md-button md-ink-ripple";
		
		String JTA_AUTOMATION = "select_option_36";
		String NO_FOCUS = "select_option_455";
		String POSSIBLY_WILLIAM = "select_option_443";
		String TEST_SKILLS = "select_option_454";
		String SELENIUM_WEBDRIVER = "select_option_493";
		String LEBRON_JAMES = "select_option_696";
		String RESTON_VA = "select_option_171";
		String REVATURE_11730 = "select_option_988";
		String ROOM_100 = "select_option_989";
		
		
		//Operate the batch creation menus to provide information about a new batch:
			//Set the new batch's Core Curriculum:
		TestingMethods.selectFirstOption(browser, CORE_CURRICULUM, "JTA Automation");
			//Set the new batch's Focus:
		TestingMethods.selectFirstOption(browser, FOCUS, "No Focus");
			//Set the new batch's Skills:
		TestingMethods.selectFirstOption(browser, SKILLS, "Possibly William WebDriver");
		//TestingMethods.selectAnotherOption(browser, "Test Skills");
		//TestingMethods.selectAnotherOption(browser, SELENIUM_WEBDRIVER);
			//Set the new batch's Start Date:
		TestingMethods.enterText(browser, browser.findElement(By.id(START_DATE)), "4/2/2018");
			//Set the new batch's Trainer:
		TestingMethods.selectFirstOption(browser, TRAINER, LEBRON_JAMES);
			//Set the new batch's Location:
		TestingMethods.selectFirstOption(browser, LOCATION, RESTON_VA);
			//Set the new batch's Building:
		TestingMethods.selectFirstOption(browser, BUILDING, REVATURE_11730);
			//Set the new batch's Room:
		TestingMethods.selectFirstOption(browser, ROOM, ROOM_100);
			//Create the new batch:
		TestingMethods.makeTheBatch(browser, browser.findElement(By.className(CREATE_BATCH_BUTTON)));
		
		
		Assert.assertTrue(true);
	}
	
	
	
}
