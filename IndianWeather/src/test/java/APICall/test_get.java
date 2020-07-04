package APICall;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class test_get {

	public Object getTest(String cityname, String key, String uri, RequestSpecification request) {

		Response response = get(uri + "q=" + cityname + "&appid=" + key);
		return response.path("main.temp");

	}

}
