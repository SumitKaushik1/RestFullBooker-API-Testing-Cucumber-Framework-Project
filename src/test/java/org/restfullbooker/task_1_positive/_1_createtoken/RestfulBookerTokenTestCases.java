package org.restfullbooker.task_1_positive._1_createtoken;


import com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.restfullbooker.pojoresponse.Token;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;



  /*
                    Certainly! Let's compare the two provided code snippets, one following a BDD style and the other following a non-BDD style, focusing on their structure, readability, and use of natural language:

BDD-Style Code:
java
Copy code
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BDDStylePostRequest {

    @Test
    void postUserNameAndPassword() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post()
                .then().log().all()
                .body("token", Matchers.notNullValue());
    }

    @Test
    void post2() {
        PayloadClass payloadClass = new PayloadClass("admin", "password123");

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com").basePath("/auth")
                .contentType(ContentType.JSON)
                .body(payloadClass)
                .when().post()
                .then().log().all()
                .body("token.length()", Matchers.is(15));
    }
}
Non-BDD Style Code:
java
Copy code
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NonBDDStyle {

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @BeforeTest
    void setUp() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth/23");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        response = requestSpecification.put();
        validatableResponse = response.then().log().all();
    }

    @Test
    void postNonBDD() {
        validatableResponse.body("token", Matchers.notNullValue());
    }

    @Test
    void postNonBDD2() {
        validatableResponse.body("token.length()", Matchers.is(15));
    }
}
Key Differences:
Structure:

BDD-style code uses a more declarative Given-When-Then structure within the test methods.
Non-BDD style separates the setup, execution, and assertion steps into different methods (setUp and test methods).
Natural Language:

BDD-style code reads more like natural language, with a focus on expressing the behavior of the system.
Non-BDD style uses standard programming constructs and TestNG annotations, making it more code-centric.
TestNG Annotations:

BDD-style code does not use explicit TestNG annotations for setup (@BeforeTest), as the structure inherently follows the BDD Given-When-Then structure.
Non-BDD style uses TestNG annotations for setup and test methods.
Assertion Methods:

BDD-style code uses Matchers for assertions in a natural language format.
Non-BDD style uses Matchers but in a more traditional format, directly applied to the ValidatableResponse.
Logging:

BDD-style code uses .log().all() within the then section for logging.
Non-BDD style uses .log().all() at the end of the response setup.
Summary:
BDD-style emphasizes readability and natural language constructs, making it more accessible to non-developers.
Non-BDD style is more traditional, using explicit programming constructs and annotations.
Both styles use RestAssured for API testing but differ in their approach to structuring and expressing tests. The choice between them often depends on team preferences and project requirements.















                    Key Differences:
                     Structure:
  BDD-style code uses a more declarative Given-When-Then structure within the test methods.
   Non-BDD style separates the setup, execution, and assertion steps into different methods (setUp and test methods).
    Natural Language:BDD-style code reads more like natural language, with a focus on expressing the behavior of the system.
   Non-BDD style uses standard programming constructs and TestNG annotations, making it more code-centric.
  TestNG Annotations:  BDD-style code does not use explicit TestNG annotations for setup (@BeforeTest), as the structure inherently follows the BDD Given-When-Then structure. Non-BDD style uses TestNG annotations for setup and test methods.
                     Assertion Methods:  BDD-style code uses Matchers for assertions in a natural language format.
                     Non-BDD style uses Matchers but in a more traditional format, directly applied to the ValidatableResponse.
                     Logging: BDD-style code uses .log().all() within the then section for logging.
                             Non-BDD style uses .log().all() at the end of the response setup.
                             Summary:
                     BDD-style emphasizes readability and natural language constructs, making it more accessible to non-developers.
                             Non-BDD style is more traditional, using explicit programming constructs and annotations.
                             Both styles use RestAssured for API testing but differ in their approach to structuring and expressing tests. The choice between them often depends on team                         preferences and project requirements.
                     */

//currently you know about the bdd style only ie given when then so use that only
// we donot use the chaining instead we use non-chaining way bz again we have to apply whole line again and agian

// you cannot use this below line outside any method it will give error
//   RequestSpecification r=RestAssured.given();
//
//
//                     r.baseUri("https://restful-booker.herokuapp.com");
//                     r.basePath("/auth");

