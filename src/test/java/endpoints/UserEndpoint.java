package endpoints;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

public class UserEndpoint {

	public static Response createUser(User userPayload) {

		Response response = given()
				                .accept(ContentType.JSON)
				                .contentType(ContentType.JSON)
				                .body(userPayload)
				            .when()
				                .post(Routes.postUrl);

		return response;
	}

	public static Response getUser(String userName) {

		Response response = given()
				                .pathParam("username", userName)
				            .when()
				                .get(Routes.getUrl);

		return response;
	}
	
	
	public static Response updateUser(User userPayload, String userName) {

		Response response = given()
				         .pathParam("username", userName)
				         .contentType(ContentType.JSON)
				         .accept(ContentType.JSON)
				         .body(userPayload)
				         .when().put(Routes.putUrl);

		return response;
	}
	
	public static Response deleteUser(String userName) {

		Response response = given()
				         .pathParam("username", userName)
				         .when().delete(Routes.delUrl);

		return response;
	}

}
