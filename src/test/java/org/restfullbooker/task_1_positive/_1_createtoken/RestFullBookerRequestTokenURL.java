package org.restfullbooker.task_1_positive._1_createtoken;


import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.restfullbooker.pojorequest.Customer;
import org.restfullbooker.pojoresponse.Token;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.restfullbooker.APIConstants.BASE_URI;


// this is private bz this can be used within the class only
public class RestFullBookerRequestTokenURL {

    //public is not need bz withing package allowed no specifier

    //final must be initalized (even static is allowed)

    //since every time it has to call ie the time waste so we make the static ie it can use directly teh static variable in the metaspace


    //static variable is loaded when the class si loaded so then only hte method is called


    private Response response;
    //static variable can be intialized by the static method only
    // non final variable be initilized by the static block , final variable is not initialized by the static block
    //can only be initialized by the that instance only

    public String token;


    @Given("Get Payload from {string}")
    public void get_payload_from(String string) {
        // Write code here that turns the phrase above into concrete actions
              /* payload.setUsername("admin");
                     payload.setPassword("password123");*/

                   /*  String payload = "{\n" +
                             "    \"username\" : \"admin\",\n" +
                             "    \"password\" : \"password123\"\n" +
                             "}";*/
        //serialisation means to convert the object in the byte of streams (ie the jason format or xml format) then \
        // 10110 is send on the network


        //no need to make seperate class to call for making payload(bz it will take extra time )
        // simply make the object of paylaod
        Customer customer = new Customer("admin", "password123");//directly passing the object to body
        //giving me error so we has to change the suitable string using the Gson then pass to the body of response
        Gson gson = new Gson();
        String payload = gson.toJson(customer);
        RequestSpecification requestSpecification = given();
        //each request url must have different request specification so ti must have different object for each
        //request specification


        requestSpecification.baseUri(BASE_URI);
        requestSpecification.basePath(string);
        requestSpecification.contentType(ContentType.JSON);//header is set
        requestSpecification.body(payload);//it will set as the class for payload (no map and string )
        // , class for more than 150 test case
        /* Response response=*/ // and it can be dynamic
        //since the payload is the object type so the body has the overloaded method which has argument Object
        //Response response=


        response = requestSpecification.when().post();

    }



    @Then("Verify response message {string}")
    public void verify_response_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        //1.
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(Integer.parseInt(string)));
        //	assertThat(T actual, Matcher<? super T> matcher)
        //-> now when we call the assertThat method in the second arguement we can pass hte Integer and
        // teh classes which is superclass of integer like Number
        // it became like assertThat(Integer actual,Matcher<? super Integer> matcher)
                  /*what does it mean by this -->Matcher<? super T> matcher
                    ChatGPT
                        The Matcher<? super T> is a generic type in Java,
                        and it's commonly used in testing frameworks
                         like Hamcrest for making assertions. Let's break down what it means:

                            Matcher<T>:

                    Matcher is an interface provided by the Hamcrest library
                    for creating flexible and readable assertions in tests.

                     <T> is a generic type parameter that represents the type of the value being matched.
                      <? super T>:

                     <? super T> is a wildcard bounded by the type T.
                     It means "any type that is a superclass of T" or simply "T or any of
                     its superclasses."
                        Putting it all together, Matcher<? super T> indicates that the matcher
                        can be used to match values of type T or any of its superclasses.
                         This provides flexibility when using the matcher in different contexts.

                        For example, if you have a Matcher<String>,
                         it can be used to match strings. If you have a Matcher<? super String>,
                         it can still be used to match strings, but it can also be used to match objects
                         of types that are superclasses of String.*/





                       /* ValidatableResponse vr =response.then().log().all();
                      vr.statusCode(200);*/

        // r.then().statusCode(200);
        // r.then().log().all().body("token", Matchers.notNullValue());// Hamcrest liberary  Matchers class
        // assertion is done ie the token part should not be null then only we can store it

    }


}


