package com.zaigo.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateVendorPageObjects {
	
	
	private WebDriver driver;
	private WebDriverWait wait;

	private By usermenu=By.xpath("//a[@data-automationid='user']");
	
	
	private By vendormenu=By.xpath("//a[@data-automationid='vendor']");
	
	private By vendortab=By.xpath("//a[@data-automationid='vendor']");
	private By vendorcreatebtn=By.xpath("//*[@data-automationid='createVendor']");
	
	private By vendorname=By.xpath("//input[@data-automationid='companyName']");
	
	private By vendornameer=By.xpath("//*[@data-automationid='company-name-error']");
	
	private By nextbtn = By.xpath("//button[@data-automationid='next']");
	
	
	private By vendoremail=By.xpath("//input[@data-automationid='email']");
	private By vendoremailerr=By.xpath("//*[@data-automationid='email-error']");
	
    private By vendorcperson=By.xpath("//input[@data-automationid='contactPerson']");
	
	private By vendorcpersonerr=By.xpath("//*[@data-automationid='contactperson-error']");
	
	private By vendorphone=By.xpath("//input[@data-automationid='phone']");
	
	private By vendorphoneerr=By.xpath("//*[@data-automationid='phone-error']");
	
	
	
	private By vendorfax=By.xpath("//input[@data-automationid='fax']");
	
	
	
	private By vendorsite=By.xpath("//input[@data-automationid='website']");
	
	private By vendorsiteerr=By.xpath("//*[@data-automationid='website-err']");
	
	
	private By vendorimageupload=By.id("vendorimageupload");
	
	private By vendorPdtServ = By.xpath("//input[@data-automationid='typeAndEnter']");	
	
	private By closepopup = By.xpath("//button[@data-automationid='close']");
	
	private By warningpopup = By.xpath("//button[@data-automationid='yesBtn']");
	
	private By saveform =By.xpath("//button[@data-automationid='saveAndComplete']");
	
	//Address
	
	private By addlocationbtn = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By lineone = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By lineoneerr = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	
    private By linetwo = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By linetwoerr = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	
    private By addressname = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By addressnameerr = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By city = By.xpath("//button[@data-automationid='saveAndComplete']");
		
    private By cityerr = By.xpath("//button[@data-automationid='saveAndComplete']");
	    
    
    private By zipcode = By.xpath("//button[@data-automationid='saveAndComplete']");
	
    private By zipcoderr = By.xpath("//button[@data-automationid='saveAndComplete']");
    
    private By country = By.xpath("//button[@data-automationid='saveAndComplete']");
	
    private By state = By.xpath("//button[@data-automationid='saveAndComplete']");
    
    
	
	public void vendorProductandServices(String services)
	{
    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
    driver.findElement(vendorPdtServ).sendKeys(services);
	}
	
	public void vendorclickEnter(Keys services)
	{
    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
    driver.findElement(vendorPdtServ).sendKeys(services);
	}
	
	
	public void clickAddLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((addlocationbtn)));
		driver.findElement(addlocationbtn).click();
	    }
	
	
	
	public void clickSaveandComplete() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((saveform)));
		driver.findElement(saveform).click();
	    }
	
	
	
	
	
	
	
	
	    public void dashBoardUserMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((usermenu)));
		driver.findElement(usermenu).click();
	    }
	    
	    public void clickNextButton() {
			wait.until(ExpectedConditions.visibilityOfElementLocated((nextbtn)));
			driver.findElement(nextbtn).click();
		    }
	    
	    public void clickYesButton() {
			wait.until(ExpectedConditions.visibilityOfElementLocated((warningpopup)));
			driver.findElement(warningpopup).click();
		    }
	    
	    
	    
	    
	    
	    public void clickCloseButton() 
	    {
			wait.until(ExpectedConditions.visibilityOfElementLocated((closepopup)));
			driver.findElement(closepopup).click();
		}
	    
	    
	    public String dashBoardUserMenuText() 
	    {
			wait.until(ExpectedConditions.visibilityOfElementLocated((usermenu)));
			return driver.findElement(usermenu).getText();
		 }
		
	    
	    
	    
	    public String dashBoardVendorMenuText() {
			wait.until(ExpectedConditions.visibilityOfElementLocated((vendormenu)));
			return driver.findElement(vendormenu).getText();
		    }
	    
	    
	    
		public void clickVendorTab()
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
		
		//Address Form
		
		public void selectCountry()
		 {
				wait.until(ExpectedConditions.visibilityOfElementLocated(country));
				driver.findElement(country).click();
				Select select = new Select(driver.findElement(country));
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				select.selectByVisibleText("india");
		 }
		
		public void selectState()
		 {
			wait.until(ExpectedConditions.visibilityOfElementLocated(state));
			driver.findElement(state).click();
			Select select = new Select(driver.findElement(state));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			select.selectByVisibleText("tamil nadu");
		 }
		
		
		public void vendorLineOne(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    driver.findElement(vendorPdtServ).sendKeys(services);
		}
		
		
		public String vendorLineOneError(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    return driver.findElement(vendorPdtServ).getText();
		}
		
		
		public void vendorLineTwo(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    driver.findElement(vendorPdtServ).sendKeys(services);
		}
		
		
		public String vendorLineTwoError(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    return driver.findElement(vendorPdtServ).getText();
		}
		
		public void vendorCity(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    driver.findElement(vendorPdtServ).sendKeys(services);
		}
		
		
		public String vendorCityError(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    return driver.findElement(vendorPdtServ).getText();
		}
		
		public void vendorAddressContactPerson(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    driver.findElement(vendorPdtServ).sendKeys(services);
		}
		
		
		public String vendorContctPersonError(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    return driver.findElement(vendorPdtServ).getText();
		}
		
		public void vendorZipcode(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    driver.findElement(vendorPdtServ).sendKeys(services);
		}
		
		
		public String vendorZipcodeError(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((vendorPdtServ)));
	    return driver.findElement(vendorPdtServ).getText();
		}
		
		
		
		
		
		
		
		public CreateVendorPageObjects(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(this.driver, 10);
		}
		
		
	}
		
		
