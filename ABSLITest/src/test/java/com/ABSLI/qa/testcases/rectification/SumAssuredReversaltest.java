package com.ABSLI.qa.testcases.rectification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.rectification.SumAssuredReversal;
import com.ABSLI.qa.utill.AbsliUtill;

public class SumAssuredReversaltest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "reversalSA")
	public Object[][] getTestreversa() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\rectification\\Rectification.xlsx",
				"NBReversal");
		return arrbj;
	}

	@Test(dataProvider = "reversalSA", dataProviderClass = SumAssuredReversaltest.class)
	public void reversalsa(String ClientName, String MasterPolicyNumber, String AgreementNumber, String FileLocation)
			throws Throwable {
		homepage.sumassuredreversalprocess();
		SumAssuredReversal SAR = new SumAssuredReversal();
		SAR.sareversalprocess(ClientName, MasterPolicyNumber, AgreementNumber, FileLocation);
	}

}
