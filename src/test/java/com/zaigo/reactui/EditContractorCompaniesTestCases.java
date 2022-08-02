package com.zaigo.reactui;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.EditContractor;
import com.zaigo.pageobjects.EditPOM;
import com.zaigo.pageobjects.LoginPage;
import com.zaigo.utility.BrowserSetup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditContractorCompaniesTestCases {
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
	public void userModuleField() throws InterruptedException {
		EditPOM userModuleField = new EditPOM(driver);
		userModuleField.userModule();

	}

	@Test(priority = 3)
	public void editField() {
		EditPOM edit = new EditPOM(driver);
		edit.editField();

	}

	@Test(priority = 4)
	public void editName() throws InterruptedException {
		EditPOM edit = new EditPOM(driver);
		String alphabetics = RandomStringUtils.randomAlphabetic(7);
		edit.editNameField(alphabetics);

	}

	@Test(priority = 5)
	public void deleteField() {
		EditPOM delete = new EditPOM(driver);
		delete.dltField();
	}

}
