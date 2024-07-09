package com.ABSLI.qa.testcases.configuration.productsetup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.configration.productsetup.PremiumPaymentFrequencypage;
import com.ABSLI.qa.pages.myaccount.ProductChangepage;
import com.ABSLI.qa.utill.AbsliUtill;

public class PremiumPaymentFrequencytest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;
	ProductChangepage productChangepage;

	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}
	@DataProvider(name = "ProductPaymentFrequency")
	public Object[][] getTestpayment() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ProductSetup.xlsx",
				"Premiumpayfreq");
		return arrbj;
	}
	
	@Test(dataProvider = "ProductPaymentFrequency",dataProviderClass = PremiumPaymentFrequencytest.class)
	public void Createpremiumpayfreq(String Variant,String PremiumPaymentFrequency,String ModalFactor,String GracePeriod,String NOticePeriod) throws Throwable {
		homepage.Myaccountprocess();
		productChangepage =new ProductChangepage();
	    productChangepage.changeproduct(prop.getProperty("Productname"));
		homepage.premiumpaymentProcess();
		PremiumPaymentFrequencypage PPF=new  PremiumPaymentFrequencypage();
		PPF.premiumpayfreqprocess(Variant,PremiumPaymentFrequency,ModalFactor,GracePeriod,NOticePeriod);
	}
		
}
