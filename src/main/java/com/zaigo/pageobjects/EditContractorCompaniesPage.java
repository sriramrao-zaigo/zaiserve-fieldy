package com.zaigo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EditContractorCompaniesPage {

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

	public EditContractorCompaniesPage(WebDriver driver) {
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

	}

	private void clickTeam() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Team)).click();
	}

	private void clickContractor() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contractor)).click();
	}

	By Dashboard = By.xpath("//div[@data-menuselector='dashboard-menu']");

	private void assertDashboard() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard)).getText();
		Assert.assertEquals(text, "Dashboard");

	}

	public void userModule() throws InterruptedException {
//		this.clickTeam();
//		Thread.sleep(5000);
		this.assertDashboard();
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

	private void visibleName() {
		wait = new WebDriverWait(driver, 10);
		String attribute = wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).getAttribute("value");
		wait.until(ExpectedConditions.textToBePresentInElementLocated(Name, attribute));
	}

	private void editName(String CompanyName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).sendKeys(CompanyName);

	}

	private void clickSaveNext() {
		wait = new WebDriverWait(driver, 10);
		String until = wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNext)).getText();
		Assert.assertEquals(until, "Save & Complete");
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNext)).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(Assertion)).getText();
		Assert.assertEquals(text, "Contractor have been updated successfully");

	}

	public void editNameField(String CompanyName) throws InterruptedException {
		Thread.sleep(2000);
		// this.visibleName();
		this.clearName();
		this.editName(CompanyName);
		this.clickSaveNext();

	}

	By attributeValue = By.xpath("//*[@id=\"contact_person_name\"]");

	private void attributeData() {
		wait = new WebDriverWait(driver, 10);
		String attribute = wait.until(ExpectedConditions.visibilityOfElementLocated(attributeValue))
				.getAttribute("value");
		System.out.println(attribute);
		Assert.assertEquals(attribute, attribute);

	}

	By Delete = By
			.xpath("//*[@id='fieldy-user-company-contractor-list_aserpttbl']/tbody/tr[2]/td[8]/div/div[2]/ul/li[2]");

	By DeleteAssert = By.xpath("//span[text()='Contractor have been deleted successfully']");

	By Yes = By.xpath("//button[text()='Yes']");
	By Value = By.xpath("//*[@id=\"modal-confirmation-popup\"]/div/div/div/div/h4");
	By firstName = By.xpath("//td[text()='Company']");

	private void clickYes() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Yes)).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteAssert)).getText();
		Assert.assertEquals(text, "Contractor have been deleted successfully");
		String texts = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).getText();
		Assert.assertEquals(texts, "Company");
	}

	By Deletes = By.xpath("(//i[@class='fa fa-ellipsis-v'])[2]");

	private void deleteField() {
		wait = new WebDriverWait(driver, 10);
		WebElement MOA = wait.until(ExpectedConditions.visibilityOfElementLocated(ThreeDots));
		Actions actions = new Actions(driver);
		actions.moveToElement(MOA).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Delete)).click();

	}

	public void dltField() {
		// Thread.sleep(2000);
		this.deleteField();
		this.clickYes();
	}

}
