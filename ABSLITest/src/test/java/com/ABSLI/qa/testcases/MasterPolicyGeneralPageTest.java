package com.ABSLI.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.MasterPolicyGeneralPage;

public class MasterPolicyGeneralPageTest extends AbsliParent {
	
	Loginpage loginpage;
	MasterPolicyGeneralPage maker;
	
	@BeforeClass
	public void setup() {
		initial();
		loginpage = new Loginpage();
		maker = new MasterPolicyGeneralPage();
	}
	
	@Test()
	public  void logintest() throws InterruptedException, IOException {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority = 1)
	public void masterPolicyMaker() throws InterruptedException {
		maker.clientmaster();
		
	}

	/*
	 * @AfterClass public void atlast() { driver.close();
	 * 
	 * }
	 */

}
