package com.zaigo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendInvitePageObjects {
	
	 
	 

			
			private WebDriver driver;
			private WebDriverWait wait;

			private By usermenu=By.xpath("//a[@data-automationid='user']");
			
			private By usersubmenu =By.xpath("//a[@data-automationid='companies']//following::a[1]");
			
			
			private By userinvitebtn=By.xpath("//button[@data-automationid='sendInvite']");
			
			
			private By sendbtn=By.xpath("//button[@data-automationid='sendLink']");
			
			//fn
			private By firstname=By.xpath("//input[@data-automationid='firstName']");
			
			private By firstnameerr=By.xpath("//div[@data-automationid='firstName-error']");
			
			
			
			//ln
			
			private By lastname=By.xpath("//button[@data-automationid='lastName']");
			
			
			//type
			
			
			private By type=By.xpath("//button[@data-automationid='usertype']");
			
			
			//email
			
			private By email=By.xpath("//input[@data-automationid='email']");
			
			private By emailerr=By.xpath("//div[@data-automationid='email-error']");
			
			
			private By next=By.xpath("//button[@data-automationid='next']");
			
			
			private By mesage=By.xpath("//*[@data-automationid='message']");
			
			
			private By popuptext=By.xpath("//h5[contains(text(),'Send Invite')]");
			
			private By closepopup = By.xpath("//button[@data-automationid='close']");
			
			private By clickyes = By.xpath("//button[@data-automationid='yesBtn']");
			
			
			
			private By clickAdd = By.xpath("//button[@data-automationid='addMore']");
			
			private By getSuccessmessage = By.xpath("//*[@data-automationid='addMore']");
					
			
			
			private By clickSaveandComplete = By.xpath("//button[@data-automationid='sendLink']");
			
			
			public void clickSubmit()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((clickSaveandComplete)));
		    driver.findElement(clickSaveandComplete).click();
			}
			
			
			public String getSuccessMessages()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((getSuccessmessage)));
		    return driver.findElement(getSuccessmessage).getText();
			}
			
			
			
			public String getAddMoreText()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((clickAdd)));
		    return driver.findElement(clickAdd).getText();
			}
			
			
			public void clickClose()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((closepopup)));
		    driver.findElement(closepopup).click();
			}
			
			public void clickYes()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((clickyes)));
		    driver.findElement(clickyes).click();
			}
			
			
			public void clickNext()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((next)));
		    driver.findElement(next).click();
			}
			
			
			
			public void enterMessage(String ContactPhone)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated((mesage)));
			    driver.findElement(mesage).sendKeys(ContactPhone);
			}
			
			
			public String getMessageText()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((mesage)));
		    return driver.findElement(mesage).getAttribute("placeholder");
			}
			
			
			
			public void enterFirstName(String ContactPhone)
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((firstname)));
		    driver.findElement(firstname).sendKeys(ContactPhone);
			}
			
			
			public String firstNameError()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((firstnameerr)));
		    return driver.findElement(firstnameerr).getText();
			}
			
			public void enterLastName(String ContactPhone)
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((lastname)));
		    driver.findElement(lastname).sendKeys(ContactPhone);
			}
			
			
			public void enterEmail(String ContactPhone)
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((email)));
		    driver.findElement(email).sendKeys(ContactPhone);
			}
			
			
			
			public String getEmailErrorText()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((emailerr)));
		   return driver.findElement(emailerr).getText();
			}
			
			
			
			public void clickSendInvite()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((userinvitebtn)));
		    driver.findElement(userinvitebtn).click();
			}
			
			
			public void clickUserTab()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((usermenu)));
		    driver.findElement(usermenu).click();
			}
			
			public String getUserTab()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((usermenu)));
		    return   driver.findElement(usermenu).getText();
			}
			
			public void clickUserSubMenu()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((usersubmenu)));
		    driver.findElement(usersubmenu).click();
			}
			
			
			public String popupText()
			{
		    wait.until(ExpectedConditions.visibilityOfElementLocated((popuptext)));
		    return   driver.findElement(popuptext).getText();
			}
			
			
			public SendInvitePageObjects (WebDriver driver) {
				this.driver = driver;
				this.wait = new WebDriverWait(this.driver, 10);
			}
			
}
