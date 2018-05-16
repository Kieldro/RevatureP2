package com.revature.tests;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.revature.util.TestingMethods;

public class CurriculaTests {

	
	//Get a WebDriver object for use in the tests:
		WebDriver browser;
		WebElement tableElement;
		List<WebElement> trList;
			
		@BeforeClass
		public void setUp() {
			browser = TestingMethods.getDriver();
			//Perform the login actions:
			vpLogin(browser);
			for (int i = 0; i < 375; i++) {
				System.out.println(browser.getPageSource());
			}
			pushButtonFromNavBar(browser, "curricula");
		}
		
		/*
		 * Test if a curricula can be added, by checking the pagesource before and after adding the curricula.
		 */
		@Ignore
		@Test
		public void testAddingCurricula() {
			//get the pagesource
			String sourceCode = browser.getPageSource();
			
			//get and click the add curriculum element
			WebElement button = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/md-card[1]/md-toolbar/div/button[1]"));
			button.click();
			
			// get the curriculumName input element, and the save button
			WebElement curriculumName = browser.findElement(By.xpath("//*[@aria-label=\"curriculumName\"]"));
			WebElement saveButton = browser.findElement(By.xpath("/html/body/div[3]/md-dialog/md-dialog-actions/button[2]"));
			
			// send a randomly generated string to the input element, and click the save button
			curriculumName.sendKeys(createRandomString());
			saveButton.click();
			
			// changeDetected will hold true if a pageSource is detected in the page.
			boolean changeDetected = false;
			
			// loop a max of 50 times, if the pagesource is changed from what it was initially, 
			// this means the curriculum was added.
			for (int i = 0; i < 50; i++) {
				System.out.println(browser.getPageSource());
				if (!sourceCode.equals(browser.getPageSource())) {
					changeDetected = true;
					break;
				}
			}
			// if changeDetected is true then test will pass, otherwise it will fail.
			Assert.assertTrue(changeDetected);
		}
		
		
		/*
		 * Test that the buttons on the page are still there after refreshing the page
		 * Should fail, because website isn't currently working
		 */
		@Test
		public void testButtonsAfterRefreshingPage() {
			for (int i = 0; i < 10; i++) {
				System.out.println(browser.getPageSource());
			}
			//get the current url
			String url = browser.getCurrentUrl();
			
			for (int i = 0; i < 10; i++) {
				System.out.println(browser.getPageSource());
			}
			//navigate to the same url, basically refreshing the page
			browser.navigate().to(url);
			
			for (int i = 0; i < 30; i++) {
				System.out.println(browser.getPageSource());
			}
			// assume button is there
			boolean buttonDetected = true;
			
			//see if buttons still exist
			try {
				WebElement button = browser.findElement(By.xpath("//*[@aria-label=\"Add New Curriculum\"]"));
			} catch (NoSuchElementException e) {
				buttonDetected = false;
			}
			
			Assert.assertTrue(buttonDetected);
		}
		
		
		
		
		
		@AfterClass
		public void closeBrowser() {
			//close chromedriver and chrome window
			browser.quit();
		}
		
		/*
		 * Create a randomly generated string, that can be used to add new curriculum.
		 */
		public String createRandomString() {
			byte[] array = new byte[10]; // length 10
		    new Random().nextBytes(array);
		    String generatedString = new String(array, Charset.forName("UTF-8"));
		    System.out.println(generatedString);
		    return generatedString;
		}
		
		public void pushButtonFromNavBar(WebDriver browser, String buttonName)
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
				for (int i = 0; i < 100; i++)
				{
					sourceCode = browser.getPageSource();
				}
			}
			System.out.println("About to push the " + buttonName + " button...");
			
			// Push the button to be tested:
			Zhalfir.click();
			System.out.println("Pushed the " + buttonName + " button.");
		}
		
		public void vpLogin(WebDriver browser) {
			// Declare the relevant input objects:
			WebElement usernameField;
			WebElement passwordField;
			WebElement submitButton;

			// Supports the test even if the trainer tests didn't leave off on a login page:
			try {
				// Acquire the relevant input objects:
				usernameField = browser.findElement(By.id("username"));
				passwordField = browser.findElement(By.id("password"));
				submitButton = browser.findElement(By.id("Login"));
			} catch (NoSuchElementException e) {
				
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

}
