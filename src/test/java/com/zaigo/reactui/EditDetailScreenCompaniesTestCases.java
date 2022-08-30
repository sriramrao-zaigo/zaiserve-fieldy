package com.zaigo.reactui;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.EditDetailScreenCompaniesPage;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

public class EditDetailScreenCompaniesTestCases {

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
	public void teamModule() throws InterruptedException {
		EditDetailScreenCompaniesPage module = new EditDetailScreenCompaniesPage(driver);
		module.modulePage();

	}

	@Test(priority = 2)
	public void edit() throws InterruptedException {
		EditDetailScreenCompaniesPage edit = new EditDetailScreenCompaniesPage(driver);
		edit.editContent();
	}

	@Test(priority = 3)
	private void addLocation() {
		EditDetailScreenCompaniesPage add = new EditDetailScreenCompaniesPage(driver);
		String alpha = RandomStringUtils.randomAlphabetic(6);
		String number = RandomStringUtils.randomNumeric(6);
		String alph = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(10);
		add.addLocation(alpha, alpha + "@" + alph + "." + alph, alpha, num, alpha, alpha, alpha, alpha, number);
	}

	@Test(priority = 4)
	private void deleteLocation() {
		EditDetailScreenCompaniesPage delete = new EditDetailScreenCompaniesPage(driver);
		delete.deleteLocation();
	}

}
