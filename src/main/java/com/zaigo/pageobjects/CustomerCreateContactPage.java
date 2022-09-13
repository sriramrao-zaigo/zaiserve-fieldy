package com.zaigo.pageobjects;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.sql.Savepoint;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.lang.model.element.Element;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.MouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.internal.BaseClassFinder;

import com.base.BaseClass;

public class CustomerCreateContactPage extends BaseClass {

	WebDriverWait wait;
	WebDriver driver;

	String ManditoryValidation = "Required Field";
	String MaxCharacterVaildation = "Not Allowed More than 256 characters";
	String MinValidationPhoneNumber = "Atleast 6 digits required";
	String MaxValidationPhoneNumber = "Not Allowed More than 12 digits";
	String ValidEmail = "Enter a valid Email";
	String MaxCharactersValidation = "Not Allowed More than 512 characters";
	String MinZipCodeValidation = "Atleast 3 characters required";
	String MaxZipCodeValidation = "Not Allowed More than 10 characters";
	String MaxStateNameValidation = "Not Allowed More than 45 characters";
	String MaxInstallationNote = "Not Allowed More than 2048 characters";
	String FormatValidationLogo = "Only jpg,jpeg,png Formats Allowed";
	String MaxLogoValidation = "File Size Not Allowed More Than 2 MB";
	String CreatedMessage = "Customer contact created successfully";
	String EmailAlreadyExisted = "The e-mail is already exit";
	String Invalid = "No Result Found for Contacts";
	String LogoError = "File Size Not Allowed More Than 2 MB";
	String MinValidationZipcode = "Atleast 3 characters required";
	String MaxValidationZipcode = "Not Allowed More than 10 characters";

	public CustomerCreateContactPage(WebDriver driver) {
		this.driver = driver;
	}

	By DashBoard = By.id("customer-main");
	By Today = By.xpath("(//div[@class='mb-2']//parent::div)[4]");
	By Customer = By.id("customer-main");
	By Contact = By.id("customer-contact-menu");
	By AddContact = By.xpath("//button[@data-tabposition='1']");
	By ErrorLogo = By.id("logo_error");
	By AlpbabetM = By.xpath("//*[@data-filteralphacon='M']");
	By Yes = By.xpath("//*[text()='Yes']");
	By ResponseMessage = By.xpath("//span[text()='Customer contact created successfully']");
	By ListName = By.xpath("//*[@class='border-bottom']//a[text()='Manoj Kumar']");
	By Search = By.id("customer-contact-search-value");
	By SearchButton = By.id("customer-contact-search-button");
	By InvalidList = By.xpath("//div[text()='No Result Found for Contacts']");

