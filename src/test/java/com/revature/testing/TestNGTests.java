//John Eifert
package com.revature.testing;

//import java.io.File;
import org.testng.Assert;
import org.testng.annotations.*;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;



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
			//Overview button:
		TestingMethods.pushButtonFromNavBar(browser, "batches");
		expectedURL = "https://dev.assignforce.revaturelabs.com/batches";
		actualURL = browser.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertEquals(actualURL, expectedURL);
		browser.navigate().back();
		
		/*
		By
		
		
		<li class="md-nav-item ng-scope ng-isolate-scope layout-align-end-end" role="option" aria-selected="false" md-nav-href="batches" name="batches" layout-align="end end">
		<!-- ngIf: ctrl.mdNavSref -->
		<!-- ngIf: ctrl.mdNavHref -->
		<a class="_md-nav-button md-accent md-button ng-scope md-ink-ripple md-unselected" ng-transclude="" ng-if="ctrl.mdNavHref" ng-class="ctrl.getNgClassMap()" tabindex="-1" ng-href="batches" href="batches">
		<span ng-transclude="" class="_md-nav-button-text ng-scope">
		<span class="ng-scope">
		Batches   
				</span>
		</span>
		<div class="md-ripple-container" style="">
		</div>
		</a>
		<!-- end ngIf: ctrl.mdNavHref -->
		<!-- ngIf: ctrl.mdNavClick -->
		</li>
		
		/*
			//Batches button:
		TestingMethods.pushButton(browser, "batches");
		expectedURL = "https://dev.assignforce.revaturelabs.com/batches";
		actualURL = browser.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		browser.navigate().back();
			//
			 */
		
		
		
		browser.close();
	}
	
	
	
}
