package com.ABSLI.qa.testcases.configuration.productsetup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.configration.productsetup.VariantPage;
import com.ABSLI.qa.utill.AbsliUtill;

public class Varianttest extends AbsliParent{
	
	Loginpage loginpage;
	Homepage homepage;
	
	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}
	@DataProvider(name = "Variantdemo1")
	public Object[][] getTestvarianttestdata() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel("C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\Configuration\\ProductSetup.xlsx", "Sheet1");
		return arrbj;
	}
	@Test(dataProvider = "Variantdemo1",dataProviderClass = Varianttest.class)
	public void Variantcreation(String Product,String Variant,String Code,String UIN,String UINEffectiveDate,String VariantStartDate,String VariantEndDate,String VariantMinEntryAge,String VariantMaxEntryAge,
			String UnderwritingMinAge,String UnderWritingMaxAge,String VariantMinTerm,String VariantMaxTerm,String MinSumAssured,String MaxSumAssured,String FreeLookup,String Frequency
			,String RiderFactor,String EligibleForLoan,String WaitingPeriodForLoan,String WaitingPeriodForNB,String WaitingPeriodForEndorsement,String IsUnderwritingApplicable,String WaitingPeriodForClaim
			,String ProductType,String EndorsementMemberDeletionApplicable,String IsSurrenderApplicable,String IsMasterpolicyRenewalVariantEditable,String IsMultipleYearRenewalTerm
			,String PremiumPaymentTerm,String AgeFrom,String AgeTo,String BenifitRider,String StumpDutyRate,String WaitingForClaimPeriod,String AccidentPeriodReport,String SurvivalPeriod,String PermanencePeriod,String DeathVerificationPeriod,String EffectFromDate,String EffectToDate) throws Throwable {
		homepage.variantProcess();
		VariantPage Vp = new VariantPage();
		Vp.AddVariant(Product,Variant,Code,UIN,UINEffectiveDate,VariantStartDate,VariantEndDate,VariantMinEntryAge,VariantMaxEntryAge,UnderwritingMinAge,UnderWritingMaxAge
				,VariantMinTerm,VariantMaxTerm,MinSumAssured,MaxSumAssured,FreeLookup,Frequency,RiderFactor,EligibleForLoan,WaitingPeriodForLoan,WaitingPeriodForNB,WaitingPeriodForEndorsement
				,IsUnderwritingApplicable,WaitingPeriodForClaim,ProductType,EndorsementMemberDeletionApplicable,IsSurrenderApplicable,IsMasterpolicyRenewalVariantEditable,
				IsMultipleYearRenewalTerm,PremiumPaymentTerm,AgeFrom,AgeTo,BenifitRider,StumpDutyRate,WaitingForClaimPeriod,AccidentPeriodReport,SurvivalPeriod,PermanencePeriod,DeathVerificationPeriod,EffectFromDate,EffectToDate);
	}

}
