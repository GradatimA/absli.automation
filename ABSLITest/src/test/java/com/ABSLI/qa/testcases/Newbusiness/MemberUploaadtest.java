package com.ABSLI.qa.testcases.Newbusiness;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.Newbusiness.MemberUpload;

public class MemberUploaadtest extends AbsliParent {
	
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
	public void addmember() throws Throwable {
		homepage.memberuploading();
		MemberUpload MU = new MemberUpload();
		MU.memberuploadprocess();
		homepage.Memdefectdata();
		MU.defectdataprocess();
		
		
	}

}
