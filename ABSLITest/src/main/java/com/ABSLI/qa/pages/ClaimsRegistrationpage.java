package com.ABSLI.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class ClaimsRegistrationpage extends AbsliParent {

	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimDrops;
	
	@FindBy(xpath = "//a[normalize-space()='Registration']")
	WebElement Registration;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Client_Name;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement Master_Policy_Number;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaim_btngvClaimSelect_0']")
	WebElement Select;
	
	
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement Search;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnClaimSave']")
	WebElement Register;
	
	@FindBy(xpath = "//button[@type='button'][@class='ui-button ui-corner-all ui-widget']")
	WebElement OkButton;
	
	public ClaimsRegistrationpage() {
		PageFactory.initElements(driver, this);
		
	}

	public void Registration() throws InterruptedException, AWTException {
		/*
		 * Thread.sleep(5000); claimDrops.click(); Thread.sleep(3000);
		 * Registration.click(); Thread.sleep(3000); Client_Name.sendKeys("Cynnent");
		 * Thread.sleep(3000); Client_Name.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		 * Thread.sleep(5000); Robot robot = new Robot(); Master_Policy_Number.click();
		 * Thread.sleep(5000); robot.keyPress(KeyEvent.VK_DOWN); Thread.sleep(3000);
		 * robot.keyPress(KeyEvent.VK_DOWN); Thread.sleep(3000);
		 * robot.keyPress(KeyEvent.VK_ENTER); Thread.sleep(3000); Search.click();
		 * Thread.sleep(3000); Select.click();
		 */
		Thread.sleep(3000);
		Register.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		OkButton.click();
		
	}
}
