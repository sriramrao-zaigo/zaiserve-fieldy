package com.zaigo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;

	private By username_by = By.id("login");
	private By username_error_by = By.id("login-email-error");
	private By password_by = By.id("password");
	private By password_error = By.id("login-password-error");
	private By form_title_css = By.tagName("h5");
	private By login_button = By.tagName("button");
//	private By forgot_password = By.linkText("Forgot Password");
	private By lockpopup=By.xpath("//*[contains(text(), 'Your account is locked due to 3 failed login attempts. Lock will be released in 60 seconds.')]");
	private By lockpopuptwo =By.xpath("//*[contains(text(),'Your account is locked. Please contact admin.')]");
	private By dashboard =By.xpath("//span[text()='Dashboard']");
	private By multiaccount = By.xpath("//h4[contains(text(),'Fieldy Tenant 2')]");
	
	
	
	public LoginPage(WebDriver driver)  {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
		String APP_URL=null;

		if(APP_URL == null) {
			APP_URL = "http://tenant1.zaisuite.com/";
		}
		driver.get(APP_URL);
	}
	
	public String dashBoardText() {
		wait.until(ExpectedConditions.elementToBeClickable((dashboard)));
		return driver.findElement(dashboard).getText();
	}
	
	
	
	public String toastText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((lockpopup)));
		return driver.findElement(lockpopup).getText();
	}
	
	
	public String toastTextTwo() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((lockpopuptwo)));
		return driver.findElement(lockpopuptwo).getText();
	}
	
	
	
	
	
	public void passwordField(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((password_by)));
		driver.findElement(password_by).clear();
		driver.findElement(password_by).sendKeys(password);
	}
	
	public void userField(String user) {
		wait.until(ExpectedConditions.visibilityOfElementLocated((username_by)));
		driver.findElement(username_by).clear();
		driver.findElement(username_by).sendKeys(user);
	}
	
	

	public String buttonText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((login_button)));
		return driver.findElement(login_button).getText();
	}
	
	
	
	
	 
	
	
	public String getLoginFormTitle() {
		String title = driver.findElement(form_title_css).getText();
		return title;
	}

	public String getErrorMessagePassword() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password_error));
		return driver.findElement(password_error).getText();
	}
	
	
	public String getUserText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username_by));
		return driver.findElement(username_by).getAttribute("value");
	}
	
	public String getPasswordText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password_by));
		return driver.findElement(password_by).getAttribute("value");
	}
	
	

	public String getErrorMessageUserName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username_error_by));
		return driver.findElement(username_error_by).getText();
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(login_button)));
		driver.findElement(login_button).click();
	}
	
	public String fieldPassword() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(password_by)));
		return driver.findElement(password_by).getAttribute("type");
	}
	
	public void clickMultiAccount() {
		wait.until(ExpectedConditions.presenceOfElementLocated(multiaccount));
		driver.findElement(multiaccount).click();
	}
	

	public void clearTextElement(By web_element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='';", driver.findElement(web_element));
	}

	public void setUserCredentials(String user_name, String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username_by));
		this.clearTextElement(username_by);
		if (user_name != null) {
			driver.findElement(username_by).sendKeys(user_name);
		}
		if (password != null) {
			driver.findElement(password_by).sendKeys(password);
		}
	}

}
