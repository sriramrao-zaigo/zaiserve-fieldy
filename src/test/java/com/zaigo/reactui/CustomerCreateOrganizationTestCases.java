package com.zaigo.reactui;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.CustomerCreateOrganizationPage;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class CustomerCreateOrganizationTestCases {

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

	@Test(priority = -1) // 1-Login
	public void loginPage() throws InterruptedException {
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("fieldy@zaiportal.com", "Zaiserve@123");
		loginInPage.clickLoginButton();
	}

	@Test(priority = 0)
	private void modulePage() throws InterruptedException, AWTException {
		CustomerCreateOrganizationPage modulePage = new CustomerCreateOrganizationPage(driver);
		modulePage.modulePage();

	}

	@Test(priority = 2)
	public void maxSizeValidationLogoField() throws AWTException, InterruptedException {
		CustomerCreateOrganizationPage logoSizeValidation = new CustomerCreateOrganizationPage(driver);
		logoSizeValidation.maxSizeLogoValidation();

	}

	@Test(priority = 1)
	private void formatLogoValidation() throws InterruptedException, AWTException {
		CustomerCreateOrganizationPage formatLogoValidation = new CustomerCreateOrganizationPage(driver);
		formatLogoValidation.formatLogoValidation();

	}

	@Test(priority = 3)
	private void mandatoryValidation() throws InterruptedException {
		CustomerCreateOrganizationPage mandatoryValidation = new CustomerCreateOrganizationPage(driver);
		mandatoryValidation.mandatoryValidation();

	}

	@Test(priority = 4)
	private void organizationNameAlreadyExistValidation() {
		CustomerCreateOrganizationPage alreadyValidation = new CustomerCreateOrganizationPage(driver);
		alreadyValidation.alreadyExistOrganizationName();

	}

	@Test(priority = 5)
	private void maxValidationOrganizationField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationOrganization();

	}

	@Test(priority = 6)
	private void maxValidationWebsiteField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationWebsite();

	}

	@Test(priority = 7)
	private void maxValidationAddress1Field() {
		CustomerCreateOrganizationPage address1Validation = new CustomerCreateOrganizationPage(driver);
		address1Validation.maxValidationAddress1Field();

	}

	@Test(priority = 8)
	private void maxValidationAddress2Field() {
		CustomerCreateOrganizationPage address2Validation = new CustomerCreateOrganizationPage(driver);
		address2Validation.maxValidationAddress2Field();

	}

	@Test(priority = 9)
	private void maxValidationCityField() {
		CustomerCreateOrganizationPage cityValidation = new CustomerCreateOrganizationPage(driver);
		cityValidation.maxValidationCityField();

	}

	@Test(priority = 10)
	private void maxValidationStateField() {
		CustomerCreateOrganizationPage stateValidation = new CustomerCreateOrganizationPage(driver);
		stateValidation.maxValidationStateField();

	}

	@Test(priority = 11)
	private void minValidationZipcodeField() {
		CustomerCreateOrganizationPage minValidation = new CustomerCreateOrganizationPage(driver);
		minValidation.minValidationZipcodeField();

	}

	@Test(priority = 12)
	private void maxValidationZipcodeField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationZipcodeField();

	}

	@Test(priority = 13)
	private void emailValidation() {
		CustomerCreateOrganizationPage emailValidation = new CustomerCreateOrganizationPage(driver);
		emailValidation.validEmailField();

	}

	@Test(priority = 14)
	private void maxValidationEmailField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationEmailField();

	}

	@Test(priority = 15)
	private void minValidationPhoneNumberField() {
		CustomerCreateOrganizationPage minValidation = new CustomerCreateOrganizationPage(driver);
		minValidation.minValidationPhoneNumberField();

	}

	@Test(priority = 16)
	private void maxValidationPhoneNumberField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationPhoneNumberField();

	}

	@Test(priority = 17)
	private void maxValidationContactFirstNameField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationFirstName();

	}

	@Test(priority = 18)
	private void maxValidationContactLastNameField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationLastName();

	}

	@Test(priority = 19)
	private void maxValidationContactEmailField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationContactEmail();

	}

	@Test(priority = 20)
	private void validateContactEmailField() {
		CustomerCreateOrganizationPage validateEmail = new CustomerCreateOrganizationPage(driver);
		validateEmail.validateContactEmail();

	}

	@Test(priority = 21)
	private void minValidationContactPhoneNumberField() {
		CustomerCreateOrganizationPage minValidation = new CustomerCreateOrganizationPage(driver);
		minValidation.minValidationContactPhoneNumber();

	}

	@Test(priority = 22)
	private void maxValidationContactPhoneNumberField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationContactPhoneNumber();

	}

	@Test(priority = 23)
	private void maxValidationJobTittleField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationJobTittle();

	}

	@Test(priority = 24)
	private void maxValidationPropertyNameField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationPropertyName();

	}

	@Test(priority = 25)
	private void maxValidationPropertyContactPersonNameField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationContactPersonName();

	}

	@Test(priority = 26)
	private void maxValidationPropertyAddress1Field() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationPropertyAddress1();

	}

	@Test(priority = 27)
	private void maxValidationPropertyAddress2Field() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationPropertyAddress2();

	}

	@Test(priority = 29)
	private void maxValidationPropertyStateField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationPropertyStateName();

	}

	@Test(priority = 30)
	private void maxValidationPropertyCityField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationPropertyCityName();

	}

	@Test(priority = 31)
	private void minValidationPropertyZipCodeField() {
		CustomerCreateOrganizationPage minValidation = new CustomerCreateOrganizationPage(driver);
		minValidation.minValidationPropertyZipcode();

	}

	@Test(priority = 32)
	private void maxValidationPropertyZipCodeField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationPropertyZipcode();

	}

	@Test(priority = 33)
	private void maxValidationProductNameField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationProductName();

	}

	@Test(priority = 34)
	private void maxValidationBrandNameField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationBrandName();

	}

	@Test(priority = 35)
	private void maxValidationModelNumberField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationModelNumber();

	}

	@Test(priority = 36)
	private void maxValidationSerialNumberField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationSerialNumber();

	}

	@Test(priority = 37)
	private void maxValidationAccessHoursField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationAccessHours();

	}

	@Test(priority = 38)
	private void maxValidationInstallationNotesField() {
		CustomerCreateOrganizationPage maxValidation = new CustomerCreateOrganizationPage(driver);
		maxValidation.maxValidationInstallationNotes();

	}

	@Test(priority = 39)
	private void maxSizeValidationAttachmentField() throws AWTException, InterruptedException {
		CustomerCreateOrganizationPage maxFileValidation = new CustomerCreateOrganizationPage(driver);
		maxFileValidation.maxSizeValidationAttachmentFile();

	}

	@Test(priority = 40)
	private void fileFormatAttachmentField() throws InterruptedException, AWTException {
		CustomerCreateOrganizationPage fileformat = new CustomerCreateOrganizationPage(driver);
		fileformat.fileFormatValidation();
	}

	@Test(priority = 41)
	private void maxFileUploadSizeValidationField() throws AWTException, InterruptedException {
		CustomerCreateOrganizationPage maxFileValidation = new CustomerCreateOrganizationPage(driver);
		maxFileValidation.maxFileUploadSizeValidation();

	}

	@Test(priority = 42)
	private void createOrganization() throws InterruptedException, AWTException {
		CustomerCreateOrganizationPage create = new CustomerCreateOrganizationPage(driver);
		create.contactPage();
		create.propertyPage();
		create.equipmentPage();
		create.organizationPage();

	}

