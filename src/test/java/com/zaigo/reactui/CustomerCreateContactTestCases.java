package com.zaigo.reactui;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CustomerCreateContactPage;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

public class CustomerCreateContactTestCases {

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

	@Test(priority = 0) // 1-Login
	public void loginPage() throws InterruptedException {
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("fieldy@zaiportal.com", "Zaiserve@123");
		loginInPage.clickLoginButton();
	}

	@Test(priority = 1)
	private void contactModule() throws InterruptedException {
		CustomerCreateContactPage module = new CustomerCreateContactPage(driver);
		module.modulePage();

	}

	@Test(priority = 2)
	private void manditoryField() throws InterruptedException, AWTException {
		CustomerCreateContactPage manditory = new CustomerCreateContactPage(driver);
		manditory.manditoryValidation();

	}

	@Test(priority = 3)
	private void minValidationContactPage() throws AWTException {
		CustomerCreateContactPage minValidation = new CustomerCreateContactPage(driver);
		minValidation.minValidation();
	}

	@Test(priority = 4)
	private void maxValidationContactPage() {
		CustomerCreateContactPage maxValidation = new CustomerCreateContactPage(driver);
		maxValidation.maxValidation();

	}

	@Test(priority = 5)
	private void minValidationPropertyPage() {
		CustomerCreateContactPage minValidation = new CustomerCreateContactPage(driver);
		minValidation.minValidations();

	}

	@Test(priority = 6)
	private void maxValidationPropertyPage() {
		CustomerCreateContactPage maxValidation = new CustomerCreateContactPage(driver);
		maxValidation.maxValidations();

	}

	@Test(priority = 7)
	private void maxValidationEquipmentPage() {
		CustomerCreateContactPage maxValidation = new CustomerCreateContactPage(driver);
		maxValidation.equipmentMaxFieldValidation();

	}

	@Test(priority = 8)
	private void valdationOfAttachmentField() throws AWTException, InterruptedException {
		CustomerCreateContactPage maxValidation = new CustomerCreateContactPage(driver);
		maxValidation.attachmentFiles();

	}

	@Test(priority = 9)
	private void createContact() throws AWTException {
		CustomerCreateContactPage createContact = new CustomerCreateContactPage(driver);

		createContact.validationFormPropertyPage();
		createContact.validationFormEquipmentPage();
		createContact.validationFormContactPage();

	}

	@Test(priority = 11)
	private void listValidation() {
		CustomerCreateContactPage listValidation = new CustomerCreateContactPage(driver);
		listValidation.alphabetsFilters();
		listValidation.searchListName();
		listValidation.searchInvalidListName();

	}

	@Test(priority = 10)
	private void alreadyExistedMail() {
		CustomerCreateContactPage alreadyExisted = new CustomerCreateContactPage(driver);
		alreadyExisted.alreadyExistedEmail();

	}

}
