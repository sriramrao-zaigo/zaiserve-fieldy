package com.zaigo.pageobjects;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateUserPage {

	WebDriver driver;
	WebDriverWait wait;
	By Email = By.id("login");
	By Pass = By.id("password");
	By Click = By.xpath("//button[@type='submit']");

	By Team = By.id("team-menu");
	By User = By.id("team-user-menu");
	By AddUser = By.xpath("//button[@class='btn btn-bg-blue font-14 w-100']");

	By ClickTheUser = By.xpath("//a[@data-goesto='team-user-view']");

	By FirstName = By.id("first_name");
	By LastName = By.id("last_name");
	By DropDown = By.xpath("//input[@data-dropdownlist='user-type']");
	By Manager = By.xpath("//div[text()='Manager']");
	By JobTitle = By.xpath("//input[@data-automationid='job_title']");
	By TxtEmail = By.id("email");
	By PhoneNo = By.id("phones__number__0");
	By SaveNext = By.xpath("//span[@class='right-icon']");

	By Contractor = By.xpath("//a[text()='Contractor']");
	By AddContractor = By.xpath("//button[@data-tabformid='team-user-contract-create']");

	By LocationName = By.xpath("//input[@id='addresses__name__0']");
	By LocationName1 = By.xpath("//input[@id='addresses__name__0']");
	By ReqLocationName = By.xpath("//div[text()='Not Allowed More than 256 characters']");

	By FlatName = By.xpath("//input[@id='addresses__line_1__0']");
	By FlatName1 = By.xpath("//input[@id='addresses__line_1__0']");

	By StreetName = By.xpath("//input[@id='addresses__line_2__0']");
	By StreetName1 = By.xpath("//input[@id='addresses__line_2__0']");

	By StateName = By.xpath("//input[@id='addresses__state__0']");
	By StateName1 = By.xpath("//input[@id='addresses__state__0']");
	By ReqStateName = By.xpath("//div[@id='addresses__state__0_error']");

	By CityVillage = By.xpath("//input[@id='addresses__city__0']");
	By CityVillage1 = By.xpath("//input[@id='addresses__city__0']");

	By ZipCode = By.xpath("//input[@id='addresses__zipcode__0']");
	By ZipCode1 = By.xpath("//input[@id='addresses__zipcode__0']");
	By ReqZipCode = By.xpath("//div[text()='Not Allowed More than 10 characters']");

	By Url = By.id("social_media__url__1");

	By SaveComplete = By.xpath("//button[@data-formsubmit='user_create']");
	By ConSaveComplete = By.xpath("//button[@data-automationid='save-complete']");

	By SuccessfulMessage = By.xpath("//span[text()='User created successfully']");
	By AlreadySameMail = By.xpath("//span[text()='User Already Exist with the same email address']");

	By Contract = By.xpath("//input[@data-formswitcher='user-contractor-create']");
	By conFirstName = By.id("first_name");
	By conLastName = By.id("last_name");
	By BussinessUnit = By.xpath("//input[@data-dropdownlist='business-unit']");
	By clkGeneral = By.id("dropid-364");
	By ServiceType = By.xpath("//input[@data-dropdownlist='service-type']");
	By clkRepair = By.id("dropid-365");
	By conEmail = By.xpath("//input[@id='email']");
	By conPhoneNo = By.xpath("//input[@data-automationid='phones__number__0']");
	By conSaveNext = By.xpath("//button[@data-spinloader='user_contractor_create_edit']");

	By conOrganization = By.xpath("//input[@name='contractor_type' and @value=1]");

	By reqFieldFirstName = By.xpath("//div[@id='first_name_error']");
	By reqFieldType = By.xpath("//div[@id='role_id_error']");
	By reqFieldEmail = By.xpath("//div[@id='email_error']");
	By reqFieldCompany = By.xpath("//div[@id='company_id_error']");

	By clkUser = By.xpath("//input[@data-formdynamic='user_create_edit']");

	By Company = By.xpath("//input[@data-dropdownlist='contractor-company']");
	By CompanyName = By.xpath("//div[text()='Dhamu']");

	By ClickContractor = By.xpath("//input[@data-formdynamic='user_contractor_create_edit']");
	By ClickUser = By.xpath("//input[@data-formdynamic='user_create_edit']");

	By ClickUsers = By.xpath("//a[text()='User ']");

	By Edit = By.xpath("(//div[@class='drop-down position-relative'])[1]");
	By clkEdit = By.xpath("//*[@id=\"fieldy-user-user-user-list_aserpttbl\"]/tbody/tr[2]/td[9]/div/div[2]/ul/li[2]/a");

	By DeleteLocation = By.xpath("//div[@class='team-delete-btn text-right red-delect']");
	By AddMoreLocation = By.xpath("//button[@id='add-more-team-user-location']");
	By AddMoreLocationCon = By.xpath("//button[@id='add-more-team-user-contractor-location']");

	By ProfileUpload = By.xpath("//label[@for='user_image']");
	By ProfileErrorMessage = By.xpath("//div[@id='user_image_error']");

	By SearchBox = By.xpath("//input[@id='team-user-user-user-search-filter']");
	By ClickSearchIcon = By.xpath("//button[@id='team-user-user-search-button']");
	By ValidationName = By.xpath("//a[text()='Ajith']");
	By InvalidData = By.xpath("//div[text()='No result found for Team User']");

	By clickNext = By.xpath("//span[text()='Next']");

	public CreateUserPage(WebDriver driver) {
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

	private void clickTeam() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Team)).click();
	}

	private void clickUsers() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickUsers)).click();

	}

	private void clickUser() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(User)).click();
	}

	private void clickAddUser() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddUser)).click();

	}

	private void firstName(String firstName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstName)).sendKeys(firstName);

	}

	private void userClick() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickUser)).click();

	}

	private void lastName(String lastName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LastName)).sendKeys(lastName);
	}

	private void dropDownType() throws InterruptedException {
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DropDown)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Manager)).click();

	}

	private void jobTitle(String title) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(JobTitle)).sendKeys(title);
	}

	private void txtEmail(String email) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TxtEmail)).sendKeys(email);
	}

	private void phoneNo(String phoneNo) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PhoneNo)).sendKeys(phoneNo);
	}

	private void clkSave() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveNext)).click();

	}

	private void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");

	}

	private void successfulMessage() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessfulMessage)).getText();
		// System.out.println(text);
		Assert.assertEquals(text, "User created successfully");

	}

	private void clickContract() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Contract)).click();
	}

	private void Contractor() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Contractor)).click();

	}

	private void addContractor() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AddContractor)).click();

	}

	private void conFirstName(String firstName) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conFirstName)).sendKeys(firstName);

	}

	private void conEmail(String email) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conEmail)).sendKeys(email);

	}

	private void conLastName(String lastName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conLastName)).sendKeys(lastName);

	}

	private void conBussinessUnit() throws InterruptedException {
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BussinessUnit)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(clkGeneral)).click();

	}

	private void conServiceType() throws InterruptedException {
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceType)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(clkRepair)).click();

	}

	private void conPhoneNo(String conPhoneNO) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conPhoneNo)).sendKeys(conPhoneNO);

	}

	private void conOrganization() {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conOrganization)).click();

	}

	private void clickTheUser() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickTheUser)).click();

	}

	private void ScrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1000)");

	}

	private void ScrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-1000)");

	}

	private void conSaveComplete() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(ConSaveComplete));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();
	}

	private void alreadyExist() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadySameMail)).getText();
		// System.out.println(text);
		Assert.assertEquals(text, "User Already Exist with the same email address");

	}

	private void requiredFieldFirstName() {
		wait = new WebDriverWait(driver, 10);
		String firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(reqFieldFirstName)).getText();
		// System.out.println("First Name " + firstName);
		Assert.assertEquals(firstName, "Required Field");

	}

	private void requiredFieldType() {
		wait = new WebDriverWait(driver, 10);
		String type = wait.until(ExpectedConditions.visibilityOfElementLocated(reqFieldType)).getText();
		// System.out.println("Type " + type);
		Assert.assertEquals(type, "Required Field");

	}

	private void requiredFieldEmail() {
		wait = new WebDriverWait(driver, 10);
		String email = wait.until(ExpectedConditions.visibilityOfElementLocated(reqFieldEmail)).getText();
		// System.out.println("Email " + email);
		Assert.assertEquals(email, "Required Field");

	}

	private void requiredFieldCompany() {
		wait = new WebDriverWait(driver, 10);
		String company = wait.until(ExpectedConditions.visibilityOfElementLocated(reqFieldCompany)).getText();
		// System.out.println("Company " + company);
		Assert.assertEquals(company, "Required Field");

	}

	private void saveComplete() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveComplete)).click();
	}

	private void clkUser() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clkUser)).click();

	}

	private void organization() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Company)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(CompanyName)).click();

	}

	private void clkContractor() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickContractor)).click();

	}

	private void actionEdit() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(Edit));
		Actions action = new Actions(driver);
		action.moveToElement(until).build().perform();
		WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(clkEdit));
		action.moveToElement(edit).click().build().perform();
	}

	private void inputLocationName() throws IOException {
		wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(LocationName));
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(257);
		until.sendKeys(randomAlphanumeric, Keys.TAB);
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(ReqLocationName)).getText();
		// System.out.println("Location Field is " + req);
		Assert.assertEquals(req, "Not Allowed More than 256 characters");
	}

	private void clearLocationNameField() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LocationName)).clear();

	}

	private void inputBuildingName() throws IOException {
		wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(FlatName));
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(257);
		until.sendKeys(randomAlphanumeric, Keys.TAB);
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(ReqLocationName)).getText();
		// System.out.println("Building Name Field is " + req);
		Assert.assertEquals(req, "Not Allowed More than 256 characters");

	}

	private void clearBuildingName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlatName)).clear();

	}

	private void inputStreetName() throws IOException {
		wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(StreetName));
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(257);

		until.sendKeys(randomAlphanumeric, Keys.TAB);
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(ReqLocationName)).getText();
		// System.out.println("Street Name Field is " + req);
		Assert.assertEquals(req, "Not Allowed More than 256 characters");

	}

	private void clearStreetName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(StreetName)).clear();

	}

	private void inputStateName() throws IOException {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(StateName));
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(257);

		until.sendKeys(randomAlphanumeric, Keys.TAB);
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(ReqStateName)).getText();
		// System.out.println("State Name Field is " + req);
		Assert.assertEquals(req, "Not Allowed More than 45 characters");

	}

	private void clearStateName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(StateName)).clear();

	}

	private void inputCityName() throws IOException {
		wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(CityVillage));
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(257);
		until.sendKeys(randomAlphanumeric, Keys.TAB);
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(ReqLocationName)).getText();
		// System.out.println("City Name Field is " + req);
		Assert.assertEquals(req, "Not Allowed More than 256 characters");

	}

	private void clearCityName() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CityVillage)).clear();

	}

	private void inputZipCode() throws IOException {
		wait = new WebDriverWait(driver, 20);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(ZipCode));
		String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(257);
		until.sendKeys(randomAlphanumeric, Keys.TAB);
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(ReqZipCode)).getText();
		// System.out.println("ZipCode Field is " + req);
		Assert.assertEquals(req, "Not Allowed More than 10 characters");

	}

	private void clearZipCode() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ZipCode)).clear();

	}

	private void deleteLocation() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteLocation));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(AddMoreLocation)).getText();
		// System.out.println("+ " + req + " is Present");
		Assert.assertEquals(req, "Add More Location");

	}

	private void deleteLocationCon() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteLocation));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).click().build().perform();
		String req = wait.until(ExpectedConditions.visibilityOfElementLocated(AddMoreLocationCon)).getText();
		// System.out.println("+ " + req + " is Present");
		Assert.assertEquals(req, "Add More Location");

	}

	private void inputLocationName1(String locationName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LocationName1)).sendKeys(locationName);

	}

	private void inputBuildingName1(String buildingName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FlatName1)).sendKeys(buildingName);

	}

	private void inputStreetName1(String streetName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(StreetName1)).sendKeys(streetName);

	}

	private void inputStateName1(String stateName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(StateName1)).sendKeys(stateName);

	}

	private void inputCityVillage1(String cityName) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CityVillage1)).sendKeys(cityName);
	}

	private void inputZipCode1(String zipCodeNo) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ZipCode1)).sendKeys(zipCodeNo);

	}

