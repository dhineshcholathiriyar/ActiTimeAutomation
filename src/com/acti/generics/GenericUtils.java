package com.acti.generics;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericUtils
{
	public static void getScreenShot(WebDriver driver,String name)
	{
		try
		{
			TakesScreenshot screenshot = (TakesScreenshot)driver;
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./screenshots/"+name+".png"));
		}
		catch(Exception e)
		{
			
		}
		
	}
		
	
}
