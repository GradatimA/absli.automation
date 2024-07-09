package com.ABSLI.qa.testcases.Newbusiness;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Newbusiness.MemberUpload;
import com.ABSLI.qa.pages.Newbusiness.VoluntaryMemberUpload;

public class VoluntaryMemberUploadtest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;
    
    
	@BeforeMethod
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}
	@Test
	public void Voluntryaddmember() throws Throwable {
		homepage.Volutarymemberuploading();
		VoluntaryMemberUpload VMU = new VoluntaryMemberUpload();
		VMU.volumemupload();
	}
}
