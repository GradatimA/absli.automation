package com.ABSLI.qa.testcases.cliam.gps;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Claims.Approvalpage;
import com.ABSLI.qa.utill.AbsliUtill;

public class Approvaltest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;
//	Approvalpage approve;

	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		homepage = new Homepage();
		loginpage.login(prop.getProperty("usernames"), prop.getProperty("password"));
	}
	@DataProvider(name = "ClaimRegistration")
	public Object[][] getTestClaimRegistration() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ClaimData.xlsx",
				"ClaimRegistration");
		return arrbj;
	}

	@Test(dataProvider = "ClaimRegistration", dataProviderClass = Approvaltest.class)
	public void Approvetest(String ClientName,String MasterPolicyNumber) throws Throwable {
		homepage.Approvalprocess();
		Approvalpage CA = new Approvalpage();
		CA.Approvalmethod(ClientName,MasterPolicyNumber);
	}

}
