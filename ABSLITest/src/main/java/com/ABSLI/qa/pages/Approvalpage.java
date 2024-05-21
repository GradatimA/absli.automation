package com.ABSLI.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearch']")
	WebElement Search;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaim_btngvClaimSelect_0']")
	WebElement Select;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnClaimSave']")
	WebElement ApprovalButton;

	public Approvalpage() {

		PageFactory.initElements(driver, this);
	}

	public void Approvalmethod() throws AWTException, InterruptedException {

		Robot robot = new Robot();
		Thread.sleep(8000);
		ClaimsDrop.click();
		Thread.sleep(3000);
		Approval.click();
		Thread.sleep(3000);
		Clientname.sendKeys("cynnent");
		Thread.sleep(3000);
		Clientname.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);
		MasterPolicyNumber.click();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		Search.click();
		Thread.sleep(3000);
		Select.click();
		Thread.sleep(3000);
		ApprovalButton.click();
		Thread.sleep(3000);

	}

}