	private void inputText(By element, String text) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text);

	}

	private void validationCheckingInputText(By element, String text) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(text, Keys.TAB);

	}

	private void clearField(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();

	}

	private void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	private void dashBoard() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(DashBoard)).getText();
		Assert.assertEquals(text, "Customer");

	}

	private void today() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(Today)).getText();
		Assert.assertEquals(text, "Today's List");

	}

	private void clickCustomer() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Customer)).click();

	}

	private void clickContact() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(Contact));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();

	}

	private void mouseClickButton(By element) {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();

	}

	private void clickAddContact() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddContact)).click();

	}

	public void modulePage() throws InterruptedException {

		this.dashBoard();
		Thread.sleep(5000);
		this.clickCustomer();
		this.clickContact();

	}

	By Tittle = By.xpath("//a[@data-exitpopup='customer_contact']");
	By SaveComplete = By.id("customerdrop");
	By ErrorFirstName = By.id("first_name_error");

	private void assertTittle() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(Tittle)).getText();
		Assert.assertEquals(text, "Customer / Add Contact");

	}

	private void clickSaveComplete() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(SaveComplete));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();

	}

	private void errorMessage() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFirstName)).getText();
		Assert.assertEquals(text, ManditoryValidation);

	}

	public void manditoryValidation() throws InterruptedException, AWTException {
		this.clickAddContact();
		this.assertTittle();
		Thread.sleep(5000);
		this.blankFirstName();
		this.errorMessage();
		this.clearFirstName();

	}

	By Virus = By.xpath("//div[@id='dropid-4189']");
	By FirstName = By.id("first_name");
	By MaxErrorFirstName = By.id("first_name_error");
	By LastName = By.id("last_name");
	By MaxErrorLastName = By.id("last_name_error");
	By JobTittle = By.id("job_title");
	By ErrorJobTittle = By.id("job_title_error");
	By Email = By.id("email");
	By ErrorEmail = By.id("email_error");
	By Phone = By.id("phones__number__0");
	By ErrorPhoneNo = By.id("phones__number__0_error");
	By Organization = By.xpath("//input[@placeholder='Choose Organization Name']");
	By New = By.xpath("//button[@data-modalfetch='shorter_organization_create']");
	By Logo = By.xpath("//input[@id='logo']//following::label[@for='logo']");
	By LeadSources = By.xpath("//input[@data-dropdownlist='lead-source']");
	By Social = By.xpath("//div[@id='dropid-367']");

	private void logoFormatValidation() throws AWTException {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(Logo));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();
		attachmentFile(System.getProperty("user.dir" + "\\Validation Files\\png.png"));
	}

	private void firstName(String firstName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(firstName);

	}

	private void blankFirstName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys("    ", Keys.TAB);

	}

	private void maxFirstName() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertFirstName() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorFirstName)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void clearFirstName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).clear();

	}

	private void lastName(String lastName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LastName)).sendKeys(lastName);

	}

	private void maxLastName() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LastName)).sendKeys(maxCharacter, Keys.TAB);
	}

	private void assertLastName() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(MaxErrorLastName)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);
	}

	private void clearLastName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LastName)).clear();

	}

	private void maxJobTittle() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(JobTittle)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertJobTittle() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorJobTittle)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void clearJobTittle() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(JobTittle)).clear();

	}

	private void maxEmail() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertMaxEmail() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorEmail)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void clearEmail() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).clear();

	}

	private void Email(String email) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Email)).sendKeys(email, Keys.TAB);

	}

	private void assertEmail() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorEmail)).getText();
		Assert.assertEquals(text, ValidEmail);

	}

	private void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	private void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

	}

	private void minValidationPhoneNumber() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Phone)).sendKeys("9875", Keys.TAB);

	}

	private void assertMinPhone() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorPhoneNo)).getText();
		Assert.assertEquals(text, MinValidationPhoneNumber);
	}

	private void maxValidationPhoneNumber() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Phone)).sendKeys("98757777888988887788787", Keys.TAB);

	}

	private void assertMaxPhone() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorPhoneNo)).getText();
		Assert.assertEquals(text, MaxValidationPhoneNumber);
	}

	private void clearPhone() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Phone)).clear();

	}

	public void maxValidation() throws AWTException, InterruptedException {
		this.mouseActionClick(Logo);
		this.attachmentFile("dsc00531");
		this.assertName(ErrorLogo, LogoError);
		this.maxFirstName();
		this.assertFirstName();
		this.clearFirstName();
		this.firstName("Ajith");
		this.maxLastName();
		this.assertLastName();
		this.clearLastName();
		this.maxJobTittle();
		this.assertJobTittle();
		this.clearJobTittle();
		this.scrollDown();
		this.maxEmail();
		this.assertMaxEmail();
		this.clearEmail();
		this.maxValidationPhoneNumber();
		this.assertMaxPhone();
		this.clearPhone();
		this.clickNext();

	}

	private void assertName(By element, String Name) {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		Assert.assertEquals(text, Name);

	}

	public void minValidation() throws AWTException {
		this.firstName("Ajith");
		this.scrollDown();
		this.Email("uyguyg");
		this.assertEmail();
		this.clearEmail();
		this.minValidationPhoneNumber();
		this.assertMinPhone();
		this.clearPhone();
		this.clearFirstName();
	}

	By AlreadyEmail = By.xpath("//span[text()='The e-mail is already exit']");
	By Next = By.xpath("//span[text()='Next']");
	By MakethisProperty = By.id("addresses__is_primary__1");
	By PropertyName = By.id("addresses__location_name__1");
	By ContactPersonName = By.id("addresses__name__1");
	By Address1 = By.id("addresses__line_1__1");
	By Address2 = By.id("addresses__line_2__1");
	By StateName = By.id("addresses__state__1");
	By CityName = By.id("addresses__city__1");
	By Zipcode = By.id("addresses__zipcode__1");

	By DeleteLocation = By.xpath("//div[@class='accordion-body']//child::div[text()='Delete Property']");
	By AddProperty = By.xpath(
			"//div[@class='col-lg-6 text-left plus-icon']//child::button[@id='add-more-property-customer-contact']");

	By ErrorPropertyName = By.id("addresses__location_name__1_error");
	By ErrorContactPersonName = By.id("addresses__name__1_error");
	By ErrorAddress1 = By.id("addresses__line_1__1_error");
	By ErrorAddress2 = By.id("addresses__line_2__1_error");
	By ErrorStateName = By.id("addresses__state__1_error");
	By ErrorCityName = By.id("addresses__city__1_error");
	By ErrorZipCode = By.id("addresses__zipcode__1_error");

	By Previous = By.xpath("//i[@class='fa fa-chevron-left font-14 pr-2']");

	private void clickNext() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Next)).click();

	}

	private void clickProperty() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(MakethisProperty));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();

	}

	private void maxValidationPropertyName() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PropertyName)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertPropertyName() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.elementToBeClickable(ErrorPropertyName)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void clearPropertyName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PropertyName)).clear();
	}

	private void maxValidationContactPersonName() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(513);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactPersonName)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertContactPerson() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorContactPersonName)).getText();
		Assert.assertEquals(text, MaxCharactersValidation);

	}

	private void clearContactPerson() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactPersonName)).clear();

	}

	private void maxValidationAddress1() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Address1)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertAddress1() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorAddress1)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void clearAddress1() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Address1)).clear();

	}

	private void maxValidationAddress2() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Address2)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertAddress2() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorAddress2)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void clearAddress2() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Address2)).clear();

	}

	private void maxValidationStateName() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(StateName)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertStateName() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorStateName)).getText();
		Assert.assertEquals(text, MaxStateNameValidation);

	}

	private void clearStateName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(StateName)).clear();

	}

	private void maxValidationCityName() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomAlphabetic(257);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CityName)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertCityName() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorCityName)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void clearCityName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CityName)).clear();

	}

	private void minValidationZipCode() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Zipcode)).sendKeys("33", Keys.TAB);

	}

	private void maxValidationZipCode() {
		wait = new WebDriverWait(driver, 10);
		String maxCharacter = RandomStringUtils.randomNumeric(15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Zipcode)).sendKeys(maxCharacter, Keys.TAB);

	}

	private void assertMinZipCode() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorZipCode)).getText();
		Assert.assertEquals(text, MinZipCodeValidation);

	}

	private void assertMaxZipCode() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorZipCode)).getText();
		Assert.assertEquals(text, MaxZipCodeValidation);

	}

	private void clearZipCode() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Zipcode)).clear();

	}

	private void clickDeleteLocation() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteLocation)).click();

	}

	private void clickAddProperty() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddProperty)).click();

	}

	public void minValidations() {
		this.clickDeleteLocation();
		this.clickAddProperty();
		this.clickProperty();
		this.minValidationZipCode();
		this.assertMinZipCode();
		this.clearZipCode();
	}

	public void maxValidations() {
		this.maxValidationPropertyName();
		this.assertPropertyName();
		this.clearPropertyName();
		this.maxValidationContactPersonName();
		this.assertContactPerson();
		this.clearContactPerson();
		this.maxValidationAddress1();
		this.assertAddress1();
		this.clearAddress1();
		this.maxValidationAddress2();
		this.assertAddress2();
		this.clearAddress2();
		this.maxValidationStateName();
		this.assertStateName();
		this.clearStateName();
		this.maxValidationCityName();
		this.assertCityName();
		this.clearCityName();
		this.maxValidationZipCode();
		this.assertMaxZipCode();
		this.clearZipCode();

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
	String randomAlphabetic = RandomStringUtils.randomAlphabetic(257);
	String num = RandomStringUtils.randomNumeric(3);
	String MinValidationZipPhone = RandomStringUtils.randomNumeric(2);
	String MaxValidationZipPhone = RandomStringUtils.randomNumeric(15);
	String MaxValidationStateName = RandomStringUtils.randomAlphabetic(50);
	String PhoneNumber = RandomStringUtils.randomNumeric(9);

	private void max256Fields(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(randomAlphabetic, Keys.TAB);

	}

	private void max2048Fields(By element) {
		wait = new WebDriverWait(driver, 10);
		String randomAlphabetic2 = RandomStringUtils.randomAlphabetic(2049);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(randomAlphabetic2, Keys.TAB);

	}

	private void min3Fields(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(MinValidationZipPhone, Keys.TAB);

	}

	private void max12Fields(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(MaxValidationZipPhone, Keys.TAB);

	}

	private void error12ErrorMessage(By element) {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		Assert.assertEquals(text, MaxValidationPhoneNumber);

	}

	private void error3ErrorMessage(By element) {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		Assert.assertEquals(text, MinValidationZipPhone);

	}

	private void error256ErrorMessage(By element) {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		Assert.assertEquals(text, MaxCharacterVaildation);

	}

	private void error2048ErrorMessage(By element) {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
		Assert.assertEquals(text, MaxInstallationNote);

	}

	private void clearEquipmentPage(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();

	}

	private void dropDownWarantyInformation() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(WarrantyInformation));
		Select select = new Select(until);
		select.selectByIndex(1);
	}

	public void equipmentMaxFieldValidation() {
		this.clickNext();
		this.max256Fields(ProductName);
		this.error256ErrorMessage(ErrorProductName);
		this.clearEquipmentPage(ProductName);
		this.max256Fields(BrandName);
		this.error256ErrorMessage(ErrorBrandName);
		this.clearEquipmentPage(BrandName);
		this.max256Fields(ModelNumber);
		this.error256ErrorMessage(ErrorModelNumber);
		this.clearEquipmentPage(ModelNumber);
		this.max256Fields(SerialNumber);
		this.error256ErrorMessage(ErrorSerialNumber);
		this.clearEquipmentPage(SerialNumber);
		this.dropDownWarantyInformation();
		this.max256Fields(AccessHours);
		this.error256ErrorMessage(ErrorAccessHours);
		this.clearEquipmentPage(AccessHours);
		this.max2048Fields(InstallationNotes);
		this.error2048ErrorMessage(ErrorInstallationNotes);
		this.clearEquipmentPage(InstallationNotes);
	}

	By AttachmentFile = By.id("customerDropZone");
	By ErrorAttachmentFile = By.xpath("//div[@class='dropzone-error invalid-feedback']");
	By attached = By.className("dropzone-uploads");
