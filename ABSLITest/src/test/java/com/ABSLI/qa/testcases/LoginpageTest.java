package com.ABSLI.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Claimspage;
import com.ABSLI.qa.pages.Loginpage;

public class LoginpageTest extends AbsliParent {
     Loginpage loginpage;
	

	/*
	 * public LoginpageTest() { super();
	 * 
	 * }
	 */

	@BeforeMethod
	public void setup() {
		initial();
		loginpage = new Loginpage();
	}

	@AfterMethod
	public void atlast() {
		driver.close();
	}

	@Test()
	public  void logintest() throws InterruptedException, IOException {
		loginpage.login(prop.getProperty("usernames"), prop.getProperty("passwords"));
	}

}
