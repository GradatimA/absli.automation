package com.ABSLI.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Claimspage;
import com.ABSLI.qa.pages.Loginpage;

public class ClaimspageTest extends AbsliParent {
	Loginpage loginpage;

	Claimspage claims;

	@BeforeClass
	public void setup() {
		initial();
		loginpage = new Loginpage();
		claims = new Claimspage();

	}

	@Test()
	public void logintest() throws InterruptedException, IOException {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void CreateClaims()throws InterruptedException, AWTException {
		claims.claimintimation();
		

	}
}
