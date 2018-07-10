package com.acti.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.acti.generics.BasePage;

public class TaskListPage extends BasePage
{
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement NewCustomerBtn;

	@FindBy(id="customerLightBox_nameField")
	private WebElement customerNameTf;
	
	@FindBy(id="customerLightBox_descriptionField")
	private WebElement customerDescriptionTf;
	
	@FindBy(xpath="//span[.='Create Customer']")
	private WebElement createCustomerBtn;
	
	@FindBy(xpath="(//a[.='All Customers']/../..//div[@class='title ellipsis'])[1]")
	private WebElement customerNameText;
	
	
	
	public TaskListPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickAddNewBtn() 
	{
	addNewBtn.click();	
	}
	
	public void clickNewCustomerBtn()
	{
		NewCustomerBtn.click();
	}
	
	public void enterCustomerName(String name)
	{
		customerNameTf.sendKeys(name);
	}
	
	public void enterCustomerDescription(String Description)
	{
		customerDescriptionTf.sendKeys(Description);
	}

	public void clickCreateCustomerBtn()
	{
		createCustomerBtn.click();
	}
	public void verifyTheTitle(String eTitle)
	{
		verifyTitle(eTitle);
	}
	public String verifyTheCreatedCustomer(String eCustomerName)
	{
		verifyElement(customerNameText);
		String text = customerNameText.getText();
		Reporter.log("Expected customer name is "+eCustomerName,true);
		Reporter.log("Actual customer name is "+text,true);
		return text;
	}
	
	}

