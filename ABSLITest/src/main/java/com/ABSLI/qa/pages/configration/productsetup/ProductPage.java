package com.ABSLI.qa.pages.configration.productsetup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ABSLI.qa.base.AbsliParent;

public class ProductPage extends AbsliParent {

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtPlanName']")
	WebElement productName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtShortName']")
	WebElement Code;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlCategory']")
	WebElement Category;
	
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']")
	WebElement ProductSaveButton;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public void AddProduct(String product,String code,String category) throws Throwable {
		
		wait.until(ExpectedConditions.elementToBeClickable(productName));
		productName.sendKeys(product);
		wait.until(ExpectedConditions.elementToBeClickable(Code));
		Code.sendKeys(code);
		wait.until(ExpectedConditions.elementToBeClickable(Category));
		dropdown(Category, category);
		wait.until(ExpectedConditions.elementToBeClickable(ProductSaveButton));
		ProductSaveButton.click();
		Thread.sleep(2000);
	}

}
