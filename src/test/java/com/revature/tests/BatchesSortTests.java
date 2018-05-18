package com.revature.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BatchesSortTests 
{
	public static boolean ascSort(WebDriver browser, WebElement tag, int colNum)
	{
		WebElement tableElement;
		List<WebElement> trList;
		tableElement = browser.findElement(By.tagName("table"));
		trList = tableElement.findElements(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/tbody/tr"));
		
		int rowNum = 1; 
		
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) 
        {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));

            if(tdList.size() <= 1) 
            {
            	continue;
            }
            
           if(!(tdList.get(colNum).getText().isEmpty()))
           {
        	   names.add(tdList.get(colNum).getText());
           }
            rowNum++;
        } 
        
		if(tag.findElement(By.tagName("md-icon").className("md-asc")) != null) 
		{
			return(OverviewTests.ascSortCheck(names));
		}
		return false;
	}
	
	
	public static boolean descSort(WebDriver browser, WebElement tag, int colNum)
	{
		WebElement tableElement;
		List<WebElement> trList;
		tableElement = browser.findElement(By.tagName("table"));
		trList = tableElement.findElements(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/tbody/tr"));
		
		int rowNum = 1; 
		
        List<String> names = new ArrayList<>();
        
        for(WebElement trElement : trList) 
        {
            List<WebElement> tdList= trElement.findElements(By.xpath("td"));

            if(tdList.size() <= 1) 
            {
            	continue;
            }
            
           if(!(tdList.get(colNum).getText().isEmpty()))
           {
        	   names.add(tdList.get(colNum).getText());
           }
            rowNum++;
        } 
        
		if(tag.findElement(By.tagName("md-icon").className("md-asc")) != null) 
		{
			return(OverviewTests.descSortCheck(names));
		}
		return false;
	}
	
	public static boolean BatchesSortbyNameAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[2]"));
		tag.click();
		return ascSort(browser, tag, 1);
	}
	
	public static boolean BatchesSortbyNameDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[2]"));
		tag.click();
		return descSort(browser, tag, 1);
	}
	
	public static boolean BatchesSortbyCurriculumAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[3]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyCurriculumDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[3]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyFocusAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[4]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyFocusDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[4]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyTrainerAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[5]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyTrainerDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[5]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyLocationAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[6]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyLocationDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[6]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyBuildingAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[7]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyBuildingDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[7]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyRoomAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[8]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyRoomDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[8]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyStartDateAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[9]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyStartDateDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[9]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyEndDateAsc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[10]"));
		tag.click();
		return ascSort(browser, tag, 2);
	}
	
	public static boolean BatchesSortbyEndDateDesc(WebDriver browser)
	{
		WebElement tag = browser.findElement(By.xpath("//*[@id=\"view\"]/md-card/md-content/div/md-table-container/table/thead/tr/th[10]"));
		tag.click();
		return descSort(browser, tag, 2);
	}
}
