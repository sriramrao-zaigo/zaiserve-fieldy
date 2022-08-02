package com.zaigo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EditUserPage {

	WebDriver driver;
	WebDriverWait wait;

	public EditUserPage(WebDriver driver) {
		this.driver = driver;
	}

	By Email = By.id("login");
	By Pass = By.id("password");
	By Click = By.xpath("//button[@type='submit']");

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

	By Team = By.id("team-menu");
	By User = By.id("team-user-menu");

	private void clickTeam() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Team)).click();
	}

	private void clickUser() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(User)).click();
	}

	public void modules() throws InterruptedException {
		//Thread.sleep(5000);
		this.clickTeam();
		this.clickUser();

	}

	By Dots = By.xpath("//*[@id=\"fieldy-user-user-user-list_aserpttbl\"]/tbody/tr[3]/td[9]");
	By Edit = By.xpath("//*[@id=\"fieldy-user-user-user-list_aserpttbl\"]/tbody/tr[3]/td[9]/div/div[2]/ul/li[2]");
	Actions actions;

	private void mouseActionDots() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(Dots));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).perform();

	}

	private void clickEdit() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(Edit));
		actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();

	}

	public void editField() {
		this.mouseActionDots();
		this.clickEdit();

	}

	By FirstName = By.id("first_name");
	By SaveNext = By.xpath("//button[@data-automationid='save_complete']");
	By SuccessMessage = By.xpath("//span[text()='User information updated successfully']");

	private void clearFirstName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).clear();

	}

	private void updateFirstName(String updateName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(updateName);
	}

	private void clickSaveNext() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNext)).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMessage)).getText();
		Assert.assertEquals(text, "User information updated successfully");

	}

	public void updateField(String updateName) throws InterruptedException {
		Thread.sleep(2000);
		this.clearFirstName();
		this.updateFirstName(updateName);
		this.clickSaveNext();

	}

	By Delete = By.xpath("//*[@id=\"fieldy-user-user-user-list_aserpttbl\"]/tbody/tr[3]/td[9]/div/div[2]/ul/li[3]");
	By Yes = By.xpath("//button[text()='Yes']");
	By DeleteMessage = By.xpath("//span[text()='User have been deleted successfully']");

	private void clickDelete() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Delete)).click();

	}

	private void clickYes() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Yes)).click();

	}

	private void verifyDeleteMessage() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteMessage)).getText();
		Assert.assertEquals(text, "User have been deleted successfully");

	}

	public void deleteField() {
		this.mouseActionDots();
		this.clickDelete();
		this.clickYes();
		this.verifyDeleteMessage();

	}

}
