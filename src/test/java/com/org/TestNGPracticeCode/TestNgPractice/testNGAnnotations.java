package com.org.TestNGPracticeCode.TestNgPractice;

import org.testng.annotations.Test;

import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.SkipException;

public class testNGAnnotations {
	Assertion hardAssert = new Assertion();
	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 2,groups= {"Sanity","Smoke"})
	public void firstTest() {
		long id=Thread.currentThread().getId();
		System.out.println(id);
		System.out.println("I am in firstTest and going to use soft assert.");
		softAssert.assertEquals(1, 1);
		System.out.println("My first soft Assert pass.");
		softAssert.assertEquals(0, 1);
		System.out.println("My second soft Assert pass.");
		// Point 1-->this works a return statement of any loop and must be present as
		// the last
		// statement of the method where we are using soft assert. the work of this
		// assertAll() method is to collect all the failures of the method and print the
		// log in the report and mark the test case as failed.If we do not give this
		// statement at the end of method your test case will remain pass even if the
		// soft assert condition is failing.
		// as we have disabled the softAssert.assertAll() in the next line hence this
		// test case will always marked as pass.
		// softAssert.assertAll();
	}

	@Test(priority = 1,groups="Smoke" )
	public void fourthTest() {
		long id=Thread.currentThread().getId();
		System.out.println(id);
		System.out.println("I am in firstTest and going to use soft assert.");
		softAssert.assertEquals(1, 1);
		System.out.println("My first soft Assert pass.");
		softAssert.assertEquals(0, 1);
		System.out.println("My second soft Assert fail.");
		// as we have enabled the softAssert.assertAll() in the next line hence this
		// test case will marked as fail as our send soft assert condition is failing
		// and
		// you can get the failure log in report..
		softAssert.assertAll();
	}

	// use enabled=false for @Test for not to run any specific test case.by default
	// enabled param is set to true.
	// here we don't have priority assign to the test case hence it will be
	// considered as P0 and will be executed first
	@Test(groups="Smoke")
	public void secondTest() {
		long id=Thread.currentThread().getId();
		System.out.println(id);
		System.out.println("I am in second Test and going to use hard assert.");
		hardAssert.assertEquals(1, 1);
		System.out.println("first hard assert pass.");
		hardAssert.assertEquals(2, 2);
		System.out.println("Second hard assert fail.");
	}

	// Way to Ignore test case at run time.Use SkipException.
	@Test(priority = 3, groups="Sanity")
	public void thirdTest() {
		long id=Thread.currentThread().getId();
		System.out.println(id);
		System.out.println("I am in Third Test");
		throw new SkipException("Declare your message");
	}

	// This Method will be executed before every test case. Hence should contain
	// some common things for all the test cases which required before running the
	// test case.
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am in Before method of testNGAnnotations.");
	}

	@AfterMethod
	// This Method will be executed after every test case.Hence should contain
	// some common things for all the test cases which required after running the
	// test case.
	public void afterMethod() {
		System.out.println("I am in after method of testNGAnnotations.");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am in before classof testNGAnnotations.");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am in after class of testNGAnnotations.");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am in before test class of testNGAnnotations.");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am in after test calss of testNGAnnotations.");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am in before Suite of of testNGAnnotations.");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am in after Suite of testNGAnnotations.");
	}

}
