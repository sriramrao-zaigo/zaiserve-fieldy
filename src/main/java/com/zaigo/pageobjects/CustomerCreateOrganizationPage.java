package com.zaigo.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.base.BaseClass;

public class CustomerCreateOrganizationPage extends BaseClass {
	String ManditoryValidation = "Required Field";
	String Max256CharacterValidation = "Not Allowed More than 256 characters";
	String Min6CharacterValidation = "Atleast 6 digits required";
	String MaxValidationPhoneNumber = "Not Allowed More than 12 digits";
	String ValidEmail = "Enter a valid Email";
	String Max512CharactersValidation = "Not Allowed More than 512 characters";
	String Min3CharacterValidation = "Atleast 3 characters required";
	String Max10CharacterValidation = "Not Allowed More than 10 characters";
	String Max45CharacterValidation = "Not Allowed More than 45 characters";
	String Max2048Validation = "Not Allowed More than 2048 characters";
	String FormatValidationLogo = "Only jpg,jpeg,png Formats Allowed";
	String MaxLogoValidation = "File Size Not Allowed More Than 2 MB";
	String ListInvalid = "No Result Found";
	String MaxSizeLogo = "File Size Not Allowed More Than 2 MB";
	String SaveCompleteButton = "Save & Complete";
	String OrganizationAlreadyExist = "Name Already Exists";
	String EmailAlreadyExisted = "Email Already Exists";

	String characters256 = RandomStringUtils.randomAlphabetic(257);
	String characters512 = RandomStringUtils.randomAlphabetic(513);
	String randomCharacter = RandomStringUtils.randomAlphabetic(6);
	String characters2048 = RandomStringUtils.randomAlphabetic(2049);
	WebDriver driver;
	WebDriverWait wait;

	public CustomerCreateOrganizationPage(WebDriver driver) {
		this.driver = driver;

	}