//	private void reqProfileUpload() throws AWTException, InterruptedException {
//		wait = new WebDriverWait(driver, 10);
//		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfileUpload));
//		Actions action = new Actions(driver);
//		action.moveToElement(until).click().build().perform();
//		Thread.sleep(1000);
//		attachmentFile("C:\\Users\\Zaigo PC\\Downloads\\sample-file.pdf");
//		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfileErrorMessage)).getText();
//		// System.out.println("Error message Upload Pic " + text);
//		Assert.assertEquals(text, "Only png,jpeg,jpg Formats Allowed");
//
//	}

//	private void ProfileUpload() throws AWTException, InterruptedException {
//		wait = new WebDriverWait(driver, 10);
//		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(ProfileUpload));
//		Actions action = new Actions(driver);
//		action.moveToElement(until).click().build().perform();
//		Thread.sleep(1000);
//		attachmentFile("1622641377484.jpg");
//
//	}

	private void searchBox(String name) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBox)).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickSearchIcon)).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ValidationName)).getText();
		Assert.assertEquals(text, "Ajith");
	}

	private void verifyName() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(ValidationName)).getText();
		Assert.assertEquals(text, "Ajith");
	}

	private void anySearchData(String invaliddata) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBox)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchBox)).sendKeys(invaliddata);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClickSearchIcon)).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidData)).getText();
		Assert.assertEquals(text, "No result found for Team User");

	}

	private void clickNext() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickNext)).click();

	}

	public void loginFieldy(String email, String pass) throws InterruptedException {
		this.setEmail(email);
		this.setPass(pass);
		this.clickLogin();
	}

	By filter = By.xpath("//div[text()=' Overall data']");
	//By Apply = By.xpath("(//button[@data-searchbutton='invoice_filter'])[1]");

	private void dashBoard() {
		wait = new WebDriverWait(driver, 10);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(filter)).getText();
		Assert.assertEquals(text, " Overall data");
		//wait.until(ExpectedConditions.elementToBeClickable(Apply)).click();

	}

	public void enterTeamModule() throws InterruptedException {
//		driver.navigate().refresh();
//		this.dashBoard();
		this.clickTeam();
		Thread.sleep(4000);
		this.clickTeam();
		this.clickUser();
		this.clickAddUser();

	}

	public void datas(String firstName, String lastName, String title, String email, String phoneNumber,
			String location, String buildingName, String streetName, String stateName, String cityName,
			String zipCodeNo) throws InterruptedException, AWTException {
		this.ScrollUp();
		this.clkUser();
		// this.ProfileUpload();
		this.firstName(firstName);
		this.lastName(lastName);
		this.dropDownType();
		this.jobTitle(title);
		this.txtEmail(email);
		this.phoneNo(phoneNumber);
		this.scrollDown();
		this.clkSave();
		this.inputLocationName1(location);
		this.inputBuildingName1(buildingName);
		this.inputStreetName1(streetName);
		this.inputStateName1(stateName);
		this.inputCityVillage1(cityName);
		this.inputZipCode1(zipCodeNo);
		this.saveComplete();
		this.successfulMessage();

	}

	public void manditoryDatas(String firstName, String email) throws InterruptedException {
		this.clickTeam();
		this.clickUser();
		this.clickAddUser();
		this.firstName(firstName);
		// Thread.sleep(2000);
		this.dropDownType();
		this.txtEmail(email);

	}

	public void existingData(String firstName, String lastName, String title, String email, String phoneNumber)
			throws InterruptedException {
		this.clickTheUser();
		this.clickAddUser();
		this.firstName(firstName);
		this.lastName(lastName);
		this.dropDownType();
		this.jobTitle(title);
		this.txtEmail(email);
		this.ScrollDown();
		this.phoneNo(phoneNumber);
		this.saveComplete();
		this.alreadyExist();

	}

	public void reqField() throws InterruptedException, AWTException {
		// this.reqProfileUpload();
		Thread.sleep(3000);
		this.clkSave();
		scrollDown();
		this.requiredFieldFirstName();
		this.requiredFieldType();
		this.requiredFieldEmail();
//		//reqProfileUpload();
//		scrollDown();
//		Thread.sleep(5000);
//		//this.reqProfileUpload();
//		this.clkSave();
//		this.requiredFieldFirstName();
//		this.requiredFieldType();
//		this.requiredFieldEmail();

	}

	public void conReqField() throws InterruptedException, AWTException {
		driver.navigate().refresh();
		this.clickTeam();
		this.clickUser();
		this.Contractor();
		this.addContractor();
		// this.reqProfileUpload();
		Thread.sleep(2000);
		this.clkSave();
		this.requiredFieldFirstName();
		this.requiredFieldEmail();

	}

	public void conDataReqOrganization(String firstName, String lastName, String email, String phoneNo, String location,
			String buildingName, String streetName, String stateName, String cityName, String zipCodeNo)
			throws InterruptedException, AWTException {
		this.Contractor();
		this.addContractor();
		// this.ProfileUpload();
		this.conFirstName(firstName);
		this.conLastName(lastName);
		// Thread.sleep(3000);
		this.conBussinessUnit();
		this.conServiceType();
		this.conEmail(email);
		this.ScrollDown();
		this.conPhoneNo(phoneNo);
		this.conOrganization();
		this.organization();
		this.clkSave();
		this.inputLocationName1(location);
		this.inputBuildingName1(buildingName);
		this.inputStreetName1(streetName);
		this.inputStateName1(stateName);
		this.inputCityVillage1(cityName);
		this.inputZipCode1(zipCodeNo);
		this.conSaveComplete();
		this.successfulMessage();

	}

	public void conExistingDatas(String firstName, String lastName, String email, String phoneNo)
			throws InterruptedException {
		this.clkContractor();
		this.conFirstName(firstName);
		this.conLastName(lastName);
		// Thread.sleep(2000);
		this.conBussinessUnit();
		this.conServiceType();
		this.conEmail(email);
		this.ScrollDown();
		this.conPhoneNo(phoneNo);
		this.conSaveComplete();
		this.conSaveComplete();
		this.alreadyExist();

	}

	public void reqOrganization(String firstName, String email) throws InterruptedException {
		driver.navigate().refresh();
//		this.Contractor();
//		this.addContractor();
//		this.clkContractor();
		this.ScrollDown();
		this.conFirstName(firstName);
		this.conEmail(email);
		this.conOrganization();
		Thread.sleep(1000);
		this.conSaveComplete();
		this.conSaveComplete();
		this.requiredFieldCompany();

	}

	public void conOrganization(String firstName, String email) throws InterruptedException {
		// this.clkContractor();
//		this.Contractor();
//		this.addContractor();
		this.clickContract();
		this.conFirstName(firstName);
		this.conEmail(email);
		this.ScrollDown();
//		this.conOrganization();
//		// Thread.sleep(2000);
//		this.organization();

	}

	public void inputUserLocationFieldReqs() throws IOException, InterruptedException {
//		this.clickTeam();
//		this.clickUser();
		this.clkSave();
		this.inputLocationName();
		this.clearLocationNameField();
		this.inputBuildingName();
		// Thread.sleep(2000);
		this.clearBuildingName();

		this.inputStreetName();
		this.clearStreetName();

		this.inputStateName();
		this.clearStateName();

		this.inputCityName();
		this.clearCityName();

		this.inputZipCode();
		this.clearZipCode();

		this.deleteLocation();

	}

	public void inputConLocatioFieldReq() throws IOException, InterruptedException {
		this.clkSave();
		this.inputLocationName();
		this.clearLocationNameField();
		this.inputBuildingName();
		// Thread.sleep(2000);
		this.clearBuildingName();

		this.inputStreetName();
		this.clearStreetName();

		this.inputStateName();
		this.clearStateName();

		this.inputCityName();
		this.clearCityName();

		this.inputZipCode();
		this.clearZipCode();

		this.deleteLocationCon();

	}

	public void validationList(String name) {
		this.searchBox(name);

	}

	public void verifyNameList() {
		this.verifyName();

	}

	public void invalidData(String data) {
		this.anySearchData(data);

	}

	By Dots = By.xpath("//*[@id=\"fieldy-user-user-user-list_aserpttbl\"]/tbody/tr[2]/td[9]/div/div[1]");
	By conDots = By.xpath("//*[@id=\"fieldy-user-user-contractor-list_aserpttbl\"]/tbody/tr[2]/td[10]/div/div[1]/i");
	Actions actions;

	private void mouseActionDots() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(Dots));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).perform();

	}

	private void conmouseActionDots() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(conDots));
		Actions actions = new Actions(driver);
		actions.moveToElement(until).perform();

	}

	By Delete = By.xpath("//*[@id=\"fieldy-user-user-user-list_aserpttbl\"]/tbody/tr[2]/td[9]/div/div[2]/ul/li[3]/a");
	By conDelete = By
			.xpath("//*[@id=\"fieldy-user-user-contractor-list_aserpttbl\"]/tbody/tr[2]/td[10]/div/div[2]/ul/li[3]");
	By Yes = By.xpath("//button[text()='Yes']");
	By DeleteMessage = By.xpath("//span[text()='User have been deleted successfully']");

	private void clickDelete() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Delete)).click();

	}

	private void clickconDelete() {
		wait = new WebDriverWait(driver, 10);
		WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(conDelete));
		Actions actions = new Actions(driver);
		actions.click(until).perform();

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
		this.clickUser();
		this.mouseActionDots();
		this.clickDelete();
		this.clickYes();
		this.verifyDeleteMessage();

	}

	public void deleteConField() {
		this.Contractor();
		this.conmouseActionDots();
		this.clickconDelete();
		this.clickYes();
		this.verifyDeleteMessage();

	}

}
