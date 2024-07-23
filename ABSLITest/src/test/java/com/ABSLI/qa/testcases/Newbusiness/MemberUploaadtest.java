package com.ABSLI.qa.testcases.Newbusiness;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Newbusiness.MemberUpload;
import com.ABSLI.qa.utill.AbsliUtill;

public class MemberUploaadtest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "Memberupload")
	public Object[][] getTestuploaded() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\Newbusiness\\MemberUploaded.xlsx",
				"Memupload");
		return arrbj;
	}

	@Test(priority = 0, dataProvider = "Memberupload", dataProviderClass = MemberUploaadtest.class)
	public void addmember(String ClientName, String MasterPolicyNumber, String AgreementNumber,
			String AuthorisedSignatory, String FileLocation) throws Throwable {
		homepage.memberuploading();
		MemberUpload MU = new MemberUpload();
		MU.memberuploadprocess(ClientName, MasterPolicyNumber, AgreementNumber, AuthorisedSignatory, FileLocation);
	}

	@DataProvider(name = "DefectData")
	public Object[][] getTestdefuploaded() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\Newbusiness\\MemberUploaded.xlsx",
				"Defectdata");
		return arrbj;
	}

	@Test(priority = 1, dataProvider = "DefectData", dataProviderClass = MemberUploaadtest.class)
	public void defectdataprocess(String ClientName, String MasterPolicyNumber, String AgreementNumber)
			throws Throwable {
		homepage.Memdefectdata();
		MemberUpload MU = new MemberUpload();
		MU.defectdataprocess(ClientName, MasterPolicyNumber, AgreementNumber);
	}

	@AfterMethod
	public void endUp() {
		homepage.logout();
		end();
	}
}
