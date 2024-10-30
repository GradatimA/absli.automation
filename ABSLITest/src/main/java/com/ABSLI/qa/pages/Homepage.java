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

	@FindBy(xpath = "//a[normalize-space()='Advance Deposit Receipting']")
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

	@FindBy(xpath = "//a[normalize-space()='Voluntary Defect Data']")
	WebElement Voluntarydefectdata;

	@FindBy(xpath = "//a[normalize-space()='Nischint NB Upload']")
	WebElement NischintNBUpload;

	@FindBy(xpath = "//a[normalize-space()='Nischint NB Defect Data']")
	WebElement NischintDefeactData;

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liEndorsement']/a[1]")
	WebElement Endorsement;

	@FindBy(xpath = "//a[contains(text(),'Member Addition – File Upload')]")
	WebElement MemberAddition;

	@FindBy(xpath = "//a[contains(text(),'Member Deletion – File Upload')]")
	WebElement MemberDeletion;

	@FindBy(xpath = "//a[@href='../Endorsement/FSAEndorsement?Type=A']")
	WebElement SumAssured;

	@FindBy(xpath = "//a[contains(text(),'Decrease Sum Assured – File Upload')]")
	WebElement Decreasesum;

	@FindBy(xpath = "//a[normalize-space()='Non Monetary - File Upload']")
	WebElement Nonmonetary;

	@FindBy(xpath = "//a[normalize-space()='Client File New Upload']")
	WebElement clientfilenewupload;

	@FindBy(xpath = "//li[@id='liRenewal']//a[@class='first-link']")
	WebElement Renewal;

	@FindBy(xpath = "//a[normalize-space()='Renewal Member Upload']")
	WebElement renewalmemberupload;

	@FindBy(xpath = "//a[normalize-space()='Nischint Member Upload']")
	WebElement renischint;

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']/ul[@class='nav sidebar-nav']/li[@id='liRefund']/a[1]")
	WebElement Refund;

	@FindBy(xpath = "//a[normalize-space()='Excess Refund Maker']")
	WebElement refundmaker;

	@FindBy(xpath = "//a[normalize-space()='Excess Refund Checker']")
	WebElement refundchecker;

	@FindBy(xpath = "//a[normalize-space()='Rectification']")
	WebElement rectification;

	@FindBy(xpath = "//a[normalize-space()='New Business Reversal - File Upload']")
	WebElement NBreversal;

	@FindBy(xpath = "//a[normalize-space()='Member Addition Reversal - File Upload']")
	WebElement MAreversal;

	@FindBy(xpath = "//a[normalize-space()='Member Deletion Reversal - File Upload']")
	WebElement MDreversal;

	@FindBy(xpath = "//a[normalize-space()='Sum Assured Reversal- File Upload']")
	WebElement SAreversal;

	@FindBy(xpath = "//a[normalize-space()='Decrease Sum Assured Reversal- File Upload']")
	WebElement DSAreversal;

	@FindBy(xpath = "//a[normalize-space()='Renewal Reversal - File Upload']")
	WebElement renewalreversal;

	@FindBy(xpath = "//a[normalize-space()='Underwriting Decision Reversal - File Upload']")
	WebElement UDreversal;

	@FindBy(xpath = "//a[normalize-space()='Receipt Reversal']")
	WebElement receiptreversal;

	@FindBy(xpath = "//a[normalize-space()='Non Annual Collection Reversal']")
	WebElement NACreversal;

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

		// wait.until(ExpectedConditions.elementToBeClickable(claimDrops));
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

	public void Productprocess() {
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

	public void Myaccountprocess() {
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

	public void Voluntarydefectdata() {
		wait.until(ExpectedConditions.elementToBeClickable(Newbusiness));
		Newbusiness.click();
		wait.until(ExpectedConditions.elementToBeClickable(Voluntarydefectdata));
		Voluntarydefectdata.click();
	}

	public void nischintMemberUploading() {
		wait.until(ExpectedConditions.elementToBeClickable(Newbusiness));
		Newbusiness.click();
		wait.until(ExpectedConditions.elementToBeClickable(NischintNBUpload));
		NischintNBUpload.click();
	}

	public void nischintdefectdata() {
		wait.until(ExpectedConditions.elementToBeClickable(Newbusiness));
		Newbusiness.click();
		wait.until(ExpectedConditions.elementToBeClickable(NischintDefeactData));
		NischintDefeactData.click();
	}

	public void memberaddition() {
		wait.until(ExpectedConditions.elementToBeClickable(Endorsement));
		Endorsement.click();
		wait.until(ExpectedConditions.elementToBeClickable(MemberAddition));
		MemberAddition.click();
	}

	public void memberdeletion() {
		wait.until(ExpectedConditions.elementToBeClickable(Endorsement));
		Endorsement.click();
		wait.until(ExpectedConditions.elementToBeClickable(MemberDeletion));
		MemberDeletion.click();
	}

	public void sumassured() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(Endorsement));
		Endorsement.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(SumAssured));
		SumAssured.click();
	}

	public void decreasesum() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(Endorsement));
		Endorsement.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(Decreasesum));
		Decreasesum.click();
	}

	public void nonmonetaryupload() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(Endorsement));
		Endorsement.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(Nonmonetary));
		Nonmonetary.click();
	}

	public void fileuploadprocess() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(Endorsement));
		Endorsement.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(clientfilenewupload));
		clientfilenewupload.click();
	}

	public void renewalprocess() {
		wait.until(ExpectedConditions.elementToBeClickable(Renewal));
		Renewal.click();
		wait.until(ExpectedConditions.elementToBeClickable(renewalmemberupload));
		renewalmemberupload.click();
	}

	public void renewalnischint() {
		wait.until(ExpectedConditions.elementToBeClickable(Renewal));
		Renewal.click();
		wait.until(ExpectedConditions.elementToBeClickable(renischint));
		renischint.click();

	}

	public void excessrefundmaker() {
		wait.until(ExpectedConditions.elementToBeClickable(Refund));
		Refund.click();
		wait.until(ExpectedConditions.elementToBeClickable(refundmaker));
		refundmaker.click();
	}

	public void excessrefundchecker() {
		wait.until(ExpectedConditions.elementToBeClickable(Refund));
		Refund.click();
		wait.until(ExpectedConditions.elementToBeClickable(refundchecker));
		refundchecker.click();
	}

	public void newbusinessreversalprocess() {
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(NBreversal));
		NBreversal.click();

	}

	public void memberadditionreversalprocess() {
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(MAreversal));
		MAreversal.click();
	}

	public void memberdeletionreversalprocess() {
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(MDreversal));
		MDreversal.click();
	}

	public void sumassuredreversalprocess() {
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(SAreversal));
		SAreversal.click();
	}

	public void decreasedsumassuredreversalprocess() {
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(DSAreversal));
		DSAreversal.click();
	}
	
	public void renewalreversalprocess() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(renewalreversal));
		renewalreversal.click();
	
	}
	public void underwritingreversalprocess()
	{
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(UDreversal));
		UDreversal.click();
	}
	public void nonannualreversalprocess() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(NACreversal));
		NACreversal.click();
	}
	
	public void receiptreversalprocess() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(rectification));
		rectification.click();
		wait.until(ExpectedConditions.elementToBeClickable(receiptreversal));
		receiptreversal.click();
	}
	
	
	
}
