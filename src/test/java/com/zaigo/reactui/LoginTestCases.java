package com.zaigo.reactui;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.Field_Page_Automation;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CreateContractorPage;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

import io.github.bonigarcia.wdm.WebDriverManager;

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
	public void verifyEmptyEmail() {
		// check the Error message when the Username is Empty

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("", "");
		loginInPage.clickLoginButton();
		String nameerr = driver.findElement(By.id("login")).getAttribute("validationMessage");
		Assert.assertEquals(nameerr, "Please fill out this field.");

	}

	@Test(priority = 2)
	public void verifyEmptyPassword() {

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("fieldy@zaiportal.com", "");
		loginInPage.clickLoginButton();
		String nameerr = loginInPage.getErrorMessagePassword();
		Assert.assertEquals(nameerr, "Invalid Password");

	}

	@Test(priority = 3)
	public void verifyIncorrectMail() {
		// Verify when both the Email and password are not exist in the database

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("fieldys@zaiportal.com", "Zaiserve@123");
		loginInPage.clickLoginButton();
		String nameerr = loginInPage.getErrorMessageUserName();
		Assert.assertEquals(nameerr, "Invalid Email");

	}

	@Test(priority = 4)
	public void verifyIncorrectPassword() {
		// Verify when password are not exist in the database.

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("fieldy@zaiportal.com", "Zaisuite@124");
		loginInPage.clickLoginButton();
		String nameerr = loginInPage.getErrorMessagePassword();
		Assert.assertEquals(nameerr, "Invalid Password");

	}

	@Test(priority = 5)
	public void verifyInvalidEmail() {
		// verify Email validation error message

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("admin", "Zaiserve@123");
		loginInPage.clickLoginButton();
		String nameerr = loginInPage.getErrorMessageUserName();
		Assert.assertEquals(nameerr, "Invalid Email");

	}

	@Test(priority = 6)
	public void verifyInvalidPassword() {
		// verify with Min password validation

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.userField("fieldy@zaiportal.com");
		loginInPage.passwordField("asd");
		loginInPage.clickLoginButton();
		String nameerr = loginInPage.getErrorMessagePassword();
		Assert.assertEquals(nameerr, "Enter minimum 8 characters.");
	}

	@Test(priority = 7)
	public void verifyInvalidCredentials() {

		// verify with the invalid Email

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("fieldy@zaiportal.co", "sxdasdsdd");
		loginInPage.clickLoginButton();
		String nameerr = loginInPage.getErrorMessageUserName();
		Assert.assertEquals(nameerr, "Invalid Email");

	}
