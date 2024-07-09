package com.ABSLI.qa.pages.Claims;

import java.awt.AWTException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ABSLI.qa.base.AbsliParent;

public class Intimationpage extends AbsliParent {

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimDrops;

	@FindBy(xpath = "//a[normalize-space()='Intimation']")
	WebElement Intimation;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Client_Name;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement Master_Policy_Number;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement input;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtABSLIMemberID']")
	WebElement memberid;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtNBusiness']")
	WebElement New_Claim;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearchClaims']")
	WebElement Search;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaimGroup_btngvSelectGroup_0']")
	WebElement Select;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtRiderClaimType']")
	WebElement RiderClaim;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtBaseAdditionalCI']")
	WebElement Base_AdditionalRiders;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtLocationofDeath']")
	WebElement Location_Of_Event;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDateofLoss']")
	WebElement DateOfEvent;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtClaimIntimationDate']")
	WebElement Claim_Intimation_Date;

	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='prev'][normalize-space()='«']")
	WebElement NextButton;

	@FindBy(xpath = "//td[@class='day'][normalize-space()='5']")
	WebElement SPDate;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlCauseofdeath']")
	WebElement Caus_of_Event;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtTypeOfDeathNatural']")
	WebElement NaturalButton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtTypeOfDeathUnnatural']")
	WebElement UnNaturalButton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbIssameasNBorEndorsementNominee_0']")
	WebElement YesButton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtBeneficiary']")
	WebElement Beneficiary_Name;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlPaymentMode']")
	WebElement PaymentMode;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlBeneficiaryRelationShip']")
	WebElement RelationshipWithInsured;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtBeneficiaryIFSCCode']")
	WebElement IFSCCode;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtBeneficiaryBankName']")
	WebElement Bank_Name;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlBenenficiaryAccountType']")
	WebElement AccountType;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtBeneficiaryAccountNo']")
	WebElement AccountNumber;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlBenenficiaryshareType']")
	WebElement ShareType;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtBeneficiaryShare']")
	WebElement Share;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtBeneficiaryClaimAmounttShare']")
	WebElement ClaimAmount;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddBeneficiary']")
	WebElement AddButton;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']")
	WebElement Submit;

	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlNewRequirement']")
	WebElement Additional_Documents;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAdditionalDocument']")
	WebElement DocumentName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddAdditionalDoc']")
	WebElement AddDocButton;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkDocumentType_0']")
	WebElement Checklist;

	@FindBy(id = "ContentPlaceHolder1_ddlDocumentType")
	WebElement DocumentType;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_afuUpload']")
	WebElement UploadFile;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddDocuments']")
	WebElement AddDocument;

	public Intimationpage() {
		PageFactory.initElements(driver, this);
	}

	public void claimintimationProcess(String clinam, String MPolicy, String MemID, String Location, String DOE,
			String COE, String IssameasNBorEndorsementNominees, String BeniName, String PayMode, String RelaWithInsu,
			String Ifsccode, String AccType, String AccNum, String Sharetyp, String share, String ClmAmt, String COD,
			String AddiDocu, String DocuName, String DocuType) throws InterruptedException, AWTException {

		Client_Name.sendKeys(clinam);
		Thread.sleep(1000);
		Client_Name.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(2000);
		Master_Policy_Number.click();
		Thread.sleep(2000);
		input.sendKeys(MPolicy, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(2000);
	//	memberid.sendKeys(MemID);
		New_Claim.click();
		Search.click();
		wait.until(ExpectedConditions.elementToBeClickable(Select));
		Select.click();
		wait.until(ExpectedConditions.elementToBeClickable(Location_Of_Event));
		Location_Of_Event.sendKeys(Location, Keys.ENTER);
		DateOfEvent.sendKeys(DOE, Keys.ENTER);
		Claim_Intimation_Date.sendKeys(COD);
		dropdown(Caus_of_Event, COE);
		Thread.sleep(3000);
		if (IssameasNBorEndorsementNominees.equals("Yes")) {
			YesButton.click();
			Thread.sleep(2000);
			dropdown(PaymentMode, PayMode);
			Thread.sleep(2000);
		} else {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(Beneficiary_Name));
			Beneficiary_Name.sendKeys(BeniName, Keys.ENTER);
			Thread.sleep(3000);
			dropdown(PaymentMode, PayMode);
			Thread.sleep(3000);
			dropdown(RelationshipWithInsured, RelaWithInsu);
		}
		Thread.sleep(3000);
		IFSCCode.sendKeys(Ifsccode);
		Thread.sleep(2000);
		IFSCCode.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		dropdown(AccountType, AccType);
		Thread.sleep(2000);
		AccountNumber.sendKeys(AccNum, Keys.ENTER);
		System.out.println(Sharetyp);
		Thread.sleep(2000);
		if (Sharetyp.equals("Percentage")) {
			dropdown(ShareType, Sharetyp);
			Thread.sleep(2000);
			Share.sendKeys(share, Keys.ENTER);
			Thread.sleep(2000);
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(ClaimAmount));
			ClaimAmount.sendKeys(ClmAmt, Keys.ENTER);
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(AddButton));
		AddButton.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(OkButton));
		OkButton.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Additional_Documents));
		dropdown(Additional_Documents, AddiDocu);
		Thread.sleep(2000);
		DocumentName.sendKeys(DocuName, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(AddDocButton));
		AddDocButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(Checklist));
		Checklist.click();
		//wait.until(ExpectedConditions.elementToBeClickable(DocumentType));
		Thread.sleep(2000);
		dropdown(DocumentType, DocuType);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(UploadFile));
		UploadFile.sendKeys("C:\\Users\\Mallikandan E\\Documents\\Automation Testing Worksheet.xlsx");
		AddDocument.click();
		wait.until(ExpectedConditions.elementToBeClickable(OkButton));
		OkButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(Submit));
		Submit.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();

	}

}
