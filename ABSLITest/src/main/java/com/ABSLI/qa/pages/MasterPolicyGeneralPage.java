package com.ABSLI.qa.pages;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class MasterPolicyGeneralPage extends AbsliParent {

	
	@FindBy(xpath = "//a[normalize-space()='Client Master']")
	WebElement client_master;
	
	@FindBy(xpath = "//a[normalize-space()='Master Policy - Maker']")
	WebElement maker;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompany']")
	WebElement clientname;
	
	/*
	 * @FindBy(xpath = "//div[@id='ui-id-8']") WebElement SearchButton;
	 */
	
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtInsurerMasterAgreementNo']")
	WebElement Agreement_number;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtQuotationDesc']")
	WebElement Quotation_Details;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlSalutation']")
	WebElement Contact_Person_First_Name_Dropdown;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtContactPersonFirstName']")
	WebElement Contact_Person_First_Name;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtContactNumber']")
    WebElement Contact_Number;
	
	@FindBy (xpath = "//input[@id='ContentPlaceHolder1_txtEmailID']")
	WebElement Email_ID;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTotalMembers']")
	WebElement Total_Probable_Number_of_Insured;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSumInsured']")
	WebElement Total_Sum_Assured_at_the_time_of_Inception_policy;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAgentCode']")
	WebElement Agent_Code;
	
	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtBrokerageUpdation']")
	WebElement Brokerage_Updation;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlProduct']")
	WebElement Variant;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAgreementStart']")
	WebElement Master_Policy_Inception_Date;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlBenefitType']")
	WebElement Benefit_Type;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkIsEmployee']")
	WebElement Type_of_Renewal;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtWindowPeriod']")
	WebElement Window_Period;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtNRIIsNRILetterReceivedNo']")
	WebElement NRA_Letter;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlFrequency']")
	WebElement Frequency;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlZonal']")
	WebElement Zone;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtUnderwritingMinimumAge']")
	WebElement Underwriting_Minimum_Age;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtUnderwritingMaximumAge']")
	WebElement Underwriting_Maximum_Age;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlReinsurer']")
	WebElement Reinsurer;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbUnitAddress_1']")
	WebElement NoButton;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbAddress_1']")
	WebElement Address;
	
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlCoverage']")
	WebElement Benefits_Riders;
	
	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlVariantType']")
	WebElement Variant_Type;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCoverageSumInsured']")
	WebElement Free_Cover_Limit;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnAddCoverage']")
	WebElement AddRiders;
	
	
	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement alert;
	
	
	
	
	
	
	
	
	
	
	public MasterPolicyGeneralPage() {
		PageFactory.initElements(driver, this);

	}

	public void clientmaster() throws InterruptedException  {
		Thread.sleep(3000);
		client_master.click();
		Thread.sleep(3000);
		maker.click();
		Thread.sleep(3000);
		clientname.sendKeys("Cynnent");
		Thread.sleep(3000);
		clientname.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		//SearchButton.click();
		Thread.sleep(9000);
		Agreement_number.sendKeys("345665");
		Thread.sleep(3000);
		Quotation_Details.sendKeys("NA");
		Thread.sleep(3000);
		
		dropdownselector(Contact_Person_First_Name_Dropdown, "9");
		Thread.sleep(3000);
		Contact_Person_First_Name.sendKeys("lic");
		Thread.sleep(3000);
		Contact_Number.sendKeys("0987654321");
		Thread.sleep(3000);
		Email_ID.sendKeys("manikandan.e@gradatim.co.in");
		Thread.sleep(3000);
		Total_Probable_Number_of_Insured.sendKeys("30");
		Thread.sleep(3000);
		Total_Sum_Assured_at_the_time_of_Inception_policy.sendKeys("10000000");
		Thread.sleep(3000);
		Agent_Code.sendKeys("C001");
		Thread.sleep(3000);
		Brokerage_Updation.sendKeys("50");
		Thread.sleep(3000);
		dropdownselector(Variant, "201");
		Thread.sleep(3000);
		Master_Policy_Inception_Date.sendKeys("01/04/2024");
		Thread.sleep(3000);
		dropdownselector(Benefit_Type, "4");
		Thread.sleep(5000);
		Type_of_Renewal.click();
		Thread.sleep(3000);
		Window_Period.sendKeys("60");
		Thread.sleep(3000);
		NRA_Letter.click();
		Thread.sleep(3000);
		dropdownselector(Frequency, "6");
		Thread.sleep(3000);
		dropdownselector(Zone, "2213");
		Thread.sleep(3000);
		Underwriting_Minimum_Age.sendKeys("18");
		Thread.sleep(3000);
		Underwriting_Maximum_Age.sendKeys("70");
		Thread.sleep(3000);
		dropdownselector(Reinsurer, "5");
		Thread.sleep(3000);
		NoButton.click();
		Thread.sleep(3000);
		Address.click();
		Thread.sleep(3000);
		dropdownselector(Benefits_Riders, "65");
		Thread.sleep(3000);
		dropdownselector(Variant_Type, "7");
		Thread.sleep(3000);
		Free_Cover_Limit.sendKeys("1000000");
		Thread.sleep(3000);
		AddRiders.click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept();
		
		alert.click();
		Thread.sleep(3000);
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
