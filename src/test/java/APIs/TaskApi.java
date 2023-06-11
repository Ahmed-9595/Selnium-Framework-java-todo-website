package APIs;

import Config.EndPoint;
import Object.Task;
import Utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskApi {


    public void addTask(String token){
        Task task=new Task("Learn Selenium",false);
        Response response =
                given()
                        .baseUri(ConfigUtils.getInstance().getbaseUrl())
                        .headers("Content-Type","application/json")
                        .body(task)
                        .auth().oauth2(token)
                .when()
                        .post(EndPoint.API_TASK_ENDPOINT)
                .then().log().all().extract().response();
        if (response.statusCode() !=201){
            throw  new RuntimeException("Something went wrong with adding Tasks");
        }

    }
}
