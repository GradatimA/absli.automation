package com.ABSLI.qa.pages;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class Claimspage extends AbsliParent {

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimDrops;

	@FindBy(xpath = "//a[normalize-space()='Intimation']")
	WebElement Intimation;

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

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaimGroup_btngvSelectGroup_0']")
	WebElement Select;

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

	public Claimspage() {
		PageFactory.initElements(driver, this);

	}

	public void claimintimation() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		claimDrops.click();
		Thread.sleep(3000);
		Intimation.click();
		Thread.sleep(3000);
		Client_Name.sendKeys("Cynnent");
		Thread.sleep(3000);
		Client_Name.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(5000);
		Robot robot = new Robot();
		Master_Policy_Number.click();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		New_Claim.click();
		Thread.sleep(3000);
		Search.click();
		Thread.sleep(3000);
		Select.click();
		Thread.sleep(3000);
		Location_Of_Event.sendKeys("Bangalore");
		Thread.sleep(3000);
		DateOfEvent.sendKeys("01/05/2024");
		Thread.sleep(5000);
		Claim_Intimation_Date.click();
		Thread.sleep(5000);
		// NextButton.click();
		Thread.sleep(3000);
		// SPDate.click();
		Thread.sleep(3000);
		dropdownselector(Caus_of_Event, "1");
		Thread.sleep(3000);
		Beneficiary_Name.sendKeys("Test");
		Thread.sleep(3000);
		dropdownselector(PaymentMode, "12");
		Thread.sleep(3000);
		dropdownselector(RelationshipWithInsured, "11");
		Thread.sleep(3000);
		IFSCCode.sendKeys("ESS");
		Thread.sleep(3000);
		IFSCCode.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);
		// Bank_Name.sendKeys("Indian Bank");
		Thread.sleep(3000);
		dropdownselector(AccountType, "3");
		Thread.sleep(3000);
		AccountNumber.sendKeys("0987654321");
		Thread.sleep(3000);
		dropdownselector(ShareType, "1");
		Thread.sleep(3000);
		Share.sendKeys("100");
		Thread.sleep(8000);
		ClaimAmount.click();
		Thread.sleep(5000);
		AddButton.click();
		Thread.sleep(5000);
		OkButton.click();
		Thread.sleep(8000);
		Submit.click();
		Thread.sleep(8000);
		driver.switchTo().alert().accept();
		Thread.sleep(8000);
		// driver.switchTo().alert().accept();
		OkButton.click();
		Thread.sleep(8000);
		Claim_Intimation_Date.sendKeys("05/05/2024");
		Thread.sleep(8000);
		Submit.click();
		Thread.sleep(8000);
		driver.switchTo().alert().accept();
		Thread.sleep(8000);
		driver.switchTo().alert().getText();

	}

}
