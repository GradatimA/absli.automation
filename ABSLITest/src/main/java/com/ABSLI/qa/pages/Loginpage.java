package com.ABSLI.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class Loginpage extends AbsliParent {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtUserName']")
	WebElement username;
	
	//input[@id='ContentPlaceHolder1_txtUserName']
	

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSubmit']")
	WebElement loginbtn;

	public Loginpage() {
		PageFactory.initElements(driver, this);

	}

	public void login(String un, String pwd) throws InterruptedException {
		Thread.sleep(2000);
		username.sendKeys(un);
		Thread.sleep(1000);
		password.sendKeys(pwd);
		Thread.sleep(1000);
		loginbtn.click();
		Thread.sleep(5000);

	}
}
