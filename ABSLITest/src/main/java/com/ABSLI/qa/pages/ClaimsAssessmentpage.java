package com.ABSLI.qa.pages;

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

import com.ABSLI.qa.base.AbsliParent;

import bsh.This;

public class ClaimsAssessmentpage extends AbsliParent {

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimsdrop;

	@FindBy(xpath = "//a[normalize-space()='Assessment']")
	WebElement Assessment;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Client_Name;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement Master_Policy_Number;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement Search;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaim_btngvClaimSelect_0']")
	WebElement Select;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlPayout']")
	WebElement Claim_Recommendation;

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

	@FindBy(xpath = "//div[@id='ContentPlaceHolder1_trImage']//div[@class='distab-cell-middle form-width']")
	WebElement UploadFile;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddDocuments']")
	WebElement AddDocument;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;	
	
	public ClaimsAssessmentpage() {
		PageFactory.initElements(driver, this);
	}

	public void Assessment() throws InterruptedException, AWTException {

		Robot robot = new Robot();
		Thread.sleep(8000);
		claimsdrop.click();
		Thread.sleep(3000);
		Assessment.click();
		Thread.sleep(3000);
		Client_Name.sendKeys("Cynnent");
		Thread.sleep(3000);
		Client_Name.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(5000);
		Master_Policy_Number.click();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		Search.click();
		Thread.sleep(3000);
		Select.click();
		Thread.sleep(3000);
		dropdownselector(Claim_Recommendation, "1");
		Thread.sleep(3000);
		dropdownselector(Deviation_Approver, "180");
		Thread.sleep(3000);
		dropdownselector(Additional_Documents, "1");
		Thread.sleep(3000);
		DocumentName.sendKeys("Adhar");
		Thread.sleep(3000);
		AddButton.click();
		Thread.sleep(3000);
		Checklist.click();
		Thread.sleep(3000);
		dropdownselector(DocumentType, "100001");
		Thread.sleep(5000);
		UploadFile.click();
		Thread.sleep(5000);
		String file = "C:\\Users\\Mallikandan E\\Downloads\\Simple-Fresher-Resume-Format.docx";
		StringSelection Selection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		AddDocument.click();
		Thread.sleep(3000);
		OkButton.click();
		Thread.sleep(3000);
		SendForApproval.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		OkButton.click();
		
		//dropdownselector(Additional_Documents, "1");
		//Thread.sleep(3000);
		
		
	}

}
