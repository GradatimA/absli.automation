package com.Analyzer;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ABSLI.qa.base.AbsliParent;
import com.ABSLI.qa.utill.AbsliUtill;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Mylisteners extends AbsliParent implements ITestListener {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case Started: "+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		System.out.println("Test Case Success: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		try {
			String failureTestCaseName = result.getName();
			AbsliUtill.takeScreenshotatTesting(failureTestCaseName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*****Test Case is Failed*****");
		System.out.println("Test Case Name: "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER));
		try {
			String skippedTestCaseName = result.getName();
			AbsliUtill.takeScreenshotatTesting(skippedTestCaseName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*****Test case is Skipped*****");
		System.out.println("Test Case Name: "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		String reportName = "Test-Report-" +AbsliUtill.getDateTimeString() +".html";
		htmlReporter=new ExtentSparkReporter("./extent-reports/" + reportName);
		try {
			htmlReporter.loadXMLConfig("./extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Manikandan");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
		extent.setSystemInfo("Application URL", prop.getProperty("url"));
		extent.setSystemInfo("Username", prop.getProperty("username"));
		extent.setSystemInfo("Password", prop.getProperty("password"));
		htmlReporter.config().setDocumentTitle("Absli Automation Test Report");
		htmlReporter.config().setReportName("Regression Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		System.out.println("Test Name: "+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		System.out.println("Test Finished: "+context.getName());
	}
		
	}