/*
String payload -> 1. cannot reuse the payload,2.static /non dyamic ,3.difficult to maintain in automation framework ,4.limited validation the response-string extra and limited(object)
if you have curd or api to automate
< 50 test cases ->strings

Map payload-> 1.key value,2.hashmap-hasing code,3.map to jason-gson/jackson,4.dynamic in nature
5.code reusabiltiy is limited.

still not a object
validation will be limited
automation framework < 50-150 test cases

Objects and classes payload -->
1.pojo
2. dynamic
3. no limitation on validation
4. gson/jackson-object
5. reuse the code
6. easy to maintain
7.reuse the code
8.automation framework maintain
test case>100



 */











public class RestfulBookerTokenTestCases {
    //@Test is the annotation which tells the metadata to compiler that compiler use to show further ui on the console after result
    // to testng file that these are test cases of testng
   public  static  String token;


    @Test
    void  resfullBoookerResponseIsThere(){

        Response response = RestFullBookerRequestTokenURL.response;
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        MatcherAssert.assertThat(response.getBody().asPrettyString(),Matchers.notNullValue());

    }

    @Test
    void  resfullBoookerResponseContainToken(){

        Response response = RestFullBookerRequestTokenURL.response;
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        // Assume you have a method that returns a response string
        // Replace this with the actual method or API call that returns your response

         Gson gson=new Gson();

         //convert the response to class
         Token token=gson.fromJson(response.asPrettyString(), Token.class);
         //asPreety string comes in the json format string easy to convert into the object
        System.out.println("myToken"+token);

        //since the jasonRespone takes only teh map so map is made with object
        Map<String,Object> map=new HashMap<>();
        map.put("token",token);

        // Parse the response string into a JSONObject
        //we can check each key and value fo teh reespone (in jason format ) using this
        JSONObject jsonResponse = new JSONObject(map);

        // Check if the JSONObject contains the "token" key
        MatcherAssert.assertThat(jsonResponse.containsKey("token"), Matchers.is(true));

    }





    @Test
    void  resfullBoookerTokenStatusOk(){

               Response response= RestFullBookerRequestTokenURL.response;

                //1.
                 MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));
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


                 @Test
                        void  resfullBoookerTokenHeaderContentType() {

                         Response response = RestFullBookerRequestTokenURL.response;
                         //3. (by content ype you get-> true),true since both true matched so assertion is passed
                         MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"),Matchers.is( true));

                     }


                     @Test
                     void resfullBoookerTokenBodyToken () {




                         Response response = RestFullBookerRequestTokenURL.response;

                         //  System.out.println(response1.asString());
                         //it means with jasonpath you can get the values of response body and
                         // with hemcrest you can assert the values of response headers and the respone body,status code,

                         //2. to get value from the response use the jsonpath
                         JsonPath jsonPath = new JsonPath(response.asString());
                         token=jsonPath.getString("token");

                         //static variable withing a class can be accessed
                         System.out.println(token);//$.token ->jasonpath

                         //MatcherAssert.assertThat(response.getHeaders(), hasKey("Content-Type"));


                         //Restfull booker is the class which is loaded first then all the static variable inside that class loaded then
                         // so static variable is at the class level when then7 class the destroyed in then only static variable is destroyed
                         //per class you can make only one type of variable name can be static variable.



                         //3. (by content ype you get-> true),true since both true matched so assertion is passed
                         //4.
                         System.out.println(response.asPrettyString());
                         // "token" :"1343434", value in double quotes so it is string only ,now left side "12334" comes,right side
                         // ,there is with Matcher object that it gives signal that it must not be the null value
                         // equivalent to $.token
                         MatcherAssert.assertThat(response.getBody().jsonPath().getString("token"),Matchers.notNullValue());
                     }


                @Test
                void  resfullBoookerTokenBodyJsonSchema() {

                    Response response =RestFullBookerRequestTokenURL.response;
                    //1 to 4 ,all request was made till "when"  ie so upto when hamcrest liberary can be used for the validation the response

                    //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
                    ValidatableResponse validatableResponse =response.then();



                    validatableResponse.assertThat()
                            .body(JsonSchemaValidator.
                                    matchesJsonSchema(new File("src/test/java/resource/task1/schema.json")));
                 }



}
