package com.ABSLI.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.ABSLI.qa.utill.AbsliUtill;

public class AbsliParent {

	public static WebDriver driver;
	public static Properties prop;

	public AbsliParent() {
		prop = new Properties();

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\config\\AbsliConfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initial() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Mallikandan E\\eclipse-workspace\\Practice_claim\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("FF")) {
			// System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(AbsliUtill.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(AbsliUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	public static void  dropdownselector(WebElement e,String str) {
		
		Select s=new Select(e);
		s.selectByValue(str);

	}
	public static void dropdown(WebElement f,String str) {
		Select v=new Select (f);
		v.selectByVisibleText(str);
		
	}
}
