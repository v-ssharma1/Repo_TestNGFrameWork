package com.org.TestNGPracticeCode.TestNgPractice;

import org.testng.asserts.SoftAssert;
import org.testng.asserts.Assertion;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class parallelRunWithPriorityAndGrouping {
	Assertion hardAssert = new Assertion();
	SoftAssert softAssert = new SoftAssert();

	@Test(enabled = false, groups = "Sanity", priority = 7)
	public void TestFunctionFirst() {
		System.out.println("I am doing Sanity and in the first test case of parallelRunWithPriorityAndGrouping.");
		softAssert.assertTrue(true);
		System.out.println("AssertTrue of softAssert pass as it is true.");
		softAssert.assertNull(null);
		System.out.println("AssertNull of softAssert pass as it is null.");
		softAssert.assertNotNull("Saurabh");
		System.out.println("AssertNull of softAssert pass as it is not null.");
		softAssert.assertTrue(false);
		System.out.println("AssertTrue of softAssert fails as it is true.");
		softAssert.assertAll();
	}

	@Test(groups = "Smoke", priority = 3)
	public void TestFunctionSecond() {
		System.out.println("I am running Smoke test and in the second case of parallelRunWithPriorityAndGrouping.");
		softAssert.assertFalse(false);
		System.out.println("AssertFalse of softAssert passes as it is true.");
		softAssert.assertFalse(true);
		System.out.println("AssertFalse of softAssert passes as it is true.");
		softAssert.assertAll();
	}

	@Test(groups = "Functional")
	public void TestFunctionThird() {
		System.out.println("I am running Functional test and in the third case of parallelRunWithPriorityAndGrouping.");
		System.out.println(
				"Third test of parallelRunWithPriorityAndGrouping belongs to Functional group and has default highest priority");
		hardAssert.assertNotEquals(4, 5);
		System.out.println("AssertNotEqual of hardassert passes as condition is not matching.");
	}

	@Test(groups = { "Functional", "Sanity" }, priority = 1)
	public void TestFunctionFourth() {
		System.out.println(
				"I am running Functional+Sanity test grouping test and in the Fourth case of parallelRunWithPriorityAndGrouping.");
		softAssert.assertEquals(10, 10);
		System.out.println("AssertFalse of softAssert passes as it is true.");
		softAssert.assertEquals(10, 11);
		System.out.println("AssertFalse of softAssert fails as it is true.");
		softAssert.assertAll();
	}

	@Test(groups = "Functional", priority = 4)
	public void TestFunctionFifth() {
		System.out.println("I am running Functional test and in the fifth case of parallelRunWithPriorityAndGrouping.");
		System.out.println("I am going to skip it in the runtime.");
		throw new SkipException("I am going to skip it during run time.");
	}

	@Test(groups = "Smoke", priority = 2)
	public void TestFunctionSixth() {
		System.out.println("I am running Functional test and in the third case of parallelRunWithPriorityAndGrouping.");
		System.out.println(
				"Third test of parallelRunWithPriorityAndGrouping belongs to Functional group and has default highest priority");
		softAssert.assertNotEquals(4, 5);
		System.out.println("AssertNotEqual of softassert passes as condition is not matching.");
		softAssert.assertNotEquals(4, 4);
		System.out.println("AssertNotEqual of softassert fails as condition is matching.");
	}

	@Test(groups = "Sanity", priority = 6)
	public void TestFunctionSiventh() {
		System.out.println("I am running Sanity test and in the Seventh case of parallelRunWithPriorityAndGrouping.");
		System.out.println("This test will be failed due the failure of assertNotEqual condtion failed of HardAssert.");
		hardAssert.assertNotEquals(4, 4);
		System.out.println("AssertFalse of hardassert passes as condition is true.");
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
