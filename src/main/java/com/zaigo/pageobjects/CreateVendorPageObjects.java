package com.zaigo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateVendorPageObjects {
	
	
	private WebDriver driver;
	private WebDriverWait wait;

	private By usermenu=By.xpath("//a[@data-automationid='user']");
	private By vendortab=By.xpath("//a[@data-automationid='vendor']");
	private By vendorcreatebtn=By.xpath("//a[@data-automationid='createvendor']");
	
	private By vendorname=By.xpath("//a[@data-automationid='companyName']");
	
	private By vendornameer=By.xpath("//a[@data-automationid='company-name-error']");
	
	
	
	private By vendoremail=By.xpath("//a[@data-automationid='email']");
	private By vendoremailerr=By.xpath("//a[@data-automationid='email-error']");
	
    private By vendorcperson=By.xpath("//a[@data-automationid='contactPerson']");
	
	private By vendorcpersonerr=By.xpath("//a[@data-automationid='contactPerson-error']");
	
	private By vendorphone=By.xpath("//a[@data-automationid='phone']");
	
	private By vendorphoneerr=By.xpath("//a[@data-automationid='phone-error']");
	
	
	
	private By vendorfax=By.xpath("//a[@data-automationid='fax']");
	
	
	
	private By vendorsite=By.xpath("//a[@data-automationid='website']");
	
	private By vendorsiteerr=By.xpath("//a[@data-automationid='website-err']");
	
	
	
	    public void dashBoardUserMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((usermenu)));
		driver.findElement(usermenu).click();
	    }
		
		public void vendorTab()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendortab)));
	    driver.findElement(vendortab).click();
		}
		
		public void vendorCreateButton()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorcreatebtn)));
	    driver.findElement(vendorcreatebtn).click();
		}

		public void vendorName(String name)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorname)));
	    driver.findElement(vendorname).sendKeys(name);
		}

		
		public void vendorEmail(String Email)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendoremail)));
	    driver.findElement(vendoremail).sendKeys(Email);
		}
		
		
		public void vendorContactPerson(String ContactPerson)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorcperson)));
	    driver.findElement(vendorcperson).sendKeys(ContactPerson);
		}
		
		
		public void vendorPhone(String ContactPhone)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorcperson)));
	    driver.findElement(vendorcperson).sendKeys(ContactPhone);
		}
		
		
		
		public void vendorWebsite(String Website)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorsite)));
	    driver.findElement(vendorsite).sendKeys(Website);
		}
		
		
		
		
		
		public String vendorNameError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendornameer)));
	    return driver.findElement(vendornameer).getText();
		}
		
		public String vendorEmailError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendoremailerr)));
	    return driver.findElement(vendoremailerr).getText();
		}
		
		public String vendorContactNameError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorcpersonerr)));
	    return driver.findElement(vendorcpersonerr).getText();
		}
		
		
		public String vendorPhoneError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorphoneerr)));
	    return driver.findElement(vendorphoneerr).getText();
		}
		
		public String vendorWebsiteError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorsiteerr)));
	    return driver.findElement(vendorsiteerr).getText();
		}
		
		
		
		
	}
		
		
