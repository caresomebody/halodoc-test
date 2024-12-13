import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class stepDef {

    @Test
    public void AuthUser() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("username","admin");
        requestParams.put("password","password123");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post("/auth");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());
        System.out.println(body.asString());

//        given().body("")
//                .when()
//                .post("https://restful-booker.herokuapp.com/auth")
//                .then()
//                .statusCode(200)
//                .body("page", equalTo(2))
//                .log().all();
    }
}
