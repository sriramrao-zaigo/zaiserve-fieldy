package com.zaigo.reactui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.LoginPageObjects;
import com.zaigo.utility.BrowserSetup;

public class LoginTestCases {
	
	private WebDriver driver = null;

	@BeforeClass
	public void setup() {
		this.driver = BrowserSetup.startBrowser();
	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
	}

	
	@Test(priority = 1)
	public void verifyEmptyEmail() 
	{
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("", "asdasdas");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessageUserName();
	    Assert.assertEquals(nameerr, "Enter Your Email");
	   
	    
    }
	
	
	
	@Test(priority = 2)
	public void verifyEmptyPassword() 
	{
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("hello@bg.in", "");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessagePassword();
	    Assert.assertEquals(nameerr, "Enter Your Password");
	   
	    
    }
	
	@Test(priority = 3)
	public void verifyIncorrectMail() 
	{
		//Verify when both the Email and password are not exist in the database
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("aswss@bg.in", "sxdsssscs");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessageUserName();
	    Assert.assertEquals(nameerr, "Invalid Email");
	   
	    
    }
	
	
	@Test(priority =4 )
	public void verifyIncorrectPassword() 
	{
		//Verify when password are not exist in the database.
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("admin@fieldy.co", "sxdsssscs");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessagePassword();
	    Assert.assertEquals(nameerr, "Invalid Password");
	   
	    
    }
	
	@Test(priority =5)
	public void verifyInvalidEmail() 
	{
		//verify Email validation error message
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("admin", "sxdsssscs");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessageUserName();
	    Assert.assertEquals(nameerr, "Please Enter Valid Email");
	   
	    
    }
	
	@Test(priority =6)
	public void verifyInvalidPassword() 
	{
		//verify with Min password validation
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("admin@fieldy.co", "sxd");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessagePassword();
	    Assert.assertEquals(nameerr, "Enter minimum 8 characters.");
	   
	    
    }
	
	@Test(priority =7)
	public void verifyInvalidCredentials() 
	{
		
		//verify with the invalid Email
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("admin@field.co", "sxdasdsdd");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessageUserName();
	    Assert.assertEquals(nameerr, "Invalid Email");
	   
	    
    }
	
	
	
	
	
	
	
	@Test(priority =9)
	public void verifyLockedUser() 
	{
		
		//Verify the Error Message is Displayed when the Account is locked
		
	    LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
    	loginInPage.setUserCredentials("Locked@fieldy.co", "Zaiserve@123");
	    loginInPage.clickLoginButton();
	    String locked = loginInPage.toastTextTwo();
	    Assert.assertEquals(locked, "Your account is locked. Please contact admin.");
	    
	   
	    
    }
    
    
	
	@Test(priority =10)
	public void verifyInvalidAttempts() 
	{
		
		
		//Error Message Should Displayed when the user Enters Invalida datas for 3+ times
		
		LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
		loginInPage.setUserCredentials("admin@fieldy.co", "sxdasdsdd");
	    loginInPage.clickLoginButton();
	    String er1= loginInPage.getErrorMessagePassword();
	    loginInPage.passwordField("hello123");
	    loginInPage.clickLoginButton();
	    String er2= loginInPage.getErrorMessagePassword();
	    loginInPage.passwordField("hello1234");
	    loginInPage.clickLoginButton();
	    String locked = loginInPage.toastText();
	    Assert.assertEquals(locked, "Your account is locked due to 3 failed login attempts. Lock will be released in 60 seconds.");
	   
	    
	  }
	
	
	@Test(priority =11)
	public void addDelay() throws InterruptedException 
	{
		
		
	   Thread.sleep(62000);
	   
	   
	 }	
	
	
	
	
	
	
	
	@Test(priority =12)
	public void verify() 
	{
		//Single Account User
		
	    LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
    	loginInPage.setUserCredentials("sriram@zaigoinfotech.com", "Zaiserve@123");
	    loginInPage.clickLoginButton();
	    String text =loginInPage.dashBoardText();
	    Assert.assertEquals(text, "Dashboard");
	    
	   
	   
	 }	
	
		
	@Test(priority =13)
	public void verifyMultiAccount() 
	{
		//MutiAccount Account User
		
	    LoginPageObjects loginInPage = new LoginPageObjects(this.driver);
    	loginInPage.setUserCredentials("admin@fieldy.co", "Zaiserve@123");
	    loginInPage.clickLoginButton();
	    loginInPage.clickMultiAccount();
	    String text =loginInPage.dashBoardText();
	    Assert.assertEquals(text, "Dashboard");
	    
	   
	 }	
	
	
	

}
