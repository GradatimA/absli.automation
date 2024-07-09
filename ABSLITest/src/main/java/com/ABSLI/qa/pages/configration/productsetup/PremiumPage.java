package com.ABSLI.qa.pages.configration.productsetup;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class PremiumPage extends AbsliParent{

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlProduct-container']")
	WebElement Variantdropdown;
	
	@FindBy(xpath = "//input[@role='textbox']")
	WebElement InputBox;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlProductPremiumType-container']")
	WebElement Typedropdown;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlCoverage-container']")
	WebElement BenifitsRider;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement SearchButton;
	
	@FindBy(xpath ="//input[@id='ContentPlaceHolder1_UInfluencingfactors_txtRuleSetName']")
	WebElement RuleSetName;
	
	@FindBy(xpath = "//span[@class='select2 select2-container select2-container--default']")
	WebElement SpecifiedUs;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_UInfluencingfactors_gvRules_gvtxtMinimumValue_0']")
	WebElement InfluencingFactorMinAgeYrs;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_UInfluencingfactors_gvRules_gvtxtMinimumMonth_0']")
	WebElement InfluencingFactorMinAgeMon;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_UInfluencingfactors_gvRules_gvtxtMaximumValue_0']")
	WebElement InfluencingFactorMaxAgeYrs;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_UInfluencingfactors_gvRules_gvtxtMaximumMonth_0']")
	WebElement InfluencingFactorMaxAgeMon;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_UInfluencingfactors_txtPremiumValue']")
	WebElement PremiumValue;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_UInfluencingfactors_btnAddRuleSet']")
	WebElement SaveRuleSet;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuLogo']")
	WebElement ChooseFile;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnupload']")
	WebElement FileUpload;
	


public PremiumPage() 
{
	PageFactory.initElements(driver, this);
}

public void premiumCreation(String variant,String type,String benifit,String rule,String spec,String minyrs,String minmon,String maxyrs,String maxmon,String prem) throws Throwable 
{
	
	Thread.sleep(2000);
	Variantdropdown.click();
	Thread.sleep(2000);
	InputBox.sendKeys(variant,Keys.ENTER);
	Typedropdown.click();
	Thread.sleep(2000);
	InputBox.sendKeys(type,Keys.ARROW_DOWN,Keys.ENTER);
	Thread.sleep(2000);
	BenifitsRider.click();
	Thread.sleep(2000);
	InputBox.sendKeys(benifit,Keys.ARROW_DOWN,Keys.ENTER);
	SearchButton.click();
	Thread.sleep(3000);
	RuleSetName.sendKeys(rule);
	SpecifiedUs.click();
	Thread.sleep(2000);
	InputBox.sendKeys(spec,Keys.ARROW_DOWN,Keys.ENTER);
	Thread.sleep(2000);
	InfluencingFactorMinAgeYrs.sendKeys(minyrs);
	InfluencingFactorMinAgeMon.sendKeys(minmon);
	InfluencingFactorMaxAgeYrs.sendKeys(maxyrs);
	InfluencingFactorMaxAgeMon.sendKeys(maxmon);
	PremiumValue.sendKeys(prem);
	Thread.sleep(3000);
	ChooseFile.sendKeys("C:\\Users\\Mallikandan E\\Documents\\Automation Testing Worksheet.xlsx");
	Thread.sleep(3000);
//	FileUpload.click();
}
}
