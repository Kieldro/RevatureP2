package com.revature.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.revature.util.TestingMethods;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberOptions(features = "src/test/resources")
public class FocusTests {

	// Get a WebDriver object for use in the tests:
	WebDriver browser;
	WebElement tableElement;
	List<WebElement> trList;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		browser = TestingMethods.getDriver();
		wait = new WebDriverWait(browser, 10);
		// Perform the login actions:
		vpLogin(browser);

		pushButtonFromNavBar(browser, "curricula");
	}

	@Given("^I want to edit a focus with sql$")
	public void i_want_to_edit_a_focus_with_sql() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I edit the focus to have nosql$")
	public void i_edit_the_focus_to_have_nosql() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I verify the focus has nosql$")
	public void i_verify_the_focus_has_nosql() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
	
	public void pushButtonFromNavBar(WebDriver browser, String buttonName)
	{
		
		System.out.println("Now testing the " + buttonName + " button.");
		

		// Kills some time while the JS finishes making the buttons interactable:
		wait.until(ExpectedConditions.elementToBeClickable(By.name(buttonName)));
		
		//get the button
		WebElement Zhalfir = browser.findElement(By.name(buttonName));
		System.out.println("About to push the " + buttonName + " button...");
		
		// Click the button to be tested:
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