	private void inputText(By element, String text) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);
	}

	private void clearField(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
	}

	private void clickButton(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	private void mouseActionClick(By element) {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();
	}

	public void assertName(By element, String text) {
		wait = new WebDriverWait(driver, 10);
		String until = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		Assert.assertEquals(until, text);
	}

	private void validationTab(By element, String text) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text, Keys.TAB);
	}

	private void dropDownByIndex(By element, int num) {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Select select = new Select(until);
		select.selectByIndex(num);
	}

	private String getText(By element) {
		wait = new WebDriverWait(driver, 10);
		String until = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		return until;

	}

	By Customer = By.id("customer-main");
	By Organization = By.id("customer-organization-menu");
	By AddOrganization = By.xpath("//button[@data-dropzonereset='customer-form']");
	By OrganizationName = By.id("company_name");
	By OrganizationError = By.id("company_name_error");
	By Website = By.id("website");
	By WebsiteError = By.id("website_error");
	By Address1 = By.id("line_1");
	By Address1Error = By.id("line_1_error");
	By Address2 = By.id("line_2");
	By Address2Error = By.id("line_2_error");
	By City = By.id("city");
	By CityError = By.id("city_error");
	By State = By.id("state");
	By StateError = By.id("state_error");
	By ZipCode = By.id("zipcode");
	By ZipCodeError = By.id("zipcode_error");
	By Email = By.id("email");
	By EmailError = By.id("email_error");
	By LeadSource = By.xpath("//input[@data-dropdownlist='lead-source']");
	By PhoneNumber = By.id("phones__number__0");
	By PhoneNumberError = By.id("phones__number__0_error");
	By SaveComplete = By.id("customerdrop");
	By Next = By.xpath("//button[@data-automationid='next']");
	By Logo = By.xpath("//label[@for='company_logo']");
	By LogoError = By.id("company_logo_error");
	By MaxSizeLogoError = By.xpath("//div[text()='File Size Not Allowed More Than 2 MB']");
	By Heading = By.xpath("//a[@data-goesto='organization-view']");
	By Social = By.id("dropid-367");
	By AlreadyExistsMail = By.xpath("//span[text()='Customer with Company Email already exists']");
	By Yes = By.xpath("//button[text()='Yes']");
	By CreateResponseMessage = By.xpath("//span[text()='Company has been created']");
	By Text = By.xpath("//td[text()='Name']");

	public void modulePage() throws InterruptedException, AWTException {
		this.assertName(Customer, "Customer");
		Thread.sleep(5000);
		this.clickButton(Customer);
		this.assertName(Text, "Name");
		this.clickButton(Organization);
		this.clickButton(AddOrganization);

	}

	public void mandatoryValidation() throws InterruptedException {
		this.assertName(SaveComplete, SaveCompleteButton);
		this.mouseActionClick(SaveComplete);
		this.assertName(OrganizationError, ManditoryValidation);
	}

	public void maxSizeLogoValidation() throws AWTException, InterruptedException {
		this.mouseActionClick(Logo);
		Thread.sleep(1000);
		attachmentFile("dsc00531");
		this.assertName(MaxSizeLogoError, MaxSizeLogo);

	}

	public void formatLogoValidation() throws InterruptedException, AWTException {
		this.assertName(Heading, "Customer / Add Organization");
		Thread.sleep(3000);
		this.mouseActionClick(Logo);
		Thread.sleep(1000);
		attachmentFile("sample-file.pdf");
		this.assertName(LogoError, FormatValidationLogo);

	}

	public void logoFile() throws InterruptedException, AWTException {
		this.mouseActionClick(Logo);
		Thread.sleep(1000);
		attachmentFile("1622641377484");

	}

	public void alreadyExistOrganizationName() {
		this.validationTab(OrganizationName, "q");
		this.assertName(OrganizationError, OrganizationAlreadyExist);
		this.clearField(OrganizationName);
	}

	public void maxValidationOrganization() {
		this.validationTab(OrganizationName, characters256);
		this.assertName(OrganizationError, Max256CharacterValidation);
		this.clearField(OrganizationName);
		this.inputText(OrganizationName, "Organization");

	}

	public void maxValidationWebsite() {
		this.validationTab(Website, characters256);
		this.assertName(WebsiteError, Max256CharacterValidation);
		this.clearField(Website);

	}

	public void maxValidationAddress1Field() {
		this.validationTab(Address1, characters256);
		this.assertName(Address1Error, Max256CharacterValidation);
		this.clearField(Address1);

	}

	public void maxValidationAddress2Field() {
		this.validationTab(Address2, characters256);
		this.assertName(Address2Error, Max256CharacterValidation);
		this.clearField(Address2);

	}

	public void maxValidationCityField() {
		this.validationTab(City, characters256);
		this.assertName(CityError, Max256CharacterValidation);
		this.clearField(City);

	}

	public void maxValidationStateField() {
		this.validationTab(State, characters256);
		this.assertName(StateError, Max45CharacterValidation);
		this.clearField(State);

	}

	public void minValidationZipcodeField() {
		this.validationTab(ZipCode, "12");
		this.assertName(ZipCodeError, Min3CharacterValidation);
		this.clearField(ZipCode);

	}

	public void maxValidationZipcodeField() {
		this.validationTab(ZipCode, "21321312133131313");
		this.assertName(ZipCodeError, Max10CharacterValidation);
		this.clearField(ZipCode);

	}

	public void maxValidationEmailField() {
		this.validationTab(Email, characters256);
		this.assertName(EmailError, Max256CharacterValidation);
		this.clearField(Email);

	}

	public void validEmailField() {
		this.validationTab(Email, "jshdasjdh");
		this.assertName(EmailError, ValidEmail);
		this.clearField(Email);

	}

	public void minValidationPhoneNumberField() {
		this.validationTab(PhoneNumber, "22");
		this.assertName(PhoneNumberError, Min6CharacterValidation);
		this.clearField(PhoneNumber);

	}

	public void maxValidationPhoneNumberField() {
		this.validationTab(PhoneNumber, "231213212133321");
		this.assertName(PhoneNumberError, MaxValidationPhoneNumber);
		this.clearField(PhoneNumber);

	}

	By FirstName = By.id("contacts__first_name__0");
	By LastName = By.id("contacts__last_name__0");
	By ContactEmail = By.id("contacts__email__0");
	By ContactPhoneNumber = By.id("contacts__phone__0");
	By JobTittle = By.id("contacts__job_title__0");
	By AddMoreContact = By.id("add-more-contact-customer-organization");
	By FirstNameError = By.id("contacts__first_name__0_error");
	By LastNameError = By.id("contacts__last_name__0_error");
	By ContactEmailError = By.id("contacts__email__0_error");
	By ContactPhoneNumberError = By.id("contacts__phone__0_error");
	By JobTittleError = By.id("contacts__job_title__0_error");

	public void maxValidationFirstName() {
		this.mouseActionClick(Next);
		this.validationTab(FirstName, characters256);
		this.assertName(FirstNameError, Max256CharacterValidation);
		this.clearField(FirstName);

	}

	public void maxValidationLastName() {
		this.validationTab(LastName, characters256);
		this.assertName(LastNameError, Max256CharacterValidation);
		this.clearField(LastName);

	}

	public void maxValidationContactEmail() {
		this.validationTab(ContactEmail, characters256);
		this.assertName(ContactEmailError, Max256CharacterValidation);
		this.clearField(ContactEmail);

	}

	public void validateContactEmail() {
		this.validationTab(ContactEmail, "hdsjd");
		this.assertName(ContactEmailError, ValidEmail);
		this.clearField(ContactEmail);

	}

	public void minValidationContactPhoneNumber() {
		this.validationTab(ContactPhoneNumber, "12");
		this.assertName(ContactPhoneNumberError, Min6CharacterValidation);
		this.clearField(ContactPhoneNumber);

	}

	public void maxValidationContactPhoneNumber() {
		this.validationTab(ContactPhoneNumber, "456455445664464564646");
		this.assertName(ContactPhoneNumberError, MaxValidationPhoneNumber);
		this.clearField(ContactPhoneNumber);

	}

	public void maxValidationJobTittle() {
		this.validationTab(JobTittle, characters256);
		this.assertName(JobTittleError, Max256CharacterValidation);
		this.clearField(JobTittle);
		this.mouseActionClick(Next);

	}

	By MakethisProperty = By.id("addresses__is_primary__1");
	By PropertyName = By.id("addresses__location_name__1");
	By ContactPersonName = By.id("addresses__name__1");
	By PropertyAddress1 = By.id("addresses__line_1__1");
	By PropertyAddress2 = By.id("addresses__line_2__1");
	By StreetName = By.id("addresses__line_2__1");
	By StateName = By.id("addresses__state__1");
	By CityName = By.id("addresses__city__1");
	By PropertyZipcode = By.id("addresses__zipcode__1");

	By DeleteLocation = By.xpath("//div[@class='accordion-body']//child::div[text()='Delete Property']");
	By AddProperty = By.id("add-more-property-customer-organization");

	By ErrorPropertyName = By.id("addresses__location_name__1_error");
	By ErrorContactPersonName = By.id("addresses__name__1_error");
	By ErrorPropertyAddress1 = By.id("addresses__line_1__1_error");
	By ErrorPropertyAddress2 = By.id("addresses__line_2__1_error");
	By ErrorStreetName = By.id("addresses__line_2__1_error");
	By ErrorStateName = By.id("addresses__state__1_error");
	By ErrorCityName = By.id("addresses__city__1_error");
	By ErrorZipCode = By.id("addresses__zipcode__1_error");

	By Previous = By.xpath("//i[@class='fa fa-chevron-left font-14 pr-2']");

	public void maxValidationPropertyName() {
		this.mouseActionClick(DeleteLocation);
		this.mouseActionClick(AddProperty);
		this.mouseActionClick(MakethisProperty);
		this.validationTab(PropertyName, characters256);
		this.assertName(ErrorPropertyName, Max256CharacterValidation);
		this.clearField(PropertyName);

	}

	public void maxValidationContactPersonName() {
		this.validationTab(ContactPersonName, characters512);
		this.assertName(ErrorContactPersonName, Max512CharactersValidation);
		this.clearField(ContactPersonName);

	}

	public void maxValidationPropertyAddress1() {
		this.validationTab(PropertyAddress1, characters256);
		this.assertName(ErrorPropertyAddress1, Max256CharacterValidation);
		this.clearField(PropertyAddress1);

	}

	public void maxValidationPropertyAddress2() {
		this.validationTab(PropertyAddress2, characters256);
		this.assertName(ErrorPropertyAddress2, Max256CharacterValidation);
		this.clearField(PropertyAddress2);

	}

	public void maxValidationPropertyCityName() {
		this.validationTab(CityName, characters256);
		this.assertName(ErrorCityName, Max256CharacterValidation);
		this.clearField(CityName);

	}

	public void maxValidationPropertyStateName() {
		this.validationTab(StateName, characters256);
		this.assertName(ErrorStateName, Max45CharacterValidation);
		this.clearField(StateName);

	}

	public void minValidationPropertyZipcode() {
		this.validationTab(PropertyZipcode, "23");
		this.assertName(ErrorZipCode, Min3CharacterValidation);
		this.clearField(PropertyZipcode);

	}

	public void maxValidationPropertyZipcode() {
		this.validationTab(PropertyZipcode, "545465646456446454");
		this.assertName(ErrorZipCode, Max10CharacterValidation);
		this.clearField(PropertyZipcode);
		this.mouseActionClick(Next);

	}

	By ProductName = By.id("equipments__product_name__0");
	By ErrorProductName = By.id("equipments__product_name__0_error");
	By BrandName = By.id("equipments__brand_name__0");
	By ErrorBrandName = By.id("equipments__brand_name__0_error");
	By ModelNumber = By.id("equipments__model_number__0");
	By ErrorModelNumber = By.id("equipments__model_number__0_error");
	By SerialNumber = By.id("equipments__serial_number__0");
	By DateInstalled = By.id("equipments__date_installed__0");
	By ErrorSerialNumber = By.id("equipments__serial_number__0_error");
	By WarrantyInformation = By.id("equipments__warrenty_info__0");
	By AccessHours = By.id("equipments__access_hours__0");
	By ErrorAccessHours = By.id("equipments__access_hours__0_error");
	By InstallationNotes = By.id("equipments__installation_notes__0");
	By ErrorInstallationNotes = By.id("equipments__installation_notes__0_error");

	public void maxValidationProductName() {
		this.validationTab(ProductName, characters256);
		this.assertName(ErrorProductName, Max256CharacterValidation);
		this.clearField(ProductName);

	}

	public void maxValidationBrandName() {
		this.validationTab(BrandName, characters256);
		this.assertName(ErrorBrandName, Max256CharacterValidation);
		this.clearField(BrandName);

	}

	public void maxValidationModelNumber() {
		this.validationTab(ModelNumber, characters256);
		this.assertName(ErrorModelNumber, Max256CharacterValidation);
		this.clearField(ModelNumber);

	}

	public void maxValidationSerialNumber() {
		this.validationTab(SerialNumber, characters256);
		this.assertName(ErrorSerialNumber, Max256CharacterValidation);
		this.clearField(SerialNumber);

	}

	public void warrantyInformation() {
		this.dropDownByIndex(WarrantyInformation, 1);

	}

	public void maxValidationAccessHours() {
		this.validationTab(AccessHours, characters256);
		this.assertName(ErrorAccessHours, Max256CharacterValidation);
		this.clearField(AccessHours);

	}

	public void maxValidationInstallationNotes() {
		this.validationTab(InstallationNotes, characters2048);
		this.assertName(ErrorInstallationNotes, Max2048Validation);
		this.clearField(InstallationNotes);
		this.mouseActionClick(Next);

	}

	private void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	By AttachmentFile = By.id("customerDropZone");
	By ErrorAttachmentFile = By.xpath("//div[@class='dropzone-error invalid-feedback']");
	By Delete = By.xpath("(//span[text()='Delete'])[10]");

	public void maxSizeValidationAttachmentFile() throws AWTException, InterruptedException {
		this.mouseActionClick(AttachmentFile);
		Thread.sleep(1000);
		attachmentFile("4889");
		this.assertName(ErrorAttachmentFile, "File is too big (24.67MiB). Max filesize: 20MiB.");

	}

	public void fileFormatValidation() throws InterruptedException, AWTException {
		this.mouseActionClick(AttachmentFile);
		Thread.sleep(1000);
		attachmentFile("kms_portfolio_new1.html");
		this.assertName(ErrorAttachmentFile, "Only JPG/PNG/JPEG files allowed");

	}

	public void maxFileUploadSizeValidation() throws InterruptedException, AWTException {
		for (int i = 1; i < 11; i++) {
			this.mouseActionClick(AttachmentFile);
			Thread.sleep(1000);
			attachmentFile("sample-file.pdf");
			this.scrollDown();
			By AssertionFile = By.xpath("(//span[@class='fieldy-dropzone-title'])[" + i + "]");
			wait = new WebDriverWait(driver, 10);
			String text = wait.until(ExpectedConditions.visibilityOfElementLocated(AssertionFile)).getText();
			Assert.assertEquals(text, "sample-file.pdf");
		}
		this.mouseActionClick(AttachmentFile);
		Thread.sleep(1000);
		attachmentFile("sample-file.pdf");
		this.scrollDown();
		this.assertName(ErrorAttachmentFile, "Maximum upload limit reached");
		for (int i = 1; i < 5; i++) {
			By Delete = By.xpath("(//span[text()='Delete'])[" + i + "]");
			this.mouseActionClick(Delete);
		}
		for (int i = 1; i < 4; i++) {
			this.mouseActionClick(Previous);
		}
	}

	public void organizationPage() throws InterruptedException, AWTException {
		String add = RandomStringUtils.randomAlphanumeric(4);
		String EMail = "Tony" + add + "@gmail.com";
		this.mouseActionClick(Logo);
		Thread.sleep(1000);
		attachmentFile("human-community-five-people-symbol-illustration-web-91578287");
		this.clearField(OrganizationName);
		this.inputText(OrganizationName, "Tony" + add);
		this.inputText(Website, "https://www.zaigoInfotech.com");
		this.inputText(Address1, "12/356");
		this.inputText(Address2, "Sakthi Nagar");
		this.inputText(City, "Chennai");
		this.inputText(State, "TamilNadu");
		this.scrollDown();
		this.inputText(ZipCode, "620001");
		this.inputText(Email, EMail);
		this.mouseActionClick(LeadSource);
		this.mouseActionClick(Social);
		String randomNumeric = RandomStringUtils.randomNumeric(8);
		this.inputText(PhoneNumber, "96" + randomNumeric);
		this.mouseActionClick(SaveComplete);
		this.assertName(CreateResponseMessage, "Company has been created");
		this.assertName(ListFirstName, "Tony" + add);

	}

	public void alreadyExistEmail() throws InterruptedException {
		String text = this.getText(ListEmail);
		this.mouseActionClick(AddOrganization);
		this.inputText(OrganizationName, "jdshjhadjs");
		this.validationTab(Email, text);
		this.scrollDown();
		this.mouseActionClick(Next);
		this.mouseActionClick(Previous);
		this.scrollDown();
		this.mouseActionClick(PhoneNumber);
		this.assertName(EmailError, EmailAlreadyExisted);
		this.mouseActionClick(Heading);
		this.mouseActionClick(Yes);

	}

	public void contactPage() {
		for (int i = 0; i < 6; i++) {
			By FirstName = By.id("contacts__first_name__" + i);
			By LastName = By.id("contacts__last_name__" + i);
			By ContactEmail = By.id("contacts__email__" + i);
			By ContactPhoneNumber = By.id("contacts__phone__" + i);
			By JobTittle = By.id("contacts__job_title__" + i);
			By AddMoreContact = By.id("add-more-contact-customer-organization");
			String num = RandomStringUtils.randomNumeric(3);
			String FName = RandomStringUtils.randomAlphabetic(6);
			String LName = RandomStringUtils.randomAlphabetic(6);
			String PNumber = RandomStringUtils.randomNumeric(10);
			String Tittle = RandomStringUtils.randomAlphabetic(15);
			this.inputText(FirstName, FName);
			this.inputText(LastName, LName);
			this.inputText(ContactEmail, FName + num + "@yahoo.com");
			this.inputText(ContactPhoneNumber, PNumber);
			this.inputText(JobTittle, Tittle);
			this.mouseActionClick(AddMoreContact);
			this.scrollDown();
		}
		this.mouseActionClick(Next);

	}

	public void propertyPage() {
		this.inputText(PropertyName, "Fieldy");
		this.inputText(ContactPersonName, "AjithKumar");
		this.inputText(PropertyAddress1, "256/18");
		this.inputText(PropertyAddress2, "Kumuran Nagar");
		this.inputText(CityName, "Bangalore");
		this.inputText(StateName, "Karnataka");
		this.inputText(PropertyZipcode, "630001");
		this.mouseActionClick(Next);

	}

	public void equipmentPage() {
		String Note = RandomStringUtils.randomAlphabetic(500);
		this.inputText(ProductName, "Sony");
		this.inputText(BrandName, "Sony X10");
		this.inputText(ModelNumber, "HUUSJ656498563121949");
		this.inputText(SerialNumber, "87656453456787978");
		this.inputText(DateInstalled, "09/18/2022");
		this.dropDownByIndex(WarrantyInformation, 1);
		this.inputText(AccessHours, "8hrs");
		this.inputText(InstallationNotes, Note);
		for (int i = 1; i < 4; i++) {
			this.mouseActionClick(Previous);
		}
	}

	By ListFirstName = By.xpath("(//*[@data-n-linkto='customer_organization_timeline'])[3]");
	By Search = By.id("customer-organization-search-box");
	By ListPhoneNumber = By.xpath("(//td[@class='p-2 pt-1 pb-1'])[4]");
	By ListEmail = By.xpath("(//td[@class='p-2 pt-1 pb-1'])[5]");
	By CharacterName = By.xpath("//a[text()='T']");
	By Filter = By.xpath("//span[@data-timeline-open='customerorganization']");
	By LeadSourceCheckBox = By.xpath("(//input[@id='filter-organization-leadSource-checkbox'])[2]");
	By ListLeadSource = By.id("customer-organization-lead-input-place");
	By Status = By.id("customer-contact-status-active");
	By Apply = By.xpath("//button[text()='Apply']");
	By SearchButton = By.id("customer-organization-search-enter");
	By Invalid = By.xpath("//div[text()='No Result Found']");

	public void createListFirstName() {
		String text = this.getText(ListFirstName);
		this.assertName(ListFirstName, text);
	}

	public void searchNameValidation() throws InterruptedException {
		String text = this.getText(ListFirstName);
		this.inputText(Search, text);
		this.mouseActionClick(SearchButton);
		this.assertName(ListFirstName, text);
		this.clearField(Search);

	}

	public void searchPhoneNumberValidation() {
		String text = this.getText(ListPhoneNumber);
		this.inputText(Search, text);
		this.mouseActionClick(SearchButton);
		this.assertName(ListPhoneNumber, text);
		this.clearField(Search);

	}

	public void searchEmailValidation() {
		String text = this.getText(ListEmail);
		this.inputText(Search, text);
		this.mouseActionClick(SearchButton);
		this.assertName(ListEmail, text);
		this.clearField(Search);

	}

	public void searchInvalidValidation() {
		this.inputText(Search, "bdscciuuici");
		this.mouseActionClick(SearchButton);
		this.assertName(Invalid, "No Result Found");

	}

	public void characterListValidation() {
		this.mouseActionClick(CharacterName);
		String text = this.getText(ListFirstName);
		this.assertName(ListFirstName, text);

	}

	public void filterValidation() {
		this.mouseActionClick(Filter);
		this.mouseActionClick(ListLeadSource);
		this.mouseActionClick(LeadSourceCheckBox);
		this.dropDownByIndex(Status, 1);
		this.mouseActionClick(Apply);
		String text = this.getText(ListFirstName);
		this.assertName(ListFirstName, text);

	}

}
