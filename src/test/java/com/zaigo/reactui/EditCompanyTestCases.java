package com.zaigo.reactui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CompanyEditPage;
//import com.zaigo.pageobjects.CreateVendorPageObjects;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

public class EditCompanyTestCases {
	
	
	
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
	     loginInPage.setUserCredentials("admin@fieldy.co", "Zaiserve@123");
		 loginInPage.clickLoginButton();
		 CompanyEditPage editcompany = new CompanyEditPage(this.driver);
		 String text = editcompany.getUserMenuText();
		 Assert.assertEquals(text, "User");
		    
	    
	}
	
	@Test
	(priority=2)
	public void verifyCompanyTab() 
	{
		//Verify company tab
		
		CompanyEditPage editcompany = new CompanyEditPage(this.driver);
		editcompany.clickUserMenu();
		
		try
		{
		String text= editcompany.getCompanyTabText();
		Assert.assertEquals(text, "Companies");
		}
		
		catch(Exception e)
		{
			String text=e.getMessage();
			System.out.print(text);
		}
	}

	@Test
	(priority=3)
	public void modalPopup() 
	{
		//Verify popup 
		
		CompanyEditPage editcompany = new CompanyEditPage(this.driver);
		editcompany.clickUserMenu();
		editcompany.clickCompanyTab();
		editcompany.clickEditButton();
		
		try
		{
		String text= editcompany.getButtonText();
		//System.out.print(text);
		Assert.assertEquals(text, "Save and Complete");
		}
		
		catch(Exception e)
		{
			String texte=e.getMessage();
			System.out.print(texte);
		}
		
		
	}
	
	
	@Test
	(priority=4)
	public void verifyEmptyName() 
	{
		//Verify Name Empty
		
		CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//		editcompany.clickUserMenu();
//		editcompany.clickCompanyTab();
//		editcompany.clickEditButton();
		editcompany.enterCompanyName(" ");
		
		try
		{
		String text= editcompany.getNameErrorMessage();
		//System.out.print(text);
		Assert.assertEquals(text, "Blank space not allowed");
		}
		
		catch(Exception e)
		{
			String texte=e.getMessage();
			System.out.print(texte);
		}
		
		
	}
	@Test
	(priority=5)
	public void verifyMaxName() 
	{
		//Verify Name Empty
		
		CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//		editcompany.clickUserMenu();
//		editcompany.clickCompanyTab();
//		editcompany.clickEditButton();
		editcompany.enterCompanyName("helollllllllllllllllllllllllllllllllllknkijnkijiojkkij");
		
		try
		{
		String text= editcompany.getNameErrorMessage();
		//System.out.print(text);
		Assert.assertEquals(text, "Not allowed more than 50 characters");
		}
		
		catch(Exception e)
		{
			String texte=e.getMessage();
			System.out.print(texte);
		}
		
		
	}
	
	
	@Test
	(priority=6)
	public void verifyEmptySpacesinOwner() 
	{
		//Verify Name Empty
		
		CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//		editcompany.clickUserMenu();
//		editcompany.clickCompanyTab();
//		editcompany.clickEditButton();
		editcompany.enterOwnerName("  ");
		
		try
		{
		String text= editcompany.getOwnerErrorMessage();
		//System.out.print(text);
		Assert.assertEquals(text, "Blank space not allowed");
		}
		
		catch(Exception e)
		{
			String texte=e.getMessage();
			System.out.print(texte);
		}
		
	}
		@Test
		(priority=7)
		public void verifyMaxOwnerName() 
		{
			//Verify Name Empty
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
			editcompany.enterOwnerName("helollllllllllllllllllllllllllllllllllknkijnkijiojkkij");
			
			try
			{
			String text= editcompany.getOwnerErrorMessage();
			//System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 50 characters");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		@Test
		(priority=8)
		public void verifyLocationOne() 
		{
			//Verify Name Empty
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
			editcompany.enterCompanyName("csk ind pvt");
		    editcompany.enterOwnerName("hello");
			editcompany.clickNext();
			editcompany.clickAddMore();
			editcompany.clickLocation();
     		editcompany.enterLocationName("Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1Location 1");
			
			try
			{
			String text= editcompany.getAddressNameErrorMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 50 characters");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		@Test
		(priority=9)
		public void verifyEmailFormat() 
		{
			//Verify Email Format
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
//			editcompany.enterCompanyName("csk ind pvt");
//			editcompany.enterOwnerName("hello");
//			editcompany.clickNext();
//			editcompany.clickAddMore();
//			editcompany.clickLocation();
			editcompany.enterLocationEmail("mkjn");
			try
			{
			String text= editcompany.getAddressEmailErrorMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Enter valid email address");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		@Test
		(priority=10)
		public void verifyPhoneFormat() 
		{
			//Verify Phone Format
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
//			editcompany.enterCompanyName("csk ind pvt");
//			editcompany.enterOwnerName("hello");
//			editcompany.clickNext();
//			editcompany.clickAddMore();
//			editcompany.clickLocation();
			editcompany.enterLocationPhone("123456789003333");
			try
			{
			String text= editcompany.getAddressPhoneErrorMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 10 characters");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		@Test
		(priority=11)
		public void verifyMaxContactPerson() 
		{
			//Verify Max contact person chracters
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
//			editcompany.enterCompanyName("csk ind pvt");
//			editcompany.enterOwnerName("hello");
//			editcompany.clickNext();
//			editcompany.clickAddMore();
//			editcompany.clickLocation();
			editcompany.enterLocationPerson("A simple & fast character counter character counter");
			try
			{
			String text= editcompany.getAddressPersonErrorMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 50 characters");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		@Test
		(priority=12)
		public void verifyMaxLineOne() 
		{
			//Verify Max contact person chracters
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
//			editcompany.enterCompanyName("csk ind pvt");
//			editcompany.enterOwnerName("hello");
//			editcompany.clickNext();
//			editcompany.clickAddMore();
//			editcompany.clickLocation();
     		editcompany.enterLineOne("A simple & fast character counter character counterA simple & fast character counter character counterA simple & fast character counter character counter");
			try
			{
			String text= editcompany.getLineOneErr();
			System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 150 characters");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		
		@Test
		(priority=14)
		public void verifyMaxLineTwo() 
		{
			//Verify Max contact person chracters
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
//			editcompany.enterCompanyName("csk ind pvt");
//			editcompany.enterOwnerName("hello");
//			editcompany.clickNext();
//			editcompany.clickAddMore();
//			editcompany.clickLocation();
     		editcompany.enterLineTwo("A simple & fast character counter character counter A simple & fast character counter character counterA simple & fast character counter character counter");
			try
			{
				
			String text= editcompany.getLineTwoErrorMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 150 characters");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		
		
		@Test
		(priority=13)
		public void verifyMaxCity() 
		{
			//Verify Max contact person chracters
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
//			editcompany.enterCompanyName("csk ind pvt");
//			editcompany.enterOwnerName("hello");
//			editcompany.clickNext();
//			editcompany.clickAddMore();
//			editcompany.clickLocation();
			editcompany.enterCity("A simple & fast character counter character counter A simple & fast character counter character counterA simple & fast character counter character counter");
			try
			{
			String text= editcompany.getCityErrorMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 150 characters");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		
		@Test
		(priority=15)
		public void verifyMaxZip() 
		{
			//Verify Max contact person chracters
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
//			editcompany.clickUserMenu();
//			editcompany.clickCompanyTab();
//			editcompany.clickEditButton();
//			editcompany.enterCompanyName("csk ind pvt");
//			editcompany.enterOwnerName("hello");
//			editcompany.clickNext();
//			editcompany.clickAddMore();
//			editcompany.clickLocation();
			editcompany.enterZipcode("12345678901");
			try
			{
			String text= editcompany.getZipcodeErrorMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Not allowed more than 10 characters");
			
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			editcompany.clickClose();
			editcompany.clickYes();
		}
		
	/*		
		@Test
		(priority=16)
		public void verifyErrorMessageImageSize() 
		{
			//Verify Max contact person chracters
			
			ComapanyEditPageObjects editcompany = new ComapanyEditPageObjects(this.driver);
			editcompany.clickUserMenu();
			editcompany.clickCompanyTab();
			editcompany.clickEditButton();
			editcompany.enterCompanyName("csk ind pvt");
			editcompany.uploadImage("C:\\Users\\lenovo\\Pictures\\picjpg.jpg");
			editcompany.clickNext();
			try
			{
			String text= editcompany.imageError();
			System.out.print(text);
			Assert.assertEquals(text, "");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		*/
		
		
		@Test
		(priority=17)
		public void verifyUpdatedSuccessfully() 
		{
			//Verify success message
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
			//editcompany.clickUserMenu();
			//editcompany.clickCompanyTab();
			editcompany.clickEditButton();
			editcompany.enterCompanyName("Tenant Edit");
			editcompany.clickSaveandComplete();
			try
			{
			String text= editcompany.getSuccessMessage();
			System.out.print(text);
			Assert.assertEquals(text, "Updated Successfully");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		
		@Test
		(priority=18)
		public void verifyNameUpdated() 
		{
			//Verify the Name is edited
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
			try
			{
			String text= editcompany.getCompanyName();
			System.out.print(text);
			Assert.assertEquals(text, "Tenant Edit");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		
		@Test
		(priority=19)
		public void verifySiteUpdated() 
		{
			//Verify the Name is edited
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
			try
			{
			String text= editcompany.getWebsite();
			System.out.print(text);
			Assert.assertEquals(text, "https://www.zaigoinfotech.com/");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		@Test
		(priority=20)
		public void verifyNotesEdited() 
		{
			//Verify the Name is edited
			
			CompanyEditPage editcompany = new CompanyEditPage(this.driver);
			try
			{
			String text= editcompany.getNotes();
			System.out.print(text);
			Assert.assertEquals(text, "Noted");
			}
			
			catch(Exception e)
			{
				String texte=e.getMessage();
				System.out.print(texte);
			}
			
			
		}
		
		
		
		
		
		
}

