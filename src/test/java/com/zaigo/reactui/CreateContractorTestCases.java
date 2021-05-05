package com.zaigo.reactui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CreateContractorPageObjects;
import com.zaigo.pageobjects.CreateVendorPageObjects;
import com.zaigo.pageobjects.LoginPageObjects;
import com.zaigo.utility.BrowserSetup;

public class CreateContractorTestCases {
	
	
	
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
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		 String text = contractorPage.dashBoardUserMenuText();
		 Assert.assertEquals(text, "User");
	    
	}

	
	
	@Test
	(priority=2)
	public void verifyContractorab() 
	{
		//Verify the Vendor Tab
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		 contractorPage.dashBoardUserMenu();
		 String text = contractorPage.dashBoardVendorMenuText();
		 Assert.assertEquals(text, "Contractor");
		    
	    
	}
	
	
	@Test
	(priority=3)
	public void verifyCreateButton() throws InterruptedException 
	{
		//Verify the CreateButton and Enter the Name
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorEmail("    ");
		contractorPage.clickNextButton();
		String text =contractorPage.contractorEmailError();
		Assert.assertEquals(text, "Enter a valid email address");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=9)
	public void verifyEmailFormat() 
	{
		//Verify Format
		
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
	
	
	@Test
	(priority=13)
	public void verifyMaxPhone() 
	{
		//Verify Phone Field accepts 20 digits
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorPhone("99402115639940211563");
		contractorPage.clickNextButton();
		String text = contractorPage.contractorPhoneError();
		Assert.assertEquals(text,"Max 10 characters allowed");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	
	
	
	
	
	
	@Test
	(priority=14)
	public void verifyMaxName() throws InterruptedException 
	{
		//Verify the max vendor name validation if Exceeds the Limit 50
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		 contractorPage.dashBoardUserMenu();
		 contractorPage.clickVendorTab();
		 contractorPage.contractorCreateButton();
		 contractorPage.contractorName("Lorem ipsum dolor sit amet, consectetuer adipiscin");
		 contractorPage.clickNextButton();
		 String text =contractorPage.contractorNameError();
		 Assert.assertEquals(text, "Name Should not have More than 50 characters");
		 contractorPage.clickCloseButton();
		 contractorPage.clickYesButton();
		 
		 
	    
	}
	
	
	
	@Test
	(priority=16)
	public void verifyMaxContactPerson() 
	{
		
		//
		//Verify the max validation if Contact person Exceeds the Limit 50
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
	(priority=27)
	public void verifyDuplicateEmail() throws InterruptedException 
	{
	
	//add this after creating the email
		//Verify if Email Already Exist
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorEmail("alreadyexist@zaigo.com");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorEmailError();
		 Assert.assertEquals(text, "Email Already Exist");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	
	
	@Test
	(priority=18)
	public void verifyLineOneMaxCharacters() throws InterruptedException 
	{
		//
		//check the Line One has Max characters validation
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
		Assert.assertEquals(text,"maxOneFifty");
	     
		 
	}
	
	
	@Test
	(priority=19)
	public void verifyLineTwoMaxCharacters() throws InterruptedException 
	{
		
		//check the Line Two has Max characters validation
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
	     
	}
	
	
	
	
	@Test
	(priority=20)
	public void verifyCityMaxCharacters() throws InterruptedException 
	{
		
		//check City with Max character validations
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
	     
	}
	
	
	
	
	
	
	
	
	@Test
	(priority=21)
	public void verifyMinZipcode() throws InterruptedException 
	{
		//
		//check zipcode accepts the 3 digits
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
	     
		 
	}
	
	
	
	@Test
	(priority=22)
	public void verifyWithValidDetails() throws InterruptedException 
	{
		//
		//check zipcode WITH 30 + CHARCAERS
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
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
	     
		 
	}
	

	
	
	@Test
	(priority=23)
	public void verifyWithvalidImage() throws InterruptedException 
	
	{
		
		//check with valid Image file
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.uploadImage("C:\\Users\\lenovo\\Pictures\\picjpg.jpg");
		try
		{
		String textd =contractorPage.vendorImageError();
		}catch (Exception e) {
			// TODO: handle exception
			String hello=e.getMessage();
			System.out.print("Pass");
		}
	
	   
	 
	     
	 }
	
	
	
	

 @Test
(priority=24)
   public void verifyContractorCreated() throws InterruptedException 
{
	//Contractor Created successfully
	
	CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
	contractorPage.dashBoardUserMenu();
	contractorPage.clickVendorTab();
	contractorPage.contractorCreateButton();
	contractorPage.contractorName("hello");
	contractorPage.contractorEmail("emailu1@gmail.com");
	contractorPage.contractorContactPerson("cperson hello");
	contractorPage.uploadImage("C:\\Users\\lenovo\\Pictures\\picjpg.jpg");
	contractorPage.clickSaveandComplete();
    String text =contractorPage.contractorSuccessMessage();
	Assert.assertEquals(text,"Company Created successfully");
     
	 
}
	
	
	
	@Test
	(priority=25)
	   public void verifyContracorInList() throws InterruptedException 
	{
		//check the created contractor name is in list
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		String text =contractorPage.getCreatedContractorName();
		Assert.assertEquals(text,"Contractor Name");
	     
		 
	}
	
	
	  
	
	@Test
	(priority=26)
	   public void verifyContracorDetail() throws InterruptedException 
	{
		//check the created contractor name is Detail
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.clickContractorName();
		String text =contractorPage.getCreatedContractorNameDetail();
		Assert.assertEquals(text,"erg");
	     
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	(priority=28)
	   public void verifyContractorDeleted() throws InterruptedException 
	{
		//Contractor Deleted successfully
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.clickActionMenu();
		contractorPage.clickDeleteMenu();
		String text =contractorPage.contractorSuccessMessage();
		Assert.assertEquals(text,"Deleted Successfully");
	     
		 
	}
	
	
	
	
}
