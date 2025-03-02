package test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserEndpoint;
import io.restassured.response.Response;
import payload.User;

public class UserTest {
	
	public Logger logger; 
	Faker faker;
	User user;
	
	@BeforeTest
	public void getUserData() {
		faker = new Faker();
		user = new User();
		user.setId(faker.idNumber().hashCode());
		user.setUsername(faker.name().username());
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setPassword(faker.internet().password());
		user.setEmail(faker.internet().emailAddress());
		user.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void testPostData() {
		
		logger.info("create post data");
		Response response = UserEndpoint.createUser(user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testGetData() {
		
		logger.info("create get data");
		Response response = UserEndpoint.getUser(this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority = 3)
	public void testUpdateData() {
		
		logger.info("update post data");
		Response response = UserEndpoint.updateUser(user, this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	public void testdeleteData() {
		
		logger.info("delete post data");
		Response response = UserEndpoint.deleteUser(this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
