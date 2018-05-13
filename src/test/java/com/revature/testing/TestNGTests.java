//John Eifert
package com.revature.testing;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;



public class TestNGTests
{
	//Get a WebDriver object for use in the tests:
	WebDriver browser = TestingMethods.getDriver();
	Random rand = new Random();
	
	@Test(groups="trainerTests", priority=1)
	public void trainerLoginTest()
	{
		
		//Perform the login actions:
		TestingMethods.trainerLogin(browser);
		
		String sourceCode = "";
		for(int i=0; i<700; i++)
		{
			System.out.println(browser.getCurrentUrl());
		}
		try
		{
			browser.manage().timeouts().wait(3000);
		}
		catch (InterruptedException e)
		{
			System.err.println("Oops");
		}
		
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/home";
		String actualURL = browser.getCurrentUrl();
		System.out.println(actualURL);
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	/*
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
	*/
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerOverviewNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "overview");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/home");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerBatchesNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "batches");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/batches");
	}
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerLocationsNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "locations");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/locations");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerCurriculaNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "curricula");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/curriculum");
	}
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerTrainersNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "trainers");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/trainers");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerProfileNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "profile");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/profile");
	}
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerReportNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "reports");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/reports");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=1)
	public void trainerSettingsNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "settings");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/settings");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=2)
	public void TrainerLogoutTest()
	{
		String expectedURL, actualURL;
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
	
	
	@Test(groups="vpTests", priority=3)
	public void vpLoginTest()
	{
		//Perform the login actions:
		TestingMethods.vpLogin(browser);
		
		
		String sourceCode = "";
		for(int i=0; i<500; i++)
		{
			System.out.println(browser.getCurrentUrl());
		}
		
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/home";
		String actualURL = browser.getCurrentUrl();
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=3)
	public void vpOverviewNavTest()
	{
		//Test the overview nav button:
		TestingMethods.pushButtonFromNavBar(browser, "overview");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/home");
	}
	
	@Test(groups= {"vpTests", "batchesTests"}, dependsOnMethods="vpLoginTest", priority=4)
	public void vpBatchesNavTest()
	{
		//Test the batches nav button:
		TestingMethods.pushButtonFromNavBar(browser, "batches");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/batches");
	}
	
	/*
	@Test(groups={"vpTests", "batchesTests"}, dependsOnMethods="vpBatchesNavTest", priority=4)
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
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=5)
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
		String locName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		
		TestingMethods.makeLocation(browser, locName);
		
		String sourceCode = "";
		for(int i=0; i<150; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		Assert.assertTrue(TestingMethods.findLocation(browser, "Townsville"));
		
		for(int i=0; i<150; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		TestingMethods.deleteLocation(browser, "Townsville");
		
		for(int i=0; i<150; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		Assert.assertFalse(TestingMethods.findLocation(browser, "Townsville"));
		
		
		
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=6)
	public void curriculumTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "curricula");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/curriculum");
		
		String CurrName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		TestingMethods.makeCurricula(browser, CurrName);
		
		String sourceCode = "";
		for(int i=0; i<100; i++)
		{
			sourceCode = browser.getPageSource();
		}

		String FocusName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		TestingMethods.makeFocus(browser, FocusName);
		
		sourceCode = "";
		for(int i=0; i<100; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		String SkillName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		TestingMethods.makeSkill(browser, SkillName);
		
		sourceCode = "";
		for(int i=0; i<100; i++)
		{
			sourceCode = browser.getPageSource();
		}
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=7)
	public void TrainersTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "trainers");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/trainers");
		
		String firstName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		String lastName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		TestingMethods.makeTrainer(browser, firstName, lastName);
		String sourceCode = "";
		for(int i=0; i<300; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getPageSource());
		}
		
		String fullName = firstName + " " + lastName;
		Assert.assertTrue(TestingMethods.findTrainer(browser, fullName));
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=8)
	public void ReportsTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "reports");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/reports");
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=9)
	public void SettingsTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "settings");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/settings");
		
		TestingMethods.settingsTest(browser);
		
		
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=10)
	public void LogoutTest()
	{
		String expectedURL, actualURL;
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
	@AfterTest
	public void quitBrowser()
	{
		browser.quit();
	}
	*/
	
	
	
}
