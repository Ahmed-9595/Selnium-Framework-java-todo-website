package APIs;

import Config.EndPoint;
import Object.User;
import Utils.ConfigUtils;
import Utils.UserUtils;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

public class RegisterApi {
    private  List<Cookie>restAssuredcookie;
    private  String accessToken;
    private  String firstName;
    private  String userId;

    public List<Cookie> getCookie() {
        return this.restAssuredcookie;
    }
    public String getAccessToken() {
        return this.accessToken;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getUserId() {
        return this.userId;
    }
    public void register(){

        User user= UserUtils.generateRandomUser();
        Response response=RestAssured.given()
                 .baseUri(ConfigUtils.getInstance().getbaseUrl())
                 .headers("Content-Type","application/json")
                 .body(user).log().all()
                .when()
                 .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                 .log()
                 .all()
                 .extract()
                 .response();
        if (response.statusCode()!=201){
            throw new RuntimeException("something went wrong with the request");
        }
        restAssuredcookie= response.detailedCookies().asList();
        firstName=response.path("firstName");
        userId=response.path("userID");
        accessToken=response.path("access_token");
    }


}
