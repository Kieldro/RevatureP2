//John Eifert
package com.revature.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.revature.util.Driver;
import com.revature.util.TestingMethods;



public class TestNGTests
{
	//Get a WebDriver object for use in the tests:
	Driver browser = Driver.getInstance();
	Random rand = new Random();
	Actions act = new Actions(browser);
	
	@Test(groups="trainerTests", priority=1)
	public void trainerLoginTest()
	{
		
		//Perform the login actions:
		TestingMethods.trainerLogin(browser);
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/home";
		String actualURL = browser.getCurrentUrl();
		System.out.println(actualURL);
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=2)
	public void trainerOverviewNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "overview");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/home");
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=2)
	public void trainerSortNameAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByNameAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortNameAscTest", groups="trainerTests", priority=2)
	public void trainerSortNameDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByNameDesc(browser));
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=3)
	public void trainerSortCurrAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByCurriculumAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortCurrAscTest", groups="trainerTests", priority=3)
	public void trainerSortCurrDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByCurriculumDesc(browser));
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=4)
	public void trainerSortTnrAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByTrainerAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortTnrAscTest", groups="trainerTests", priority=4)
	public void trainerSortTnrDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByTrainerDesc(browser));
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=5)
	public void trainerSortLocAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByLocationAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortLocAscTest", groups="trainerTests", priority=5)
	public void trainerSortLocDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByLocationDesc(browser));
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=6)
	public void trainerSortBldAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByBuildingAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortBldAscTest", groups="trainerTests", priority=6)
	public void trainerSortBldDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByBuildingDesc(browser));
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=7)
	public void trainerSortRoomAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByRoomAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortRoomAscTest", groups="trainerTests", priority=7)
	public void trainerSortRoomDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByRoomDesc(browser));
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=8)
	public void trainerSortStdAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByStartDateAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortStdAscTest", groups="trainerTests", priority=8)
	public void trainerSortStdDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByStartDateDesc(browser));
	}
	
	@Test(dependsOnMethods="trainerOverviewNavTest", groups="trainerTests", priority=9)
	public void trainerSortEndAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByEndDateAsc(browser));
	}
	
	@Test(dependsOnMethods="trainerSortEndAscTest", groups="trainerTests", priority=9)
	public void trainerSortEndDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByEndDateDesc(browser));
	}
		
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=10)
	public void trainerBatchesNavTest()
	{
		/*
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		System.out.println("About to find the Batches button...");
		
		List<WebElement> allUls = new ArrayList<WebElement>();
		allUls = browser.findElements(By.tagName("ul"));
		WebElement thisUl = null;
		//List<WebElement> allLis = new ArrayList<WebElement>();
		WebElement thisLi = null;
		for(int i=0; i<allUls.size(); i++)
		{
			thisUl = allUls.get(i);
			
			System.out.println("ul " + i + " class = " + thisUl.getAttribute("class"));
			
			if(thisUl.getAttribute("class").contains("nav-bar-list"))
			{
				System.out.println("!!!!!Found the ul containing " + thisUl.getAttribute("class"));
				
				thisLi = thisUl.findElement(By.xpath(".//li[@name='batches']"));
				
				System.out.println("Got the li containing " + thisLi.getAttribute("name"));
				
				thisLi.click();
				
				System.out.println("Clicked the li.");
				
				break;
			}
		}
		
		/////////////////////////////////////////////////////////////////////
		sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
		*/
		
		
		TestingMethods.pushButtonFromNavBar(browser, "batches");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/batches");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=10)
	public void trainerLocationsNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "locations");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/locations");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=10)
	public void trainerCurriculaNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "curricula");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/curriculum");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=10)
	public void trainerTrainersNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "trainers");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/trainers");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=10)
	public void trainerProfileNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "profile");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/profile");
	}
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=10)
	public void trainerReportNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "reports");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/reports");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=10)
	public void trainerSettingsNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "settings");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/settings");
	}
	
	@Test(dependsOnMethods="trainerLoginTest", groups="trainerTests", priority=11)
	public void TrainerLogoutTest()
	{
		String expectedURL, actualURL;
		TestingMethods.pushButtonFromNavBar(browser, "logout");
		String sourceCode = "";
		/////////////////////////////////////////////////////////////////////
		if(!browser.getCurrentUrl().equals("https://dev.assignforce.revaturelabs.com/reports"))
		{
			for(int i=0; i<9; i++)
			{
				//System.out.println(i);
				sourceCode = browser.getPageSource();
				//System.out.println(browser.getCurrentUrl());
			}
		}
		else
		{
			sourceCode = browser.getPageSource();
			sourceCode = browser.getPageSource();
			sourceCode = browser.getPageSource();
		}
		
		System.out.println(browser.getCurrentUrl());
		expectedURL = "https://dev.assignforce.revaturelabs.com/settings";
		actualURL = browser.getCurrentUrl();
		
		Assert.assertNotEquals(actualURL, expectedURL);
	}
	
	
	@Test(groups="vpTests", priority=12)
	public void vpLoginTest()
	{
		//Perform the login actions:
		TestingMethods.vpLogin(browser);
		
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<250; i++)
		{
			System.out.println(browser.getCurrentUrl());
		}
		
		
		//Establish what URL we expect the new URL to be and what the new URL actually is:
		String expectedURL = "https://dev.assignforce.revaturelabs.com/home";
		String actualURL = browser.getCurrentUrl();
		
		//Test whether the new URL is what it should be:
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=12)
	public void vpOverviewNavTest()
	{
		//Test the overview nav button:
		TestingMethods.pushButtonFromNavBar(browser, "overview");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/home");
	}
	

	@Test(dependsOnMethods="vpOverviewNavTest", priority=12)
	public void vpSortNameAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByNameAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortNameAscTest", priority=13)
	public void vpSortNameDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByNameDesc(browser));
	}
	
	@Test(dependsOnMethods="vpOverviewNavTest", priority=13)
	public void vpSortCurrAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByCurriculumAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortCurrAscTest", priority=14)
	public void vpSortCurrDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByCurriculumDesc(browser));
	}
	
	@Test(dependsOnMethods="vpOverviewNavTest", priority=14)
	public void vpSortTnrAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByTrainerAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortTnrAscTest", priority=15)
	public void vpSortTnrDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByTrainerDesc(browser));
	}
	
	@Test(dependsOnMethods="vpOverviewNavTest", priority=16)
	public void vpSortLocAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByLocationAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortLocAscTest", priority=16)
	public void vpSortLocDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByLocationDesc(browser));
	}
	
	@Test(dependsOnMethods="vpOverviewNavTest", priority=17)
	public void vpSortBldAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByBuildingAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortBldAscTest", priority=17)
	public void vpSortBldDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByBuildingDesc(browser));
	}
	
	@Test(dependsOnMethods="vpOverviewNavTest", priority=18)
	public void vpSortRoomAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByRoomAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortRoomAscTest", priority=18)
	public void vpSortRoomDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByRoomDesc(browser));
	}
	
	@Test(dependsOnMethods="vpOverviewNavTest", priority=19)
	public void vpSortStdAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByStartDateAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortStdAscTest", priority=19)
	public void vpSortStdDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByStartDateDesc(browser));
	}
	
	@Test(dependsOnMethods="vpOverviewNavTest", priority=20)
	public void vpSortEndAscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByEndDateAsc(browser));
	}
	
	@Test(dependsOnMethods="vpSortEndAscTest", priority=20)
	public void vpSortEndDscTest()
	{
		Assert.assertTrue(OverviewTests.testOverviewSortByEndDateDesc(browser));
	}
	
	
	@Test(groups= "vpTests", dependsOnMethods="vpLoginTest", priority=21)
	public void vpBatchesNavTest()
	{
		//Test the batches nav button:
		TestingMethods.pushButtonFromNavBar(browser, "batches");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/batches");
	}
	
	/*
	@Test(groups={"vpTests", "batchesTests"}, dependsOnMethods="vpBatchesNavTest", priority=21)
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
		
		
		//Operate the batch creation menus to provide information about a new batch:
			//Set the new batch's Core Curriculum:
		TestingMethods.selectCoreCurriculum(browser, CORE_CURRICULUM, "JTA Automation");
			//Set the new batch's Focus:
		TestingMethods.selectFocus(browser, FOCUS, "No Focus");
			//Add some skills to the new batch:
		/*
		WebElement revatureLogo = browser.findElement(By.xpath(
				"/html/body/div[1]/div[1]/ng-include/div/md-content/img"));
		*/
	
	/*
		TestingMethods.selectFirstSkill(browser, "Possibly William WebDriver");
		TestingMethods.selectAnotherSkill(browser, "Advanced UI");
		TestingMethods.leaveDropDown(browser, act);
		*/
	
		//TestingMethods.leaveDropDown(browser, revatureLogo);
		
		
		/*
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
		*/
		/*
		
		Assert.assertTrue(true);
	}
	*/
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=22)
	public void vplocationNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "locations");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/locations");
	}
	
	@Test(groups="vpTests", dependsOnMethods="vplocationNavTest", priority=22)
	public void makeLocationTest()
	{		
		//Assert.assertTrue(thisThing.isSelected());
		String locName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		
		TestingMethods.makeLocation(browser, locName);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<150; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		Assert.assertTrue(TestingMethods.findLocation(browser, "Townsville"));
	}
	@Test(groups="vpTests", dependsOnMethods="makeLocationTest", priority=22)
	public void deleteLocationTest()
	{
		String sourceCode = "";
		/////////////////////////////////////////////////////////////////////
		for(int i=0; i<150; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		TestingMethods.deleteLocation(browser, "Townsville");
		
		/////////////////////////////////////////////////////////////////////
		for(int i=0; i<500; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		Assert.assertFalse(TestingMethods.findLocation(browser, "Townsville"));
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=23)
	public void vpcurriculumNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "curricula");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/curriculum");
	}
	
	/*
	@Test(groups="vpTests", dependsOnMethods="vpcurriculumNavTest", priority=23)
	public void makeCurriculumTest()
	{		
		String CurrName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		TestingMethods.makeCurricula(browser, CurrName);
		
		Assert.assertTrue(true);
		/////////////////////////////////////////////////////////////////////
	}
	*/
	
	@Test(groups="vpTests", dependsOnMethods="vpcurriculumNavTest", priority=23)
	public void makeFocusTest()
	{	
		String sourceCode = "";
		for(int i=0; i<100; i++)
		{
			sourceCode = browser.getPageSource();
		}

		String FocusName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		TestingMethods.makeFocus(browser, FocusName);
		Assert.assertTrue(true);
	}
	
	/*
	@Test(groups="vpTests", dependsOnMethods="vpcurriculumNavTest", priority=23)
	public void makeSkillTest()
	{
		String sourceCode = "";
		/////////////////////////////////////////////////////////////////////
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
		Assert.assertTrue(true);
	}
	*/
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=24)
	public void vpTrainersNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "trainers");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/trainers");
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpTrainersNavTest", priority=24)
	public void makeTrainersTest()
	{
		String firstName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
		String lastName = Integer.toString(rand.nextInt(500000)).concat(
				Integer.toString(rand.nextInt(500000)));
//		TestingMethods.makeTrainer(browser, firstName, lastName);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<100; i++)
		{
			sourceCode = browser.getPageSource();
			//System.out.println(browser.getPageSource());
		}
		
		String fullName = firstName + " " + lastName;
//		Assert.assertTrue(TestingMethods.findTrainer(browser, fullName));
	}
	
	/*
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=25)
	public void ReportsTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "reports");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/reports");
	}
	*/
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=26)
	public void vpSettingsNavTest()
	{
		TestingMethods.pushButtonFromNavBar(browser, "settings");
		Assert.assertEquals(browser.getCurrentUrl(),
				"https://dev.assignforce.revaturelabs.com/settings");
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpSettingsNavTest", priority=26)
	public void SettingsTest()
	{
		TestingMethods.settingsTest(browser);
		Assert.assertTrue(true);
		
	}
	
	@Test(groups="vpTests", dependsOnMethods="vpLoginTest", priority=27)
	public void LogoutTest()
	{
		String expectedURL, actualURL;
		TestingMethods.pushButtonFromNavBar(browser, "logout");
		
		/////////////////////////////////////////////////////////////////////
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
	
	

	@AfterTest
	public void quitBrowser()
	{
		System.out.println("About to quit the browser...");
		browser.quit();
		System.out.println("Quit the browser.");
	}

}
