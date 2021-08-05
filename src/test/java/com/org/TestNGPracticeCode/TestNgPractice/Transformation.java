package com.org.TestNGPracticeCode.TestNgPractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class Transformation implements IAnnotationTransformer {
	//Saurabh

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer retry=annotation.getRetryAnalyzer();
		if(retry==null) {
			annotation.setRetryAnalyzer(Retry.class);
		}
	}
}
