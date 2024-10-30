package com.ABSLI.qa.pages.refund;

import java.util.Scanner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class ExcessRefundChecker extends AbsliParent {

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

	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtRejReason']")
	WebElement Reasonfield;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']")
	WebElement Approve;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnReject']")
	WebElement Reject;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSendBM']")
	WebElement SendBM;

	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;

	public ExcessRefundChecker() {
		PageFactory.initElements(driver, this);
	}

	public void excesschecker(String clinam, String masternum, String agreenum, String reason, String button) throws Throwable {
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
		Thread.sleep(3000);
		Reasonfield.sendKeys(reason);
		if (button.equals("Approve")) {
			Approve.click();
		} else if (button.equals("reject")) {
			Reject.click();
		} else {
			SendBM.click();
		}
		Thread.sleep(8000);
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();
	}
}
