package org.restfullbooker.task.task_3_positive;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.io.File;

import static org.restfullbooker.task.task_3_positive.RestFullBookerGetAllBookingOne.getBookingIdToUpdate;

public class RestFullbookerGetIdThree {


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




    private  final  String BOOKING_ID_TO_UPDATE;
    //it msut be used within the class only so private


    public  RestFullbookerGetIdThree () {

        //when the 3nd scenerio of the feature file is called by jvm then form the object of it made
        // and teh class related to that is loaded int the metaspace and then
        //automactically the constructor is called the final data member is intialzed
        // ie we did not made the object it is the object that jvm made in background that object also

        // used to callt he methods here in below which @Given and aother annotation
        this.BOOKING_ID_TO_UPDATE = getBookingIdToUpdate();
    }

    @Given("Get payload from urlNine {string}")
    public void get_payload_from_url_nine(String baseUri) {
        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri(baseUri+"/"+BOOKING_ID_TO_UPDATE);

        System.out.println(BOOKING_ID_TO_UPDATE);
      //  requestSpecification.basePath(baseUri+"/"+BOOKING_ID_TO_UPDATE);


        response = requestSpecification.get();
        // Printing Response as string
       // System.out.println(response.asString());


    }
    @Then("verify responseNine status code \"{int}")
    public void verify_response_nine_status_code(Integer int1) {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(Integer.parseInt(String.valueOf(int1))));
    }
    @Then("verify responseNine contains header content type")
    public void verify_response_nine_contains_header_content_type() {
        // Write code here that turns the phrase above into concrete actions
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"), Matchers.is(true));
    }
    @Then("verify responseNine contains firstname")
    public void verify_response_nine_contains_firstname() {
        MatcherAssert.assertThat(response.asPrettyString().contains("firstname"),Matchers.is(true));
    }
    @Then("verify responseNine Json Schema")
    public void verify_response_nine_json_schema() {
        // Write code here that turns the phrase above into concrete actions
        //1 to 4 ,all request was made till "when"  ie so upto when hamcrest liberary can be used for the validation the response

        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/resource/task3/schema3.json")));
    }



}
