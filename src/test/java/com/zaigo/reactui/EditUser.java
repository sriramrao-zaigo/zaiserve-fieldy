package com.zaigo.reactui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zaigo.pageobjects.EditUserPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditUser {
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

	@Test(priority = 1)
	public void login() throws InterruptedException {
		EditUserPage login = new EditUserPage(driver);
		login.login("fieldy@zaiportal.com", "Zaiserve@123");

	}

	@Test(priority = 2)
	public void modulePage() throws InterruptedException {
		EditUserPage module = new EditUserPage(driver);
		module.modules();

	}

	@Test(priority = 3)
	public void editFunctionality() {
		EditUserPage edit = new EditUserPage(driver);
		edit.editField();
	}

	@Test(priority = 4)
	public void updateContent() throws InterruptedException {
		EditUserPage update = new EditUserPage(driver);
		update.updateField("Kumar");
	}

	@Test(priority = 5)
	public void deleteList() {
		EditUserPage delete = new EditUserPage(driver);
		delete.deleteField();
	}

}
