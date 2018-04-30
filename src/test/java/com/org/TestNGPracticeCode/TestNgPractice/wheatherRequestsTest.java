package com.org.TestNGPracticeCode.TestNgPractice;
//link to check different status codes:
//https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
//import com.jayway.restassured.matcher.RestAssuredMatchers.*;
//import org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

//import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.remote.Response;

public class wheatherRequestsTest{
	Logger log = Logger.getLogger("wheatherRequestsTest");

	// simple get request with param for getting wheather request
	@Test
	public void Test_01() {
		PropertyConfigurator.configure("log4j.properties");
		given().param("q", "London").param("appid", "b6907d289e10d714a6e88b30761fae22").
		when().get("http://samples.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);
		log.info("Status code succfully validatied for this test..");

		// link to check different status codes:
		// https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
	}

	//@Test
	public void Test_02() {
		PropertyConfigurator.configure("log4j.properties");
		ValidatableResponse res = given().param("q", "London").param("appid", "b6907d289e10d714a6e88b30761fae22").
				when().get("http://samples.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);
		log.info("Status code succfully validatied for this test..");
		log.info(res.extract().asString());
	}

	//@Test
	// By city ID
	public void Test_03() {
		// PropertyConfigurator.configure("log4j.properties");
		ValidatableResponse res = given().param("id", "2172797").param("appid", "b6907d289e10d714a6e88b30761fae22").
				when().get("http://samples.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200);
		log.info("Status code succfully validatied for this test..");
		log.info(res.extract().asString());
	}

	//@Test
	// By zipcode
	public void Test_04() {
		// PropertyConfigurator.configure("log4j.properties");
		ValidatableResponse res = given().param("zip", "94040").param("appid", "b6907d289e10d714a6e88b30761fae22").
				when().get("http://samples.openweathermap.org/data/2.5/weather").
				then().assertThat().statusCode(200);
		log.info("Status code succfully validatied for this test..");
		log.info(res.extract().asString());
	}

	@Test
	// extracting actual test results from apis
	public void Test_05() {
		PropertyConfigurator.configure("log4j.properties");
		Response res = given().parameter("id", "2172797")
				.parameter("appid", "b6907d289e10d714a6e88b30761fae22").
				when().get("http://samples.openweathermap.org/data/2.5/weather");
		
		//String Actaul_Wheather_Report=res.then().contentType(ContentType.JSON)
		//		.extract().path("weather[0].description").toString();
		//log.info("Report: " + Actaul_Wheather_Report);
		
		String Expected_Wheather_Report=null;
		ValidatableResponse vRes =res.then().assertThat().contentType(Expected_Wheather_Report);
		log.info("Test Case Pass.");
		log.info("Report is: " + vRes.toString());
	}

}
