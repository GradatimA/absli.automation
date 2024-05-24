package com.ABSLI.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Claimspage;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.utill.AbsliUtill;

public class ClaimspageTest extends AbsliParent {
	Loginpage loginpage;
	// Claimspage claims;
	Homepage homepage;

	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

//	@Test(priority = 1)
//	public void logintest() throws InterruptedException, IOException {
//		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
//	}

	@DataProvider(name = "ClaimIntimation")
	public Object[][] getTestClaiIntimation() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ClaimData.xlsx",
				"ClaimIntimation");
		return arrbj;
	}

	@Test(dataProvider = "ClaimIntimation", dataProviderClass = ClaimspageTest.class)

	public void CreateClaims(String LocationOfEvent,String DataOfEvent,String CauseOfEvent,String BeneficaryName,String PaymentMode,
			String RelationShipWithInsured,String IFSCCode,String AccountType,String AccountNumber,String ShareType,
			String Share,String ClaimIntimationDate) throws Throwable {
		homepage.ClaimIntialprocess();
		Claimspage CI = new Claimspage();
		CI.claimintimationProcess(LocationOfEvent,DataOfEvent,CauseOfEvent,BeneficaryName,PaymentMode,RelationShipWithInsured,IFSCCode,AccountType,AccountNumber,ShareType,Share,ClaimIntimationDate);

	}
}
