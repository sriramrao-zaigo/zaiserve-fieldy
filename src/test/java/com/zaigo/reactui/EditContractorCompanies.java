package com.zaigo.reactui;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.EditContractor;
import com.zaigo.pageobjects.EditPOM;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditContractorCompanies {
	WebDriver driver;

	@BeforeClass
	public void beforeLaunching() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://tenant4.zaiportal.com/login/");
	}

	@AfterClass
	public void afterLaunching() {
		driver.quit();
	}

	@Test(priority = 0)
	public void loginPage() throws InterruptedException {
		EditPOM login = new EditPOM(driver);
		login.login("fieldy@zaiportal.com", "Zaiserve@123");
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
