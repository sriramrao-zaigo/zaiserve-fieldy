package com.test;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.pom.Field_Page_Automation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Fieldy_Project {
	WebDriver driver;

//	@BeforeClass
//	public void beforeLaunching() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://tenant4.zaiportal.com/login/");
//	}
//
//	@AfterClass
//	public void afterLaunching() {
//		driver.quit();
//	}
//
	@Test(priority = 1) // 1-Login
	public void loginPage() throws InterruptedException {
		Field_Page_Automation login = new Field_Page_Automation(driver);
		login.loginFieldy("fieldy@zaiportal.com", "Zaiserve@123");
	}
//
	@Test(priority = 2) // 2-Module
	public void modulePage() throws InterruptedException {
		Field_Page_Automation modules = new Field_Page_Automation(driver);
		modules.enterTeamModule();
	}

	@Test(priority = 3) // 3ReqField User
	public void reqFieldUser() throws InterruptedException, AWTException {
		Field_Page_Automation reqField = new Field_Page_Automation(driver);
		reqField.reqField();

	}

	@Test(priority = 4) // 4-ReqField Contractor
	public void conReqField() throws InterruptedException, AWTException {
		Field_Page_Automation conReqField = new Field_Page_Automation(driver);
		conReqField.conReqField();

	}

	@Test(priority = 5) // 5-ReqField organization
	public void reqOrganization() throws InterruptedException {
		Field_Page_Automation reqOrganization = new Field_Page_Automation(driver);
		reqOrganization.reqOrganization("Kumar", "kumar@zaigoinfotech.com");
	}

	@Test(priority = 6)
	public void manditoryField() throws InterruptedException {
		Field_Page_Automation manditoryField = new Field_Page_Automation(driver);
		manditoryField.manditoryDatas("Prem", "prem@zaigoinfotech.com");

	}

	@Test(priority = 7)
	public void inputUserLocationFieldReq() throws IOException, InterruptedException {
		Field_Page_Automation inputLocationFieldReq = new Field_Page_Automation(driver);
		inputLocationFieldReq.inputUserLocationFieldReqs();

	}

	@Test(priority = 8)
	private void conManditoryField() throws InterruptedException {
		Field_Page_Automation conManditoryField = new Field_Page_Automation(driver);
		conManditoryField.conOrganization("Kumar", "kumar@gmail.com");

	}

	@Test(priority = 9)
	private void inputContractorLocationFieldReq() throws IOException, InterruptedException {
		Field_Page_Automation conLocationField = new Field_Page_Automation(driver);
		conLocationField.inputConLocatioFieldReq();

	}

	@Test(priority = 10)
	public void UserModule() throws InterruptedException, AWTException {
		Field_Page_Automation data = new Field_Page_Automation(driver);
		data.datas("Ajith", "Kumar", "Testing", "ajith@zaigoinfotech.com", "9876543210", "Chennai", "100",
				"Sakthinagar", "TamilNadu", "Egmore", "600084");
	}

	@Test(priority = 11)
	public void conDatas() throws InterruptedException, AWTException {
		Field_Page_Automation conDataReqOrganization = new Field_Page_Automation(driver);
		conDataReqOrganization.conDataReqOrganization("Prem", "Kumar", "Prem@zaigoinfotech.com", "8765432190",
				"Coimbatore", "200", "Cavery Nagar", "TamilNadu", "Main City", "630098");
	}

	@Test(priority = 12)
	public void alreadyExistData() throws InterruptedException {
		Field_Page_Automation existData = new Field_Page_Automation(driver);
		existData.existingData("Ajith", "Kumar", "Testing", "ajith@zaigoinfotech.com", "9876543210");

	}

	@Test(priority = 13)
	public void contractExistingData() throws InterruptedException {
		Field_Page_Automation contractExistingData = new Field_Page_Automation(driver);
		contractExistingData.conExistingDatas("Prem", "Kumar", "Prem@zaigoinfotech.com", "8765432190");

	}

}
