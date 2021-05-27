package com.zaigo.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	private By userheader = By.xpath("//*[@data-automationid='user']");
	private By clickusermenu = By.xpath("//*[@id=\'root\']/div/div/div[1]/div/ul/li[2]/a");
	private By createbutton=By.xpath("//*[@data-automationid='createUser']");
	private By fname=By.xpath("//input[@data-automationid='firstName']");
	private By fnameerr = By.xpath("//*[@data-automationid='firstName-error']");
	private By lname=By.xpath("//input[@data-automationid='lastName']");
	private By lnameer=By.xpath("//*[@data-automationid='lastName-error']");
	private By role=By.xpath("//*[@data-automationid='usertype']");
	private By roleerr=By.xpath("//*[@data-automationid='usertype-error']");
	private By emailerr =By.xpath("//*[@data-automationid='email-error']");
	private By phone =By.xpath("//input[@data-automationid='cellPhone']");
	private By phoneerr= By.xpath("//*[@data-automationid='cellPhone-error']");
	private By homephone = By.xpath("//input[@data-automationid='homePhone']");
	private By homephoneerr =By.xpath("//*[@data-automationid='homePhone-error']");
	private By nxtbtn = By.xpath("//button[@data-automationid='next']");
	private By closebutton =By.xpath("//button[@data-automationid='close']");
	private By yesbtn =By.xpath("//button[@data-automationid='yesBtn']");
	private By jobtitle = By.xpath("//input[@data-automationid='jobTitle']");
    private By jobtitleerr = By.xpath("//*[@data-automationid='jobTitle-error']");
    private By email = By.xpath("//input[@data-automationid='email']");
    
    //Address
    
   private By addlocationbtn = By.xpath("//button[@data-automationid='anotherLocation']");
	
   private By locationone = By.xpath("//*[@data-automationid='Location 1']");
	
	private By lineone = By.xpath("//input[@data-automationid='noBuildingFlatName']");
	
	private By lineoneerr = By.xpath("//*[@data-automationid='noBuildingFlatName-error']");
	
	
    private By linetwo = By.xpath("//input[@data-automationid='streetName']");
	
	private By linetwoerr = By.xpath("//*[contains(text(),'Not allowed more than 150 characters')]");
	
	
    private By addressname = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By addressnameerr = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By city = By.xpath("//input[@data-automationid='cityVillage']");
		
    private By cityerr = By.xpath("//*[contains(text(),'Not allowed more than 150 characters')]");
	    
    
    private By zipcode = By.xpath("//input[@data-automationid='zipCode']");
	
    private By zipcoderr = By.xpath("//*[contains(text(),'Not allowed more than 6 characters')]");
    
    private By companyerror = By.xpath("//*[@data-automationid='contractorcompany-error']");
    
    private By selectcompany = By.xpath("//span[contains(text(),'Comapny')]");
    
    private By save = By.xpath("//button[@data-automationid='saveAndComplete']");
    
    private By clickcontractor =By.xpath("//input[@value='contractor_user']");
    
    private By clickcontractortab =By.xpath("//*[@data-automationid='contractor']");
    
    private By successmessage =By.xpath("//h3[@data-automationid='sucmessage']");
    
    private By closesuccess = By.xpath("//button[@data-automationid='close']");
    
    public void clicksave()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((save)));
			driver.findElement(save).click();
			
	   }
    
    
    public String getSuccessText()
	   {
		   
	        wait.until(ExpectedConditions.visibilityOfElementLocated((successmessage)));
			return driver.findElement(successmessage).getText();
		
	   }
    
    
    public void clicksuccessclose()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((closesuccess)));
			driver.findElement(closesuccess).click();
			
	   }
    
    public void clickContractorUser()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((clickcontractortab)));
			driver.findElement(clickcontractortab).click();
			
	   }
    
    
    
    
    public void clickContractorCompany()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((selectcompany)));
			driver.findElement(selectcompany).click();
			
			
			
			
		 }
    
    public String getCompanyError()
	   {
		   
	        wait.until(ExpectedConditions.visibilityOfElementLocated((companyerror)));
			return driver.findElement(companyerror).getText();
		
	   }
    
    
    
  
    public String getTitleError()
	   {
		   
	        wait.until(ExpectedConditions.visibilityOfElementLocated((jobtitleerr)));
			return driver.findElement(jobtitleerr).getText();
		
	   }
    
    public String getPhoneError()
	   {
		   
	        wait.until(ExpectedConditions.visibilityOfElementLocated((phoneerr)));
			return driver.findElement(phoneerr).getText();
		
	   }
    
    
    public String getHomePhoneError()
	   {
		   
	        wait.until(ExpectedConditions.visibilityOfElementLocated((homephoneerr)));
			return driver.findElement(homephoneerr).getText();
		
	   }
    
    
	
    public void enterJobTitle(String services)
	{
    wait.until(ExpectedConditions.visibilityOfElementLocated((jobtitle)));
    driver.findElement(jobtitle).sendKeys(services);
	}
    
    
    
    
    
    
    
	
	public String getFirstNameError()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((fnameerr)));
			return driver.findElement(fnameerr).getText();
		 }
	
	public String getLastNameError()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((lnameer)));
			return driver.findElement(lnameer).getText();
		 }
	
	
	
	
	
	public String getRoleError()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((roleerr)));
			return driver.findElement(roleerr).getText();
		 }
	public String getEmailError()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((emailerr)));
			return driver.findElement(emailerr).getText();
		 }
	
	
	
	public void clickClose()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((closebutton)));
			driver.findElement(closebutton).click();
		 }
	
	public void clickYes()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((yesbtn)));
			driver.findElement(yesbtn).click();
			
			
			
			
		 }
	
	public void selectRole()
	   {
		   
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(role));
		driver.findElement(role).click();
		Select select = new Select(driver.findElement(role));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		select.selectByIndex(1);
	   
			
	   }
	
	
	
	
	public void clickNextButton()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((nxtbtn)));
			driver.findElement(nxtbtn).click();
		 }
	
	public void clickCreateUserButton()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((createbutton)));
			driver.findElement(createbutton).click();
		 }
	
	
	
	
	
	
	
	 public void clickUserHeaderMenu()
	   {
		   
	   
			wait.until(ExpectedConditions.visibilityOfElementLocated((userheader)));
			driver.findElement(userheader).click();
		 }
	   
	   
	   public void clickUser() 
	   {
			wait.until(ExpectedConditions.visibilityOfElementLocated((clickusermenu)));
		    driver.findElement(clickusermenu).click();
	    }
	   public void enterFirstName(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((fname)));
	    driver.findElement(fname).sendKeys(services);
		}
	
	   public void enterLastName(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((lname)));
	    driver.findElement(lname).sendKeys(services);
		}
	   
	   
	   public void enterPhone(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((phone)));
	    driver.findElement(phone).sendKeys(services);
		}
	   
	   
	   
	   
	   
	   public void enterHomePhone(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((homephone)));
	    driver.findElement(homephone).sendKeys(services);
		}
	   
	   
	   
	   
	   public void enterEmail(String services)
		{
	    wait.until(ExpectedConditions.visibilityOfElementLocated((email)));
	    driver.findElement(email).sendKeys(services);
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
		
		public void clickLocationOne()
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated((locationone)));
		driver.findElement(locationone).click();
		   }
		
		
		public void clickAddLocation() {
			wait.until(ExpectedConditions.visibilityOfElementLocated((addlocationbtn)));
			driver.findElement(addlocationbtn).click();
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
	   
	   
	   
	 
	   public CreateUserPage(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(this.driver, 10);
		}
	
	
	

}
