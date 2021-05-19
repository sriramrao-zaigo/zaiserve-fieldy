package com.zaigo.pageobjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyEditPage {

	
	
	private WebDriver driver;
	private WebDriverWait wait;

	private By usermenu=By.xpath("//a[@data-automationid='user']");
	
	private By companies =By.xpath("//a[@data-automationid='companies']");
	private By companytab =By.xpath("//a[@data-automationid='company']");
	private By editcompany= By.xpath("//button[@data-automationid='companyEdit']");
	private By savebtn = By.xpath("//button[@data-automationid='saveAndComplete']");
	
	private By companyname =By.xpath("//input[@data-automationid='compay-name']");
//    private By website =By.xpath("//input[@data-automationid='company-website']");
    private By accountowner =By.xpath("//input[@data-automationid='company-accountowner']");
    
    private By nextbtn = By.xpath("//button[@data-automationid='next']");
    private By anotherlocation = By.xpath("//button[@data-automationid='anotherLocation']");
    private By clicklocation = By.xpath("//div[@data-automationid='Location 1']");
    
    private By imageupload= By.id("imageUpload");
    
//    private By imageerr = By.xpath("//p[@data-automationid='imageErr']");
	
    private By locactionname =By.xpath("//input[@data-automationid='locationName']");
    private By contactperson =By.xpath("//input[@data-automationid='locationContactPerson']");
    private By email =By.xpath("//input[@data-automationid='locationEmail']");
    private By phone =By.xpath("//input[@data-automationid='locationPhoneNumber']");
    
    private By lineone  = By.xpath("//input[@data-automationid='noBuildingFlatName']");
    private By linetwo =By.xpath("//input[@data-automationid='streetName']");
    private By city = By.xpath("//input[@data-automationid='cityVillage']");
    private By zipcode =By.xpath("//input[@data-automationid='zipCode']");
   
    private By succmessage = By.xpath("//div[@data-automationid='success-message']");
    
    private By yesbtn = By.xpath("//button[@data-automationid='yesBtn']");
    
    //Errors Basics
    
    private By companynameerr = By.xpath("//div[@data-automationid='company-name-error']");
    private By acntownererr = By.xpath("//div[@data-automationid='company-accountowner-error']");
	
   //Errors Address tab
    
    
    private By locactionnameerr =By.xpath("//div[@data-automationid='locationName-error']");
    private By contactpersonerr =By.xpath("//div[@data-automationid='locationContactPerson-error']");
    private By emailerr =By.xpath("//div[@data-automationid='locationEmail-error']");
    private By phoneerr =By.xpath("//div[@data-automationid='locationPhoneNumber-error']");
    
    private By lineoneerr  = By.xpath("//div[@data-automationid='noBuildingFlatName-error']");
    private By linetwoerr =By.xpath("//div[@data-automationid='streetName-error']");
    private By cityerr= By.xpath("//div[@data-automationid='cityVillage-error']");
    private By zipcodeerr =By.xpath("//div[@data-automationid='zipCode-error']");
    
    private By getcompany = By.xpath("//div[contains(text(),'Tenant Edit')]");
    private By getwebsite = By.xpath("//div[contains(text(),'https://www.zaigoinfotech.com/')]");
    private By getnotes = By.xpath("//p[contains(text(),'Noted')]");
    
    private By close = By.xpath("//button[@data-automationid='close']");
    
    
    public void clickClose() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((close)));
 	    driver.findElement(close).click();
    }
    
    public void clickYes() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((yesbtn)));
 	    driver.findElement(yesbtn).click();
    }
    
    
    
    public String getWebsite() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((getwebsite)));
 	    return driver.findElement(getwebsite).getText();
    }
    
    
    public String getNotes() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((getnotes)));
 	    return driver.findElement(getnotes).getText();
    }
    
    
    
    
    public String getCompanyName() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((getcompany)));
 	    return driver.findElement(getcompany).getText();
    }
    
    
    public String getSuccessMessage() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((succmessage)));
 	    return driver.findElement(succmessage).getText();
    }
   
    
    public void clickUserMenu() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((usermenu)));
 	    driver.findElement(usermenu).click();
    }
    
    
    public void clickSaveandComplete() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((savebtn)));
 	    driver.findElement(savebtn).click();
    }
    
    
    
    public void clickCompanyTab() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((companytab)));
 	    driver.findElement(companytab).click();
    }
    
    
    public String getUserMenuText() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((usermenu)));
 	    return driver.findElement(usermenu).getText();
    }
    
    public String getButtonText() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((savebtn)));
 	    return driver.findElement(savebtn).getText();
    }
    
   
    
    public void uploadImage(String upload) 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((imageupload)));
 		driver.findElement(imageupload).sendKeys(upload);
    }
    
    public void clickCompany() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((companytab)));
 		driver.findElement(companytab).click();
    }
    
    public String getCompanyTabText() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((companies)));
 	    return driver.findElement(companies).getText();
    }
    
    public void clickEditButton() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((editcompany)));
 	    driver.findElement(editcompany).click();
 	}
    
    public void enterCompanyName(String teamname)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(companyname));
		driver.findElement(companyname).clear();
		driver.findElement(companyname).sendKeys(teamname);
	}
    
 
    
    public String getNameErrorMessage()
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(companynameerr));
		return driver.findElement(companynameerr).getText();
   	}
    
    
    
    
    public void enterOwnerName(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(accountowner));
   		driver.findElement(accountowner).clear();
   		driver.findElement(accountowner).sendKeys(teamname);
   	}
    
    
    
    public String getOwnerErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(acntownererr));
		return driver.findElement(acntownererr).getText();   	
		
   	}
    
    
    
    public void clickNext() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((nextbtn)));
 		driver.findElement(nextbtn).click();
    }
    
    public void clickAddMore() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((anotherlocation)));
 		driver.findElement(anotherlocation).click();
    }
    
    public void clickLocation() 
    {
 		wait.until(ExpectedConditions.visibilityOfElementLocated((clicklocation)));
 		driver.findElement(clicklocation).click();
    }
    
    public void enterLocationName(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(locactionname));
   		driver.findElement(locactionname).clear();
   		driver.findElement(locactionname).sendKeys(teamname);
   		
   	}
    
    public String getAddressNameErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(locactionnameerr));
		return driver.findElement(locactionnameerr).getText();   	
		
   	}
    
    
    public void enterLocationEmail(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(email));
   		driver.findElement(email).clear();
   		driver.findElement(email).sendKeys(teamname);
   	}
    
    public String getAddressEmailErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(emailerr));
		return driver.findElement(emailerr).getText();   	
		
   	}
    
    public void enterLocationPhone(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(phone));
   		driver.findElement(phone).clear();
   		driver.findElement(phone).sendKeys(teamname);
   	}
    
    public String getAddressPhoneErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(phoneerr));
		return driver.findElement(phoneerr).getText();   	
		
   	}
    public void enterLocationPerson(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(contactperson));
   		driver.findElement(contactperson).clear();
   		driver.findElement(contactperson).sendKeys(teamname);
   		
   	}
    public String getAddressPersonErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(contactpersonerr));
		return driver.findElement(contactpersonerr).getText();   	
		
   	}
    public void enterLineOne(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(lineone));
   		driver.findElement(lineone).clear();
   		driver.findElement(lineone).sendKeys(teamname);
   	}
    public String getLineOneErr()
   	{
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(lineoneerr));
		return driver.findElement(lineoneerr).getText();   	
		
   	}
   	
   	public void enterLineTwo(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(linetwo));
   		driver.findElement(linetwo).clear();
   		driver.findElement(linetwo).sendKeys(teamname);
   	}
   	public String getLineTwoErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(linetwoerr));
		return driver.findElement(linetwoerr).getText();   	
		
   	}
   	
   	public void enterCity(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(city));
   		driver.findElement(city).clear();
   		driver.findElement(city).sendKeys(teamname);
   	}
   	
   	public String getCityErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(cityerr));
		return driver.findElement(cityerr).getText();   	
		
   	}
   	
   	public void enterZipcode(String teamname )
   	{
   		wait.until(ExpectedConditions.presenceOfElementLocated(zipcode));
   		driver.findElement(zipcode).clear();
   		driver.findElement(zipcode).sendKeys(teamname);
   	}
   	
   	public String getZipcodeErrorMessage()
   	{
    	wait.until(ExpectedConditions.presenceOfElementLocated(zipcodeerr));
		return driver.findElement(zipcodeerr).getText();   	
		
   	}
   	
   	
    
    
    
    
    
	public CompanyEditPage(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
	}
	
	
	
	
}
