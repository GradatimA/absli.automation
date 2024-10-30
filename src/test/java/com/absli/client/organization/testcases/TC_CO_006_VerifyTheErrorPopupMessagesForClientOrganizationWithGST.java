package com.absli.client.organization.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IListeners;

import com.absli.base.AbsliBase;
import com.absli.pages.HomePage;
import com.absli.pages.LoginPage;
import com.absli.pages.clientmaster.ClientOrganizationPage;
import com.absli.utill.MyITestListener;
import com.absli.utill.MySuiteListener;
import com.absli.utill.TestUtill;

@Listeners({MyITestListener.class,MySuiteListener.class})
public class TC_CO_006_VerifyTheErrorPopupMessagesForClientOrganizationWithGST extends AbsliBase {

	LoginPage loginPage;
	HomePage homePage;
	ClientOrganizationPage clientOrganizationPage;
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new LoginPage();
		loginPage.loginFunction(prof.getProperty("username"), prof.getProperty("password"));
		homePage=new HomePage();
	}
	
	@DataProvider(name = "TestDataFromTC_CO_006")
	public Object[][] getTestDataFromTC_CO_006() {
		Object arrobj[][] = TestUtill.getDataFromExcel("C:\\Users\\Gokulnath\\git\\com.absli.auto\\src\\main\\java\\com\\absli\\testdata\\client\\organization\\Test Data For TC_CO_006.xlsx", "TC_CO_006");
		return arrobj;
	}
	
	@Test(dataProvider = "TestDataFromTC_CO_006",dataProviderClass = TC_CO_006_VerifyTheErrorPopupMessagesForClientOrganizationWithGST.class)
	public void VerifyErrorPopupMessagesForClientOrganizationWithGST(String existClientName, String clientName, 
			String occuptionValue, String title, String firstNameValue, String typeofClient, String existPANNumber, 
			String panNumberValue, String invalidGSTNumber, String existGSTNumber, String validGSTNumber, String gstType, String changePasswordAccessValue, 
			String servicingBranchValue, String marketingOfficerCodeNum, String adds1, String zipCode, String county, String state, 
			String district) throws Throwable
	{
		homePage.clientOrganizationPage();
		clientOrganizationPage=new ClientOrganizationPage();
		clientOrganizationPage.VerifyTheErrorPopupMessagesForClientOrganizationwithGST(existClientName, clientName, occuptionValue, title, 
				firstNameValue, typeofClient, existPANNumber, panNumberValue, invalidGSTNumber, existGSTNumber, validGSTNumber, gstType, 
				changePasswordAccessValue, servicingBranchValue, marketingOfficerCodeNum, adds1, zipCode, county, state, district);
	}
}
