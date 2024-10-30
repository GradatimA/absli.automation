package com.ABSLI.qa.testcases.rectification;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.rectification.ReceiptReversal;
import com.ABSLI.qa.utill.AbsliUtill;

public class ReceiptReversaltest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;

	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}

	@DataProvider(name = "reversalreceipt")
	public Object[][] getTestreverrec() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\rectification\\Rectification.xlsx",
				"Receipt");
		return arrbj;
	}

	@Test(dataProvider = "reversalreceipt", dataProviderClass = ReceiptReversaltest.class)
	public void receiptreversal(String ClientName, String MasterPolicyNumber, String AgreementNumber,
			String ReasonForReceipt) throws Throwable 
	{
		homepage.receiptreversalprocess();
		ReceiptReversal RR = new ReceiptReversal();
		RR.receiptreversalprocess(ClientName, MasterPolicyNumber, AgreementNumber, ReasonForReceipt);
	}
}
