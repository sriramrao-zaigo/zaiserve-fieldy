package com.zaigo.reactui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void verifyContractorTab() throws InterruptedException 
	{
		//Verify  User Tab
		
		 LoginPage loginInPage = new LoginPage(this.driver);
	     loginInPage.setUserCredentials("alpha@zaisuite.com", "Zaiserve@123");
		 loginInPage.clickLoginButton();
		 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		 contractorPage.clickTeam();
	     Thread.sleep(5000);
		 contractorPage.clickTeam();
		 contractorPage.clickCompany();
		 contractorPage.clickContractor();
		 contractorPage.createContractorButtonj();
		 
		 
	    
	}
	
	@Test
	(priority=2)
	public void verifyName() throws InterruptedException
	{
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);

		contractorPage.contractorName("vanguard pvt ltd");

		contractorPage.clickSaveandComplete();
		
		Thread.sleep(6000);
		
		
		
	}
	
	
	

	
	/*
	
	@Test
	(priority=21)
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
		contractorPage.contractorPhone("123");
		contractorPage.clickNextButton();
		String text = contractorPage.contractorPhoneError();
		Assert.assertEquals(text,"Input should contains 10 digits");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	@Test
	(priority=13)
	public void verifyMaxPhone() 
	{
		//Verify Phone Field accepts 20 digits
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorPhone("99402115639940211563");
		contractorPage.clickNextButton();
		String text = contractorPage.contractorPhoneError();
		Assert.assertEquals(text,"Input should contains 10 digits");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	        @Test
		(priority=14)
		public void verifyMaxContactPerson() 
		{
			
			
			//Verify the max validation if Contact person Exceeds the Limit 50
			
			CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
			contractorPage.dashBoardUserMenu();
			contractorPage.clickVendorTab();
			contractorPage.contractorCreateButton();
			contractorPage.contractorContactPerson("ghgfhghgjgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjthgthjjjj");
			 String text =contractorPage.contractorContactNameError();
			 Assert.assertEquals(text, "Not allowed more than 50 characters");
			 contractorPage.clickCloseButton();
			 contractorPage.clickYesButton();
			 
		 }
	
	        @Test
		(priority=15)
		public void verifyMaxName() throws InterruptedException 
		{
			//Verify the max vendor name validation if Exceeds the Limit 50
			
			 CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
			 contractorPage.dashBoardUserMenu();
			 contractorPage.clickVendorTab();
			 contractorPage.contractorCreateButton();
			 contractorPage.contractorName("Lorem ipsum dolor sit amet, consectetuer adipiscinddede ddededdcdc ddcdc");
			 contractorPage.clickNextButton();
			 String text =contractorPage.contractorNameError();
			 Assert.assertEquals(text, "Not allowed more than 50 characters");
			 contractorPage.clickCloseButton();
			 contractorPage.clickYesButton();
			 
			 
		    
		}
	
	
	@Test
	(priority=16)
	public void verifyLineOneMaxCharacters() throws InterruptedException 
	{
		
		//check the Line One has Max characters validation
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorName("hello");
		contractorPage.contractorEmail("email@gmail.com");
		contractorPage.contractorContactPerson("cperson hello");
		contractorPage.clickNextButton();
		contractorPage.clickAddLocation();
		contractorPage.clickLocationOne();
		contractorPage.contractorLineOne("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		contractorPage.clickSaveandComplete();
	    String text =contractorPage.contractorLineOneError();
		Assert.assertEquals(text,"Not allowed more than 150 characters");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
	     
		 
	}
	
	
	@Test
	(priority=17)
	public void verifyLineTwoMaxCharacters() throws InterruptedException 
	{
		
		//check the Line Two has Max characters validation
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorName("hello");
		contractorPage.contractorEmail("email@gmail.com");
		contractorPage.contractorContactPerson("cperson hello");
		contractorPage.clickNextButton();
		contractorPage.clickAddLocation();
		contractorPage.clickLocationOne();
		contractorPage.contractorLineTwo("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		contractorPage.clickSaveandComplete();
	    String text =contractorPage.contractorLineTwoError();
		Assert.assertEquals(text,"Not allowed more than 150 characters");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
	}
	
	
	
	
	@Test
	(priority=18)
	public void verifyCityMaxCharacters() throws InterruptedException 
	{
		
		//check City with Max character validations
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorName("hello");
		contractorPage.contractorEmail("email@gmail.com");
		contractorPage.contractorContactPerson("cperson hello");
		contractorPage.clickNextButton();
		contractorPage.clickAddLocation();
		contractorPage.clickLocationOne();
		contractorPage.contractorCity("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		contractorPage.clickSaveandComplete();
	    String text =contractorPage.contractorCityError();
		Assert.assertEquals(text,"Not allowed more than 150 characters");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
	}
	
	
	
	
	
	
	
	
	@Test
	(priority=19)
	public void verifyMinZipcode() throws InterruptedException 
	{
		//
		//check zipcode accepts the 3 digits
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorName("hello");
		contractorPage.contractorEmail("email@gmail.com");
		contractorPage.contractorContactPerson("cperson hello");
		contractorPage.clickNextButton();
		contractorPage.clickAddLocation();
		contractorPage.clickLocationOne();
		contractorPage.contractorZipcode("123");
		contractorPage.clickSaveandComplete();
	        String text =contractorPage.contractorZipcodeError();
		Assert.assertEquals(text,"The field must be minimum 6");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	}
	
	
	
	@Test
	(priority=20)
	public void verifyWithValidDetails() throws InterruptedException 
	{
		//
		//check zipcode WITH 30 + CHARCAERS
		
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorName("hello");
		contractorPage.contractorEmail("email@gmail.com");
		contractorPage.contractorContactPerson("cperson hello");
		contractorPage.clickNextButton();
		contractorPage.clickAddLocation();
		contractorPage.clickLocationOne();
		contractorPage.contractorZipcode("123123456123123456123123456123123456123123456123123456");
	    String text =contractorPage.contractorZipcodeError1();
		Assert.assertEquals(text,"Not allowed more than 30 characters");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	}
	

	
	
	
	
	
	
	

 @Test
(priority=2)
   public void verifyContractorCreated() throws InterruptedException 
{
	//Contractor Created successfully
	
	CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
	contractorPage.dashBoardUserMenu();
	contractorPage.clickVendorTab();
	contractorPage.contractorCreateButton();
	contractorPage.contractorName("hello");
	contractorPage.contractorEmail("emailu781@gmail.com");
	contractorPage.contractorContactPerson("cperson hello");
	//contractorPage.uploadImage("C:\\Users\\lenovo\\Pictures\\picjpg.jpg");
	   contractorPage.clickSaveandComplete();
    String text =contractorPage.contractorSuccessMessage();
	Assert.assertEquals(text,"Company Created successfully");
	contractorPage.clickCloseButton();
	
}
	
	
	
	*/
	
}

	
	
	
	
	
	
	
