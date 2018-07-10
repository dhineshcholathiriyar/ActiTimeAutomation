package com.acti.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.acti.generics.BaseTest;
import com.acti.generics.ExcelData;
import com.acti.pages.LoginPage;
@Ignore
public class VerifyVersionTest extends BaseTest
{
	@Test(priority=1)
	public  void testVerifyCustomerCreate() 
	{
		//Open the browser and enter the URL from BaseTest class
		
		LoginPage lp = new LoginPage(driver);
		String eLoginTitle=ExcelData.getData(file_Path,"VersionValidation",1,2);
		String eVersion = ExcelData.getData(file_Path,"VersionValidation",1,1);
		
		//verify the title
		
		lp.verifyTheTitle(eLoginTitle);
		
		//verify the Version
		String aVersion = lp.verifyTheVersion(eVersion);
		SoftAssert sa =new SoftAssert();
		sa.assertEquals(aVersion,eVersion);
		sa.assertAll();
	}
	
}
