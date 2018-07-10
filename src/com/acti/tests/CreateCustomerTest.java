package com.acti.tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.acti.generics.BaseTest;
import com.acti.generics.ExcelData;
import com.acti.pages.EnterTimeTrackPage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskListPage;
@Ignore
public class CreateCustomerTest extends BaseTest
{

	@Test(priority=5)
	public  void testVerifyCustomerCreate() throws InterruptedException
	{
		//Open the browser and enter the URL from BaseTest class
		
		LoginPage lp = new LoginPage(driver);
		String eLoginTitle=ExcelData.getData(file_Path,"CustomerCreation",1,5);
		String username=ExcelData.getData(file_Path, "CustomerCreation",1,1);
		String password=ExcelData.getData(file_Path,"CustomerCreation",1,2);
		String eEnterTimeTrackTitle=ExcelData.getData(file_Path,"CustomerCreation",1,6);
		String eTaskListTitle = ExcelData.getData(file_Path,"CustomerCreation",1,7);
		String eCustomerName=ExcelData.getData(file_Path, "CustomerCreation", 1, 3);
		String eCustomerDescription=ExcelData.getData(file_Path,"CustomerCreation",1,4);
	
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
		
		//click on TaskTab
		tt.clickTaskTab();
		
		//Verify TaskListPage 
		TaskListPage tl = new TaskListPage(driver);
		tl.verifyTheTitle(eTaskListTitle);
		
		//Click addNewUserBtn
		tl.clickAddNewBtn();
		
		//Click newCustomerBtn
		tl.clickNewCustomerBtn();
		
		//enter Customer name
		tl.enterCustomerName(eCustomerName);
		
		//enter Customer Description
		tl.enterCustomerDescription(eCustomerDescription);
		
		//click createCustomerButton
		tl.clickCreateCustomerBtn();
		Thread.sleep(4000);
		
		//verify the customer is created
		String aCustomername = tl.verifyTheCreatedCustomer(eCustomerName);
		Assert.assertEquals(aCustomername, eCustomerName);
	}
	
}
