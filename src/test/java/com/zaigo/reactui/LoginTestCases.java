package com.zaigo.reactui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.LoginPage;
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
		//check the Error message when the Username is Empty
		
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("","");
	    loginInPage.clickLoginButton();
        String nameerr= driver.findElement(By.id("login")).getAttribute("validationMessage");
	    Assert.assertEquals(nameerr, "Please fill out this field.");

	   
	    //ww
	    
	    
	 
	    

	   
	    
    }
	
	/*
	
	
	@Test(priority = 2)
	public void verifyEmptyPassword() 
	{
		
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("alpha@zaisuite.com", "");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessagePassword();
	    Assert.assertEquals(nameerr, "Invalid Password");
	   
	    
    }
	
	
	
	@Test(priority = 3)
	public void verifyIncorrectMail() 
	{
		//Verify when both the Email and password are not exist in the database
		
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("alphas@zaisuite.com", "Zaiserve@123");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessageUserName();
	    Assert.assertEquals(nameerr, "Invalid Email");
	   
	    
    }
	
	
	
	@Test(priority =4 )
	public void verifyIncorrectPassword() 
	{
		//Verify when password are not exist in the database.
		
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("alpha@zaisuite.com", "Zaisuite@124");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessagePassword();
	    Assert.assertEquals(nameerr, "Invalid Password");
	   
	    
    }
	
	
	
	@Test(priority =5)
	public void verifyInvalidEmail() 
	{
		//verify Email validation error message
		
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("admin", "Zaiserve@123");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessageUserName();
	    Assert.assertEquals(nameerr, "Invalid Email");
	   
	    
    }
	
	
	
	@Test(priority =6)
	public void verifyInvalidPassword() 
	{
		//verify with Min password validation
		
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.userField("alpha@zaisuite.com");
		loginInPage.passwordField("asd");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessagePassword();
	    Assert.assertEquals(nameerr, "Enter minimum 8 characters.");
    }
	
	
	
	@Test(priority =7)
	public void verifyInvalidCredentials() 
	{
		
		//verify with the invalid Email
		
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("admin@field.co", "sxdasdsdd");
	    loginInPage.clickLoginButton();
	    String nameerr=loginInPage.getErrorMessageUserName();
	    Assert.assertEquals(nameerr, "Invalid Email");
	   
	    
    }
	
	
	
	
	
	
	/*
	
	@Test(priority =9)
	public void verifyLockedUser() 
	{
		
		//Verify the Error Message is Displayed when the Account is locked
		
	    LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.userField("lock@zaisuite.com");
        loginInPage.passwordField("Zaiserve@123");
	    loginInPage.clickLoginButton();
	    String locked = loginInPage.toastTextTwo();
	    Assert.assertEquals(locked, "Your account is locked. Please contact admin.");
	    
	   
	    
    }
    
   
    
	
   
	
	@Test(priority =10)
	public void verifyInvalidAttempts() 
	{
		
		
		//Error Message Should Displayed when the user Enters Invalida datas for 3+ times
		
		LoginPage loginInPage = new LoginPage(this.driver);
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
	
	
	
	
	*/
	
	/*
	
	
	@Test(priority =12)
	public void verify() 
	{
		//Single Account User
		
	    LoginPage loginInPage = new LoginPage(this.driver);
    	loginInPage.userField("alpha@zaisuite.com");
        loginInPage.passwordField("Zaiserve@123");
	    loginInPage.clickLoginButton();
	    String text =loginInPage.dashBoardText();
	    Assert.assertEquals(text, "Dashboard");
	    
	   
	   
	 }	
	
	*/
	
	/*
	@Test(priority =13)
	public void verifyMultiAccount() 
	{
		//MutiAccount Account User
		
	    LoginPage loginInPage = new LoginPage(this.driver);
    	loginInPage.setUserCredentials("admin@fieldy.co", "Zaiserve@123");
	    loginInPage.clickLoginButton();
	    loginInPage.clickMultiAccount();
	    String text =loginInPage.dashBoardText();
	    Assert.assertEquals(text, "Dashboard");
	    
	   
	 }	
	*/
	
	

}
