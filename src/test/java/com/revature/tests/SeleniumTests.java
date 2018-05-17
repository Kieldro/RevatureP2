package com.revature.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.util.Driver;

public class SeleniumTests {
	private static final Driver driver = Driver.getInstance();;
	
	@BeforeClass
	public void setUp() {
		System.out.println("Starting SeleniumTests... " + SeleniumTests.class.getName());
		System.out.println("driver: " + driver);
	}

	@Test(groups = { "group1" })
	public void test1()
	{
		System.out.println("test1() " + "");
		driver.get("https://www.wikipedia.org");

		// Acquire the relevant input objects:
		WebElement searchInput = driver.findElement(By.id("searchInput"));
		WebElement submitButton = driver.findElement(By.className("pure-button-primary-progressive"));

		searchInput.sendKeys("Andromeda Galaxy");
		submitButton.click();
		
//		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Ending SeleniumTests... " + "");
		driver.quit();
	}
}
