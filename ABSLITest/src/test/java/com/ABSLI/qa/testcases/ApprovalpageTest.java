package com.ABSLI.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Approvalpage;
import com.ABSLI.qa.pages.Loginpage;

public class ApprovalpageTest extends AbsliParent {

	Loginpage loginpage;
	Approvalpage approve;

	@BeforeClass
	public void setup() {
		initial();
		loginpage = new Loginpage();
		approve = new Approvalpage();

	}

	@Test()
	public void logintest() throws InterruptedException, IOException {
		loginpage.login(prop.getProperty("usernames"), prop.getProperty("passwords"));
	}

	@Test(priority = 1)
	public void Approvetest() throws AWTException, InterruptedException {
		approve.Approvalmethod();
	}

}
