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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ABSLI.qa.utill.AbsliUtill;

public class AbsliParent {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	public AbsliParent()  {
	
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\src\\main\\java\\com\\ABSLI\\qa\\config\\AbsliConfig.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initial() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Mallikandan E\\git\\Manikandan-AutomationScript\\ABSLITest\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("FF")) {
			// System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(AbsliUtill.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(AbsliUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		driver.get(prop.getProperty("url"));
	}
	public static void end()
	{
		driver.manage().window().minimize();
		driver.quit();
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
