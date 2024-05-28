package com.ABSLI.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.ClaimApprovalpage;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;

public class ClaimsApprovalpageTest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;
//	Approvalpage approve;

	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		homepage = new Homepage();
		loginpage.login(prop.getProperty("usernames"), prop.getProperty("password"));
		//approve = new Approvalpage();

	}
	/*
	 * @Test() public void logintest() throws InterruptedException, IOException {
	 * loginpage.login(prop.getProperty("usernames"),
	 * prop.getProperty("passwords")); }
	 */

	@Test(priority = 1)
	public void Approvetest() throws Throwable {
		homepage.Approvalprocess();
		ClaimApprovalpage CA = new ClaimApprovalpage();
		
		CA.Approvalmethod();
	}

}
