package com.ABSLI.qa.testcases.configuration.productsetup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.pages.Homepage;
import com.ABSLI.qa.pages.Loginpage;
import com.ABSLI.qa.pages.configration.productsetup.ProductPage;
import com.ABSLI.qa.utill.AbsliUtill;

public class Producttest extends AbsliParent {

	Loginpage loginpage;
	Homepage homepage;
	
	@BeforeClass
	public void setup() throws Throwable {
		initial();
		loginpage = new Loginpage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new Homepage();
	}
	@DataProvider(name = "Producttestdata")
	public Object[][] getTestproducttestdata() {
		Object arrbj[][] = AbsliUtill.getDataFromExcel(
				"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\testdata\\ProductSetup.xlsx",
				"Producttestdata");
		return arrbj;
	}
	@Test(dataProvider = "Producttestdata",dataProviderClass = Producttest.class)
	public void ProductCreation (String ProductName,String Code,String Category) throws Throwable {
		homepage.Productprocess();
		ProductPage pt = new ProductPage();
	     pt.AddProduct(ProductName,Code,Category);
	}
	
}
