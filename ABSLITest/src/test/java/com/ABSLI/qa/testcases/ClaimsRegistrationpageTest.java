package com.ABSLI.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.ClaimsRegistrationpage;
import com.ABSLI.qa.pages.Claimspage;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;

public class ClaimsRegistrationpageTest extends AbsliParent {
	
	Loginpage loginpage;
  Homepage homepage;
//	Claimspage claims;
	
	//ClaimsRegistrationpage Regis;


	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		homepage = new Homepage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//claims = new Claimspage();
		//Regis = new ClaimsRegistrationpage();

	}

	/*
	 * @Test() public void logintest() throws InterruptedException, IOException {
	 * loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	 * }
	 */
	@Test(priority = 1)
	
	public void RegistrationTest() throws Throwable {
		homepage.Registrationprocess();
		ClaimsRegistrationpage CR = new ClaimsRegistrationpage();
		CR.Registration();
	}

}
