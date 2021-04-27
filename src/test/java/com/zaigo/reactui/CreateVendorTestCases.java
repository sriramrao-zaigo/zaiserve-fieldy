package com.zaigo.reactui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CreateVendorPageObjects;
import com.zaigo.pageobjects.LoginPageObjects;
import com.zaigo.utility.BrowserSetup;


public class CreateVendorTestCases {
	
	private WebDriver driver = null;
	private LoginPageObjects loginInPage = null;

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
		
		 LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
	     loginInPage.setUserCredentials("sriram@zaigoinfotech.com", "Zaiserve@123");
		 loginInPage.clickLoginButton();
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 String text = vendorPage.dashBoardUserMenuText();
		 Assert.assertEquals(text, "User");
		    
	    
	}
	
	/*
	
	@Test
	(priority=2)
	public void verifyVendorTab() 
	{
		//Verify the Vendor Tab
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 String text = vendorPage.dashBoardVendorMenuText();
		 Assert.assertEquals(text, "Vendor");
		    
	    
	}
	
	
	@Test
	(priority=3)
	public void verifyCreateButton() throws InterruptedException 
	{
		//Verify the CreateButton and Enter the Name
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("Vendor Name");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
	    
	}
	
	
	@Test
	(priority=4)
	public void verifyEmptyName() throws InterruptedException 
	{
		//Verify the Error Message if the Name field is Null
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorNameError();
		 Assert.assertEquals(text, "This field is required");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
		 
	    
	}
	
	@Test
	(priority=5)
	public void verifyEmptyEmail() throws InterruptedException 
	{
		//Verify the Error Message if the email field is Null
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorEmailError();
		 Assert.assertEquals(text, "This field is required");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=6)
	public void verifyEmptyContactPerson() 
	{
		//Verify the Error Message if the email field is Null
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorContactNameError();
		 Assert.assertEquals(text, "This field is required");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	@Test
	(priority=7)
	public void verifyNameEmptySpaces() 
	{
		//Verify the blankspace not allowed error message
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("   ");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorNameError();
		 Assert.assertEquals(text, "Blank space not allowed");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	@Test
	(priority=8)
	public void verifyEmailEmptySpaces() 
	{
		//Verify Email Empty spaces
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorEmail("    ");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorEmailError();
		 Assert.assertEquals(text, "Enter a valid email address");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	@Test
	(priority=9)
	public void verifyCnameEmptySpaces() 
	{
		//Verify Contact Person Empty spaces
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorContactPerson("       ");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorContactNameError();
		 Assert.assertEquals(text,"Blank space not allowed");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	@Test
	(priority=10)
	public void verifyWebsiteFormat() 
	{
		//Verify Contact Person Empty spaces
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorWebsite("hello");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorWebsiteError();
		 Assert.assertEquals(text,"Enter a valid website URL");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	
	
	@Test
	(priority=11)
	public void verifyPhoneFormat() 
	{
		//Verify Phone Field Accepts Only the Number field.
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorPhone("abcdefghijks");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=12)
	public void verifyVendor() 
	{
		//Verify Phone Field Accepts Only the Number field.
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	
	
	*/
	
	@Test
	(priority=12)
	public void verifyEnterProducts() throws InterruptedException 
	{
		//valid case 
		//have this last
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 vendorPage.clickNextButton();
		 vendorPage.vendorProductandServices("hello");
		 vendorPage.vendorclickEnter(Keys.ENTER);
	     vendorPage.clickSaveandComplete();
	     
	     //Add Success alert
	     
	     /*
	     String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
	     */
		 
	}
	
	
	@Test
	(priority=13)
	public void verifyLineOneMaxCharacters() throws InterruptedException 
	{
		//check the Line One has Max characters validation
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 vendorPage.clickAddLocation();
		 
	     vendorPage.clickSaveandComplete();
	     
	     //Add Success alert
	     
	     /*
	     String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
	     */
		 
	}
	
	
	@Test
	(priority=14)
	public void verifyLineTwoMaxCharacters() throws InterruptedException 
	{
		//check the Line Two has Max characters validation
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 vendorPage.clickNextButton();
		 vendorPage.vendorProductandServices("hello");
		 vendorPage.vendorclickEnter(Keys.ENTER);
	     vendorPage.clickSaveandComplete();
	     
	     //Add Success alert
	     
	     /*
	     String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
	     */
		 
	}
	
	
	
	@Test
	(priority=15)
	public void verifyCityMaxCharacters() throws InterruptedException 
	{
		//check City with Max character validations
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 vendorPage.clickNextButton();
		 vendorPage.vendorProductandServices("hello");
		 vendorPage.vendorclickEnter(Keys.ENTER);
	     vendorPage.clickSaveandComplete();
	     
	     //Add Success alert
	     
	     /*
	     String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
	     */
		 
	}
	
	
	@Test
	(priority=16)
	public void verifyContactPersonMaxCharacters() throws InterruptedException 
	{
		//check contact person have max character validation
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 vendorPage.clickNextButton();
		 vendorPage.vendorProductandServices("hello");
		 vendorPage.vendorclickEnter(Keys.ENTER);
	     vendorPage.clickSaveandComplete();
	     
	     //Add Success alert
	     
	     /*
	     String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
	     */
		 
	}
	
	@Test
	(priority=17)
	public void verifyAlphabetsinZipcode() throws InterruptedException 
	{
		//check zipcode accepts the alphabets
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 vendorPage.clickNextButton();
		 vendorPage.vendorProductandServices("hello");
		 vendorPage.vendorclickEnter(Keys.ENTER);
	     vendorPage.clickSaveandComplete();
	     
	     //Add Success alert
	     
	     /*
	     String text =vendorPage.vendorPhoneError();
		 Assert.assertEquals(text,"Only numbers allowed");
	     */
		 
	}
	
	
	
	
	
	
	
	
	
	

}
