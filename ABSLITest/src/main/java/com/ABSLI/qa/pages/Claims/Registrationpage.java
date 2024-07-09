package com.ABSLI.qa.pages.Claims;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class Registrationpage extends AbsliParent {

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimDrops;

	@FindBy(xpath = "//a[normalize-space()='Registration']")
	WebElement Registration;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Client_Name;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement Master_Policy_Number;
	
	@FindBy(xpath = "//input[@role='textbox']")
	WebElement input;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchClaimID']")
	WebElement ClaimID;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaim_btngvClaimSelect_0']")
	WebElement Select;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement Search;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnClaimSave']")
	WebElement Register;

	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;
	
	@FindBy(id = "ContentPlaceHolder1_Messagebox_lblMsg")
	WebElement popMessageText;

	public Registrationpage() {
		PageFactory.initElements(driver, this);

	}

	public void Registration(String clinam,String MPolicy) throws InterruptedException, AWTException {

		
		Client_Name.sendKeys(clinam);
		Thread.sleep(2000);
		Client_Name.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(2000);
		Master_Policy_Number.click();
		Thread.sleep(2000);
		input.sendKeys(MPolicy,Keys.ARROW_DOWN,Keys.ENTER);
		Search.click();
		Thread.sleep(2000);
		Select.click();
		wait.until(ExpectedConditions.elementToBeClickable(Register));
		Register.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(popMessageText));
		String popMsgTextValue = popMessageText.getText();
		System.out.println("Popup Message: " + popMsgTextValue);
		OkButton.click();

	}
}
