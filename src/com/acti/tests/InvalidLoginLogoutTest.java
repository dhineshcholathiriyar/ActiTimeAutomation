package com.acti.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.acti.generics.BaseTest;
import com.acti.generics.ExcelData;
import com.acti.pages.LoginPage;
@Ignore
public class InvalidLoginLogoutTest extends BaseTest
{
	@Test(priority=3)
	public  void testVerifyCustomerCreate() throws InterruptedException 
	{
		//Open the browser and enter the URL from BaseTest class
		
		LoginPage lp = new LoginPage(driver);
		String eLoginTitle=ExcelData.getData(file_Path,"InvalidLoginLogout",1,3);
		int rowCount=ExcelData.getRowCount(file_Path, "InvalidLoginLogout");
		String eErrorMessage = ExcelData.getData(file_Path, "InvalidLoginLogout",1,4);
		
		//verify the title
		
		lp.verifyTheTitle(eLoginTitle);
		
		
		for(int i=1;i<=rowCount;i++)
		{
			String username=ExcelData.getData(file_Path, "InvalidLoginLogout",i,1);
			String password=ExcelData.getData(file_Path,"InvalidLoginLogout",i,2);	
			
			//enter userName
			lp.enterUserName(username);
			
			//enter passWord
			lp.enterPassword(password);
			
			//click on login
			lp.clickLogin();
			Thread.sleep(2000);
			
			//verify ErrorMessage
			String aErrorMessage = lp.verifyErrorMessage(eErrorMessage);
			Assert.assertEquals(aErrorMessage,eErrorMessage);
		}
		
		
	}
}
