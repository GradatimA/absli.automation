package com.ABSLI.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.awt.AWTException;
import java.io.IOException;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.ClaimsAssessmentpage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.utill.AbsliUtill;

public class ClaimsAssessmentpageTest extends AbsliParent {

	Loginpage loginpage;
	

	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		

	}
	@DataProvider(name = "ClaimAssessment")
	public Object[][] getTestClaiIntimation() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ClaimData.xlsx",
				"ClaimAssessment");
		return arrbj;
	}

	@Test(dataProvider = "ClaimAssessment", dataProviderClass = ClaimsAssessmentpageTest.class)
	public void ClaimsAssessment(String ClaimReccommendation,String DeviationApprover,String AdditionalDocument,
			                      String DocumentName,String  DocumentType) throws InterruptedException, AWTException {
		ClaimsAssessmentpage CA =new ClaimsAssessmentpage();
		CA.Assessment(ClaimReccommendation,DeviationApprover,AdditionalDocument,DocumentName,DocumentType);
	}
}
