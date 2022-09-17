package com.zaigo.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OnBoardingPage {

	WebDriver driver;
	WebDriverWait wait;

	String MandatoryErrorMessage = "Required Field";
	String PasswordCondition = "Password must have one lower case letter and one upper case letter and one number";
	String MinimumValidatioPassword = "Enter minimum 8 characters";
	String MisMatchPassword = "Confirm password should match with new password";
	String Max2048Validation = "Not Allowed More than 2048 characters";
	String Max256CharacterValidation = "Not Allowed More than 256 characters";
	String ValidEmail = "Enter a valid Email";
	String BussinessNameAlready = "Business Name Already Exists";
	String AlreadyExistedEmail = "Email Already Exists";
	String IndustryMaxValidation = "Not Allowed More than 64 characters";

	String characters256 = RandomStringUtils.randomAlphabetic(257);
	String randomCharacter = RandomStringUtils.randomAlphabetic(6);
	String characters2048 = RandomStringUtils.randomAlphabetic(2049);

	public OnBoardingPage(WebDriver driver) {
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
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

	By LandingHeading = By.xpath("//h2[text()='Great to meet you!']");
	By CompanyName = By.id("company_name");
	By BussinessWebSite = By.id("company_website");
	By FirstName = By.id("first_name");
	By LastName = By.id("last_name");
	By Email = By.id("email");
	By MyBussinessType = By.className("business");
	By IndustryField = By.xpath("//h3[text()='Mention your industry information']");
	By Continue = By.id("submit-btn");
	By ChooseIndustry = By.xpath("//input[@value='Heating & Air Conditioning']");
	By Industry = By.id("industry");
	By IndustryError = By.id("industry_error");
	By NextLandingPage = By.xpath("//h2[text()='What Industry are you in?']");
	By CompanySize = By.xpath("(//div[@class='floating-form meeting']//h2)[3]");
	By CompanyEmployee = By.id("empdiv1");

	By RadioButton = By.xpath("//input[@onclick='mustIntrestedCheckBox()']");

	By IntersetedToday = By.xpath("//h2[text()='Which Solution are you most interested in today?']");
	By PasswordHeading = By.xpath("//h2[text()='Enter Your Password']");
	By Password = By.id("password");
	By ConfirmPassword = By.id("password_confirmation");

	By PasswordError = By.id("password_error");
	By ConfirmPasswordError = By.id("password_confirmation_error");
	By Back = By.id("onboarding-back-btn");

	By CompanyError = By.id("company_name_error");
	By BussinessWebsiteError = By.id("company_website_error");
	By FirstNameError = By.id("first_name_error");
	By lastNameError = By.id("last_name_error");
	By EmailError = By.id("email_error");

	public void login() {
		driver.get("http://zaiportal.com/public/Onbording/meet.html");
		this.assertName(LandingHeading, "Great to meet you!");
	}

	public void mandatoryValidation() {
		this.inputText(BussinessWebSite, "sadjh");
		this.assertName(Continue, "Continue");
		this.mouseActionClick(Continue);
		this.assertName(CompanyError, MandatoryErrorMessage);
		this.assertName(EmailError, MandatoryErrorMessage);

	}

	public void maximumValidationBussinessName() {
		this.inputText(CompanyName, characters256);
		this.mouseActionClick(Continue);
		this.assertName(CompanyError, Max256CharacterValidation);
		this.clearField(CompanyName);
		this.inputText(CompanyName, randomCharacter);
	}

	public void alreadyBussinessName() {
		this.validationTab(CompanyName, "Zaigo Infotech Tech Software Solution");
		this.assertName(CompanyError, BussinessNameAlready);
		this.clearField(CompanyName);

	}

	public void maximumValidationBussinessWebSite() {
		this.inputText(BussinessWebSite, characters2048);
		this.mouseActionClick(Continue);
		this.assertName(BussinessWebsiteError, Max2048Validation);
		this.clearField(BussinessWebSite);
	}

	public void maximumValidationFirstName() {
		this.inputText(FirstName, characters256);
		this.mouseActionClick(Continue);
		this.assertName(FirstNameError, Max256CharacterValidation);
		this.clearField(FirstName);

	}

	public void maximumValidationLastName() {
		this.validationTab(LastName, characters256);
		this.assertName(lastNameError, Max256CharacterValidation);
		this.clearField(LastName);

	}

	public void maximumValidationEmail() {
		this.inputText(Email, characters256);
		this.mouseActionClick(Continue);
		this.assertName(EmailError, Max256CharacterValidation);
		this.clearField(Email);

	}

	public void validationEmail() {
		this.inputText(Email, randomCharacter);
		this.mouseActionClick(Continue);
		this.assertName(EmailError, ValidEmail);
		this.clearField(Email);
	}

	public void alreadyExistValidation() {
		this.validationTab(Email, "Hari@yahoo.com");
		this.assertName(EmailError, AlreadyExistedEmail);
		this.clearField(Email);

	}

	public void validEmail() {
		String Start = RandomStringUtils.randomNumeric(3);
		this.inputText(Email, "Hari" + Start + "@gmail.com");
		this.mouseActionClick(Continue);
		this.mouseActionClick(Continue);
		this.assertName(NextLandingPage, "What Industry are you in?");

	}

	public void industryRadioButton() {
		for (int i = 1; i < 54; i++) {
			By xpath = By.xpath("(//input[@name='industryname'])[" + i + "]");
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(xpath)).click();
		}
	}

	public void industryTypeFieldPresent() {
		this.mouseActionClick(MyBussinessType);
		this.assertName(IndustryField, "Mention your industry information");

	}

	public void maximumValidationIndustryField() {
		this.validationTab(Industry, characters256);
		this.assertName(IndustryError, IndustryMaxValidation);
		this.clearField(Industry);
		this.mouseActionClick(Continue);

	}

	public void sizeCompany() {
		this.assertName(Continue, "Continue");
		for (int i = 1; i < 4; i++) {
			By xpath = By.id("empdiv" + i);
			wait = new WebDriverWait(driver, 10);
			WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(until).click().build().perform();
			String text = until.getText();
			Assert.assertEquals(text, text);
		}
		this.mouseActionClick(Continue);

	}

	public void radioButtonCurrent() {
		this.assertName(IntersetedToday, "Which Solution are you most interested in today?");
		for (int i = 1; i < 7; i++) {
			By xpath = By.xpath("(//input[@name='mostInrested'])[" + i + "]");
			wait = new WebDriverWait(driver, 10);
			WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(until).click().build().perform();
		}
		this.assertName(Continue, "Continue");
		this.mouseActionClick(Continue);
	}

	public void passwordFieldMandatory() {
		this.assertName(PasswordHeading, "Enter Your Password");
		this.assertName(Continue, "Continue");
		this.mouseActionClick(Continue);
		this.assertName(PasswordError, MandatoryErrorMessage);
		this.assertName(ConfirmPasswordError, MandatoryErrorMessage);

	}

	public void minimumValidationPassword() {
		this.validationTab(Password, "356");
		this.assertName(PasswordError, MinimumValidatioPassword);
		this.clearField(Password);
	}

	public void minimumValidationConfirmPassword() {
		this.validationTab(ConfirmPassword, "356");
		this.assertName(ConfirmPasswordError, MinimumValidatioPassword);
		this.clearField(ConfirmPassword);
	}

	public void passwordFieldCondition() {
		this.validationTab(Password, "63247456524545745");
		this.assertName(PasswordError, PasswordCondition);
		this.clearField(Password);

	}

	public void confirmPasswordFieldCondition() {
		this.validationTab(ConfirmPassword, "63247456524545745");
		this.assertName(ConfirmPasswordError, PasswordCondition);
		this.clearField(ConfirmPassword);

	}

	public void lowercaseValidation() {
		this.inputText(Password, "Hari@1997");
		this.inputText(ConfirmPassword, "hari@1997");
		this.mouseActionClick(Continue);
		this.assertName(ConfirmPasswordError, PasswordCondition);

	}
	
	public void mismatchPasswordValidation() {
		this.inputText(ConfirmPassword, "Mhari@1997");
		this.mouseActionClick(Continue);
		this.assertName(ConfirmPasswordError, MisMatchPassword);

	}

}
