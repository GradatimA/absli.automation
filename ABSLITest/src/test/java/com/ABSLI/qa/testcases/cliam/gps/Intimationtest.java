package com.ABSLI.qa.testcases.cliam.gps;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Claims.Intimationpage;
import com.ABSLI.qa.utill.AbsliUtill;
import com.Analyzer.Mylisteners;

@Listeners(Mylisteners.class)
public class Intimationtest extends AbsliParent {
	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "ClaimIntimation")
	public Object[][] getTestClaiIntimation() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\claims\\"
						+ "ClaimData.xlsx",
				"ClaimIntimation");
		return arrbj;
	}

	@Test(dataProvider = "ClaimIntimation", dataProviderClass = Intimationtest.class)

	public void CreateClaims(String ClientName, String MasterPolicyNumber, String MemberID, String Type, String Riders,
			String LocationOfEvent, String DataOfEvent, String CauseOfEvent, String IssameasNBorEndorsementNominees,
			String BeneficaryName, String PaymentMode, String RelationShipWithInsured, String IFSCCode,
			String AccountType, String AccountNumber, String Coverage, String ShareType, String Share,
			String ClaimAmount, String ClaimIntimationDate, String AdditionalDocument, String DocumentName,
			String DocumentType) throws Throwable {
		homepage.ClaimIntialprocess();
		Intimationpage CI = new Intimationpage();
		CI.claimintimationProcess(ClientName, MasterPolicyNumber, MemberID, Type, Riders, LocationOfEvent, DataOfEvent,
				CauseOfEvent, IssameasNBorEndorsementNominees, BeneficaryName, PaymentMode, RelationShipWithInsured,
				IFSCCode, AccountType, AccountNumber, Coverage, ShareType, Share, ClaimAmount, ClaimIntimationDate,
				AdditionalDocument, DocumentName, DocumentType);
	}
	
	@Test
	public void validationcreateclaim() throws Throwable 
	{
		homepage.ClaimIntialprocess();
		Intimationpage CI = new Intimationpage();
		CI.validationclaimintimationProcess();
	}
	/*
	 * @AfterMethod public void endUp() { homepage.logout(); end(); }
	 */

}
