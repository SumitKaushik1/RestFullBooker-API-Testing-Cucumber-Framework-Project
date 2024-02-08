package org.restfullbooker.task.task_3_positive;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.io.File;

public class RestFullBookerGetAllBookingOne {

// private bz i want to intialize the response in this classs i donot want ot share that resposne accross
    //any other class of even not to same package
    //every request has seperate respone we need different variable for each request

    private Response response;

    //bydefault set to null instance variable

    //now what happens that in the metaspace space  remain intact in whole running state of till  jvm running the code
    //so the static variabels and the classes space si remain in the metaspace till jvm is running the code
    //stack and heap space is destroyed once the jvm has executed the scope of variabel or object or method
    //till one class has only one static variable  corresponding to that static variable remain there till the class
    //corresponding class remain there.
    //(stack and heap space destroyed once the scope of code is completed by jvm )


    // it must be used within the class only so private
    private static String  BOOKING_ID_TO_UPDATE;

    // it must be used within the class only so private

    //i donot want the other classes to change the value whatever come in resposne in below code
    public static String getBookingIdToUpdate() {
        return BOOKING_ID_TO_UPDATE;
    }


    @Given("Get payload from urlSeven {string}")
    public void get_payload_from_url_seven(String baseUri) {

        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri(baseUri);
        //requestSpecification.basePath("/booking");


          response = requestSpecification.get();

        // Printing Response as string
       // System.out.println(response.asString());

       // return response;

    }
    @Then("verify responseSeven status code \"{int}")
    public void verify_response_seven_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(Integer.parseInt(String.valueOf(int1))));
    }
    @Then("verify responseSeven contains header content type")
    public void verify_response_seven_contains_header_content_type() {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"),Matchers.is(true));
    }
    @Then("verify responseSeven contains bookingid")
    public void verify_response_seven_contains_bookingid() {
        // Write code here that turns the phrase above into concrete actions
        // calling method will take time so directly teh value fo final static method will save time while calling
      //  Response response= RestfullBookerRequestGetAllBookingURL.response;

        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        BOOKING_ID_TO_UPDATE=jsonPath.getString("[0].bookingid");

        //static variable withing a class can be accessed
       // System.out.println(BOOKING_ID_TO_UPDATE);//$.[0].bookingid ->jasonpath

        //MatcherAssert.assertThat(response.getHeaders(), hasKey("Content-Type"));


        //Restfull booker is the class which is loaded first then all the static variable inside that class loaded then
        // so static variable is at the class level when then7 class the destroyed in then only static variable is destroyed
        //per class you can make only one type of variable name can be static variable.



        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        //4.
       // System.out.println(response.asPrettyString());
        // "token" :"1343434", value in double quotes so it is string only ,now left side "12334" comes,right side
        // ,there is with Matcher object that it gives signal that it must not be the null value
        // equivalent to $.token

        // MatcherAssert.assertThat(response.asPrettyString(), hasJsonPath("$.bookingId"));
        // MatcherAssert.assertThat(response.getBody().jsonPath().getString("firstname"),Matchers.notNullValue());
        MatcherAssert.assertThat(response.asPrettyString().contains("bookingid"),Matchers.is(true));
    }
    @Then("verify responseSeven Json Schema")
    public void verify_response_seven_json_schema() {
        // Write code here that turns the phrase above into concrete actions
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/resource/task3/schema1.json")));
    }
}
