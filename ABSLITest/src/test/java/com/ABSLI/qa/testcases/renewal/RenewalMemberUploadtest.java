package com.ABSLI.qa.testcases.renewal;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.renewal.RenewalMemberUpload;
import com.ABSLI.qa.utill.AbsliUtill;

public class RenewalMemberUploadtest extends AbsliParent {
	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "RenewalMember")
	public Object[][] getTestmemadd() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\endorsement\\MemberAddition.xlsx",
				"Sheet1");
		return arrbj;
	}

	@Test(dataProvider = "RenewalMember", dataProviderClass = RenewalMemberUploadtest.class)
	public void renewaluploaded(String ClientName, String MasterPolicyNumber, String AgreementNumber,String Authorized,
			String FileLocation) throws Throwable {
		homepage.renewalprocess();
		RenewalMemberUpload RMU = new RenewalMemberUpload();
		RMU.renewalmemberprocess(ClientName, MasterPolicyNumber, AgreementNumber,Authorized, FileLocation);

	}
}
