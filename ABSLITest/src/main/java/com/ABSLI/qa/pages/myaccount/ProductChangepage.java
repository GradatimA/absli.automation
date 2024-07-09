package com.ABSLI.qa.pages.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ABSLI.qa.base.AbsliParent;

public class ProductChangepage extends AbsliParent {

	@FindBy(id = "ContentPlaceHolder1_ddlPlan")
	WebElement ProductChangedropdown;
	
	public ProductChangepage() 
	{
		PageFactory.initElements(driver, this);
	}
	public void changeproduct(String Productchange) throws InterruptedException {
		dropdown(ProductChangedropdown, Productchange);
		Thread.sleep(3000);
	}
}
