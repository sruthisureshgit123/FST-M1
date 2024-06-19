package activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    //set URL
    final static String url = "https://petstore.swagger.io/v2/pet";

    @Test (priority=1)
    public void  addPet(){
        String reqBody = "{"
                + "\"id\": 123456,"
                + "\"name\": \"Name\","
                + " \"status\": \"alive\""
                + "}";
        Response response =
                given().
                        header("Content-Type","application/json").
                        body(reqBody).
                        log().all().
                        when().
                        post(url);

        // Assertion
        response.then().body("id", equalTo(123456));
        response.then().body("name", equalTo("Name"));
        response.then().body("status", equalTo("alive"));
    }
    @Test(priority=2)
    public  void getPetInfo(){
        Response getResponse =
                given().
                        headers("Content-Type", "application/json").
                        baseUri(url).
                        pathParam("petId","123456").
                        when().
                        get ("/{petId}");

        // Assertion
        getResponse.then().body("id", equalTo(123456));
        getResponse.then().body("name", equalTo("Name"));
        getResponse.then().body("status", equalTo("alive"));

    }

    @Test(priority=3)
    public void deletePet(){
        Response deleteResponse =
                given().
                        headers("Content-Type","application/json").
                        baseUri(url).
                        pathParam("petId",123456).
                        when().
                        delete("/{petId}");

        //assertions
        deleteResponse.then().body("code", equalTo(200));
        deleteResponse.then().body("message", equalTo("123456"));


    }
}
