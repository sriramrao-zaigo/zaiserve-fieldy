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
	(priority=9)
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
	(priority=10)
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
	(priority=11)
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
		Assert.assertEquals(text,"Only numbers allowed");
		contractorPage.clickCloseButton();
		contractorPage.clickYesButton();
		 
	    
	}
	
	/*
	@Test
	(priority=12)
	public void verifyMaxPhone() 
	{
		//Verify Phone Field accepts 20 characters
		
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
	(priority=12)*
	public void verifyVendor() 
	{
		//Verify Phone Field Accepts Only the Number field.
		
		CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		contractorPage.dashBoardUserMenu();
		contractorPage.clickVendorTab();
		contractorPage.contractorCreateButton();
		contractorPage.contractorName("hello");
		contractorPage.contractorEmail("email@gmail.com");
		contractorPage.contractorContactPerson("cperson hello");
		contractorPage.clickNextButton();
		String text =contractorPage.contractorPhoneError();
		Assert.assertEquals(text,"Only numbers allowed");
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
	(priority=15)
	public void verifyMaxEmail() throws InterruptedException 
	{
		//Verify the max validation if Email Exceeds the Limit 50
		
		 CreateContractorPageObjects contractorPage = new CreateContractorPageObjects(this.driver);
		 contractorPage.dashBoardUserMenu();
		 contractorPage.clickVendorTab();
		 contractorPage.contractorCreateButton();
		 contractorPage.contractorEmail("Lorem ipsum dolor sit amet, consectetuer adipiscin");
		 contractorPage.clickNextButton();
		 String text =contractorPage.contractorEmailError();
		 Assert.assertEquals(text, "Email Should not have More than 50 characters");
		 contractorPage.clickCloseButton();
		 contractorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=16)
	public void verifyMaxContactPerson() 
	{
		//Verify the max validation if Contact person Exceeds the Limit 50
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorContactPerson("Lorem ipsum dolor sit amet, consectetuer adipiscin");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorContactNameError();
		 Assert.assertEquals(text, "Contact Person Should not have More than 50 characters");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	 }
	
	
	@Test
	(priority=17)
	public void verifyDuplicateEmail() throws InterruptedException 
	{
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
	public void verifyFaxMaxValidation() throws InterruptedException 
	{
		//Verify the Fax Field have the Max valdations
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorFax("asddddddcddcdcdcdc");
		 vendorPage.clickNextButton();
		 String text =vendorPage.vendorFaxError();
		 Assert.assertEquals(text, "This field is required");
		 vendorPage.clickCloseButton();
		 vendorPage.clickYesButton();
		 
	    
	}
	
	
	@Test
	(priority=19)
	public void verifyLineOneMaxCharacters() throws InterruptedException 
	{
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
		contractorPage.contractorLineOne("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		contractorPage.clickSaveandComplete();
	    String text =contractorPage.contractorLineOneError();
		Assert.assertEquals(text,"The Address field is limited to 200 characters");
	     
		 
	}
	
	
	@Test
	(priority=20)
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
		 vendorPage.clickAddLocation();
		 vendorPage.vendorLineTwo("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		 vendorPage.clickSaveandComplete();
	     String text =vendorPage.vendorLineTwoError();
		 Assert.assertEquals(text,"The Address field is limited to 200 characters");
		 
	}
	
	
	
	@Test
	(priority=21)
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
		 vendorPage.clickAddLocation();
		 vendorPage.vendorCity("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		 vendorPage.clickSaveandComplete();
	     String text =vendorPage.vendorCityError();
		 Assert.assertEquals(text,"The City field is limited to 200 characters");
	}
	
	
	@Test
	(priority=22)
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
		 vendorPage.clickAddLocation();
		 vendorPage.vendorAddressContactPerson("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		 vendorPage.clickSaveandComplete();
	     String text =vendorPage.vendorContctPersonError();
		 Assert.assertEquals(text,"The Contact Person field is limited to 200 characters");
		 
	}
	
	@Test
	(priority=23)
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
		 vendorPage.clickAddLocation();
		 vendorPage.vendorZipcode("Abcdefgh");
		 vendorPage.clickSaveandComplete();
	     String text =vendorPage.vendorZipcodeError();
		 Assert.assertEquals(text,"Allowed Only 8 Digits");
		 
	}
	
	
	@Test
	(priority=24)
	public void verifyMinZipcode() throws InterruptedException 
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
		 vendorPage.clickAddLocation();
		 vendorPage.vendorZipcode("Ab");
		 vendorPage.clickSaveandComplete();
	     String text =vendorPage.vendorZipcodeError();
		 Assert.assertEquals(text,"Allowed only 8 digits");
		 
	}
	
	
	@Test
	(priority=25)
	public void verifyWithValidDetails() throws InterruptedException 
	{
		//check zipcode accepts the one characters
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
		 vendorPage.clickNextButton();
		 vendorPage.clickNextButton();
	     vendorPage.clickSaveandComplete();
	     String text =vendorPage.vendorSuccessMessage();
		 Assert.assertEquals(text,"Successfully Created");
	     
		 
	}
	
	
	
	
	@Test
	(priority=26)
	public void verifyWithInvalidImage() throws InterruptedException 
	{
		//check with Invalid Image file
		
		 CreateVendorPageObjects vendorPage = new CreateVendorPageObjects(this.driver);
		 vendorPage.dashBoardUserMenu();
		 vendorPage.clickVendorTab();
		 vendorPage.vendorCreateButton();
		 vendorPage.vendorName("hello");
		 vendorPage.vendorEmail("email@gmail.com");
		 vendorPage.vendorContactPerson("cperson hello");
	     vendorPage.clickSaveandComplete();
		 vendorPage.uploadImage("C:\\Users\\lenovo\\Pictures\\picjpg.jpg");
		 String textd =vendorPage.vendorImageError();
		 Assert.assertEquals(textd,"Image Error");
	   
	     
	 }
	
	
	
	
	*/
	
	
	
	
	
	
	
	
}
