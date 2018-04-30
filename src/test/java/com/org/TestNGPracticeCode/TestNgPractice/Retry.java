package com.org.TestNGPracticeCode.TestNgPractice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer{
	// code to retry your failed test cases.
	public boolean retry(ITestResult result) {
			int counter = 0;
			int reTryCount = 1;
			if (counter < reTryCount) {
				counter++;
				return true;
			}
			return false;
		}

}