//	@Test(priority = 43)
	private void alreadyExistedEmail() throws InterruptedException {
		CustomerCreateOrganizationPage alreadyEmail = new CustomerCreateOrganizationPage(driver);
		alreadyEmail.alreadyExistEmail();

	}

	@Test(priority = 44)
	private void createOrganizationListFirstName() {
		CustomerCreateOrganizationPage listCreate = new CustomerCreateOrganizationPage(driver);
		listCreate.createListFirstName();

	}

	@Test(priority = 45)
	private void characterListValidation() {
		CustomerCreateOrganizationPage characterList = new CustomerCreateOrganizationPage(driver);
		characterList.characterListValidation();

	}

	@Test(priority = 46)
	private void searchOrganizationNameListValidation() throws InterruptedException {
		CustomerCreateOrganizationPage searchName = new CustomerCreateOrganizationPage(driver);
		searchName.searchNameValidation();

	}

	@Test(priority = 47)
	private void searchPhoneNumberListValidation() {
		CustomerCreateOrganizationPage searchPhone = new CustomerCreateOrganizationPage(driver);
		searchPhone.searchPhoneNumberValidation();

	}

	@Test(priority = 48)
	private void searchEmailListValidation() {
		CustomerCreateOrganizationPage searchEmail = new CustomerCreateOrganizationPage(driver);
		searchEmail.searchEmailValidation();

	}

	@Test(priority = 49)
	private void filterListValidation() {
		CustomerCreateOrganizationPage filter = new CustomerCreateOrganizationPage(driver);
		filter.filterValidation();

	}

	@Test(priority = 50)
	private void searchInvalid() {
		CustomerCreateOrganizationPage invalid = new CustomerCreateOrganizationPage(driver);
		invalid.searchInvalidValidation();

	}

}
