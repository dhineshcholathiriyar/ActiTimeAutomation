package com.acti.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.acti.generics.BaseTest;
import com.acti.generics.ExcelData;
import com.acti.pages.EnterTimeTrackPage;
import com.acti.pages.LoginPage;
@Ignore
public class BuildVerificationTest extends BaseTest
{
	@Test(priority=4)
	public  void testVerifyCustomerCreate() throws InterruptedException
	{
		//Open the browser and enter the URL from BaseTest class
		
		LoginPage lp = new LoginPage(driver);
		String eLoginTitle=ExcelData.getData(file_Path,"BuildValidation",1,4);
		String username=ExcelData.getData(file_Path, "BuildValidation",1,1);
		String password=ExcelData.getData(file_Path,"BuildValidation",1,2);
		String eEnterTimeTrackTitle=ExcelData.getData(file_Path,"BuildValidation",1,5);
		String eBuildNo = ExcelData.getData(file_Path,"BuildValidation",1,3);
		
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
				
				//click on help
				tt.clickOnHelp();
				
				//click on AboutYourActitime
				tt.clickOnAboutYourActitime();
				
				//verify build no
				String aBuildNo = tt.verifyBuildNo(eBuildNo);
				SoftAssert sa=new SoftAssert();
				sa.assertEquals(aBuildNo, eBuildNo);
				
				//popup close
				tt.popupClose();
				
				//click on logout
				tt.clickOnLogout();
				
				
				//verify login page
				lp.verifyTheTitle(eLoginTitle);
				sa.assertAll();
	}
}
