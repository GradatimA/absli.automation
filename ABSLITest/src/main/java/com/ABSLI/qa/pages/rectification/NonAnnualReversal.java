package com.ABSLI.qa.pages.rectification;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class NonAnnualReversal extends AbsliParent
{
	@FindBy(id = "ContentPlaceHolder1_txtGroupName")
	WebElement ClientName;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlApplicationNumber-container']")
	WebElement masterPolicynum;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAgreementNo-container']")
	WebElement Agreementnum;

	@FindBy(id = "ContentPlaceHolder1_fuLogo")
	WebElement choosefile;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnupload']")
	WebElement Uploadfile;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement inputBox;

	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;
	
	public NonAnnualReversal() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void nonannualreversalprocess(String clinam, String masternum, String Agreenum, String path) throws Throwable 
	{
		ClientName.sendKeys(clinam);
		Thread.sleep(3000);
		ClientName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);
		masterPolicynum.click();
		Thread.sleep(3000);
		inputBox.sendKeys(masternum, Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(Agreementnum));
		Agreementnum.click();
		Thread.sleep(3000);
		inputBox.sendKeys(Agreenum, Keys.ENTER);
		Thread.sleep(3000);
		choosefile.sendKeys(path);
		Thread.sleep(2000);
		Uploadfile.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();
	}
}
