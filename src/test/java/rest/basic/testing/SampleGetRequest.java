package rest.basic.testing;

//import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import static com.jayway.restassured.RestAssured.given;
//import static com.jayway.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.equalTo;

public class SampleGetRequest {
	public static String Uri = "http://samples.openweathermap.org/";

	@Test()
	public static void getRequestForFindingWeatherByCityName() {
		// Logger log = Logger.getLogger("SampleGetRequest");

		// define my baseURI in restAssure
		RestAssured.baseURI = Uri;

		// Sending the request and getting the response

		Response resp = given().param("q", "London").param("appid", "7919254f4476089f98a9b254625427e5").when()
				.get("/data/2.5/weather");

		/*
		 * another way to give base uri in the response.
		 * given().baseUri(baseUri).param("q", "London").param("appid",
		 * "7919254f4476089f98a9b254625427e5"). when().get("/data/2.5/weather");
		 */

		// and validating response code.

		ValidatableResponse validatableResp = resp.then().assertThat().statusCode(200);

		System.out.println("Status code succfully validatied for this test..");

		System.out.println(validatableResp.extract().asString());

		// check the contant type of your response (json\xml)

		//ValidatableResponse contantType = validatableResp.contentType(ContentType.JSON);

		// contantType.extract().jsonPath(arg0);
		// ValidatableResponse res1=contantType.and().body("weather[0].description",
		// equalTo("light intensity drizzle"));
		// .and().body("sys.sunrise",equalTo(""));
		

	}
	
	public static ValidatableResponse contentTypeValidation() {
		RestAssured.baseURI = Uri;
		Response resp = given().param("q", "London").param("appid", "7919254f4476089f98a9b254625427e5").when()
				.get("/data/2.5/weather");
	    ValidatableResponse valResp = resp.then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	    return valResp;
	}

	@Test()
	public static void bodyVariableValicationforDescription() {
		String respPath1 = null;
		String actaulDiscription = "light intensity drizzle";
		ValidatableResponse valResp= contentTypeValidation();
		respPath1 = valResp.extract().path("weather[0].description");
		if (respPath1.equalsIgnoreCase(actaulDiscription)) {
			System.out.println("Test case Pass");
		} else {
			System.out.println("Test Case Failed.");
		}
	}
	
	@Test()
	public static void bodyVariableValicationCountry() {
		String respPath1 = null;
		String actaulDiscription = "GB";
		ValidatableResponse valResp= contentTypeValidation();
		respPath1=valResp.extract().path("sys.country");
		if (respPath1.equalsIgnoreCase(actaulDiscription)) {
			System.out.println("Test case Pass");
		} else {
			System.out.println("Test Case Failed.");
		}
	}
	
	@Test
	public void headerValidation() {
		ValidatableResponse contantType= contentTypeValidation();
		contantType.assertThat().header("server", "openresty/1.9.7.1");
		//valResp.and().header("content-encoding ", "gzip");
		System.out.println("Header info validated.");
	}
}
