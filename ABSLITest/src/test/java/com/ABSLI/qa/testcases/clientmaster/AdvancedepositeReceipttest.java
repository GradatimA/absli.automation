package com.ABSLI.qa.testcases.clientmaster;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.clientMaster.AdvanceDepositeReceipting;

public class AdvancedepositeReceipttest extends AbsliParent {
	Loginpage loginpage;
	Homepage homepage;
	

	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}
	@Test
	public void receipting() throws Throwable {
		homepage.ADRProcess();
		AdvanceDepositeReceipting ADR = new AdvanceDepositeReceipting();
		ADR.addreceiptProcess();
	}
}
