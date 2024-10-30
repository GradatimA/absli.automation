package com.ABSLI.qa.pages.Claims;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import com.ABSLI.qa.base.AbsliParent;

public class Approvalpage extends AbsliParent {

	@FindBy(xpath = "//a[normalize-space()='Claims']")
	WebElement ClaimsDrop;

	@FindBy(xpath = "//a[normalize-space()='Approval']")
	WebElement Approval;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Clientname;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement MasterPolicyNumber;
	
	@FindBy(xpath = "//input[@role='textbox']")
	WebElement input;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchClaimID']")
	WebElement ClaimID;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement Search;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaim_btngvClaimSelect_0']")
	WebElement Select;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnClaimSave']")
	WebElement ApprovalButton;
	
	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;

	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;
	public Approvalpage() {

		PageFactory.initElements(driver, this);
	}

	public void Approvalmethod(String clinam,String MPolicy) throws AWTException, InterruptedException {

	

		Thread.sleep(3000);
		Clientname.sendKeys(clinam);
		Thread.sleep(3000);
		Clientname.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);
		MasterPolicyNumber.click();
		Thread.sleep(5000);
		input.sendKeys(MPolicy,Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(3000);
		Search.click();
		Thread.sleep(3000);
		Select.click();
		Thread.sleep(3000);
		//ApprovalButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();
		

	}

}
