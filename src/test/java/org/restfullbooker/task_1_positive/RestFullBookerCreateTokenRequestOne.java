package org.restfullbooker.task_1_positive;


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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class RestFullBookerCreateTokenRequestOne {
    // private bz i want to intialize the response in this classs i donot want ot share that resposne accross
    //any other class of even not to same package

    //every request has seperate response we need different variable for each request

    //you know the feature file is loaded then teh corresponding jvm see the methods of that class then it makes the object and call the
    //class is loaded corresponding  to that then the all static variables inside it then jvm is able to call the methods inside it
    // so we cannot make the final static variable of response just like previous assignment bz method {string} we cannot provide argument
    //only jvm can provide so ,we cannot alos make the finla non static variable reason as below
    //methods of it
    //if i take "private final Response response1" as teh data member  --> then at the time of when   RestFullBookerCreateTokenRequestOne class is loaded
    //then object is made of it  then the

    //when the this RestFullBookerCreateTokenRequestOne metaspace object  is made in heap by jvm after anysying the feature file then the
    // class of RestFullBookerCreateTokenRequestOne is loaded in the metaspace  at the back now using that object firstly
    //since at the back non paramterized constructor is ther so the data variable is assingned null value
    //bydeafult since it is final it remain null throughout and whihc is problem so we cannot use it agian





    // so only security is remained that private directly the variable name has to be used in throughout no security
    private Response response;

    //bydefault set to null instance variable


    //i want token must be assigned in this class not in other class so private
    //data member not used other classes only be used in this class
    //other classes can be used it by classname.method

    //static is easy to called by the classnaem thats why
    private static String token;


    // but i donot wnat that varicalt to change direclty
    //if someone outer class  want get the value ,it can use the static method direclty by classname
    public static String token() {
        return token;
    }




    @Given("Get payload from urlOne {string}")
    public  void get_payload_from_urlOne(String baseUri) {
          /* payload.setUsername("admin");
                     payload.setPassword("password123");*/

                   /*  String payload = "{\n" +
                             "    \"username\" : \"admin\",\n" +
                             "    \"password\" : \"password123\"\n" +
                             "}";*/
        //serialisation means to convert the object in the byte of streams (ie the jason format or xml format) then \
        // 10110 is send on the network




        Customer customer=new Customer("admin","password123");//directly passing the object to body
        //giving me error so we has to change the suitable string using the Gson then pass to the body of response
        Gson gson=new Gson();
        String payload= gson.toJson(customer);
        RequestSpecification requestSpecification= given();




        requestSpecification.baseUri(baseUri);
       // requestSpecification.baseUri(BASE_URI);
       // requestSpecification.basePath(BASE_PATH_TOKEN);
        requestSpecification.contentType(ContentType.JSON);//header is set
        requestSpecification.body(payload);//it will set as the class for payload (no map and string )
        // , class for more than 150 test case
        /* RestFullBookerResponse response=*/ // and it can be dynamic
        //since the payload is the object type so the body has the overloaded method which has argument Object





        //now we know when the object  RestFullBookerCreateTokenRequestOne is made by the jvm after analysing
        // the feature file scenerio then class
        // RestFullBookerCreateTokenRequestOne
        //is loaded corresponding to tha all the static variable are loaded in the metaspace now
        //since the response is private so this resposen can only be used within in class
        // response is actually the this.response,no use of getter or setter they are used when other classes can only
        //use that method not directly through variable ,this.response means jvm is currently working on the object
        //  RestFullBookerCreateTokenRequestOne that
        //this.response is assigned
        response=requestSpecification.when().post();

    }

    //private means only used within class
    @Then("verify responseOne status code {string}")
    public  void verify_response_one_status_code(String statusCode) {


        //1.
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is( Integer.valueOf(statusCode)));
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


    //private means only used within class
    @Then("verify responseOne contains token as key")
    public  void verify_response_one_contains_token_as_key() {

        // calling method will take time so directly teh value fo final static method will save time while calling
      //  RestFullBookerResponse response = RestFullBookerRequestTokenURL.response;
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        // Assume you have a method that returns a response string
        // Replace this with the actual method or API call that returns your response

        Gson gson=new Gson();

        //convert the response to class
        Token token=gson.fromJson(response.asPrettyString(), Token.class);
        //asPreety string comes in the json format string easy to convert into the object
       // System.out.println("myToken"+token);

        //since the jasonRespone takes only teh map so map is made with object
        Map<String,Object> map=new HashMap<>();
        map.put("token",token);

        // Parse the response string into a JSONObject
        //we can check each key and value fo teh reespone (in jason format ) using this
        JSONObject jsonResponse = new JSONObject(map);

        // Check if the JSONObject contains the "token" key
        MatcherAssert.assertThat(jsonResponse.containsKey("token"), Matchers.is(true));

    }


    //private means only used within class
    @Then("verify responseOne contains header content type")
    public  void verify_response_one_contains_header_content_type() {

        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"),Matchers.is( true));

    }


    //private means only used within class
    @Then("verify responseOne contains token")
    public  void verify_response_one_contains_token() {


        // calling method will take time so directly teh value fo final static method will save time while calling
     //   RestFullBookerResponse response = RestFullBookerRequestTokenURL.response;

        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        token=jsonPath.getString("token");

        //static variable withing a class can be accessed
       // System.out.println(TOKEN);//$.token ->jasonpath

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
        MatcherAssert.assertThat(response.getBody().jsonPath().getString("token"),Matchers.notNullValue());
    }


    //private means only used within class
    @Then("verify responseOne Json Schema")
    public  void verify_response_one_json_schema() {

        //1 to 4 ,all request was made till "when"  ie so upto when hamcrest liberary can be used for the validation the response

        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/resource/task1/schema.json")));
    }




}
