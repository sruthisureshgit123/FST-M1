package activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {
    final static String url = "https://petstore.swagger.io/v2/user";

    @Test(priority=1)
    public void  addUser() throws IOException {
        FileInputStream inputStream = new FileInputStream("src/test/java/resources/user.json");
        String reqBody = new String(inputStream.readAllBytes());
        Response response =
                given().
                        header("Content-Type","application/json").
                        body(reqBody).
                        log().all().
                        when().
                        post(url);
        inputStream.close();
        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("1234"));
    }
    @Test(priority=2)
    public  void getUserInfo(){
        Response getResponse =
                given().
                        headers("Content-Type", "application/json").
                        baseUri(url).
                        pathParam("username","sruthi").
                        when().
                        get ("/{username}");
        String resBody = getResponse.getBody().asPrettyString();

        // Assertion
        getResponse.then().body("id", equalTo(1234));
        getResponse.then().body("username", equalTo("sruthi"));
        getResponse.then().body("firstName", equalTo("Sruthi"));

        //write Response to file
        File outputJSON = new File("src/test/java/resources/GetUserResponse.json");
        try {
            // Create JSON file
            outputJSON.createNewFile();
            // Write response body to external file
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }

    }

    @Test(priority=3)
    public void deleteUser(){
        Response deleteResponse =
                given().
                        headers("Content-Type","application/json").
                        baseUri(url).
                        pathParam("username","sruthi").
                        when().
                        delete("/{username}");

        //assertions
        deleteResponse.then().body("code", equalTo(200));
        deleteResponse.then().body("message", equalTo("sruthi"));


    }
}
