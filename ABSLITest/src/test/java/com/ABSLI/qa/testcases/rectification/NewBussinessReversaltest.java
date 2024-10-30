package com.ABSLI.qa.testcases.rectification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.rectification.NewBussinessReversal;
import com.ABSLI.qa.utill.AbsliUtill;

public class NewBussinessReversaltest extends AbsliParent {
	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "reversalNB")
	public Object[][] getTestrevernb() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\rectification\\Rectification.xlsx",
				"NBReversal");
		return arrbj;
	}

	@Test(dataProvider = "reversalNB", dataProviderClass = NewBussinessReversaltest.class)

	public void reversalnb(String ClientName, String MasterPolicyNumber, String AgreementNumber, String FileLocation)
			throws Throwable {
		homepage.newbusinessreversalprocess();
		NewBussinessReversal NBR = new NewBussinessReversal();
		NBR.nbreversalprocess(ClientName, MasterPolicyNumber, AgreementNumber, FileLocation);

	}
}
