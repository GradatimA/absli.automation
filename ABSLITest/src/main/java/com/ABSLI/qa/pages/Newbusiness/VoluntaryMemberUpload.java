package com.ABSLI.qa.pages.Newbusiness;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class VoluntaryMemberUpload extends AbsliParent {

	@FindBy(id = "ContentPlaceHolder1_txtGroupName")
	WebElement ClientName;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlApplicationNumber-container']")
	WebElement masterPolicynum;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAgreementNo-container']")
	WebElement Agreementnum;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlAuthorisedSignatory-container']")
	WebElement autorisedsign;

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

	@FindBy(id = "ContentPlaceHolder1_btnSearch")
	WebElement SearchButton;

	public VoluntaryMemberUpload() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void volumemupload() throws Throwable {
		ClientName.sendKeys("Cynnent");
		Thread.sleep(3000);
		ClientName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(3000);
		masterPolicynum.click();
		Thread.sleep(3000);
		inputBox.sendKeys("CYNGPOY202400022009 ",Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(Agreementnum));
		Agreementnum.click();
		Thread.sleep(3000);
		inputBox.sendKeys("565455",Keys.ENTER);
		Thread.sleep(3000);
		autorisedsign.click();
		Thread.sleep(3000);
		inputBox.sendKeys("Diana Dsouza",Keys.ENTER);
		Thread.sleep(3000);
		choosefile.sendKeys("C:\\Users\\Mallikandan E\\Documents\\New Member Addition Template 05-07-01.xlsx");
		Thread.sleep(2000);
		Uploadfile.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();
	}
}
