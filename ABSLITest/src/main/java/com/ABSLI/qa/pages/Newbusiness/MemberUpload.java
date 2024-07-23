package com.ABSLI.qa.pages.Newbusiness;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.ABSLI.qa.base.AbsliParent;

public class MemberUpload extends AbsliParent {
	
	@FindBy(id="ContentPlaceHolder1_txtGroupName")
	WebElement ClientName;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlApplicationNumber-container']")
	WebElement masterPolicynum;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAgreementNo-container']")
	WebElement Agreementnum;
	
	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAuthorisedSignatory-container']")
	WebElement autorisedsign;
	
	@FindBy(id="ContentPlaceHolder1_fuLogo")
	WebElement choosefile;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnupload']")
	WebElement Uploadfile;
	
	@FindBy(xpath ="//input[@role='textbox']")
	WebElement inputBox;
	
	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;
	
	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;
	
	@FindBy(id="ContentPlaceHolder1_btnSearch")
	WebElement SearchButton;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtCompanyName']")
	WebElement defclientname;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_gvDefectsDatas_lbnSuccessRecords_0']")
	WebElement sucessrecord;
	
	@FindBy(xpath = "//a[@id='ContentPlaceHolder1_gvDefectsDatas_lbnFailureRecords_0']")
	WebElement failurerecord;
	
	public MemberUpload() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void memberuploadprocess(String clinam,String masternum,String Agreenum,String Authorsign,String path) throws Throwable {
		
	ClientName.sendKeys(clinam);
	Thread.sleep(3000);
	ClientName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	Thread.sleep(3000);
	masterPolicynum.click();
	Thread.sleep(3000);
	inputBox.sendKeys(masternum,Keys.ENTER);
	wait.until(ExpectedConditions.elementToBeClickable(Agreementnum));
	Agreementnum.click();
	Thread.sleep(3000);
	inputBox.sendKeys(Agreenum,Keys.ENTER);
	Thread.sleep(3000);
	autorisedsign.click();
	Thread.sleep(3000);
	inputBox.sendKeys(Authorsign,Keys.ENTER);
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
	
	public void defectdataprocess(String clinam,String masternum,String Agreenum) throws Throwable {
		Thread.sleep(3000);
		defclientname.sendKeys(clinam);
		Thread.sleep(3000);
		defclientname.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(3000);
		masterPolicynum.click();
		Thread.sleep(3000);
		inputBox.sendKeys(masternum,Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(Agreementnum));
		Agreementnum.click();
		Thread.sleep(3000);
		inputBox.sendKeys(Agreenum,Keys.ENTER);
		Thread.sleep(3000);
		SearchButton.click();
		String textValue = failurerecord.getText();
		String storedValue = textValue;
	    int intValue = Integer.parseInt(storedValue);
		System.out.println(intValue);
		if(intValue == 0)
		{
			System.out.println("The member successfully upolad");
			
		}
		else
		{
			failurerecord.click();
			
		}
		
	}
}
