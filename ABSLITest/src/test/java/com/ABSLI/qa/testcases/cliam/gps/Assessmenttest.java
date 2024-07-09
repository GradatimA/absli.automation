package com.ABSLI.qa.testcases.cliam.gps;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.io.IOException;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Claims.Assessmentpage;
import com.ABSLI.qa.utill.AbsliUtill;
import com.Analyzer.Mylisteners;
@Listeners(Mylisteners.class)
public class Assessmenttest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();

	}

	@DataProvider(name = "ClaimAssessment")
	public Object[][] getTestClaiIntimation() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ClaimData.xlsx",
				"Sheet1");
		return arrbj;
	}

	@Test(dataProvider = "ClaimAssessment", dataProviderClass = Assessmenttest.class)
	public void ClaimsAssessment(String ClientName,String MasterPolicyNumber,String ClaimReccommendation,String ClaimSettlementAmount, String DeviationApprover) throws Throwable {
	    homepage.Assessmentprocess();
		Assessmentpage CA = new Assessmentpage();
		CA.Assessment(ClientName,MasterPolicyNumber,ClaimReccommendation,ClaimSettlementAmount, DeviationApprover);
	}
	@AfterMethod
	public void endUp()
	{
		homepage.logout();
		end();
	}
}
