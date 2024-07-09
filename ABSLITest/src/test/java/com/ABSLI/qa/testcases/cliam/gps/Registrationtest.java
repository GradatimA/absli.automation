package com.ABSLI.qa.testcases.cliam.gps;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Claims.Intimationpage;
import com.ABSLI.qa.pages.Claims.Registrationpage;
import com.ABSLI.qa.utill.AbsliUtill;
import com.Analyzer.Mylisteners;
@Listeners(Mylisteners.class)
public class Registrationtest extends AbsliParent {
	
	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		homepage = new Homepage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@DataProvider(name = "ClaimRegistration")
	public Object[][] getTestClaimRegistration() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ClaimData.xlsx",
				"ClaimRegistration");
		return arrbj;
	}

	@Test(dataProvider = "ClaimRegistration", dataProviderClass = Registrationtest.class)

	public void RegistrationTest(String ClientName, String MasterPolicyNumber) throws Throwable {
		homepage.Registrationprocess();
		Registrationpage CR = new Registrationpage();
		CR.Registration(ClientName, MasterPolicyNumber);
	}
	@AfterMethod
	public void endUp()
	{
		homepage.logout();
		end();
	}

}
