package org.restfullbooker.task.task_1_positive;

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

public class RestfullBookerRequestGetBookingFour {

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



    //i want the +booindid must be not changed that comes form other class in this class so final so once intitalized
    //cannot not be changed further

    //jvm made object will call the parameterized constructor below
    //it is final whatever teh value imported here must not be changed throughout below while making the request

    private  final  String BOOKING_ID_TO_UPDATE;
    //it msut be used within the class only so private


    public RestfullBookerRequestGetBookingFour() {

        //when the 3nd scenerio of the feature file is called by jvm then form the object of it made
        // and teh class related to that is loaded int the metaspace and then
        //automactically the constructor is called the final data member is intialzed
        // ie we did not made the object it is the object that jvm made in background that object also

        // used to callt he methods here in below which @Given and aother annotation
        this.BOOKING_ID_TO_UPDATE = RestFullBookerRequestBookingTwo.getBookingIdToUpdate();
    }

    @Given("Get payload from urlFour {string}")
    public void get_payload_from_url_four(String baseUri ) {
        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri(baseUri+"/"+BOOKING_ID_TO_UPDATE);

       // System.out.println(BOOKING_ID_TO_UPDATE);
        //requestSpecification.basePath(BASE_PATH_BOOKING+"/"+bookingidToUpdate);

        response = requestSpecification.get();
        // Printing Response as string
//        System.out.println(response.asString());
//


    }
    @Then("verify responseFour status code {string}")
    public void verify_response_four_status_code(String string) {




        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
    }
    @Then("verify  responseFour contains fistname exist")
    public void verify_response_four_contains_fistname_exist() {


        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        String firstname=jsonPath.getString("firstname");

        //static variable withing a class can be accessed
        //System.out.println("firstname"+firstname);//$.token ->jasonpath

        //MatcherAssert.assertThat(response.getHeaders(), hasKey("Content-Type"));


        //Restfull booker is the class which is loaded first then all the static variable inside that class loaded then
        // so static variable is at the class level when then7 class the destroyed in then only static variable is destroyed
        //per class you can make only one type of variable name can be static variable.



        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        //4.
        //System.out.println(response.asPrettyString());
        // "token" :"1343434", value in double quotes so it is string only ,now left side "12334" comes,right side
        // ,there is with Matcher object that it gives signal that it must not be the null value
        // equivalent to $.token

        // MatcherAssert.assertThat(response.asPrettyString(), hasJsonPath("$.bookingId"));
        MatcherAssert.assertThat(response.getBody().jsonPath().getString("firstname"),Matchers.notNullValue());
    }
    @Then("verify  responseFour contains header content type")
    public void verify_response_four_contains_header_content_type() {
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
       // System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"),Matchers.is( true));

    }
    @Then("verify  responseFour Json Schema")
    public void verify_response_four_json_schema() {
        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/resource/task1/schema3.json")));

    }



}
