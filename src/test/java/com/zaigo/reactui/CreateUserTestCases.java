package com.zaigo.reactui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CreateContractorPageObjects;
import com.zaigo.pageobjects.CreateUserPage;
import com.zaigo.pageobjects.LoginPageObjects;
import com.zaigo.utility.BrowserSetup;

public class CreateUserTestCases {
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
	public void verifyFirstNameMandatory() 
	{
		//Verify first name field is mandatory
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.clickNextButton();
		 String text= userpage.getFirstNameError();
		 Assert.assertEquals(text, "This field is required");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
	    
	}

	@Test
	(priority=3)
	public void verifyRoleMandatory() 
	{
		//Verify Role field is mandatory
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.clickNextButton();
		 String text= userpage.getRoleError();
		 Assert.assertEquals(text, "This field is required");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
		 
	    
	}
	
	
	@Test
	(priority=4)
	public void verifyEmailMandatory() 
	{
		//Verify Email field is mandatory
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.clickNextButton();
		 String text= userpage.getEmailError();
		 Assert.assertEquals(text, "This field is required");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
	    
	}
	
	
	
	@Test
	(priority=5)
	public void verifyMaxPhoneNumber() 
	{
		//Verify phone error.
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.enterPhone("12312312311");
		 String text= userpage.getPhoneError();
		 Assert.assertEquals(text, "Not allowed more than 10 characters");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
	    
	}
	
	
	@Test
	(priority=6)
	public void verifyMaxHomePhoneNumber() 
	{
		//Verify home phone error.
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.enterHomePhone("12312312311");
		 String text= userpage.getHomePhoneError();
		 Assert.assertEquals(text, "Not allowed more than 10 characters");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
	    
	}
	
	
	@Test
	(priority=7)
	public void verifyEmailFormat() 
	{
		//Verify email not in format
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.enterEmail("text");
		 String text= userpage.getEmailError();
		 Assert.assertEquals(text, "Enter a valid email address");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
	    
	}

	
	@Test
	(priority=8)
	public void verifyFirstNameMaxCharacters() 
	{
		//Verify first name max characeters
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.enterFirstName("qaqaqaqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqaaaaaqqqqqqqqqqqqqqqqqqqqqqqqqqaaaaa");
		 String text= userpage.getFirstNameError();
		 Assert.assertEquals(text, "Not allowed more than 50 characters");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
	    
	}
	
	
	@Test
	(priority=9)
	public void verifyLastNameMaxCharacters() 
	{
		//Verify last name max characters
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.enterLastName("asswswsxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		 String text= userpage.getLastNameError();
		 Assert.assertEquals(text, "Not allowed more than 50 characters");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
	    
	}
	
	
	@Test
	(priority=10)
	public void verifyJobTitleMaxCharacters() 
	{
		//Verify job title max characters
		
		
		 CreateUserPage userpage = new CreateUserPage(this.driver);
		 userpage.clickUserHeaderMenu();
		 userpage.clickUser();
		 userpage.clickCreateUserButton();
		 userpage.enterJobTitle("asasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasssasasasssssssasss");
		 String text= userpage.getTitleError();
		 Assert.assertEquals(text, "Not allowed more than 100 characters");
		 userpage.clickClose();
		 userpage.clickYes();
		 
		 
		 
	    
	}
	
	@Test
	(priority=11)
	public void verifyLineOneMaxCharacters() throws InterruptedException 
	{
		//
		//check the Line One has Max characters validation
		
		CreateUserPage userpage = new CreateUserPage(this.driver);
		userpage.clickUserHeaderMenu();
		userpage.clickUser();
		userpage.clickCreateUserButton();
		userpage.enterFirstName("hello");
		userpage.enterEmail("email@gmail.com");
		userpage.selectRole();
		userpage.clickNextButton();
		userpage.clickAddLocation();
		userpage.clickLocationOne();
		userpage.contractorLineOne("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		String text =userpage.contractorLineOneError();
		Assert.assertEquals(text,"Not allowed more than 150 characters");
		userpage.clickClose();
		userpage.clickYes();
	     
		 
	}
	
	
	
	@Test
	(priority=12)
	public void verifyLineTwoMaxCharacters() throws InterruptedException 
	{
		
		//check the Line Two has Max characters validation
		CreateUserPage userpage = new CreateUserPage(this.driver);
		userpage.clickUserHeaderMenu();
		userpage.clickUser();
		userpage.clickCreateUserButton();
		userpage.enterFirstName("hello");
		userpage.enterEmail("email@gmail.com");
		userpage.selectRole();
		userpage.clickNextButton();
		userpage.clickAddLocation();
		userpage.clickLocationOne();
		userpage.contractorLineTwo("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
	    String text =userpage.contractorLineTwoError();
		Assert.assertEquals(text,"Not allowed more than 150 characters");
		userpage.clickClose();
		userpage.clickYes();
	}
	
	
	
	
	@Test
	(priority=13)
	public void verifyCityMaxCharacters() throws InterruptedException 
	{
		
		//check City with Max character validations
		
		CreateUserPage userpage = new CreateUserPage(this.driver);
		userpage.clickUserHeaderMenu();
		userpage.clickUser();
		userpage.clickCreateUserButton();
		userpage.enterFirstName("hello");
		userpage.enterEmail("email@gmail.com");
		userpage.selectRole();
		userpage.clickNextButton();
		userpage.clickAddLocation();
		userpage.clickLocationOne();
		userpage.contractorCity("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
	    String text =userpage.contractorCityError();
		Assert.assertEquals(text,"Not allowed more than 150 characters");
		userpage.clickClose();
		userpage.clickYes();
	}
	
	
	
	
	
	
	
	
	@Test
	(priority=14)
	public void verifyMaxZipcode() throws InterruptedException 
	{
		//
		//check zipcode accepts the 3 digits
		
		CreateUserPage userpage = new CreateUserPage(this.driver);
		userpage.clickUserHeaderMenu();
		userpage.clickUser();
		userpage.clickCreateUserButton();
		userpage.enterFirstName("hello");
		userpage.enterEmail("email@gmail.com");
		userpage.selectRole();
		userpage.clickNextButton();
		userpage.clickAddLocation();
		userpage.clickLocationOne();
		userpage.contractorZipcode("1231233");
	    String text =userpage.contractorZipcodeError();
		Assert.assertEquals(text,"Not allowed more than 6 characters");
		userpage.clickClose();
		userpage.clickYes();
		 
	}
	
	
	
	@Test
	(priority=16)
	public void verifyErrorMessageCompany() throws InterruptedException 
	{
		//
		//check error message company
		
		CreateUserPage userpage = new CreateUserPage(this.driver);
		userpage.clickUserHeaderMenu();
		userpage.clickUser();
		userpage.clickContractorUser();
		userpage.clickCreateUserButton();
		userpage.enterFirstName("hello");
		userpage.enterEmail("email@gmail.com");
		userpage.clickContractorCompany();
		userpage.clicksave();
	    String text =userpage.getCompanyError();
		Assert.assertEquals(text,"Please select the company associated or create as an Individual contractor");
		userpage.clickClose();
		userpage.clickYes();
		 
	}
	
	
	
	@Test
	(priority=15)
	public void verifySuccessMessage() throws InterruptedException 
	{
		//
		//check successmessage
		
		CreateUserPage userpage = new CreateUserPage(this.driver);
		userpage.clickUserHeaderMenu();
		userpage.clickUser();
		userpage.clickCreateUserButton();
		userpage.enterFirstName("hello");
		userpage.enterEmail("email1@gmail.com");
		userpage.selectRole();
		userpage.clicksave();
	    String text =userpage.getSuccessText();
		Assert.assertEquals(text,"User Created Successfully");
		userpage.clicksuccessclose();
		 
	}
	
	
}
