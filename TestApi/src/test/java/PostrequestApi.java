import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PostrequestApi {

//	@Test
	public void testpost1() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("name", "morpheus");
//		map.put("Job","leader");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "morpheus");
		request.put("Job","leader");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().
		post("https://reqres.in/api/users").then().statusCode(201);
		
		
	} 

	@Test
	public void testput2() {
				
		JSONObject request = new JSONObject();
		
		request.put("name", "morpheus");
		request.put("Job","leader");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().
		put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void testpatch3() {
				
		JSONObject request = new JSONObject();
		
		request.put("name", "morpheus");
		request.put("Job","leader");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().
		patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	@Test
	public void testdelete4() {
				
		when().
		delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
}