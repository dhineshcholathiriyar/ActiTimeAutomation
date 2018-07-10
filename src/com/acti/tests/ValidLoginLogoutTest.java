package com.acti.tests;

import org.testng.annotations.Test;

import com.acti.generics.BaseTest;
import com.acti.generics.ExcelData;
import com.acti.pages.EnterTimeTrackPage;
import com.acti.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority=2)
	public  void testVerifyCustomerCreate() throws InterruptedException
	{
		//Open the browser and enter the URL from BaseTest class
		
		LoginPage lp = new LoginPage(driver);
		String eLoginTitle=ExcelData.getData(file_Path,"ValidLoginLogout",1,3);
		String username=ExcelData.getData(file_Path, "ValidLoginLogout",1,1);
		String password=ExcelData.getData(file_Path,"ValidLoginLogout",1,2);
		String eEnterTimeTrackTitle=ExcelData.getData(file_Path,"ValidLoginLogout",1,4);
		
				//verify the title
		
				lp.verifyTheTitle(eLoginTitle);
				
				//enter username
				
				lp.enterUserName(username);
				
				//enterPassword
				
				lp.enterPassword(password);
				
				//click on login
				lp.clickLogin();
				Thread.sleep(4000);	
				
				EnterTimeTrackPage tt = new EnterTimeTrackPage(driver);
				
				//verify Enter TimeTrack page 
				tt.verifyTheTitle(eEnterTimeTrackTitle);
				
				//click on Logout
				tt.clickOnLogout();
				
				//verify loginTitle
				lp.verifyTheTitle(eLoginTitle);
				
	}
}

