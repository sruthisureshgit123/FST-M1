package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //set the Headers
    Map<String, String> headers = new HashMap<>();

    //Create contract
    @Pact(consumer = "UserConsumer",provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        headers.put("Content-Type","application/json");

        //Request and Response Body
        DslPart reqandResBody = new PactDslJsonBody()
                .numberType("id",123)
                .stringType("firstName","Sruthi")
                .stringType("lastName","Suresh")
                .stringType("email","sruthi@example.com");

        //interaction
        return builder.given("POST Request").
                uponReceiving("A request to create user").
                method("POST").
                path("/api/users").
                headers(headers).
                body(reqandResBody).
                willRespondWith().
                status(201).
                body(reqandResBody).
                toPact();




    }

    @Test
    @PactTestFor(providerName = "UserProvider",port = "8282" )
    public void postRequestTest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id",123);
        reqBody.put("firstName","Sruthi");
        reqBody.put("lastName","Suresh");
        reqBody.put("email","sruthi@example.com");

        //send Request
        given().baseUri("http://localhost:8282").headers(headers).body(reqBody).log().all().
                when().post("/api/users").
                then().statusCode(201).body("firstName",equalTo("Sruthi")).log().all();


    }

}
