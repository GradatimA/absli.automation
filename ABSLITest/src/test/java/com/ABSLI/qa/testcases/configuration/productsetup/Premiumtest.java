package com.ABSLI.qa.testcases.configuration.productsetup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.configration.productsetup.PremiumPage;
import com.ABSLI.qa.utill.AbsliUtill;

public class Premiumtest extends AbsliParent {
	Loginpage loginpage;
	Homepage homepage;

	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}
	@DataProvider(name = "ProductPremium")
	public Object[][] getTestpremium() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ProductSetup.xlsx",
				"Premium");
		return arrbj;
	}
	@Test(dataProvider = "ProductPremium",dataProviderClass = Premiumtest.class)
	public void Createpremium(String Variant,String Type,String BenefitRider,String RuleSetName,String SpecificAs,String MinYear,String MinMonth,String MaxYear,String MaxMonth,String PremiumValue) throws Throwable {
		homepage.premiumProcess();
		PremiumPage PP = new PremiumPage();
		PP.premiumCreation(Variant,Type,BenefitRider,RuleSetName,SpecificAs,MinYear,MinMonth,MaxYear,MaxMonth,PremiumValue);
	}
}
