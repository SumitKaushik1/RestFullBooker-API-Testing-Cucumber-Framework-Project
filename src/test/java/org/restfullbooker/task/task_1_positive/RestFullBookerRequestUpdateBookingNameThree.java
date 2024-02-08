package org.restfullbooker.task.task_1_positive;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.io.File;

public class RestFullBookerRequestUpdateBookingNameThree {
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



    //i want the bookingid must be not changed that comes form other class in this class so final so once intitalized
    //cannot not be changed further

    //jvm made object will call the parameterized constructor below
    //it is final whatever teh value imported here must not be changed throughout below while making the request

    private  final  String BOOKING_ID_TO_UPDATE;
    //it msut be used within the class only so private


    public RestFullBookerRequestUpdateBookingNameThree() {

        //when the 3nd scenerio of the feature file is called by jvm then form the object of it made
        // and teh class related to that is loaded int the metaspace and then
        //automactically the constructor is called the final data member is intialzed
        // ie we did not made the object it is the object that jvm made in background that object also

        // used to callt he methods here in below which @Given and aother annotation
        this.BOOKING_ID_TO_UPDATE = RestFullBookerCreateBookingTwo.getBookingIdToUpdate();
    }



    @Given("Get payload from urlThree {string}")
    public void get_payload_from_url_three(String baseUri) {
        JSONObject bookingDetails=new JSONObject();
        bookingDetails.put("firstname","James");
        //BookingDetails bookingDetails=new BookingDetails("James");
        //directly passing the object to body
        //when two clases closely packed so no need to creat the inner class as the seperate classs and try to import
        // instead make it as the inner nested  class and and you can save a one .java file


        //giving me error so we has to change the suitable string using the Gson then pass to the body of response
        Gson gson=new Gson();
        String payload= gson.toJson(bookingDetails);
       // System.out.println(payload);


        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        // requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header response is json no need to specify that otherwise it will give error


        //we can change the resource by two things
        //1. either we should have the token by supplying the username and password
        //2. we have to directly use the basic authorization by supplying the username and passowrd
        //System.out.println(token);
        // requestSpecification.cookie(token);

        requestSpecification.auth().preemptive().basic("admin","password123");

             /*

                   what is meant by preemptive in this -->requestSpecification.auth().preemptive().basic("admin","password123");

            SK
            In this context, "preemptive" refers to sending the HTTP Basic authentication credentials preemptively with the request, rather than waiting for a 401 Unauthorized response first.

                    Specifically:

            By default, RestAssured will not send authentication credentials until it receives a 401 Unauthorized response from the server.
                    Adding .preemptive() configures it to send the Basic auth credentials up front with the first request.
            This avoids having to make an initial unauthenticated request and get a 401 before sending the credentials.
            So "preemptive" here means sending the Basic authentication proactively before getting a 401, rather than waiting for the Unauthorized response first.

            It's a way to configure RestAssured to automatically authenticate the first request, avoiding an extra round trip to get the 401 error. The credentials are sent preemptively.

            Copy

            how whole process happnes

            SK
            Here is an overview of how the preemptive authentication process works with RestAssured:

            When making a request, RestAssured checks if preemptive auth is enabled.
            If so, it will automatically add an Authorization header containing the Base64 encoded credentials (username:password) to the request before sending it.
            For example:

            Copy code

            Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=
                    The server receives the request with the Authorization header and can authenticate the user without having to return a 401 Unauthorized first.
            If authentication succeeds, the server will return a 200 OK or whatever the normal response should be.
            If it fails, the server may still return a 401 or another error response.
            So the key points are:

            Preemptive auth sends the credentials up front, without waiting for a 401.
            This avoids an extra request/response round trip to get the 401 before authenticating.
            The Authorization header is added automatically by RestAssured before sending the request.
            Server can authenticate immediately without prompting for credentials.
                    So preemptive mode streamlines the auth process by sending credentials proactively.

            Copy

            how process happens in non preemptive

            SK
            Here is how the authentication process works without preemptive mode:

            RestAssured makes a request to the server without any authentication credentials.
                    The server returns a 401 Unauthorized status code, indicating authentication is required.
                    RestAssured sees the 401 response and automatically sends the credentials.
            It will re-send the original request, this time with an Authorization header containing the Base64 encoded username:password.
                    For example:

            Copy code

            GET /api/resource

            401 Unauthorized

            GET /api/resource
            Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=
                    The server authenticates the credentials and returns a 200 OK if they are valid.
                    So in summary, without preemptive mode:

            No credentials are sent on the first request.
            Server returns 401 asking for authentication.
                    RestAssured automatically resends request with credentials.
                    Extra round trip of unauthenticated request/401 response.
                    Overall slower due to extra call to get 401 before authenticating.
            So non-preemptive auth requires an extra call to prompt for credentials before sending them.
             Preemptive mode avoids this by sending credentials up front.*/



        // Adding URI
        requestSpecification.baseUri(baseUri);
      //  System.out.println(BOOKING_ID_TO_UPDATE);
        requestSpecification.baseUri(baseUri+"/"+BOOKING_ID_TO_UPDATE);

        // Adding body as string
        requestSpecification.body(payload);
         response = requestSpecification.patch();
        // Printing Response as string
        //System.out.println(response.asString());


    }
    @Then("verify responseThree status code {string}")
    public void verify_response_three_status_code(String string) {

        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
    }


    @Then("verify  responseThree contains fistname exist")
    public void verify_response_three_contains_fistname_exist() {
        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        String firstname=jsonPath.getString("firstname");

        //static variable withing a class can be accessed
       // System.out.println("firstName"+firstname);//$.firstname ->jasonpath

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
        MatcherAssert.assertThat(response.getBody().jsonPath().getString("firstname"),Matchers.notNullValue());
    }
    @Then("verify  responseThree contains header content type")
    public void verify_response_three_contains_header_content_type() {

        //3. (by content ype you get-> true),true since both true matched so assertion is passed
       // System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"),Matchers.is(true));

    }
    @Then("verify  responseThree Json Schema")
    public void verify_response_three_json_schema() {

        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/resource/task1/schema2.json")));  // Write code here that turns the phrase above into concrete actions

    }



}