//	By AssertionFile = By.xpath("//span[@class='fieldy-dropzone-title']");

	private void attachmentFile(By element) throws AWTException, InterruptedException {
		wait = new WebDriverWait(driver, 20);
		WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element2).click().build().perform();
	}

	private void uploadMaxSizeFile() throws AWTException, InterruptedException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AttachmentFile)).click();
		Thread.sleep(2000);
		attachmentFile("4889");
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorAttachmentFile)).getText();
		Assert.assertEquals(text, "File is too big (24.67MiB). Max filesize: 20MiB.");
	}

	private void ClickButton(By element) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();

	}

	private void mouseActionClick(By element) {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();

	}

	By MaxFile = By.xpath("//div[@class='dropzone-error invalid-feedback']");
	By Delete = By.xpath("(//span[text()='Delete'])[10]");

	private void multipleUpload() throws AWTException, InterruptedException {
		for (int i = 1; i < 11; i++) {
			this.attachmentFile(AttachmentFile);
			Thread.sleep(2000);
			attachmentFile("sample-file.pdf");
			Thread.sleep(1500);
			this.scrollDown();
			By AssertionFile = By.xpath("(//span[@class='fieldy-dropzone-title'])[" + i + "]");
			wait = new WebDriverWait(driver, 10);
			String text = wait.until(ExpectedConditions.visibilityOfElementLocated(AssertionFile)).getText();
			Assert.assertEquals(text, "sample-file.pdf");
			Thread.sleep(1500);

		}
		this.attachmentFile(AttachmentFile);
		Thread.sleep(2000);
		attachmentFile("sample-file.pdf");
		this.scrollDown();
		this.assertName(MaxFile, "Maximum upload limit reached");
		this.mouseActionClick(Delete);
	}

	public void attachmentFiles() throws AWTException, InterruptedException {
		this.clickNext();
		this.uploadMaxSizeFile();
		this.multipleUpload();
		for (int i = 0; i < 2; i++) {
			this.ClickButton(Previous);
		}
//		this.mouseActionClick(Logo);
//		attachmentFile("dsc00531");
//		this.assertName(ErrorLogo, MaxLogoValidation);

	}

	By ImagePreview = By.id("imagePreview");

	public void validationFormContactPage() throws AWTException, InterruptedException {
		for (int i = 0; i < 2; i++) {
			this.ClickButton(Previous);
		}

//		this.assertName(ImagePreview, "pexels-suliman-sallehi-1704488");
		this.clearFirstName();
		this.inputText(FirstName, "Manoj");
		this.inputText(LastName, "Kumar");
		this.inputText(JobTittle, "Replacement&Testing");
		this.ClickButton(LeadSources);
		this.ClickButton(Social);
		this.scrollDown();
		this.inputText(Email, "manoj" + c + "@yahoo.com");
		this.inputText(Phone, "9517418526");
		this.ClickButton(SaveComplete);
		this.assertName(ResponseMessage, CreatedMessage);
		this.assertName(ListName, "Manoj Kumar");
		this.ClickButton(AddContact);
		this.inputText(FirstName, "Ajith");
		this.inputText(Email, "manoj" + c + "@yahoo.com");

	}

	public void validationFormOrganizationContactPage() throws AWTException {
		this.clearFirstName();
		this.inputText(FirstName, "Manoj");
		this.inputText(LastName, "Kumar");
		this.ClickButton(Organization);
		this.ClickButton(Virus);
		this.inputText(JobTittle, "Replacement&Testing");
		this.ClickButton(LeadSources);
		this.ClickButton(Social);
		this.inputText(Email, "yahoo@gmail.com");
		this.inputText(Phone, "9" + PhoneNumber);
		this.clickNext();

	}

	public void validationFormPropertyPage() {
		this.ClickButton(MakethisProperty);
		this.inputText(PropertyName, "Work Location");
		this.inputText(ContactPersonName, "Ravi");
		this.inputText(Address1, "25/825");
		this.inputText(Address2, "Wastern Street");
		this.inputText(StateName, "TamilNadu");
		this.inputText(CityName, "Chennai");
		this.inputText(Zipcode, "624889");
		this.clickNext();

	}

	public void validationFormEquipmentPage() {
		this.inputText(ProductName, "Samsung");
		this.inputText(BrandName, "Neo QLED TVs");
		this.inputText(ModelNumber, "7894562135478789");
		this.inputText(SerialNumber, "8794562155");
		this.inputText(DateInstalled, "08/25/2022");
		this.inputText(AccessHours, "8hrs");
		this.inputText(InstallationNotes, randomAlphabetic);

	}

	public void alphabetsFilters() {
		this.ClickButton(AlpbabetM);
		this.assertName(ListName, "Manoj Kumar");

	}

	public void searchListName() {
		this.inputText(Search, "Manoj");
		this.ClickButton(SearchButton);
		this.assertName(ListName, "Manoj Kumar");
		this.clearField(Search);

	}

	public void searchInvalidListName() {
		this.inputText(Search, "sxrdcftyvghub");
		this.ClickButton(SearchButton);
		this.assertName(InvalidList, Invalid);

	}

	String a = num;
	String b = "1";
	String c = a + b;

	public void alreadyExistedEmail() {
		this.ClickButton(SaveComplete);
		this.assertName(AlreadyEmail, EmailAlreadyExisted);
		this.ClickButton(Tittle);
		this.ClickButton(Yes);
	}

	By AddNew = By.xpath("//div[@class='no-data-found text-break']//child::button");
	By CompanyName = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='company_name']");
	By OrgPhoneNumber = By
			.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='phones__number__0']");
	By OrgEmail = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='email']");
	By OrgWebsite = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='website']");
	By OrgBuilding = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='line_1']");
	By OrgStreet = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='line_2']");
	By OrgState = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='state']");
	By OrgCity = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='city']");
	By OrgZipcode = By.xpath("//form[@id='customer_organization_create_edit']//child::input[@id='zipcode']");
	By ErrorCompanyName = By
			.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='company_name_error']");
	By ErrorPhoneNumber = By
			.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='phones__number__0_error']");
	By ErrorMail = By.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='email_error']");
	By ErrorWebsite = By.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='website_error']");
	By ErrorBuilding = By.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='line_1_error']");
	By ErrorStreet = By.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='line_2_error']");
	By ErrorState = By.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='state_error']");
	By ErrorCity = By.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='city_error']");
	By ErrorZipcode = By.xpath("//form[@id='customer_organization_create_edit']//child::div[@id='zipcode_error']");
	By OrgSaveComplete = By
			.xpath("//div[@class='d-flex row justify-content-between ']//child::button[@id='organization-create']");

	public void validationCreateOrganization() throws InterruptedException {
		this.clickAddContact();
		this.firstName("Arun");
		this.ClickButton(Organization);
		this.inputText(Organization, "Demo");
		this.mouseActionClick(AddNew);
		this.max256Fields(CompanyName);
		this.error256ErrorMessage(ErrorCompanyName);
		this.clearEquipmentPage(CompanyName);
		this.inputText(CompanyName, "Demo");

		this.inputText(OrgPhoneNumber, MinValidationZipPhone);
		this.mouseActionClick(OrgEmail);
		this.assertName(ErrorPhoneNumber, MinValidationPhoneNumber);
		this.clearEquipmentPage(OrgPhoneNumber);

		this.max256Fields(OrgEmail);
		this.error256ErrorMessage(ErrorMail);
		this.clearEquipmentPage(OrgEmail);
		this.inputText(OrgEmail, "Zaigo" + num + "@yahoo.com");

		this.max256Fields(OrgWebsite);
		this.error256ErrorMessage(ErrorWebsite);
		this.clearEquipmentPage(OrgWebsite);

		this.max256Fields(OrgBuilding);
		this.error256ErrorMessage(ErrorBuilding);
		this.clearEquipmentPage(OrgBuilding);

		this.max256Fields(OrgStreet);
		this.error256ErrorMessage(ErrorStreet);
		this.clearEquipmentPage(OrgStreet);

		this.inputText(OrgState, MaxValidationStateName);
		this.mouseActionClick(OrgEmail);
		this.assertName(ErrorState, MaxStateNameValidation);
		this.clearEquipmentPage(OrgState);

		this.max256Fields(OrgCity);
		this.error256ErrorMessage(ErrorCity);
		this.clearEquipmentPage(OrgCity);

		this.inputText(OrgZipcode, MinValidationZipPhone);
		this.mouseActionClick(OrgSaveComplete);
		this.assertName(ErrorZipcode, MinValidationZipcode);
		this.clearEquipmentPage(OrgZipcode);
		this.inputText(OrgZipcode, MaxValidationZipPhone);
		this.mouseActionClick(OrgSaveComplete);
		this.assertName(ErrorZipcode, MaxValidationZipcode);
		this.clearEquipmentPage(OrgZipcode);

	}

	public void createOrganization() throws InterruptedException {
		this.inputText(OrgPhoneNumber, "9876541230");
		this.inputText(OrgWebsite, "https://www.facebook.com");
		this.inputText(OrgBuilding, "12");
		this.inputText(OrgStreet, "SakthiNagar");
		this.inputText(OrgCity, "Chennai");
		this.inputText(OrgZipcode, "620005");
		this.mouseActionClick(OrgSaveComplete);
		Thread.sleep(2000);
		this.assertName(ResponseMessage, CreatedMessage);

	}

	private void mouseAction(By element) {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).perform();

	}

	By Status = By.id("customer-contact-status-active");
	By Filter = By.xpath("//span[@data-timeline-open='customercontact']");
	By Apply = By.xpath("//div[@class='col-lg-4 col-md-4 col-sm-6 col-12 pt-2']//child::button");
	By ListPhoneNumber = By.xpath("(//td[@class='p-2 pt-1 pb-1'])[4]");
	By ListSocial = By.xpath("(//input[@class='mr-3'])[2]");
	By ListLeadSource = By.id("customer-contact-lead-source-search");
	By ListEmail = By.xpath("(//td[@class='p-2 pt-1 pb-1'])[5]");

	private void dropDownByIndex(By element, int num) {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		Select select = new Select(until);
		select.selectByIndex(num);

	}

	private String getText(By element) {
		wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();

	}

	private void filterValidation() {
		this.ClickButton(Filter);

	}

	public void searchListPhoneNumber() {
		String text = this.getText(ListPhoneNumber);
		this.inputText(Search, text);
		this.ClickButton(SearchButton);
		this.assertName(ListPhoneNumber, text);
		this.clearEquipmentPage(Search);

	}

	public void searchMailId() {
		String text = this.getText(ListEmail);
		this.inputText(Search, text);
		this.ClickButton(SearchButton);
		this.clearEquipmentPage(Search);

	}

}
