package com.zaigo.reactui;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.zaigo.pageobjects.CreateUserPage;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateUserTestCases {

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

	@Test(priority = 1) // 1-Login
	public void loginPage() throws InterruptedException {
		LoginPage loginInPage = new LoginPage(this.driver);
		loginInPage.setUserCredentials("fieldy@zaiportal.com", "Zaiserve@123");
		loginInPage.clickLoginButton();
	}

	@Test(priority = 2) // 2-Module
	public void modulePage() throws InterruptedException {
		CreateUserPage modules = new CreateUserPage(driver);
		modules.enterTeamModule();
	}

	@Test(priority = 3) // 3ReqField User
	public void reqFieldUser() throws InterruptedException, AWTException {
		CreateUserPage reqField = new CreateUserPage(driver);
		reqField.reqField();

	}

	@Test(priority = 4) // 4-ReqField Contractor
	public void conReqField() throws InterruptedException, AWTException {
		CreateUserPage conReqField = new CreateUserPage(driver);
		conReqField.conReqField();

	}

	@Test(priority = 5) // 5-ReqField organization
	public void reqOrganization() throws InterruptedException {
		CreateUserPage reqOrganization = new CreateUserPage(driver);
		reqOrganization.reqOrganization("Kumar", "kumar@zaigoinfotech.com");
	}

	@Test(priority = 6)
	public void manditoryField() throws InterruptedException {
		CreateUserPage manditoryField = new CreateUserPage(driver);
		manditoryField.manditoryDatas("Prem", "prem@zaigoingotech.com");

	}

	@Test(priority = 7)
	public void inputUserLocationFieldReq() throws IOException, InterruptedException {
		CreateUserPage inputLocationFieldReq = new CreateUserPage(driver);
		inputLocationFieldReq.inputUserLocationFieldReqs();

	}

	@Test(priority = 8)
	private void conManditoryField() throws InterruptedException {
		CreateUserPage conManditoryField = new CreateUserPage(driver);
		conManditoryField.conOrganization("Ram", "ram@gmail.com");

	}

	@Test(priority = 9)
	private void inputContractorLocationFieldReq() throws IOException, InterruptedException {
		CreateUserPage conLocationField = new CreateUserPage(driver);
		conLocationField.inputConLocatioFieldReq();

	}

	@Test(priority = 10)
	public void UserModule() throws InterruptedException, AWTException {
		CreateUserPage data = new CreateUserPage(driver);
		data.datas("Ajith", "Kumar", "Testing", "ajith@zaigoinfotech.com", "9876543210", "Chennai", "100",
				"Sakthinagar", "TamilNadu", "Egmore", "600084");
	}

	@Test(priority = 11)
	public void listValidate() {
		CreateUserPage listValidate = new CreateUserPage(driver);
		listValidate.verifyNameList();

	}

	@Test(priority = 12)
	public void searchValidate() {
		CreateUserPage searchValidate = new CreateUserPage(driver);
		searchValidate.validationList("Ajith");
	}

	@Test(priority = 13)
	public void invalidSearch() {
		CreateUserPage invalidSearch = new CreateUserPage(driver);
		invalidSearch.invalidData("afhwuifhe");
	}

	@Test(priority = 14)
	public void conDatas() throws InterruptedException, AWTException {
		CreateUserPage conDataReqOrganization = new CreateUserPage(driver);
		conDataReqOrganization.conDataReqOrganization("Prem", "Kumar", "Prem@zaigoingotech.com", "8765432190",
				"Coimbatore", "200", "Cavery Nagar", "TamilNadu", "Main City", "630098");
	}

	@Test(priority = 15)
	public void alreadyExistData() throws InterruptedException, IOException {
		CreateUserPage existData = new CreateUserPage(driver);
		existData.existingData("Ajith", "Kumar", "Testing", "ajith@zaigoinfotech.com", "9876543210");
	}

	@Test(priority = 16)
	public void contractExistingData() throws InterruptedException {
		CreateUserPage contractExistingData = new CreateUserPage(driver);
		contractExistingData.conExistingDatas("Prem", "Kumar", "Prem@zaigoingotech.com", "8765432190");
		contractExistingData.deleteField();
		contractExistingData.deleteConField();

	}

}
