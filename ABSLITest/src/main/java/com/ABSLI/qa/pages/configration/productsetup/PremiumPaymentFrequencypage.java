package com.ABSLI.qa.pages.configration.productsetup;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class PremiumPaymentFrequencypage extends AbsliParent
    {
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlSearchPlan-container']")
	WebElement VariantSearch;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlSearchPremiumPayFreq-container']")
	WebElement PremiumpayFreqSearch;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement SearchButton;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlPlan-container']")
	WebElement VariantDropdown;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlPremiumPaymentFrequency-container']")
	WebElement PremiumpayfreqDropdown;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtModalFactors']")
	WebElement ModalFactor;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtGracePeriod']")
	WebElement Graceperiod;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtNoticePeriod']")
	WebElement Noticeperiod;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']")
	WebElement SaveButton;
	
	@FindBy(xpath = "//input[@role='textbox']")
	WebElement InputBox;
   
	
	public PremiumPaymentFrequencypage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void premiumpayfreqprocess(String Vari,String Freq,String Modal,String Grace,String Notice) throws Throwable
	{
		Thread.sleep(2000);
		VariantDropdown.click();
		InputBox.sendKeys(Vari,Keys.ENTER);
		PremiumpayfreqDropdown.click();
		InputBox.sendKeys(Freq,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		ModalFactor.sendKeys(Modal);
		Graceperiod.sendKeys(Grace);
		Noticeperiod.sendKeys(Notice);
		//SaveButton.click();
       		
	}

}
