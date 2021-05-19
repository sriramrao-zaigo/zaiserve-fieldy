package com.zaigo.reactui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CreateContractorPage;
import com.zaigo.pageobjects.CreateVendorPage;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

public class CreateContractorTestCases {
	
	
	
	
	
	private WebDriver driver = null;
	private LoginPage loginInPage = null;

	@BeforeClass
	public void setup() {
		this.driver = BrowserSetup.startBrowser();
	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
	}
	
	@AfterMethod
	public void setVariableEmpty() {
		loginInPage = null;
	}
	
	
	
	@Test
	(priority=1)
	public void verifyUserTab() 
	{
		//Verify the User Tab
		
		 LoginPage loginInPage = new LoginPage(this.driver);
	     loginInPage.setUserCredentials("sriram@zaigoinfotech.com", "Zaiserve@123");
		 loginInPage.clickLoginButton();
		// CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		// String text = contractorPage.dashBoardUserMenuText();
		 //Assert.assertEquals(text, "User");
	    
	}

	
	
	@Test
	(priority=2)
	public void verifyContractorab() 
	{
		//Verify the Vendor Tab
		
		 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		 contractorPage.dashBoardUserMenu();
		 String text = contractorPage.dashBoardVendorMenuText();
		 Assert.assertEquals(text, "Contractor");
		    
	    
	}
	
	@Test
	(priority=3)
	public void verifyCreateButton() throws InterruptedException 
	{
		//Verify the CreateButton and Enter the Name
		
		 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		 contractorPage.dashBoardUserMenu();
		 contractorPage.clickVendorTab();
		 contractorPage.contractorCreateButton();
		 contractorPage.contractorName("contractor Name");
		 contractorPage.clickCloseButton();
		 contractorPage.clickYesButton();
	    
	}
	
	
	@Test
	(priority=4)
	public void verifyEmptyName() throws InterruptedException 
	{
		//Verify the Error Message if the Name field is Null
		
		 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		 contractorPage.dashBoardUserMenu();
		 contractorPage.clickVendorTab();
		 contractorPage.contractorCreateButton();
		 contractorPage.clickNextButton();
		 String text =contractorPage.contractorNameError();
		 Assert.assertEquals(text, "This field is required");
		 contractorPage.clickCloseButton();
		 contractorPage.clickYesButton();
		 
		 
	    
	}
	
	@Test
	(priority=5)
	public void verifyEmptyEmail() throws InterruptedException 
	{
		//Verify the Error Message if the email field is Null
		
		 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		 contractorPage.dashBoardUserMenu();
		 contractorPage.clickVendorTab();
		 contractorPage.contractorCreateButton();
		 contractorPage.clickNextButton();
		 String text =contractorPage.contractorEmailError();
		 Assert.assertEquals(text, "This field is required");
		 contractorPage.clickCloseButton();
		 contractorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=6)
	public void verifyEmptyContactPerson() 
	{
		//Verify the Error Message if the email field is Null
		
		 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		 contractorPage.dashBoardUserMenu();
		 contractorPage.clickVendorTab();
		 contractorPage.contractorCreateButton();
		 contractorPage.clickNextButton();
		 String text =contractorPage.contractorContactNameError();
		 Assert.assertEquals(text, "This field is required");
		 contractorPage.clickCloseButton();
		 contractorPage.clickYesButton();
		 
	    
	}
	
	@Test
	(priority=7)
	public void verifyNameEmptySpaces() 
	{
		//Verify the blankspace not allowed error message
		
		 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		 contractorPage.dashBoardUserMenu();
		 contractorPage.clickVendorTab();
		 contractorPage.contractorCreateButton();
		 contractorPage.contractorName("   ");
		 contractorPage.clickNextButton();
		 String text =contractorPage.contractorNameError();
		 Assert.assertEquals(text, "Blank space not allowed");
		 contractorPage.clickCloseButton();
		 contractorPage.clickYesButton();
		 
	    
	}
	
	@Test
	(priority=8)
	public void verifyEmailEmptySpaces() 
	{
		//Verify Email Empty spaces
		
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorEmail("    ");
		contractorPage.clickNextButton();
		String text =contractorPage.contractorEmailError();
		Assert.assertEquals(text, "This field is required");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=9)
	public void verifyEmailFormat() 
	{
		//Verify Format
		
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorEmail("asdffg");
		contractorPage.clickNextButton();
		String text =contractorPage.contractorEmailError();
		Assert.assertEquals(text, "Enter a valid email address");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=10)
	public void verifyCnameEmptySpaces() 
	{
		//Verify Contact Person Empty spaces
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorContactPerson("       ");
		contractorPage.clickNextButton();
		String text =contractorPage.contractorContactNameError();
		Assert.assertEquals(text,"Blank space not allowed");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	@Test
	(priority=11)
	public void verifyWebsiteFormat() 
	{
		//Verify Contact Person Empty spaces
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorWebsite("hello");
		contractorPage.clickNextButton();
		String text =contractorPage.contractorWebsiteError();
		Assert.assertEquals(text,"Enter a valid website URL");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	
	
	@Test
	(priority=12)
	public void verifyPhoneFormat() 
	{
		//Verify Phone Field Accepts Only the Number field.
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorPhone("abcdefghijks");
		contractorPage.clickNextButton();
		String text = contractorPage.contractorPhoneError();
		Assert.assertEquals(text,"Input should contains 10 digits");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	
	
}

	
	
	
	
	
	
	
