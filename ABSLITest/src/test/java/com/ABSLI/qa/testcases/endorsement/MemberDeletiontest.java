package com.ABSLI.qa.testcases.endorsement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.endorsement.MemberAddition;
import com.ABSLI.qa.pages.endorsement.MemberDeletion;
import com.ABSLI.qa.utill.AbsliUtill;

public class MemberDeletiontest extends AbsliParent{

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "MemberDel")
	public Object[][] getTestmemdel() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\endorsement\\MemberAddition.xlsx",
				"MemberAddition");
		return arrbj;
	}
	@Test(dataProvider = "MemberDel", dataProviderClass = MemberDeletiontest.class)
	public void memberdeletionprocess(String ClientName, String MasterPolicyNumber, String AgreementNumber,
			String FileLocation) throws Throwable {
		  homepage.memberdeletion();
		  MemberDeletion MD=new MemberDeletion();
		  MD.deletionprocess(ClientName, MasterPolicyNumber, AgreementNumber, FileLocation);
	}
	@AfterMethod
	public void endUp()
	{
		homepage.logout();
		end();
	}
}
