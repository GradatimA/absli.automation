package com.ABSLI.qa.pages.rectification;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class ReceiptReversal extends AbsliParent {
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement ClientName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement SearchButton;

	@FindBy(xpath = "//i[@title='Edit']")
	WebElement EditButton;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement MasterpolicyNum;

	@FindBy(xpath = "//i[@class='fa fa-pencil']")
	WebElement ActionButton;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAgreementNo-container']")
	WebElement Agreementnum;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement inputBox;

	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtReasonForReversal']")
	WebElement ReasonForReversal;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnCancelReceipt']")
	WebElement cancelreceipt;

	public ReceiptReversal() {
		PageFactory.initElements(driver, this);

	}

	public void receiptreversalprocess(String clinam, String masternum, String Agreenum, String reason) throws Throwable {
		ClientName.sendKeys(clinam);
		Thread.sleep(3000);
		ClientName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);
		SearchButton.click();
		Thread.sleep(3000);
		EditButton.click();
		Thread.sleep(3000);
		MasterpolicyNum.click();
		Thread.sleep(3000);
		inputBox.sendKeys(masternum, Keys.ENTER);
		Thread.sleep(3000);
		Agreementnum.click();
		Thread.sleep(3000);
		inputBox.sendKeys(Agreenum, Keys.ENTER);
		Thread.sleep(3000);
		ActionButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(ReasonForReversal));
		ReasonForReversal.sendKeys(reason);
		// cancelreceipt.click();
		

	}
}
