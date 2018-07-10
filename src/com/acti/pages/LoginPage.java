package com.acti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.acti.generics.BasePage;

public class LoginPage extends BasePage
{
	//declaration
	
	@FindBy(id="username")
	private WebElement userNameTB;
	
	@FindBy(name="pwd")
	private WebElement passwordTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//nobr[contains(.,'actiTIME 2017')]")
	private WebElement aversionName;
	
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement aErrorMessage;
	
	
	
	//Initialization
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	// Utilization
	
	public void enterUserName(String un)
	{
		userNameTB.sendKeys(un);
	}
	
	public void enterPassword(String pswd)
	{
		passwordTB.sendKeys(pswd);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void verifyTheTitle(String eTitle1)
	{
		verifyTitle(eTitle1);
	}
	
	public String verifyTheVersion(String eVersion)
	{
		verifyElement(aversionName);
		String aVersion = aversionName.getText();
		Reporter.log("Expected version is "+eVersion,true);
		Reporter.log("Actual version is "+aVersion,true);
		return aVersion;
	}
	
	public String verifyErrorMessage(String eErrorMessage)
	{
		verifyElement(aErrorMessage);
		String aErrorMessageText = aErrorMessage.getText();
		Reporter.log("Expected Error message is "+eErrorMessage,true);
		Reporter.log("Actual error message is "+aErrorMessageText,true);
		return aErrorMessageText;		
	}
	
}
