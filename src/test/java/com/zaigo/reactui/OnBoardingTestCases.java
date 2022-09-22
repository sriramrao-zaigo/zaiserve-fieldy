package com.zaigo.reactui;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.pageobjects.OnBoardingPage;
import com.zaigo.utility.BrowserSetup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnBoardingTestCases {

	private WebDriver driver = null;
	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest extentTest;

	@BeforeClass
	public void setup() {
		this.driver = BrowserSetup.startBrowser();

	}

	@AfterClass
	public void exitBrowser() {
		this.driver.quit();
	}

	@Test(priority = 0)
	public void login() throws MalformedURLException, IOException {
		OnBoardingPage boardingPage = new OnBoardingPage(driver);
		boardingPage.login();
	}

	@Test(priority = 1)
	public void mandatoryFieldValidation() {
		OnBoardingPage mandatory = new OnBoardingPage(driver);
		mandatory.mandatoryValidation();

	}

	@Test(priority = 3)
	public void maximumValidationBussinessName() {
		OnBoardingPage maxValidation = new OnBoardingPage(driver);
		maxValidation.maximumValidationBussinessName();
	}

	@Test(priority = 2)
	private void alreadyBussinessNameValidation() {
		OnBoardingPage alreadyBussiness = new OnBoardingPage(driver);
		alreadyBussiness.alreadyBussinessName();

	}

	@Test(priority = 4)
	private void maximumValidationBussinessWebSite() throws IOException {
		OnBoardingPage maxValidation = new OnBoardingPage(driver);
		maxValidation.maximumValidationBussinessWebSite();
	}

	@Test(priority = 5)
	private void maximumValidationFirstName() throws IOException {
		OnBoardingPage maxValidation = new OnBoardingPage(driver);
		maxValidation.maximumValidationFirstName();

	}

	@Test(priority = 6)
	private void maximumValidationLastName() throws IOException {
		OnBoardingPage maxValidation = new OnBoardingPage(driver);
		maxValidation.maximumValidationLastName();

	}

	@Test(priority = 7)
	private void maximumValidationEmail() throws IOException {
		OnBoardingPage maxValidation = new OnBoardingPage(driver);
		maxValidation.maximumValidationEmail();

	}

	@Test(priority = 8)
	private void validateEmailFormat() {
		OnBoardingPage validEmail = new OnBoardingPage(driver);
		validEmail.validationEmail();

	}

	@Test(priority = 9)
	private void existingEmailValidation() {
		OnBoardingPage existing = new OnBoardingPage(driver);
		existing.alreadyExistValidation();

	}

	@Test(priority = 10)
	private void correctValidationEmail() {
		OnBoardingPage validation = new OnBoardingPage(driver);
		validation.validEmail();

	}

	@Test(priority = 11)
	private void validateRadioButtonClickable() {
		OnBoardingPage radioButton = new OnBoardingPage(driver);
		radioButton.industryRadioButton();

	}

	@Test(priority = 12)
	private void industryTypeFieldPresent() {
		OnBoardingPage fieldPresent = new OnBoardingPage(driver);
		fieldPresent.industryTypeFieldPresent();

	}

	@Test(priority = 13)
	private void maximumValidationIndustryField() {
		OnBoardingPage industryValidation = new OnBoardingPage(driver);
		industryValidation.maximumValidationIndustryField();

	}

	@Test(priority = 14)
	private void sizeCompanyValidation() {
		OnBoardingPage sizeCompany = new OnBoardingPage(driver);
		sizeCompany.sizeCompany();

	}

	@Test(priority = 15)
	private void validationRadioButtonIntrested() {
		OnBoardingPage radioButton = new OnBoardingPage(driver);
		radioButton.radioButtonCurrent();

	}

	@Test(priority = 16)
	private void passwordMandatoryField() {
		OnBoardingPage mandatory = new OnBoardingPage(driver);
		mandatory.passwordFieldMandatory();

	}

	@Test(priority = 17)
	private void minValidationPassword() {
		OnBoardingPage minValidation = new OnBoardingPage(driver);
		minValidation.minimumValidationPassword();

	}

	@Test(priority = 18)
	private void minValidationConfirmPassword() {
		OnBoardingPage minValidation = new OnBoardingPage(driver);
		minValidation.minimumValidationConfirmPassword();

	}

	@Test(priority = 19)
	private void passwordFieldConditions() {
		OnBoardingPage condition = new OnBoardingPage(driver);
		condition.passwordFieldCondition();
	}

	@Test(priority = 20)
	private void confirmPasswordFieldCondition() {
		OnBoardingPage condition = new OnBoardingPage(driver);
		condition.confirmPasswordFieldCondition();

	}

	@Test(priority = 21)
	private void lowerCaseValidation() {
		OnBoardingPage lowerCaseValidation = new OnBoardingPage(driver);
		lowerCaseValidation.lowercaseValidation();

	}

	@Test(priority = 22)
	private void mismatchPassword() {
		OnBoardingPage mismatchPassword = new OnBoardingPage(driver);
		mismatchPassword.mismatchPasswordValidation();
	}

}
