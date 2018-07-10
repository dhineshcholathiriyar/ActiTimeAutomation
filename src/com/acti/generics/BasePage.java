package com.acti.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage
{
	public WebDriver driver;
	public BasePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void verifyTitle(String eTitle)
	{
		try 
		{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Title is Matching "+eTitle,true);	
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching "+eTitle,true);
			Reporter.log("Actual title is "+driver.getTitle(),true);
			Assert.fail();
		}
		
	}
	public void verifyElement(WebElement element)
	{
		try 
		{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Element is present"+element.getText(),true);	
		}
		catch(Exception e)
		{
			Reporter.log("Element is not present"+element.getText(),true);
			Assert.fail();
		}
		
	}
	
	
	
}
