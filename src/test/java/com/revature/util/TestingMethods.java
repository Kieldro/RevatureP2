//John Eifert
package com.revature.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.chrome.ChromeOptions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;



public class TestingMethods
{
	public static ChromeOptions options = new ChromeOptions()
			.addArguments(
				"user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
	
	
	public static WebDriver getDriver()
	{
		// Multi-OS support:
		String os = System.getProperty("os.name");
		System.out.println("OS: " + os);
		String path = "src/main/resources/chromedriver.exe";
		if (os.equals("Linux")) // windows path
			path = "src/main/resources/chromedriver";
		System.setProperty("webdriver.chrome.driver", path);

		// Make and return a ChromeDriver:
		return (new ChromeDriver(options));
	}

	public static void trainerLogin(WebDriver browser)
	{
		// Navigate to the login page:
		browser.get("https://dev.assignforce.revaturelabs.com");
		
		browser.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<5; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getCurrentUrl());
		}
		
		List<WebElement> allImgs = new ArrayList<WebElement>();
		allImgs = browser.findElements(By.tagName("img"));
		for(int i=0; i<allImgs.size(); i++)
		{
			try
			{
				if(allImgs.get(i).getAttribute("src").contains("/img/logo214.svg"))
				{
					/////////////////////////////////////////////////////////////////////
					sourceCode = "";
					for(int j=0; j<25; j++)
					{
						sourceCode = browser.getPageSource();
					}
					
					// Acquire the relevant input objects:
					WebElement usernameField = browser.findElement(By.id("username"));
					WebElement passwordField = browser.findElement(By.id("password"));
					WebElement submitButton = browser.findElement(By.id("Login"));
	
					// Perform the login actions:
					usernameField.sendKeys("test.trainer@revature.com.int1");
					passwordField.sendKeys("trainer123");
					submitButton.click();
					
					return;
				}
			}
			catch(NullPointerException e1)
			{ System.out.println("!!!!!!!!!!!!!!!!!Caught a NullPointerException!!!!!"); }
		}
		
		pushButtonFromNavBar(browser, "logout");
		
		/////////////////////////////////////////////////////////////////////
		sourceCode = "";
		for(int j=0; j<25; j++)
		{
			sourceCode = browser.getPageSource();
		}
		
