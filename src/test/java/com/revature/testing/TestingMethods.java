//John Eifert
package com.revature.testing;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;

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
		for(int i=0; i<25; i++)
		{
			sourceCode = browser.getPageSource();
			System.out.println(browser.getCurrentUrl());
		}
		
		// Acquire the relevant input objects:
		WebElement usernameField = browser.findElement(By.id("username"));
		WebElement passwordField = browser.findElement(By.id("password"));
		WebElement submitButton = browser.findElement(By.id("Login"));

		// Perform the login actions:
		usernameField.sendKeys("test.trainer@revature.com.int1");
		passwordField.sendKeys("trainer123");
		submitButton.click();
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
		for(int i=0; i<100; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allOptions = new ArrayList<WebElement>();
		allOptions = browser.findElements(By.tagName("md-option"));
		WebElement thisOption = null;
		for(int i=0; i<allOptions.size(); i++)
		{
			thisOption = allOptions.get(i);
			String thisText = thisOption.findElement(By.className("md-text ng-binding")).getText();
			
			if(thisText.equals(optionValue))
			{
				thisOption.click();
				break;
			}
		}
		
		
		/*
		// Acquire the desired menu object:
		WebElement menuObject = browser.findElement(By.id(menuID));
		// Click into the menu:
		menuObject.click();

		String sourceCode = "";
		for (int i = 0; i < 50; i++)
			sourceCode = browser.getPageSource();
		// System.gc();

		Select menu = new Select(browser.findElement(By.id(menuID)));
		ArrayList<WebElement> allOptions = new ArrayList<WebElement>();
		for (int i = 0; i < menu.getOptions().size(); i++)
		{
			allOptions.add(menu.getOptions().get(i));
		}

		menuObject.findElement(By.tagName("md-option")).click();

		// Select menu = new Select(browser.findElement(By.id(menuID)));

		// menu.selectByVisibleText(optionValue);

		// Acquire the desired option object:
		// WebElement optionObject = browser.findElement(By.tagName("md-option"));
		// browser.findElement(By.id(optionID));

		// System.out.println("About to push the " + optionObject.getAttribute("id") + "
		// button...");

		// Select the desired option:
		// optionObject.click();
		 */
	}
	
	public static void selectFocus(WebDriver browser, String menuID, String optionValue)
	{
		WebElement menu = browser.findElement(By.id(menuID));
		menu.click();
		
		/////////////////////////////////////////////////////////////////////
		String sourceCode = "";
		for(int i=0; i<100; i++)
		{
			sourceCode = browser.getPageSource();
		}
		
		List<WebElement> allOptions = new ArrayList<WebElement>();
		allOptions = browser.findElements(By.tagName("md-option"));
		WebElement thisOption = null;
		for(int i=0; i<allOptions.size(); i++)
		{
			thisOption = allOptions.get(i);
			
			
		}
		
	}

	public static void selectAnotherOption(WebDriver browser, String optionID)
	{
		// Acquire the desired option object:
		WebElement optionObject = browser.findElement(By.id(optionID));
		// Select the desired option:
		optionObject.click();
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
		for(int i=0; i<25; i++)
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
		for(WebElement e: allInputs)
		{
			if(e.getAttribute("ng-model") != null && e.getAttribute("ng-model").contains("cCtrl.skillName"))
			{
				e.sendKeys(skillName);
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
		for(WebElement e: allDivs)
		{
			if(e.getAttribute("ng-click").contains("createSkill"))
			{
				e.click();
				break;
			}
		}
		
	}
	
	public static void makeTrainer(WebDriver browser, String firstName, String lastName)
	{
		List<WebElement> buttons = new ArrayList<WebElement>();
		buttons = browser.findElements(By.tagName("button"));
		
		for(WebElement e: buttons)
		{
			try
			{
				if(e.getAttribute("aria-label") != null && e.getAttribute("aria-label").contains("Add Trainer"))
				{
					e.click();
					break;
				}
			}
			catch(Exception e1)
			{ }
		}
		
		List<WebElement> allInputs = new ArrayList<WebElement>();
		allInputs = browser.findElements(By.tagName("input"));
		for(WebElement e: allInputs)
		{
			if(e.getAttribute("ng-model").equals("tdCtrl.trainer.firstName"))
			{
				e.sendKeys(firstName);
			}
			if(e.getAttribute("ng-model").equals("tdCtrl.trainer.lastName"))
			{
				e.sendKeys(lastName);
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
		for(WebElement e: allInput)
		{
			if(e.getAttribute("ng-model").equals("sCtrl.settings.trainersPerPage"))
			{
				e.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.reportGrads"))
			{
				e.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.reportIncomingGrads"))
			{
				e.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.minBatchSize"))
			{
				e.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.maxBatchSize"))
			{
				e.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.batchLength"))
			{
				e.sendKeys(Integer.toString(rand.nextInt(30)));
			}
			
			if(e.getAttribute("ng-model").equals("sCtrl.settings.trainerBreakDays"))
			{
				e.sendKeys(Integer.toString(rand.nextInt(30)));
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
		for(WebElement e: allButtons)
		{
			if(e.getAttribute("ng-click").contains("updateSettings"))
			{
				e.click();
				break;
			}
		}
	}
}
