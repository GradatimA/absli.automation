package com.Analyzer;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class MySuitelistener implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Suite Name: "+suite.getName());
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Finished Suite Name: "+suite.getName());
	}

}
