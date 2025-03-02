package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import endpoints.UserEndpoint;
import io.restassured.response.Response;
import payload.User;
import utility.DataProviders;

public class UserTestWithDataProvider {

	@Test(priority = 1, dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void testPostData(String id, String username, String firstname, String lastname, String email,
			String password, String phone, String userStatus) {

		User user = new User();
		Double intid = Double.parseDouble(id);
		user.setId(intid.intValue());
		user.setUsername(username);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		Double status = Double.parseDouble(id);
		user.setUserStatus(status.intValue());
		Response response = UserEndpoint.createUser(user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "userName", dataProviderClass = DataProviders.class)
	public void testGetData(String userName) {

		Response response = UserEndpoint.getUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3, dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void testUpdateData(String id, String username, String firstname, String lastname, String email,
			String password, String phone, String userStatus) {

		User user = new User();
		Double intid = Double.parseDouble(id);
		user.setId(intid.intValue());
		user.setUsername(username);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		Double status = Double.parseDouble(id);
		user.setUserStatus(status.intValue());

		Response response = UserEndpoint.updateUser(user, user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 4, dataProvider = "userName", dataProviderClass = DataProviders.class)
	public void testdeleteData(String userName) {

		Response response = UserEndpoint.deleteUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
