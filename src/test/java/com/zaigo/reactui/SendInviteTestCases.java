package com.zaigo.reactui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CreateContractorPageObjects;
import com.zaigo.pageobjects.LoginPageObjects;
import com.zaigo.pageobjects.SendInvitePageObjects;
import com.zaigo.utility.BrowserSetup;

public class SendInviteTestCases {
	
	
	
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
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 String text = invitePage.getUserTab();
		 Assert.assertEquals(text, "User");
	    
	}

	
	
	@Test
	(priority=2)
	public void verifySendInvitePopup() throws InterruptedException 
	{
		//Verify the Send invite popup
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickUserTab();
		 invitePage.clickUserSubMenu();
		 invitePage.clickSendInvite();
		 String text= invitePage.popupText();
		 Assert.assertEquals(text, "Send Invite");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	@Test
	(priority=3)
	public void verifyEmailRequired() throws InterruptedException 
	{
		//Verify the Email format
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 invitePage.clickNext();
		 String text= invitePage.getEmailErrorText();
		 Assert.assertEquals(text, "This field is required");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	
	
	
	
	@Test
	(priority=4)
	public void verifyEmailFormat() throws InterruptedException 
	{
		//Verify the Email format
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 invitePage.enterEmail("asdf");
		 String text= invitePage.getEmailErrorText();
		 Assert.assertEquals(text, "Enter a valid email address");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	
	@Test
	(priority=5)
	public void verifyFirtName() throws InterruptedException 
	{
		//Verify the Email format
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 invitePage.clickNext();
		 String text= invitePage.firstNameError();
		 Assert.assertEquals(text, "This field is required");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	
	
	@Test
	(priority=6)
	public void verifyFirtNameWithBlankSpace() throws InterruptedException 
	{
		//Verify the Email format
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 invitePage.enterFirstName("  ");
		 invitePage.clickNext();
		 String text= invitePage.firstNameError();
		 Assert.assertEquals(text, "Blank space not allowed");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	
	
	@Test
	(priority=7)
	public void verifyUserEnterMessage() throws InterruptedException 
	{
		//Verify user can enter the message
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 invitePage.enterFirstName("Firstname");
		 invitePage.enterEmail("email@gmail.com");
		 invitePage.clickNext();
		 String text= invitePage.getMessageText();
		 Assert.assertEquals(text, "Message");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	
	@Test
	(priority=8)
	public void verifyAddMoreButton() throws InterruptedException 
	{
		//Verify add more button is present
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 String text= invitePage.getAddMoreText();
		 Assert.assertEquals(text, "ADD MORE");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	
	@Test
	(priority=9)
	public void verifyUserSendInvite() throws InterruptedException 
	{
		//Verify user can send invite without message.
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 invitePage.enterFirstName("Firstname");
		 invitePage.enterEmail("email@gmail.com");
		 invitePage.clickSubmit();
		 String text= invitePage.getSuccessMessages();
		 Assert.assertEquals(text, "Message");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}
	
	
	@Test
	(priority=10)
	public void verifyUserSendInviteWithMessage() throws InterruptedException 
	{
		//Verify user can sendinvite with message
		
		 SendInvitePageObjects invitePage = new SendInvitePageObjects(this.driver);
		 invitePage.clickSendInvite();
		 invitePage.enterFirstName("Firstname");
		 invitePage.enterEmail("email@gmail.com");
		 invitePage.clickNext();
		 invitePage.enterMessage("message");
		 invitePage.clickSubmit();
		 String text= invitePage.getSuccessMessages();
		 Assert.assertEquals(text, "Message");
		 invitePage.clickClose();
		 invitePage.clickYes();
	}

}
