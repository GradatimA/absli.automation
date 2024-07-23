package com.ABSLI.qa.testcases.Newbusiness;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Newbusiness.NischintMemberUpload;
import com.ABSLI.qa.utill.AbsliUtill;

public class NischintMemberUoloadtest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "NischintMemberupload")
	public Object[][] getTestuploaded() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\Newbusiness\\MemberUploaded.xlsx",
				"Memupload");
		return arrbj;
	}

	@Test(priority = 0, dataProvider = "NischintMemberupload", dataProviderClass = NischintMemberUoloadtest.class)
	public void Nischintaddmember(String ClientName, String MasterPolicyNumber, String AgreementNumber,
			String AuthorisedSignatory, String FileLocation) throws Throwable {
		homepage.nischintMemberUploading();
		NischintMemberUpload NMU = new NischintMemberUpload();
		NMU.nischintMemupload(ClientName, MasterPolicyNumber, AgreementNumber, AuthorisedSignatory, FileLocation);
	}

	@DataProvider(name = "NischintDefectData")
	public Object[][] getTestdefuploaded() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\Newbusiness\\MemberUploaded.xlsx",
				"Defectdata");
		return arrbj;
	}

	@Test(priority = 1, dataProvider = "NischintDefectData", dataProviderClass = NischintMemberUoloadtest.class)
	public void defectdata(String ClientName, String MasterPolicyNumber, String AgreementNumber) throws Throwable {
		homepage.nischintdefectdata();
		NischintMemberUpload NMU = new NischintMemberUpload();
		NMU.nischintDefect(ClientName, MasterPolicyNumber, AgreementNumber);
	}

}
