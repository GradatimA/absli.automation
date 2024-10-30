package com.ABSLI.qa.testcases.refund;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.refund.ExcessRefundMaker;
import com.ABSLI.qa.utill.AbsliUtill;

public class ExcessRefundMakertest extends AbsliParent

{

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable

	{
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();

	}

	@DataProvider(name = "RefundMakerTest")

                	public Object[][] getTestrefund() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\refund\\Refund.xlsx",
				"ExcessRefund");
		return arrbj;
	}

	@Test(dataProvider = "RefundMakerTest", dataProviderClass = ExcessRefundMakertest.class)
	public void refundmakerprocess(String ClientName, String MasterpolicyNumber, String AgreementNumber,
			String ReasonForPayment, String PayoutType, String PayoutPercentage, String PayoutAmount,
			String PaymentMode, String AccountHolderName, String AccountNumber, String AccountType, String BankIFSCCode)
			throws Throwable

	{
		homepage.excessrefundmaker();
		ExcessRefundMaker ERM = new ExcessRefundMaker();
		ERM.excessmaker(ClientName, MasterpolicyNumber, AgreementNumber, ReasonForPayment, PayoutType, PayoutPercentage,
				PayoutAmount, PaymentMode, AccountHolderName, AccountNumber, AccountType, BankIFSCCode);
	}

}
