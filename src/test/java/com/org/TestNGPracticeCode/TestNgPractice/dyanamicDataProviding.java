package com.org.TestNGPracticeCode.TestNgPractice;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class dyanamicDataProviding  {
	Assertion hardAssert = new Assertion();
	SoftAssert softAssert = new SoftAssert();

	//if you don't give retryAnalyzer=Retry.class but have Transformation.java file with listner in testng.xml
	//even then test case will be retried on failure.
	@Test(dataProvider = "getData",retryAnalyzer=Retry.class)
	public void logIn(String name, String familyName) {
		softAssert.assertEquals(name, "Saurabh");
		System.out.println("Name is" + name + " " + familyName);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am in Before method of parallelRunWithPriorityAndGrouping.");
	}

	@AfterMethod
	// This Method will be executed after every test case.Hence should contain
	// some common things for all the test cases which required after running the
	// test case.
	public void afterMethod() {
		System.out.println("I am in after method of parallelRunWithPriorityAndGrouping.");
	}

	// return new Object[][] {
	// new Object[] { 1, "a" },
	// new Object[] { 2, "b" },
	// };
	@DataProvider
	public Object[][] getData() {
		Object[][] dataSet = new Object[4][2];
		dataSet[0][0] = "Saurabh";
		dataSet[0][1] = "Saurabh1";

		dataSet[1][1] = "Saurabh";
		dataSet[1][1] = "Saurabh3";

		dataSet[2][1] = "Saurabh";
		dataSet[2][1] = "Saurabh5";

		dataSet[3][1] = "Saurabh1";
		dataSet[3][1] = "Saurabh7";

		return dataSet;
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am in before classof parallelRunWithPriorityAndGrouping.");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am in after class of parallelRunWithPriorityAndGrouping.");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am in before test class of parallelRunWithPriorityAndGrouping.");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am in after test calss of parallelRunWithPriorityAndGrouping.");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am in before Suite of of parallelRunWithPriorityAndGrouping.");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am in after Suite of parallelRunWithPriorityAndGrouping.");
	}
}
