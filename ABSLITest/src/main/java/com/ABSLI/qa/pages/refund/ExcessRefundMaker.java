package com.ABSLI.qa.pages.refund;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class ExcessRefundMaker extends AbsliParent {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtDepostiRefund']")
	WebElement Schemelevel;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtMemberRefund']")
	WebElement Memberlevel;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement clientname;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement masterpolicynum;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement inputbox;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAgreementNo-container']")
	WebElement agreementnum;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearchRefund']")
	WebElement searchbutton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvDepositRefundGroup_btngvSelectGroup_0']")
	WebElement select;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlReason-container']")
	WebElement reasonforpayment;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPayoutPercentage']")
	WebElement payoutpercentage;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPayoutAmount']")
	WebElement Payoutamount;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlPayoutType-container']")
	WebElement payouttype;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ucPolicyHolderPayment_ddlPaymentMode-container']")
	WebElement paymentmode;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ucPolicyHolderPayment_txtAccountName']")
	WebElement accountholdername;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ucPolicyHolderPayment_txtAccountNumber']")
	WebElement accountnum;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ucPolicyHolderPayment_ddlAccountType-container']")
	WebElement accouttype;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_ucPolicyHolderPayment_txtIFSCCode']")
	WebElement bankifsccode;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSendBM']")
	WebElement sendbacktomaker;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']")
	WebElement sendtochecker;

	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;

	public ExcessRefundMaker()

	{
		PageFactory.initElements(driver, this);
	}

	public void excessmaker(String clinam, String masternum, String agreenum, String reasonpay, String payouttyp,
			String payoutpercent, String payoutamt, String paymode, String accountname, String accnum, String acctyp,
			String ifsc) throws Throwable

	{

		Schemelevel.click();
		wait.until(ExpectedConditions.elementToBeClickable(clientname));
		clientname.sendKeys(clinam);
		Thread.sleep(3000);
		clientname.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(masterpolicynum));
		Thread.sleep(3000);
		masterpolicynum.click();
		Thread.sleep(3000);
		inputbox.sendKeys(masternum, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);
		agreementnum.click();
		Thread.sleep(3000);
		inputbox.sendKeys(agreenum, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);
		searchbutton.click();
		Thread.sleep(3000);
		select.click();
		wait.until(ExpectedConditions.elementToBeClickable(reasonforpayment));
		reasonforpayment.click();
		Thread.sleep(3000);
		inputbox.sendKeys(reasonpay, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);

		if (payouttyp.equals("Percentage")) {
			payouttype.click();
			Thread.sleep(3000);
			inputbox.sendKeys(payouttyp, Keys.ARROW_DOWN, Keys.ENTER);
			wait.until(ExpectedConditions.elementToBeClickable(payoutpercentage));
			payoutpercentage.sendKeys(payoutpercent, Keys.ENTER);
			Thread.sleep(3000);
		} else {
			payouttype.click();
			Thread.sleep(3000);
			inputbox.sendKeys(payouttyp, Keys.ARROW_DOWN, Keys.ENTER);
			wait.until(ExpectedConditions.elementToBeClickable(Payoutamount));
			Payoutamount.sendKeys(payoutamt, Keys.ENTER);
		}
		Thread.sleep(3000);
		if(paymode.equals("Neft")) {
		paymentmode.click();
		Thread.sleep(3000);
		inputbox.sendKeys(paymode, Keys.ARROW_DOWN, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(accountholdername));
		accountholdername.sendKeys(accountname);
		wait.until(ExpectedConditions.elementToBeClickable(accountnum));
		accountnum.sendKeys(accnum, Keys.ENTER);
		Thread.sleep(3000);
		accouttype.click();
		Thread.sleep(3000);
		inputbox.sendKeys(acctyp, Keys.ARROW_DOWN, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(bankifsccode));
		bankifsccode.sendKeys(ifsc, Keys.ENTER);
		Thread.sleep(3000);
		}
		else
		{
			paymentmode.click();
			Thread.sleep(3000);
			inputbox.sendKeys(paymode, Keys.ARROW_DOWN, Keys.ENTER);
			wait.until(ExpectedConditions.elementToBeClickable(accountholdername));
			accountholdername.sendKeys(accountname);
			wait.until(ExpectedConditions.elementToBeClickable(accountnum));
			accountnum.sendKeys(accnum, Keys.ENTER);
			Thread.sleep(3000);
		}
		sendtochecker.click();
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();

	}
}
