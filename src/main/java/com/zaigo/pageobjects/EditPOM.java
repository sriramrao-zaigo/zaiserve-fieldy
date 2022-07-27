package com.zaigo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EditPOM {

	WebDriver driver;
	WebDriverWait wait;
	By Email = By.id("login");
	By Pass = By.id("password");
	By Click = By.xpath("//button[@type='submit']");

	By Team = By.id("team-menu");
	By contractor = By.xpath("//div[@id='inner-id']//following::a[text()='Contractor']");

	By ThreeDots = By.xpath("//*[@id=\"fieldy-user-company-contractor-list_aserpttbl\"]/tbody/tr[2]/td[8]/div/div[1]");
	By Edit = By
			.xpath("//*[@id=\"fieldy-user-company-contractor-list_aserpttbl\"]/tbody/tr[2]/td[8]/div/div[2]/ul/li[1]");

	By Name = By.id("name");
	By SaveNext = By.xpath("//button[@data-spinloader='company_contractor_create_edit']");
	By Assertion = By.xpath("//span[text()='Contractor have been updated successfully']");
	By clickNext = By.xpath("//span[text()='Next']");

	public EditPOM(WebDriver driver) {
		this.driver = driver;
	}

	private void setEmail(String email) {
		driver.findElement(Email).sendKeys(email);
	}

	private void setPass(String pass) {
		driver.findElement(Pass).sendKeys(pass);
	}

	private void clickLogin() {
		driver.findElement(Click).click();
	}

	public void login(String UserName, String Password) throws InterruptedException {
		this.setEmail(UserName);
		this.setPass(Password);
		this.clickLogin();
		Thread.sleep(5000);
	}

	private void clickTeam() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Team)).click();
	}

	private void clickContractor() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contractor)).click();
	}

	public void userModule() throws InterruptedException {
		this.clickTeam();
		Thread.sleep(5000);
		this.clickTeam();
		this.clickContractor();

	}

	Actions actions;

	private void clickDots() {
		wait = new WebDriverWait(driver, 10);
		WebElement MOA = wait.until(ExpectedConditions.visibilityOfElementLocated(ThreeDots));
		actions = new Actions(driver);
		actions.moveToElement(MOA).perform();

	}

	private void clickEdit() {
		wait = new WebDriverWait(driver, 10);
		WebElement click = wait.until(ExpectedConditions.visibilityOfElementLocated(Edit));
		actions.moveToElement(click).click().build().perform();

	}

	public void editField() {
		this.clickDots();
		this.clickEdit();

	}

	private void clearName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).clear();

	}

	private void editName(String CompanyName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(CompanyName);

	}

	private void clickSaveNext() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNext));
		actions = new Actions(driver);
		actions.click(until).perform();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(Assertion)).getText();
		Assert.assertEquals(text, "Contractor have been updated successfully");
	}

	public void editNameField(String CompanyName) throws InterruptedException {
		Thread.sleep(2000);
		this.clearName();
		this.editName(CompanyName);
		// this.clickNext();
		this.clickSaveNext();

	}

	By Delete = By
			.xpath("//*[@id=\"fieldy-user-company-contractor-list_aserpttbl\"]/tbody/tr[2]/td[8]/div/div[2]/ul/li[2]");

	By DeleteAssert = By.xpath("//span[text()='Contractor have been deleted successfully']");

	By Yes = By.xpath("//button[text()='Yes']");

	private void clickYes() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Yes)).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(Delete)).getText();
		Assert.assertEquals(text, "Contractor have been deleted successfully");
	}

	private void deleteField() {
		wait = new WebDriverWait(driver, 10);
		WebElement MOA = wait.until(ExpectedConditions.visibilityOfElementLocated(ThreeDots));
		Actions actions = new Actions(driver);
		actions.moveToElement(MOA).perform();
		WebElement click = wait.until(ExpectedConditions.visibilityOfElementLocated(Delete));
		actions.moveToElement(click).click().build().perform();

	}

	public void dltField() {
		this.deleteField();

	}

}
