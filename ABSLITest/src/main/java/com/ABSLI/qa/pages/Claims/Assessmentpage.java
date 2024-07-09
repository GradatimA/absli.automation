package com.ABSLI.qa.pages.Claims;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

import bsh.This;

public class Assessmentpage extends AbsliParent {

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimsdrop;

	@FindBy(xpath = "//a[normalize-space()='Assessment']")
	WebElement Assessment;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Client_Name;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement Master_Policy_Number;
	
	@FindBy(xpath = "//input[@role='textbox']")
	WebElement input;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchClaimID']")
	WebElement ClaimID;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement Search;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaim_btngvClaimSelect_0']")
	WebElement Select;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlPayout']")
	WebElement Claim_Recommendation;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtClaimSumAssured']")
	WebElement ClaimSettlementAmount;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlapproverlist']")
	WebElement Deviation_Approver;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnClaimSave']")
	WebElement SendForApproval;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlNewRequirement']")
	WebElement Additional_Documents;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAdditionalDocument']")
	WebElement DocumentName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddAdditionalDoc']")
	WebElement AddButton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkDocumentType_0']")
	WebElement Checklist;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlDocumentType']")
	WebElement DocumentType;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_afuUpload']")
	WebElement UploadFile;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddDocuments']")
	WebElement AddDocument;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;	
	

	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;
	
	public Assessmentpage() {
		PageFactory.initElements(driver, this);
	}
	public void Assessment(String clinam,String MPolicy,String ClaimRecc,String claimAmt,String DeviaApprved) throws InterruptedException, AWTException {

		Robot robot = new Robot();
		Client_Name.sendKeys(clinam);
		Thread.sleep(2000);
		Client_Name.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(2000);
		Master_Policy_Number.click();
		Thread.sleep(2000);
		input.sendKeys(MPolicy,Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(2000);
		Search.click();
		Thread.sleep(2000);
		Select.click();
		Thread.sleep(2000);
		if(ClaimRecc.equals("Pay Full")) {
			wait.until(ExpectedConditions.elementToBeClickable(Claim_Recommendation));
			dropdown(Claim_Recommendation, ClaimRecc);
		}
		else
		{
			wait.until(ExpectedConditions.elementToBeClickable(ClaimSettlementAmount));
			ClaimSettlementAmount.sendKeys(claimAmt,Keys.ENTER);
		}
		Thread.sleep(3000);
		dropdown(Deviation_Approver, DeviaApprved);
		wait.until(ExpectedConditions.elementToBeClickable(SendForApproval));
		SendForApproval.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();
		
	}

}
