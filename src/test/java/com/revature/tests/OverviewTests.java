package com.revature.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.revature.util.TestingMethods;

public class OverviewTests {

	
	//Get a WebDriver object for use in the tests:
	WebDriver browser;
	WebElement tableElement;
	List<WebElement> trList;
		
	@BeforeClass
	public void setUp() {
		browser = TestingMethods.getDriver();
		//Perform the login actions:
		TestingMethods.trainerLogin(browser);
		//make sure we are on overview tab
		TestingMethods.pushButtonFromNavBar(browser, "overview");
		
		
		tableElement = browser.findElement(By.tagName("table"));
        trList = tableElement.findElements(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
	}
	
	
	@Test(priority=1)
	public void testOverviewSortByNameAsc() {
		/*
		 * Need to get and click on the arrow icon tag <md-icon> that sorts by name
		 * This tag is inside of the th tag that has an attribute of md-order-by which has a unique value
		 * <th md-order-by="name"><md-icon></md-icon></th>
		 */
		// get the tag
		//List<WebElement> thTags = new ArrayList<WebElement>();
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[1]"));
		
		tag.click();
		
		
        int rowNum = 1; 
        int colNum = 0;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS = " + tdList.size());
            
            if (tdList.size() <= 1) {
            	continue;
            }
            
            System.out.println("row # "+rowNum+", col # "+colNum+ "text="+tdList.get(colNum).getText());
            if (!(tdList.get(colNum).getText().isEmpty())) {
            	names.add(tdList.get(colNum).getText());
            }
            rowNum++;
        } 
        
		if (tag.findElement(By.tagName("md-icon").className("md-asc")) != null) {
			System.out.println("ascending");
			List<String> sortedNames = names;
			Collections.sort(sortedNames);
			Assert.assertEquals(names, sortedNames);
			
		}
		
	}	
	
	@Test(priority=2)
	public void testOverviewSortByNameDesc() {
		
		
		/*
		 * Need to get and click on the arrow icon tag <md-icon> that sorts by name
		 * This tag is inside of the th tag that has an attribute of md-order-by which has a unique value
		 * <th md-order-by="name"><md-icon></md-icon></th>
		 */
		// get the tag
		//List<WebElement> thTags = new ArrayList<WebElement>();
		//thTags = browser.findElements(By.tagName("th"));
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[1]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 0;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS = " + tdList.size());
            
            if (tdList.size() <= 1) {
            	continue;
            }
            
            System.out.println("row # "+rowNum+", col # "+colNum+ "text="+tdList.get(colNum).getText());
            if (!(tdList.get(colNum).getText().isEmpty())) {
            	names.add(tdList.get(colNum).getText());
            }
            rowNum++;
        }
        
        if (tag.findElement(By.tagName("md-icon").className("md-desc")) != null) {
			System.out.println("descending");
			List<String> sortedNames = names;
			Collections.sort(sortedNames);
			Collections.reverse(sortedNames);
			Assert.assertEquals(names, sortedNames);
		
		}
	}	
	@Test(priority=3)
	public void testOverviewSortByCurriculumAsc() {
		/*
		 * Need to get and click on the arrow icon tag <md-icon> that sorts by name
		 * This tag is inside of the th tag that has an attribute of md-order-by which has a unique value
		 * <th md-order-by="name"><md-icon></md-icon></th>
		 */
		// get the tag
		//List<WebElement> thTags = new ArrayList<WebElement>();
		//thTags = browser.findElements(By.tagName("th"));
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[2]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS = " + tdList.size());
            
            if (tdList.size() <= 1) {
            	continue;
            }
            
            if (!(tdList.get(colNum).getText().isEmpty())) {
            	names.add(tdList.get(colNum).getText());
            }
            rowNum++;
        }
        
        if (tag.findElement(By.tagName("md-icon").className("md-asc")) != null) {
			System.out.println("ascending");
			List<String> sortedNames = names;
			Collections.sort(sortedNames);
			Assert.assertEquals(names, sortedNames);
		
		}
	}
	
	@Test(priority=4)
	public void testOverviewSortByCurriculumDesc() {
		/*
		 * Need to get and click on the arrow icon tag <md-icon> that sorts by name
		 * This tag is inside of the th tag that has an attribute of md-order-by which has a unique value
		 * <th md-order-by="name"><md-icon></md-icon></th>
		 */
		// get the tag
		//List<WebElement> thTags = new ArrayList<WebElement>();
		//thTags = browser.findElements(By.tagName("th"));
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[2]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            System.out.println("NUMBER OF COLUMNS = " + tdList.size());
            
            if (tdList.size() <= 1) {
            	continue;
            }
            
            if (!(tdList.get(colNum).getText().isEmpty())) {
            	names.add(tdList.get(colNum).getText());
            }
            rowNum++;
        }
        
        if (tag.findElement(By.tagName("md-icon").className("md-desc")) != null) {
			System.out.println("descending");
			List<String> sortedNames = names;
			Collections.sort(sortedNames);
			Collections.reverse(sortedNames);
			Assert.assertEquals(names, sortedNames);
		
		}
	}
	
	
	@AfterClass
	public void closeBrowser() {
		//close chromedriver and chrome window
		browser.quit();
	}
}
