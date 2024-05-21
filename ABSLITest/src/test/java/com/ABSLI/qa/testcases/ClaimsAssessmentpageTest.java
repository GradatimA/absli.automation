package com.ABSLI.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.io.IOException;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.ClaimsAssessmentpage;
import com.ABSLI.qa.pages.Loginpage;

public class ClaimsAssessmentpageTest extends AbsliParent {

	Loginpage loginpage;
	ClaimsAssessmentpage Assess;

	@BeforeClass
	public void setup() {
		initial();
		loginpage = new Loginpage();
		Assess = new ClaimsAssessmentpage();

	}

	@Test()
	public void logintest() throws InterruptedException, IOException {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void ClaimsAssessment() throws InterruptedException, AWTException {
		Assess.Assessment();
	}
}
