package com.acti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.acti.generics.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	@FindBy(xpath="//a[@href='/tasks/tasklist.do']")
	private WebElement tasksTab;
	
	@FindBy(id="logoutLink")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//div[@class='popup_menu_icon support_icon']")
	private WebElement helpBtn;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement aboutYourActitimeBtn;
	
	@FindBy(xpath="//span[.='(build 40065)']")
	private WebElement aBuildNo;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement popupCloseBtn;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}

	public void clickTaskTab()
	{
		tasksTab.click();
	}
	
	public void verifyTheTitle(String eTitle1)
	{
		verifyTitle(eTitle1);
	}
	
	public void clickOnLogout()
	{
		logoutBtn.click();
	}
	
	public void clickOnHelp() 
	{
		helpBtn.click();	
	}
	
	public void clickOnAboutYourActitime()
	{
		aboutYourActitimeBtn.click();
	}
	
	public String verifyBuildNo(String eBuildNo)
	{
		verifyElement(aBuildNo);
		String aBuildNoText=aBuildNo.getText();
		Reporter.log("Expected Build No is "+eBuildNo,true);
		Reporter.log("Actual Build No is "+aBuildNoText,true);
		return aBuildNoText;
	}
	
	public void popupClose()
	{
		popupCloseBtn.click();
	}
	
}
