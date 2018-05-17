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
		//TestingMethods.pushButtonFromNavBar(browser, "overview");
		
		// list element and list for rows of table
		tableElement = browser.findElement(By.tagName("table"));
        trList = tableElement.findElements(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/tbody/tr"));
	}
	
	
	/*
	 * Check sorting by batch name, ascending.
	 */
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
	
	/*
	 * Check sorting by batch name, descending.
	 */
	@Test(priority=2)
	public void testOverviewSortByNameDesc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[1]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 0;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	/*
	 * Check sorting by Curriculum ascending.
	 */
	@Test(priority=3)
	public void testOverviewSortByCurriculumAsc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[2]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	/*
	 * Check sorting by Curriculum, descending.
	 */
	@Test(priority=4)
	public void testOverviewSortByCurriculumDesc() {
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[2]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	
	@Test(priority=5)
	public void testOverviewSortByTrainerAsc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[3]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=6)
	public void testOverviewSortByTrainerDesc() {
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[3]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=7)
	public void testOverviewSortByLocationAsc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[4]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=8)
	public void testOverviewSortByLocationDesc() {
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[4]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=9)
	public void testOverviewSortByBuildingAsc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[5]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=10)
	public void testOverviewSortByBuildingDesc() {
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[5]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=11)
	public void testOverviewSortByRoomAsc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[6]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=12)
	public void testOverviewSortByRoomDesc() {
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[6]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=13)
	public void testOverviewSortByStartDateAsc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[7]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=14)
	public void testOverviewSortByStartDateDesc() {
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[7]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=15)
	public void testOverviewSortByEndDateAsc() {
		
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[8]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
        	
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@Test(priority=16)
	public void testOverviewSortByEndDateDesc() {
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/div/md-card/md-content/md-table-container/table/thead/tr/th[8]"));
		
		tag.click();
		
        int rowNum = 1; 
        int colNum = 1;
        
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));
            
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
	
	@AfterClass
	public void closeBrowser() {
		//close chromedriver and chrome window
		browser.quit();
	}
}
