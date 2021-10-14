import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class testGetApi {


	@Test
	void test_api() {		
		
		Response rsp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().response();
			
		Assert.assertEquals(200, rsp.statusCode());
//		Assert.assertEquals("michael.lawson@reqres.in", rsp.jsonPath().getString("email[0]"));
//		Assert.assertEquals("7", rsp.jsonPath().getString("id[0]"));
//		Assert.assertEquals("Michael", rsp.jsonPath().getString("first_name[0]"));
	
}
}