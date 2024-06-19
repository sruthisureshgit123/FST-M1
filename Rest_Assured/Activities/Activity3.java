package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity3 {
    //set URL
    final static String url = "https://petstore.swagger.io/v2/pet";
    RequestSpecification requestSpec ;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp(){
        requestSpec = new RequestSpecBuilder().
                setContentType(ContentType.JSON).
                setBaseUri("https://petstore.swagger.io/v2/pet").build();
        responseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                // Check if response contains name property
                .expectBody("status", equalTo("alive"))
                // Build response specification
                .build();
    }
    @DataProvider
    public Object[][] petInfoDataProvider() {
        // Setting parameters to pass to test case
        Object[][] testData = new Object[][] {
                { 123456, "Name", "alive" },
                { 654321, "Names", "alive" }
        };
        return testData;
    }
    @Test(priority=1)
    public void  addPet(){
        String reqBody = "{\"id\": 123456, \"name\": \"Name\", \"status\": \"alive\"}";
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request

        reqBody = "{\"id\": 654321, \"name\": \"Names\", \"status\": \"alive\"}";
        response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request

        // Assertions
        response.then().spec(responseSpec); // Use responseSpec
    }
    // Test case using a DataProvider
    @Test(dataProvider = "petInfoDataProvider", priority=2)
    public void getPets(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().get("/{petId}"); // Send GET request

        // Print response
        System.out.println(response.asPrettyString());
        // Assertions
        response.then()
                .spec(responseSpec) // Use responseSpec
                .body("name", equalTo(name)); // Additional Assertion
    }

    // Test case using a DataProvider
    @Test(dataProvider = "petInfoDataProvider", priority=3)
    public void deletePets(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().delete("/{petId}"); // Send GET request

        // Assertions
        response.then().body("code", equalTo(200));
    }


}
