package com.zaigo.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContractorPageObjects {

	
	private WebDriver driver;
	private WebDriverWait wait;

	private By usermenu=By.xpath("//a[@data-automationid='user']");
	
	
	private By contractorrmenu=By.xpath("//a[@data-automationid='vendor']");
	
	private By contractortab=By.xpath("//a[@data-automationid='contractor']");
	
	private By contractorcreatebtn=By.xpath("//*[@data-automationid='createContractor']");
	
	private By contractorname=By.xpath("//input[@data-automationid='companyName']");
	
	private By contractornameer=By.xpath("//*[@data-automationid='companyname-error']");
	
	private By nextbtn = By.xpath("//button[@data-automationid='next']");
	
	
	private By contractoremail=By.xpath("//input[@data-automationid='email']");
	
	private By contractoremailerr=By.xpath("//*[@data-automationid='email-error']");
	
    private By contractorcperson=By.xpath("//input[@data-automationid='contactPerson']");
	
	private By contractorcpersonerr=By.xpath("//*[@data-automationid='contactperson-error']");
	
	private By contractorphone=By.xpath("//input[@data-automationid='phone']");
	
	private By contractorphoneerr=By.xpath("//*[@data-automationid='phone-error']");
	
	
	
	private By contractorfax=By.xpath("//input[@data-automationid='fax']");
	
	private By contractorfaxerror=By.xpath("//*[@data-automationid='fax']");
	
	
	private By contractorsite=By.xpath("//input[@data-automationid='website']");
	
	private By contractorsiteerr=By.xpath("//*[@data-automationid='website-error']");
	  
	//changedf
	
	private By contractorimageupload=By.id("imageUpload");
	
	private By imagerror = By.xpath("//input[@data-automationid='imageerror']");
	
		
	private By closepopup = By.xpath("//button[@data-automationid='close']");
	
	private By warningpopup = By.xpath("//button[@data-automationid='yesBtn']");
	
	private By saveform =By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By successmessage= By.xpath("//*[@data-automationid='saveAndComplete']");
	
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
    
	
    
	
	
	public void clickAddLocation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((addlocationbtn)));
		driver.findElement(addlocationbtn).click();
	    }
	
	
	
	public void clickSaveandComplete() {
		wait.until(ExpectedConditions.visibilityOfElementLocated((saveform)));
		driver.findElement(saveform).click();
	    }
	
	
	
	
	
	
	public void uploadImage(String teamname )
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(contractorimageupload));
		driver.findElement(contractorimageupload).sendKeys(teamname);
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
			wait.until(ExpectedConditions.visibilityOfElementLocated((contractortab)));
			return driver.findElement(contractortab).getText();
		    }
	    
	    
	    
		public void clickVendorTab()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractortab)));
	    driver.findElement(contractortab).click();
		}
		
		public void contractorCreateButton()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorcreatebtn)));
	    driver.findElement(contractorcreatebtn).click();
		}

		public void contractorName(String name)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorname)));
	    driver.findElement(contractorname).sendKeys(name);
		}

		
		public void contractorEmail(String Email)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractoremail)));
	    driver.findElement(contractoremail).sendKeys(Email);
		}
		
		
		public void contractorContactPerson(String ContactPerson)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorcperson)));
	    driver.findElement(contractorcperson).sendKeys(ContactPerson);
		}
		
		
		public void contractorPhone(String ContactPhone)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorphone)));
	    driver.findElement(contractorphone).sendKeys(ContactPhone);
		}
		
		public void contractorFax(String Fax)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorfax)));
	    driver.findElement(contractorfax).sendKeys(Fax);
		}
		
		
		
		
		public void contractorWebsite(String Website)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorsite)));
	    driver.findElement(contractorsite).sendKeys(Website);
		}
		
		
		
		
		
		public String contractorNameError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractornameer)));
	    return driver.findElement(contractornameer).getText();
		}
		
		public String contractorEmailError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractoremailerr)));
	    return driver.findElement(contractoremailerr).getText();
		}
		
		
		public String contractorFaxError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorfaxerror)));
	    return driver.findElement(contractorfaxerror).getText();
		}
		
		
		
		public String contractorContactNameError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorcpersonerr)));
	    return driver.findElement(contractorcpersonerr).getText();
		}
		
		
		public String contractorPhoneError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorphoneerr)));
	    return driver.findElement(contractorphoneerr).getText();
		}
		
		public String contractorWebsiteError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((contractorsiteerr)));
	    return driver.findElement(contractorsiteerr).getText();
		}
		
		
		public String contractorSuccessMessage()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((successmessage)));
	    return driver.findElement(successmessage).getText();
		}
		
		
		public String vendorImageError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((imagerror)));
	    return driver.findElement(imagerror).getText();
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
		
		
		public void contractorLineOne(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((lineone)));
	    driver.findElement(lineone).sendKeys(services);
		}
		
		
		public String contractorLineOneError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((lineoneerr)));
	    return driver.findElement(lineoneerr).getText();
		}
		
		
		public void contractorLineTwo(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((linetwo)));
	    driver.findElement(linetwo).sendKeys(services);
		}
		
		
		public String contractorLineTwoError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((linetwoerr)));
	    return driver.findElement(linetwoerr).getText();
		}
		
		public void contractorCity(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((city)));
	    driver.findElement(city).sendKeys(services);
		}
		
		
		public String contractorCityError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((cityerr)));
	    return driver.findElement(cityerr).getText();
		}
		
		public void contractorAddressContactPerson(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((addressname)));
	    driver.findElement(addressname).sendKeys(services);
		}
		
		
		public String contractorContctPersonError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((addressnameerr)));
	    return driver.findElement(addressnameerr).getText();
		}
		
		public void contractorZipcode(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((zipcode)));
	    driver.findElement(zipcode).sendKeys(services);
		}
		
		
		public String contractorZipcodeError()
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((zipcoderr)));
	    return driver.findElement(zipcoderr).getText();
		}
		
		
		
		
		
		
		
		public CreateContractorPageObjects(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(this.driver, 10);
		}
		
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
