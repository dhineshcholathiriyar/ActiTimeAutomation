package com.acti.generics;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConstant
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_Key, chrome_Value);
		System.setProperty(gecko_Key, gecko_value);
	}
	
	@Parameters({"url","browser"})
	@BeforeMethod
	public void preCondition(String urll,String brwsrname) throws MalformedURLException
	{
		URL url = new URL(urll);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(brwsrname);
		driver=new RemoteWebDriver(url,dc);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
	/*	driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(urll);*/
	}
	
	@AfterMethod
	public void postCondition(ITestResult res)
	{
		int status = res.getStatus();
		if(status==2)
		{
			String name = res.getMethod().getMethodName();
			GenericUtils.getScreenShot(driver, name);
		}
		driver.close();
		
	}
	
	
}