		trainerLogin(browser);
	}
	
	public static void pushButtonFromNavBar(WebDriver browser, String buttonName)
	{
		/*
		 * Declare the name of the button being tested, so that, should the test fail,
		 * the button that it failed on will be easily knowable
		 */
		System.out.println("Now testing the " + buttonName + " button.");
		/*
		 * Since the page's JavaScript needs time to create the nav buttons, the browser
		 * will for an arbitrary, but large amount of time to give the JS time to create
		 * the buttons
		 */

		// Acquire the button to be tested:
		WebElement Zhalfir = browser.findElement(By.name(buttonName));
		System.out.println("Got the " + buttonName + " button.");

		// Kills some time while the JS finishes making the buttons interactable:
		if(!browser.getCurrentUrl().equals("https://dev.assignforce.revaturelabs.com/reports"))
		{
			String sourceCode = "";
			for (int i = 0; i < 9; i++)
			{
				sourceCode = browser.getPageSource();
			}
		}
		System.out.println("About to push the " + buttonName + " button...");
		
		// Push the button to be tested:
		Zhalfir.click();
		System.out.println("Pushed the " + buttonName + " button.");
	}

	public static void vpLogin(WebDriver browser)
	{
		// Declare the relevant input objects:
		WebElement usernameField;
		WebElement passwordField;
		WebElement submitButton;

		// Supports the test even if the trainer tests didn't leave off on a login page:
		try
		{
			// Acquire the relevant input objects:
			usernameField = browser.findElement(By.id("username"));
			passwordField = browser.findElement(By.id("password"));
			submitButton = browser.findElement(By.id("Login"));
		} catch (NoSuchElementException e)
		{
			/*
			try
			{
				//browser.close();
			}
			catch(NoSuchSessionException nsse)
			{
				System.err.println("There was no session to quit.");
			}
			*/
			
			//browser = getDriver();
			browser.navigate().to("https://dev.assignforce.revaturelabs.com");
			//browser.get("https://dev.assignforce.revaturelabs.com");

			// Acquire the relevant input objects:
			usernameField = browser.findElement(By.id("username"));
			passwordField = browser.findElement(By.id("password"));
			submitButton = browser.findElement(By.id("Login"));
		}

		// Perform the login actions:
		usernameField.sendKeys("test.vpoftech@revature.com.int1");
		passwordField.sendKeys("yuvi1712");
		submitButton.click();
	}

	public static void selectCoreCurriculum(WebDriver browser, String menuID, String optionValue)
	{
		WebElement menu = browser.findElement(By.id(menuID));
		menu.click();
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allDivs = new ArrayList<WebElement>();
		allDivs = browser.findElements(By.tagName("div"));
		WebElement thisDiv = null;
		WebElement thisOption = null;
		String thisText = "";
		for(int i=0; i<allDivs.size(); i++)
		{
			thisDiv = allDivs.get(i);
			try
			{
				thisText = thisDiv.getText();
				if(thisText.contains(optionValue))
				{
					thisOption = thisDiv.findElement(By.xpath(".."));
					if(thisOption.getTagName().equals("md-option"))
					{
						thisOption.click();
						break;
					}
				}
			}
			catch(NullPointerException e1)
			{ }
		}
		
		/////////////////////////////////////////////////////////////////////
		sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
	}
	
	public static void selectFocus(WebDriver browser, String menuID, String optionValue)
	{
		System.out.println("Now selecting " + optionValue + " as Focus...");
		
		WebElement menu = browser.findElement(By.id(menuID));
		menu.click();
		
		System.out.println("Clicked into the dropdown menu.");
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		System.out.println("About to find the option containing " + optionValue + "...");
		
		List<WebElement> allDivs = new ArrayList<WebElement>();
		allDivs = browser.findElements(By.tagName("div"));
		WebElement thisDiv = null;
		WebElement thisOption = null;
		String thisText = "";
		for(int i=0; i<allDivs.size(); i++)
		{
			thisDiv = allDivs.get(i);
			try
			{
				thisText = thisDiv.getText();
				
				System.out.println("!!!!!option " + i + " contains " + thisText);
				
				if(thisText.equals(optionValue))
				{
					System.out.println("Found the option containing " + thisText + ".");
					
					thisOption = thisDiv.findElement(By.xpath(".."));
					if(thisOption.getTagName().equals("md-option"))
					{
						thisOption.click();
						break;
					}
				}
			}
			catch(NullPointerException e1)
			{ }
		}
		
		/////////////////////////////////////////////////////////////////////
		sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
	}
	
	public static void selectFirstSkill(WebDriver browser, String optionValue)
	{
		System.out.println("About to select the first skill...");
		
		WebElement menu = browser.findElement(By.id("select_13"));
		menu.click();
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		System.out.println("About to find the option containing " + optionValue + "...");
		
		List<WebElement> allOptions = new ArrayList<WebElement>();
		allOptions = browser.findElements(By.tagName("md-option"));
		WebElement thisOption = null;
		String thisText = "";
		for(int i=0; i<allOptions.size(); i++)
		{
			thisOption = allOptions.get(i);
			thisText = thisOption.findElement(By.xpath(
					".//div[@class='md-text ng-binding']")).getText();
			
			System.out.println("!!!!!option " + i + " contains " + thisText);
			
			if(thisText.equals(optionValue))
			{
				System.out.println("Found the option containing " + thisText + ".");
				thisOption.click();
				System.out.println("Clicked on the option containing " + optionValue + ".");
				break;
			}
		}
		
		/////////////////////////////////////////////////////////////////////
		sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
	}

	public static void selectAnotherSkill(WebDriver browser, String optionValue)
	{
		System.out.println("About to select another skill...");
		
		// Acquire the desired option object:
		List<WebElement> allOptions = new ArrayList<WebElement>();
		allOptions = browser.findElements(By.tagName("md-option"));
		WebElement thisOption = null;
		String thisText = "";
		for(int i=0; i<allOptions.size(); i++)
		{
			thisOption = allOptions.get(i);
			thisText = thisOption.findElement(
					By.xpath(".//div[@class='md-text ng-binding']")).getText();
			
			System.out.println("!!!!!option " + i + " contains " + thisText);
			
			if(thisText.equals(optionValue))
			{
				System.out.println("Found the option containing " + thisText + ".");
				thisOption.click();
				System.out.println("Clicked on the option containing " + optionValue + ".");
				break;
			}
		}
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
	}
	
	public static void leaveDropDown(WebDriver browser, WebElement place)
	{
		System.out.println("About to leave the drop down menu...");
		
		Robot mouse = null;
		
		try
		{
			mouse = new Robot();
		}
		catch(AWTException e1)
		{
			System.out.println("!!!Robot creation threw an AWTException.");
			return;
		}
		
		//Moves the mouse away from the drop down menu:
		Point thisPoint = place.getLocation();
		mouse.mouseMove(thisPoint.x, thisPoint.y);
		
		//Clicks off of the drop down menu:
		mouse.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		mouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
	}

	public static void enterText(WebDriver browser, WebElement field, String sendInput)
	{
		// Give the desired input text to the desired input object:
		field.sendKeys(sendInput);
	}

	public static void makeTheBatch(WebDriver browser, WebElement button)
	{
		// Push the submit button to submit the finished batch:
		button.click();
	}
	
	public static void makeLocation(WebDriver browser, String locName)
	{
		System.out.println("locName = " + locName);
		
		browser.findElement(By.id("locAdd")).click();
		
		List<WebElement> allInputs = new ArrayList<WebElement>();
		allInputs = browser.findElements(By.tagName("input"));
		String cityName = "Townsville";
		while(!cityName.equals("Townsville"))
		{
			cityName = "Townsville";
		}
		for(int i=0; i<allInputs.size(); i++)
		{
			System.out.println("input " + i + " = " + allInputs.get(i).getAttribute("ng-model"));
			
			if(allInputs.get(i).getAttribute("ng-model").equals("ldCtrl.location.name"))
			{
				allInputs.get(i).sendKeys(locName);
			}
			if(allInputs.get(i).getAttribute("ng-model").equals("ldCtrl.location.city"))
			{
				allInputs.get(i).sendKeys(cityName);
				
				/////////////////////////////////////////////////////////////////////
				String sourceCode = "";
				for(int j=0; j<50; j++)
				{
					sourceCode = browser.getPageSource();
				}
				
				while(!allInputs.get(i).getAttribute("value").equals(cityName))
				{
					System.out.println(cityName + "!=" + allInputs.get(i).getAttribute("value"));
					
					allInputs.get(i).clear();
					
					/////////////////////////////////////////////////////////////////////
					for(int j=0; j<9; j++)
					{
						sourceCode = browser.getPageSource();
					}
					
					allInputs.get(i).sendKeys(cityName);
					
					for(int j=0; j<25; j++)
					{
						sourceCode = browser.getPageSource();
					}
				}
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
				
				/////////////////////////////////////////////////////////////////////
				String sourceCode = "";
				for(int j=0; j<25; j++)
				{
					sourceCode = browser.getPageSource();
				}
				
				List<WebElement> allDropOptions = new ArrayList<WebElement>();
				allDropOptions = browser.findElements(By.tagName("md-option"));
				for(int j=0; j<allDropOptions.size(); j++)
				{
					if(allDropOptions.get(j).getAttribute("value").equals("OH"))
					{
						allDropOptions.get(j).click();
						break;
					}
				}
			}
		}
		
		List<WebElement> allButtons = new ArrayList<WebElement>();
		allButtons = browser.findElements(By.tagName("button"));
		for(int i=0; i<allButtons.size(); i++)
		{
			if(allButtons.get(i).getAttribute("type").equals("submit"))
			{
				allButtons.get(i).click();
				System.out.println("Created the new location.");
			}
		}
	}
	
	public static WebElement getLocationBox(WebDriver browser, String cityName)
	{
		List<WebElement> allBoxes = new ArrayList<WebElement>();
		allBoxes = browser.findElements(By.tagName("md-checkbox"));
		for(int i=0; i<allBoxes.size(); i++)
		{
			if(allBoxes.get(i).getAttribute("aria-label").contains(cityName))
			{
				System.out.println("Got the location in " + cityName + ".");
				return(allBoxes.get(i));
			}
		}
		
		//If there is no location box for cityName:
		return(null);
	}
	
	public static void checkLocation(WebDriver browser, String cityName)
	{
		System.out.println("Checking the location in " + cityName + "...");
		
		getLocationBox(browser, cityName).click();
		
		System.out.println("Checked the location in " + cityName + ".");
	}
	
	public static boolean findLocation(WebDriver browser, String cityName)
	{
		List<WebElement> allBoxes = new ArrayList<WebElement>();
		allBoxes = browser.findElements(By.tagName("md-checkbox"));
		for(int i=0; i<allBoxes.size(); i++)
		{
			System.out.println("Box " + i + " = " + allBoxes.get(i).getAttribute("aria-label"));
			
			if(allBoxes.get(i).getAttribute("aria-label").contains(cityName))
			{
				System.out.println("There is a location in " + cityName + ".");
				return(true);
			}
		}
		
		return(false);
	}
	
	public static void deleteLocation(WebDriver browser, String cityName)
	{
		checkLocation(browser, cityName);
		
		System.out.println("Checked " + cityName + ".");
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<50; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		System.out.println("Finished waiting.");
		
		List<WebElement> allButtons = new ArrayList<WebElement>();
		allButtons = browser.findElements(By.tagName("button"));
		for(int i=0; i<allButtons.size(); i++)
		{
			try
			{
				allButtons.get(i).getAttribute("aria-label");
				
				System.out.println("button "+i+" label = "+allButtons.get(i).getAttribute("aria-label"));
				if(allButtons.get(i).getAttribute("aria-label").equals("Inactivate selected"))
				{
					System.out.println("About to delete location in " + cityName + ".");
					allButtons.get(i).click();
				}
			}
			catch(NullPointerException e)
			{ }
		}
		
		for(int i=0; i<50; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		allButtons = browser.findElements(By.tagName("button"));
		for(int i=0; i<allButtons.size(); i++)
		{
			if(allButtons.get(i).getAttribute("ng-click").contains("dCtrl.delete"))
			{
				allButtons.get(i).click();
			}
		}
		
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		System.out.println("Finished location deletion.");
	}
	
	public static void makeCurricula(WebDriver browser, String currName)
	{
		System.out.println("currName = " + currName);
		
		List<WebElement> buttons = new ArrayList<WebElement>();
		buttons = browser.findElements(By.tagName("button"));
		
		for(WebElement e: buttons)
		{
			try
			{
				if(e.getAttribute("aria-label") != null && e.getAttribute("aria-label").contains("Add New Curriculum"))
				{
					e.click();
					break;
				}
			}
			catch(Exception e1)
			{ }
		}
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<10; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allInputs = new ArrayList<WebElement>();
		allInputs = browser.findElements(By.tagName("input"));
		for(WebElement e: allInputs)
		{
			try
			{
				if(e.getAttribute("aria-label") != null && e.getAttribute("aria-label").contains("curriculumName"))
				{
					e.clear();
					e.sendKeys(currName);
				}
			}
			catch(Exception e1)
			{ }
		}
		
		sourceCode = "";
		for(int i=0; i<10; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allButtons = new ArrayList<WebElement>();
		allButtons = browser.findElements(By.tagName("button"));
		for(int i=0; i<allButtons.size(); i++)
		{
			try
			{
				if(allButtons.get(i).getAttribute("ng-click") != null && allButtons.get(i).getAttribute("ng-click").contains("saveCurriculum"))
				{
					allButtons.get(i).click();
					break;
				}
			}
			catch(Exception e1)
			{ }
		}
		
		/*
		List<WebElement> allDropDowns = new ArrayList<WebElement>();
		allDropDowns = browser.findElements(By.tagName("md-select"));
		boolean done = false;
		for(int i = 0; i < allDropDowns.size(); i++)
		{
			System.out.println("drop down " + i + "=" + allDropDowns.get(i).getAttribute("ng-model"));
			
			if(allDropDowns.get(i).getAttribute("ng-model").equals("curricI.skills"))
			{
				allDropDowns.get(i).click();
				
				/////////////////////////////////////////////////////////////////////
				sourceCode = "";
				for(int j=0; j<50; j++)
				{
					sourceCode = browser.getPageSource();
				}
				
				List<WebElement> allDropOptions = new ArrayList<WebElement>();
				allDropOptions = browser.findElements(By.tagName("md-option"));
				List<WebElement> theseDivs = new ArrayList<WebElement>();
				WebElement thisOption = null;
				for(int j = 0; j < allDropOptions.size(); j++)
				{
					thisOption = allDropOptions.get(j);
					
					theseDivs = thisOption.findElements(By.tagName("div"));
					for(int k=0; k<theseDivs.size(); k++)
					{
						if(theseDivs.get(k).getAttribute("class").equals("md-text ng-binding"))
						{
							if(theseDivs.get(k).getText().equals(".ANDROID"))
							{
								thisOption.click();
								done = true;
								break;
							}
						}
					}
					if(done)
					{
						break;
					}
				}
			}
			if(done)
			{
				break;
			}
		}
		*/
		
	}
	

	public static void makeFocus(WebDriver browser, String focusName)
	{
		System.out.println("focusName = " + focusName);
		
		List<WebElement> buttons = new ArrayList<WebElement>();
		buttons = browser.findElements(By.tagName("button"));
		
		WebElement AddButton = null;
		for(WebElement e: buttons)
		{
			try
			{
				if(e.getAttribute("aria-label") != null && e.getAttribute("aria-label").contains("Add New Focus"))
				{
					AddButton = e;
					AddButton.click();
					break;
				}
			}
			catch(Exception e1)
			{ }
		}
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allInputs = new ArrayList<WebElement>();
		allInputs = browser.findElements(By.tagName("input"));
		WebElement field = null;
		for(WebElement e: allInputs)
		{
			try
			{
				if(e.getAttribute("aria-label") != null && e.getAttribute("aria-label").contains("curriculumName"))
				{
					field = e;
					field.clear();
					field.sendKeys(focusName);
					break;
				}
			}
			catch(Exception e1)
			{ }
		}
		
		sourceCode = "";
		for(int i=0; i<10; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allButtons = new ArrayList<WebElement>();
		allButtons = browser.findElements(By.tagName("button"));
		for(int i=0; i<allButtons.size(); i++)
		{
			try
			{
				if(allButtons.get(i).getAttribute("ng-click") != null && allButtons.get(i).getAttribute("ng-click").contains("saveCurriculum"))
				{
					allButtons.get(i).click();
					break;
				}
			}
			catch(Exception e1)
			{ }
		}
		
		/*
		List<WebElement> allDropDowns = new ArrayList<WebElement>();
		allDropDowns = browser.findElements(By.tagName("md-select"));
		for(int i = 0; i < allDropDowns.size(); i++)
		{
			System.out.println("drop down " + i + "=" + allDropDowns.get(i).getAttribute("ng-model"));
			
			if(allDropDowns.get(i).getAttribute("ng-model").equals("curricI.skills"))
			{
				allDropDowns.get(i).click();
				
				/////////////////////////////////////////////////////////////////////
				sourceCode = "";
				for(int j=0; j<25; j++)
				{
					sourceCode = browser.getPageSource();
				}
				
				List<WebElement> allDropOptions = new ArrayList<WebElement>();
				allDropOptions = browser.findElements(By.tagName("md-option"));
				for(int j = 0; j < allDropOptions.size(); j++)
				{
					//ADD FIXED DROPDOWN SELECTION
				}
			}
		}
		*/
		
	}
	
	public static void makeSkill(WebDriver browser, String skillName)
	{
		List<WebElement> allInputs = new ArrayList<WebElement>();
		allInputs = browser.findElements(By.tagName("input"));
		WebElement thisField = null;
		for(WebElement e: allInputs)
		{
			if(e.getAttribute("ng-model") != null && e.getAttribute("ng-model").contains("cCtrl.skillName"))
			{
				thisField = e;
				thisField.sendKeys(skillName);
				break;
			}
		}
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<9; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allDivs = new ArrayList<WebElement>();
		allDivs = browser.findElements(By.tagName("div"));
		WebElement thisDiv = null;
		for(WebElement e: allDivs)
		{
			if(e.getAttribute("ng-click") != null && e.getAttribute("ng-click").contains("createSkill"))
			{
				thisDiv = e;
				thisDiv.click(); /////////////////////////////////////////////////////
				break;
			}
		}
		
	}
	
	public static void makeTrainer(WebDriver browser, String firstName, String lastName)
	{
		List<WebElement> buttons = new ArrayList<WebElement>();
		buttons = browser.findElements(By.tagName("button"));
		WebElement thisButton = null;
		for(WebElement e: buttons)
		{
			try
			{
				if(e.getAttribute("aria-label") != null && e.getAttribute("aria-label").contains("Add Trainer"))
				{
					thisButton = e;
					thisButton.click();
					break;
				}
			}
			catch(Exception e1)
			{ }
		}
		
		List<WebElement> allInputs = new ArrayList<WebElement>();
		allInputs = browser.findElements(By.tagName("input"));
		WebElement thisField = null;
		for(WebElement e: allInputs)
		{
			if(e.getAttribute("ng-model").equals("tdCtrl.trainer.firstName"))
			{
				thisField = e;
				thisField.sendKeys(firstName);
			}
			if(e.getAttribute("ng-model").equals("tdCtrl.trainer.lastName"))
			{
				thisField = e;
				thisField.sendKeys(lastName);
			}
		}
		
		List<WebElement> allButtons = new ArrayList<WebElement>();
		allButtons = browser.findElements(By.tagName("button"));
		for(int i = 0; i < allButtons.size(); i++)
		{
			if(allButtons.get(i).getAttribute("type").equals("submit"))
			{
				allButtons.get(i).click();
				System.out.println("Created the new trainer.");
			}
		}
	}
	
	public static boolean findTrainer(WebDriver browser, String fullName)
	{
		List<WebElement> allTrainers = new ArrayList<WebElement>();
		allTrainers = browser.findElements(By.tagName("button"));
		for(int i = 0; i < allTrainers.size(); i++)
		{
			System.out.println("Trainer " + i + " = " + allTrainers.get(i).getAttribute("aria-label"));
			if(allTrainers.get(i).getAttribute("aria-label").contains(fullName))
			{
				System.out.println("There is a trainer named " + fullName + ".");
				return(true);
			}
		}
		return(false);
	}
	
	public static void settingsTest(WebDriver browser)
	{
		Random rand = new Random();
		
		List<WebElement> allInput = new ArrayList<WebElement>();
		allInput = browser.findElements(By.tagName("input"));
		WebElement thisField = null;
		for(WebElement e: allInput)
		{
			if(e.getAttribute("ng-model").equals("sCtrl.settings.trainersPerPage"))
			{
				thisField = e;
				thisField.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.reportGrads"))
			{
				thisField = e;
				thisField.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.reportIncomingGrads"))
			{
				thisField = e;
				thisField.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.minBatchSize"))
			{
				thisField = e;
				thisField.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.maxBatchSize"))
			{
				thisField = e;
				thisField.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.batchLength"))
			{
				thisField = e;
				thisField.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.trainerBreakDays"))
			{
				thisField = e;
				thisField.sendKeys(Integer.toString(rand.nextInt(30)));
			}
		}
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<9; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allButtons = new ArrayList<WebElement>();
		allInput = browser.findElements(By.tagName("button"));
		WebElement thisButton = null;
		for(WebElement e: allButtons)
		{
			if(e.getAttribute("ng-click").contains("updateSettings"))
			{
				thisButton = e;
				thisButton.click();
				break;
			}
		}
	}
}
