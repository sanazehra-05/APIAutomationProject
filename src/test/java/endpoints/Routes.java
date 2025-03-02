package endpoints;

public class Routes {
	
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	
	//user endpoints
	public static String postUrl =  baseUrl + "/user";
	public static String getUrl = baseUrl + "/user/{username}";
	public static String putUrl = baseUrl + "/user/{username}";
	public static String delUrl = baseUrl + "/user/{username}";

}
