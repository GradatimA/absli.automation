package com.ABSLI.qa.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class Homepage extends AbsliParent {
	
	@FindBy(xpath = "//body/form[@id='frm']/div[@id='wrapper']/nav[@id='sidebar_wrapper']"
			+ "/ul[@class='nav sidebar-nav']/li[@id='liClaims']/a[1]")
	WebElement claimDrops;

	@FindBy(xpath = "//a[normalize-space()='Intimation']")
	WebElement Intimation;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSearchCompanyName']")
	WebElement Client_Name;

	@FindBy(xpath = "//span[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-container']")
	WebElement Master_Policy_Number;

	@FindBy(xpath = "//li[@id='select2-ContentPlaceHolder1_ddlMasterPolicyNo-result-l847-68113']")
	WebElement drops;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rbtNBusiness']")
	WebElement New_Claim;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSearchClaims']")
	WebElement Search;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_gvClaimGroup_btngvSelectGroup_0']")
	WebElement Select;
	
      public Homepage() {
    	  PageFactory.initElements(driver, this);
      }
      
      public void ClaimIntialprocess() throws Throwable {
    	  Thread.sleep(3000);
  		claimDrops.click();
  		Thread.sleep(3000);
  		Intimation.click();
  		Thread.sleep(3000);
  		Client_Name.sendKeys("Cynnent");
  		Thread.sleep(3000);
  		Client_Name.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
  		Thread.sleep(5000);
  		Robot robot = new Robot();
  		Master_Policy_Number.click();
  		Thread.sleep(5000);
  		robot.keyPress(KeyEvent.VK_DOWN);
  		Thread.sleep(3000);
  		robot.keyPress(KeyEvent.VK_DOWN);
  		Thread.sleep(3000);
  		robot.keyPress(KeyEvent.VK_ENTER);
  		Thread.sleep(3000);
  		New_Claim.click();
  		Thread.sleep(3000);
  		Search.click();
  		Thread.sleep(3000);
  		Select.click();
    	  
      }
      
      
      
}
