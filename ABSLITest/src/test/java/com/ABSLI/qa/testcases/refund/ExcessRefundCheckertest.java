package com.ABSLI.qa.testcases.refund;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.refund.ExcessRefundChecker;
import com.ABSLI.qa.utill.AbsliUtill;

public class ExcessRefundCheckertest extends AbsliParent {

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

	@DataProvider(name = "RefundcheckerTest")

	public Object[][] getTestrefund() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\refund\\Refund.xlsx",
				"Sheet1");
		return arrbj;
	}

	@Test(dataProvider = "RefundcheckerTest", dataProviderClass = ExcessRefundCheckertest.class)
	public void refundcheckerprocess(String ClientName, String MasterpolicyNumber, String AgreementNumber,
			String Reason, String Button) throws Throwable

	{
		homepage.excessrefundchecker();
		ExcessRefundChecker ERC = new ExcessRefundChecker();
		ERC.excesschecker(ClientName, MasterpolicyNumber, AgreementNumber, Reason, Button);
	}
}
