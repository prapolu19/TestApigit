import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class getrequestApi {
	
	@Test
	void test_api() {
		
		Response res = get("https://reqres.in/api/users?page=2");
		
		int statusCode = res.getStatusCode();
		Assert.assertEquals(statusCode, 200);			
		
		
	}
	@Test
	void test_api1 ()
	{
		given().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).
		body("data.email[0]",equalTo("michael.lawson@reqres.in")).
		body("data.id.size()", equalTo(6));
		
	}
	
	@Test	void test_api2 ()
	{
		given().
		get("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		body("data.id",equalTo(2));
		
		
		
	}
	
	@Test
	void test_api3 ()
	{
		given().
		get("https://reqres.in/api/users/23").
		then().
		statusCode(404);
		
	}
	
}

