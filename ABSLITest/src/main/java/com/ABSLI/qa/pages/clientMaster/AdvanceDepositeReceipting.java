package com.ABSLI.qa.pages.clientMaster;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class AdvanceDepositeReceipting extends AbsliParent{

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Clientname;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement SearchButton;
	
	@FindBy(xpath = "//i[@title='Edit']")
	WebElement EditButton;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement MasterPolicyNumber;
	
	@FindBy(xpath = "//input[@role='textbox']")
	WebElement inputbox;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAgreementNo-container']")
	WebElement AgreementNumber;
	
	@FindBy(id="select2-ContentPlaceHolder1_ucPolicyHolderPayment_ddlPaymentMode-container")
	WebElement Paymentmode;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ucPolicyHolderPayment_txtPaymentDate']")
	WebElement Paymentdate;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ucPolicyHolderPayment_txtAmount']")
	WebElement Paidamount;
	
	@FindBy(id="select2-ContentPlaceHolder1_ucPolicyHolderPayment_ddlCollectionBank-container")
	WebElement Collectionbank;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ucPolicyHolderPayment_btnAddInitialPremium']")
	WebElement Addelement;
	
	@FindBy(id="ContentPlaceHolder1_btnSaveProduct")
	WebElement AddReceipt;
	
	@FindBy(id="select2-ContentPlaceHolder1_ucPolicyHolderPayment_ddlBankName-container")
	WebElement Bankname;
	
	@FindBy(id="select2-ContentPlaceHolder1_ucPolicyHolderPayment_ddlBankBranchName-container")
	WebElement Branchname;
	
	@FindBy(id="ContentPlaceHolder1_ucPolicyHolderPayment_btnAddInitialPremium")
	WebElement Addpayment;
	
	
	
	
	
	public AdvanceDepositeReceipting() {
		
		PageFactory.initElements(driver, this);
	}
	public void addreceiptProcess() throws Throwable 
	{
		Thread.sleep(5000);
		Clientname.sendKeys("cynnent",Keys.ENTER);
		Thread.sleep(3000);
		SearchButton.click();
		Thread.sleep(2000);
		EditButton.click();
		MasterPolicyNumber.click();
		Thread.sleep(2000);
		inputbox.sendKeys("",Keys.ENTER);
		Thread.sleep(2000);
		dropdownselector(Paymentmode, "NEFT / RTGS");
		Thread.sleep(2000);
		Paidamount.sendKeys("500000");
		dropdownselector(Bankname, "INDIAN BANK");
		Thread.sleep(2000);
		dropdownselector(Branchname, "ASHOK NAGAR");
		Thread.sleep(2000);
		dropdownselector(Collectionbank, "CENTRAL BANK OF INDIA");
		
		
	}
			
}