//
//	/*
//	 * 
//	 * @Test(priority =9) public void verifyLockedUser() {
//	 * 
//	 * //Verify the Error Message is Displayed when the Account is locked
//	 * 
//	 * LoginPage loginInPage = new LoginPage(this.driver);
//	 * loginInPage.userField("lock@zaisuite.com");
//	 * loginInPage.passwordField("Zaiserve@123"); loginInPage.clickLoginButton();
//	 * String locked = loginInPage.toastTextTwo(); Assert.assertEquals(locked,
//	 * "Your account is locked. Please contact admin.");
//	 * 
//	 * 
//	 * 
//	 * }
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * @Test(priority =10) public void verifyInvalidAttempts() {
//	 * 
//	 * 
//	 * //Error Message Should Displayed when the user Enters Invalida datas for 3+
//	 * times
//	 * 
//	 * LoginPage loginInPage = new LoginPage(this.driver);
//	 * loginInPage.setUserCredentials("admin@fieldy.co", "sxdasdsdd");
//	 * loginInPage.clickLoginButton(); String er1=
//	 * loginInPage.getErrorMessagePassword(); loginInPage.passwordField("hello123");
//	 * loginInPage.clickLoginButton(); String er2=
//	 * loginInPage.getErrorMessagePassword();
//	 * loginInPage.passwordField("hello1234"); loginInPage.clickLoginButton();
//	 * String locked = loginInPage.toastText(); Assert.assertEquals(locked,
//	 * "Your account is locked due to 3 failed login attempts. Lock will be released in 60 seconds."
//	 * );
//	 * 
//	 * 
//	 * }
//	 * 
//	 * 
//	 * @Test(priority =11) public void addDelay() throws InterruptedException {
//	 * 
//	 * 
//	 * Thread.sleep(62000);
//	 * 
//	 * 
//	 * }
//	 * 
//	 * 
//	 * 
//	 * 
//	 */

	@Test(priority = 8)
	public void verify() throws InterruptedException {
		// Single Account User

		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.userField("fieldy@zaiportal.com");
		loginInPage.passwordField("Zaiserve@123");
		loginInPage.clickLoginButton();
//		Thread.sleep(5000);
		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
		contractorPage.assertTeam();
//		contractorPage.clickTeam();

	}

//	@Test(priority = 1)
//	public void verifyContractorTab() throws InterruptedException {
//		// Verify User Tab
//
////		 LoginPage loginInPage = new LoginPage(this.driver);
////	     loginInPage.setUserCredentials("fieldy@zaiportal.com", "Zaiserve@123");
////		 loginInPage.clickLoginButton();
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.clickTeam();
//		Thread.sleep(5000);
//		contractorPage.clickTeam();
//		// contractorPage.clickCompany();
//		contractorPage.clickContractor();
//		contractorPage.createContractorButtonj();
//
//	}
//
//	@Test(priority = 2)
//	public void verifyContractorNameMandatory() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.clickSaveandComplete();
//		String error_text = contractorPage.contractorNameError();
//		Assert.assertEquals(error_text, "Required Field");
//		// q
//
//	}
//
//	@Test(priority = 4)
//	public void verifyContractorNumberMinValidation() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.contractorEmail("@gmail.com");
//		contractorPage.contractorPhone("123");
//		contractorPage.clickSaveandComplete();
//		String email_error = contractorPage.contractorPhoneError();
//		Assert.assertEquals(email_error, "Atleast 6 digits required");
//
//	}
//
//	@Test(priority = 3)
//	public void verifyContractorEmailFormat() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.contractorName("Contractor x");
//		contractorPage.contractorEmail("aibcd");
//		contractorPage.clickSaveandComplete();
//		String email_error = contractorPage.contractorEmailError();
//		Assert.assertEquals(email_error, "Enter a valid Email");
//
//	}
//
//	@Test(priority = 5)
//	public void verifyContractorNumberMaxValidation() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.contractorPhone("123123123118900");
//		contractorPage.clickSaveandComplete();
//		String email_error = contractorPage.contractorPhoneError();
//		Assert.assertEquals(email_error, "Not Allowed More than 12 digits");
//
//	}
//
//	@Test(priority = 6)
//	public void verifyFaxMinValidation() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.clearPhone();
//		contractorPage.contractorFax("77");
//		String fax_error = contractorPage.contractorFaxError();
//		Assert.assertEquals(fax_error, "Atleast 3 digits required");
//
//	}
//
//	@Test(priority = 7)
//	public void verifyFaxMaxValidation() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.clearPhone();
//		contractorPage.contractorFax("777777777777777778888888888888877777777777777777777777");
//		contractorPage.clickSaveandComplete();
//		String fax_error = contractorPage.contractorFaxError();
//		Assert.assertEquals(fax_error, "Not Allowed More than 25 digits");
//
//	}
//
//	@Test(priority = 8)
//	public void verifyCpersonMaxValidation() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		contractorPage.clearFax();
//		contractorPage.contractorContactPerson(
//				"Tambaram,chennai Tambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,ww w wwkdmwemw ewewkmewkekewewewklwklwlkwkwwkelwelwweewwwwmwmwmwmswmskwmskwmksmwksmkswsTambaram,chennai Tambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,chennaiTambaram,ww w wwkdmwemw ewewkmewkekewewewklwklwlkwkwwkelwelwweewwwwmwmwmwmswmskwmskwmksmwksmkswss");
//		contractorPage.clickSaveandComplete();
//		String cperson_error = contractorPage.contractorContactNameError();
//		Assert.assertEquals(cperson_error, "Not Allowed More than 512 characters");
//
//	}
//
////	@Test(enabled= false)
////	public void verifyWebsiteValidation() throws InterruptedException
////	{
////		
////		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
////		contractorPage.clearContactPerson();
////		contractorPage.contractorWebsite("abcd");
////		contractorPage.clickSaveandComplete();
////		String web_error=contractorPage.contractorWebsiteError();
////		Assert.assertEquals(web_error,"Enter a valid URL(http(s)://sample.co)");
////		
////		
////	}
//
//	@Test(priority = 9)
//	public void verifySaveButtonExist() throws InterruptedException {
//
//		CreateContractorPage contractorPage = new CreateContractorPage(this.driver);
//		String text_button = contractorPage.getButtonText();
//		Assert.assertEquals(text_button, "Save & Complete");
//
//	}
//
//	@Test(priority = 10) // 2-Module
//	public void modulePage() throws InterruptedException {
//		Field_Page_Automation modules = new Field_Page_Automation(driver);
//		modules.enterTeamModule();
//	}
//
//	@Test(priority = 11) // 3ReqField User
//	public void reqFieldUser() throws InterruptedException, AWTException {
//		Field_Page_Automation reqField = new Field_Page_Automation(driver);
//		reqField.reqField();
//
//	}
//
//	@Test(priority = 12) // 4-ReqField Contractor
//	public void conReqField() throws InterruptedException, AWTException {
//		Field_Page_Automation conReqField = new Field_Page_Automation(driver);
//		conReqField.conReqField();
//
//	}
//
//	@Test(priority = 13) // 5-ReqField organization
//	public void reqOrganization() throws InterruptedException {
//		Field_Page_Automation reqOrganization = new Field_Page_Automation(driver);
//		reqOrganization.reqOrganization("Kumar", "kumar@zaigoinfotech.com");
//	}
//
//	@Test(priority = 14)
//	public void manditoryField() throws InterruptedException {
//		Field_Page_Automation manditoryField = new Field_Page_Automation(driver);
//		manditoryField.manditoryDatas("Prem", "prem@zaigoinfotech.com");
//
//	}
//
//	@Test(priority = 15)
//	public void inputUserLocationFieldReq() throws IOException, InterruptedException {
//		Field_Page_Automation inputLocationFieldReq = new Field_Page_Automation(driver);
//		inputLocationFieldReq.inputUserLocationFieldReqs();
//
//	}
//
//	@Test(priority = 16)
//	private void conManditoryField() throws InterruptedException {
//		Field_Page_Automation conManditoryField = new Field_Page_Automation(driver);
//		conManditoryField.conOrganization("Kumar", "kumar@gmail.com");
//
//	}
//
//	@Test(priority = 17)
//	private void inputContractorLocationFieldReq() throws IOException, InterruptedException {
//		Field_Page_Automation conLocationField = new Field_Page_Automation(driver);
//		conLocationField.inputConLocatioFieldReq();
//
//	}
//
//	@Test(priority = 18)
//	public void UserModule() throws InterruptedException, AWTException {
//		Field_Page_Automation data = new Field_Page_Automation(driver);
//		data.datas("Ajith", "Kumar", "Testing", "ajith@zaigoinfotech.com", "9876543210", "Chennai", "100",
//				"Sakthinagar", "TamilNadu", "Egmore", "600084");
//	}
//
//	@Test(priority = 19)
//	public void conDatas() throws InterruptedException, AWTException {
//		Field_Page_Automation conDataReqOrganization = new Field_Page_Automation(driver);
//		conDataReqOrganization.conDataReqOrganization("Prem", "Kumar", "Prem@zaigoinfotech.com", "8765432190",
//				"Coimbatore", "200", "Cavery Nagar", "TamilNadu", "Main City", "630098");
//	}
//
//	@Test(priority = 20)
//	public void alreadyExistData() throws InterruptedException {
//		Field_Page_Automation existData = new Field_Page_Automation(driver);
//		existData.existingData("Ajith", "Kumar", "Testing", "ajith@zaigoinfotech.com", "9876543210");
//
//	}
//
//	@Test(priority = 21)
//	public void contractExistingData() throws InterruptedException {
//		Field_Page_Automation contractExistingData = new Field_Page_Automation(driver);
//		contractExistingData.conExistingDatas("Prem", "Kumar", "Prem@zaigoinfotech.com", "8765432190");
//
//	}
//
//	/*
//	 * @Test(priority =13) public void verifyMultiAccount() { //MutiAccount Account
//	 * User
//	 * 
//	 * LoginPage loginInPage = new LoginPage(this.driver);
//	 * loginInPage.setUserCredentials("admin@fieldy.co", "Zaiserve@123");
//	 * loginInPage.clickLoginButton(); loginInPage.clickMultiAccount(); String text
//	 * =loginInPage.dashBoardText(); Assert.assertEquals(text, "Dashboard");
//	 * 
//	 * 
//	 * }
//	 */

}
