package com.ABSLI.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class Homepage extends AbsliParent {

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimDrops;

	@FindBy(xpath = "//a[normalize-space()='Intimation']")
	WebElement Intimation;

	@FindBy(xpath = "//a[normalize-space()='Assessment']")
	WebElement Assessment;

	@FindBy(xpath = "//a[normalize-space()='Registration']")
	WebElement Registration;

	@FindBy(xpath = "//a[normalize-space()='Approval']")
	WebElement Approval;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Client_Name;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement Master_Policy_Number;

	@FindBy(xpath = "//li[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-result-l847-68113']")
	WebElement drops;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtNBusiness']")
	WebElement New_Claim;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearchClaims']")
	WebElement Search;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement Search1;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaimGroup_btngvSelectGroup_0']")
	WebElement Select;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaim_btngvClaimSelect_0']")
	WebElement Select1;
	
	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liConfiguration']/a[1]")
	WebElement ConfigurationDropdown;

	@FindBy(xpath = "//a[normalize-space()='Product Setup']")
	WebElement ProductSetupDropdown;
	
	@FindBy(xpath = "//a[normalize-space()='Product']")
	WebElement Productbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Variant']")
	WebElement VariantButton;
	
	@FindBy(xpath = "//a[normalize-space()='Premium']")
	WebElement PremiumButton;
	
	@FindBy(xpath = "//a[normalize-space()='Premium Payment Frequency']")
	WebElement PremiumPaymentFrequency;
	
	@FindBy(xpath = "//a[normalize-space()='My Account']")
	WebElement Myaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Change Product']")
	WebElement Changeproduct;
	
	@FindBy(xpath = "//a[normalize-space()='Client Master']")
	WebElement ClientmasterDropdown;
	
	@FindBy (xpath = "//a[normalize-space()='Advance Deposit Receipting']")
	WebElement AdvanceReceiptbutton;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutButton;
	
	@FindBy(xpath = "//li[@id='liNewBusiness']//a[@class='first-link']")
    WebElement Newbusiness;	
	
	@FindBy(xpath = "//a[normalize-space()='Member Upload']")
	WebElement MemberUpload;
	
	@FindBy(xpath = "//a[@class='second-link defectData_link'][normalize-space()='Defect Data']")
	WebElement DefectData;
	
	@FindBy(xpath = "//a[normalize-space()='Voluntary Member Upload']")
	WebElement Voluntarymemupload;
	
	
	
	
	
	

	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public void ClaimIntialprocess() throws Throwable {

		wait.until(ExpectedConditions.elementToBeClickable(claimDrops));
		claimDrops.click();
		wait.until(ExpectedConditions.elementToBeClickable(Intimation));
		Intimation.click();
		Thread.sleep(1000);
	}

	public void Assessmentprocess() throws Throwable {

		//wait.until(ExpectedConditions.elementToBeClickable(claimDrops));
		Thread.sleep(2000);
		claimDrops.click();
		wait.until(ExpectedConditions.elementToBeClickable(Assessment));
		Assessment.click();
		Thread.sleep(2000);

	}

	public void Registrationprocess() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(claimDrops));
		claimDrops.click();
		wait.until(ExpectedConditions.elementToBeClickable(Registration));
		Registration.click();
		Thread.sleep(2000);

	}

	public void Approvalprocess() throws InterruptedException, Throwable {

		wait.until(ExpectedConditions.elementToBeClickable(claimDrops));
		claimDrops.click();
		wait.until(ExpectedConditions.elementToBeClickable(Approval));
		Approval.click();
		Thread.sleep(2000);

	}
	
	public void Productprocess(){
		wait.until(ExpectedConditions.elementToBeClickable(ConfigurationDropdown));
		ConfigurationDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductSetupDropdown));
		ProductSetupDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(Productbutton));
		Productbutton.click();
	}
	
	public void variantProcess() throws Throwable {
		
		wait.until(ExpectedConditions.elementToBeClickable(ConfigurationDropdown));
		ConfigurationDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductSetupDropdown));
		ProductSetupDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(VariantButton));
		VariantButton.click();
		
	}
	
	public void premiumProcess() {
		wait.until(ExpectedConditions.elementToBeClickable(ConfigurationDropdown));
		ConfigurationDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductSetupDropdown));
		ProductSetupDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(PremiumButton));
		PremiumButton.click();
	}
	public void premiumpaymentProcess() {
		wait.until(ExpectedConditions.elementToBeClickable(ConfigurationDropdown));
		ConfigurationDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductSetupDropdown));
		ProductSetupDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(PremiumPaymentFrequency));
		PremiumPaymentFrequency.click();		
	}
	public void Myaccountprocess()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Myaccount));
		Myaccount.click();
		wait.until(ExpectedConditions.elementToBeClickable(Changeproduct));
		Changeproduct.click();
	}
	
	public void ADRProcess() {
		wait.until(ExpectedConditions.elementToBeClickable(ClientmasterDropdown));
		ClientmasterDropdown.click();
		wait.until(ExpectedConditions.elementToBeClickable(AdvanceReceiptbutton));
		AdvanceReceiptbutton.click();
	}
	
	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		logoutButton.click();
		driver.switchTo().alert().accept();
		
	}
	
	public void memberuploading() {
		wait.until(ExpectedConditions.elementToBeClickable(Newbusiness));
		Newbusiness.click();
		wait.until(ExpectedConditions.elementToBeClickable(MemberUpload));
		MemberUpload.click();
	}
	
	public void Memdefectdata() {
		wait.until(ExpectedConditions.elementToBeClickable(Newbusiness));
		Newbusiness.click();
		wait.until(ExpectedConditions.elementToBeClickable(DefectData));
		DefectData.click();
	}
	public void Volutarymemberuploading() {
		wait.until(ExpectedConditions.elementToBeClickable(Newbusiness));
		Newbusiness.click();
		wait.until(ExpectedConditions.elementToBeClickable(Voluntarymemupload));
		Voluntarymemupload.click();
	}
	
}
