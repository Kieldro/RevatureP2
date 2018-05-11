//John Eifert
package com.revature.testing;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;



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
		for(int i=0; i<500; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/home";
		String actualURL = browser.getCurrentUrl();
		System.out.println(actualURL);
		
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
		
		
		String sourceCode = "";
		for(int i=0; i<500; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		
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
	
	/*
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
	*/
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=4)
	public void locationTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "locations");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/locations");
		
		List<WebElement> things = new ArrayList<WebElement>();
		things = browser.findElements(By.tagName("md-checkbox"));
		
		WebElement thisThing = null;
		for(int i=0; i< things.size(); i++)
		{
			if(things.get(i).getAttribute("aria-label").contains("boston, MA"))
			{
				thisThing = things.get(i);
			}
		}
		
		System.out.println("About to check the box...");
		thisThing.click();
		System.out.println("Checked the box.");

		
		//Assert.assertTrue(thisThing.isSelected());
		
		browser.findElement(By.id("locAdd")).click();
		List<WebElement> allInputs = new ArrayList<WebElement>();
		
		for(int i=0; i<allInputs.size(); i++)
		{
			System.out.println("input " + i + " = " + allInputs.get(i).getAttribute("ng-model"));
			
			if(allInputs.get(i).getAttribute("ng-model").equals("ldCtrl.location.name"))
			{
				allInputs.get(i).sendKeys("Team Towns");
			}
			if(allInputs.get(i).getAttribute("ng-model").equals("ldCtrl.location.city"))
			{
				allInputs.get(i).sendKeys("Townsville");
			}
		}
		List<WebElement> allDropDowns = new ArrayList<WebElement>();
		allDropDowns = browser.findElements(By.tagName("md-select"));
		for(int i=0; i<allDropDowns.size(); i++)
		{
			System.out.println("drop down " + i + "=" + allDropDowns.get(i).getAttribute("ng-model"));
			
			if(allDropDowns.get(i).getAttribute("ng-model").equals("ldCtrl.location.state"))
			{
				allDropDowns.get(i).click();
				
				String sourceCode = "";
				for(int j=0; j<25; j++)
				{
					sourceCode = browser.getPageSource();
				}
				
				List<WebElement> allDropOptions = new ArrayList<WebElement>();
				allDropOptions = browser.findElements(By.tagName("md-option"));
				for(int j=0; j<allDropOptions.size(); j++)
				{
					System.out.println("option"+j+"= "+ allDropOptions.get(i).getAttribute("value"));
					
					if(allDropOptions.get(i).getAttribute("value").equals("OH"))
					{
						allDropOptions.get(i).click();
						break;
					}
				}
			}
		}
		
		
		
	}
	
	
	@AfterTest
	public void quitBrowser()
	{
		browser.quit();
	}
	
	
	
}
