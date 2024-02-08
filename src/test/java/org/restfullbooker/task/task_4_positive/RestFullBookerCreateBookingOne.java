package org.restfullbooker.task.task_4_positive;

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
import org.restfullbooker.pojorequest.BookingDetails;
import org.restfullbooker.pojoresponse.BookingDetailsResponse;
import org.restfullbooker.task.task_1_positive.RestFullBookerCreateTokenRequestOne;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class RestFullBookerCreateBookingOne {

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



    //i want the token must be not changed that comes form other class in this class so final so once intitalized
    //cannot not be changed further

    //jvm made object will call the parameterized constructor below
    //it is final whatever teh value imported here must not be changed throughout below while making the request
    private  final  String TOKEN;
    //it msut be used within the class only so private



    // it must be used within the class only so private
    private static String  BOOKING_ID_TO_UPDATE;

    // it must be used within the class only so private
    private static String  DELETED_BOOKING_ID;
    //full baseURI is taken from feature file here
    //{string} ->


    public RestFullBookerCreateBookingOne() {
        //when the 2nd scenerio of the feature file is called by jvm then form the object of it made
        // and teh class related to that is loaded int the metaspace and then
        //automactically the constructor is called the final data member is intialzed
        // ie we did not made the object it is the object that jvm made in background that object also

        // used to callt he methods here in below which @Given and aother annotation
        this.TOKEN = RestFullBookerCreateTokenRequestOne.token();
    }


    // i donot want that booking id must be set diffent in outer classses so only the getter is provided here
    //no setter is provided here ot change the value of bookign id ,only whatevert the value commes here
    //it will be used in other classes


    //i donot want the other classes to change the value whatever come in resposne in below code
    public static String getBookingIdToUpdate() {
        return BOOKING_ID_TO_UPDATE;
    }

    public static String getDeletedBookingId() {
        return DELETED_BOOKING_ID;
    }




    @Given("Get payload from urlTen {string}")
    public void get_payload_from_url_ten(String baseUri) {
          /*  RequestSpecification requestSpecification= RestAssured.given();
        ValidatableResponse validatableResponse;
        String token;

        String payload = "{\r\n" + "    \"firstname\" : \"Pramod\",\r\n" + "    \"lastname\" : \"Dutta\",\r\n"
                + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n" + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n" + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}";



        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        // Adding URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        // Adding body as string
        requestSpecification.body(payload);

        RestFullBookerResponse response = requestSpecification.post();
        // Printing RestFullBookerResponse as string
        System.out.println(response.asString());

          return response;
*/





        // since booking deatils must have two types of constructor one is the non-parameterized for the 30 line and
        // paramterized for the 31 th line

        //when inner nested class is made to avoid making seperate class we can access by it
        BookingDetails.BookingDates bookingDates=new BookingDetails().new BookingDates("2018-01-01","2019-01-01");

        //  BookingDates bookingDates= new BookingDates("2018-01-01","2019-01-01");//when seperate bookingDates class is made
        BookingDetails bookingDetails=new BookingDetails("Jim","Brown",111,true,bookingDates,"Breakfast");
        //directly passing the object to body
        //when two clases closely packed so no need to create the inner class as the seperate classs and try to import
        // instead make it as the inner nested  class and and you can save a one .java file


        //giving me error so we has to change the suitable string using the Gson then pass to the body of response
        Gson gson=new Gson();
        String payload= gson.toJson(bookingDetails);
        //System.out.println(payload);


        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header response is json no need to specify that otherwise it will give error
        //  System.out.println(TOKEN);
        requestSpecification.cookie(TOKEN);
        //requestSpecification.cookie("aafd2ca64353106");
        // Adding URI
        requestSpecification.baseUri(baseUri);
        //requestSpecification.basePath(BASE_PATH_BOOKING);
        // Adding body as string
        requestSpecification.body(payload);




        //now we know when the object  RestFullBookerCreateTokenRequestOne is made by the jvm after analysing
        // the feature file scenerio then class
        // RestFullBookerCreateTokenRequestOne
        //is loaded corresponding to tha all the static variable are loaded in the metaspace now
        //since the response is private so this resposen can only be used within in class
        // response is actually the this.response,no use of getter or setter they are used when other classes can only
        //use that method not directly through variable ,this.response means jvm is currently working on the object
        //  RestFullBookerCreateTokenRequestOne that
        //this.response is assigned
        response = requestSpecification.post();
        // Printing RestFullBookerResponse as string
        // System.out.println(response.asString());
    }
    @Then("verify responseTen status code {string}")
    public void verify_response_ten_status_code(String string) {
        // calling method will take time so directly teh value fo final static
        //method will save time while calling
        // RestFullBookerResponse response =RestFullBookerRequestBookingURL.response;


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));// Write code here that turns the phrase above into concrete actions

    }
    @Then("verify  responseTen contains bookingId as key")
    public void verify_response_ten_contains_booking_id_as_key() {
        // calling method will take time so directly teh value fo final static method will save time while calling
        // RestFullBookerResponse response =RestFullBookerRequestBookingURL.response;
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        // Assume you have a method that returns a response string
        // Replace this with the actual method or API call that returns your response

        Gson gson=new Gson();

        //convert the response to class
        BookingDetailsResponse bookingDetailsResponse=gson.fromJson(response.asPrettyString(), BookingDetailsResponse.class);
        //asPreety string comes in the json format string easy to convert into the object
        // System.out.println("mybookingDetailsResponse"+bookingDetailsResponse);

        //since the jasonRespone takes only teh map so map is made with object
        Map<String,Object> map=new HashMap<>();
        map.put("bookingid",bookingDetailsResponse.getBookingid());

        // Parse the response string into a JSONObject
        //we can check each key and value fo teh reespone (in jason format ) using this
        JSONObject jsonResponse = new JSONObject(map);

        // Check if the JSONObject contains the "token" key
        MatcherAssert.assertThat(jsonResponse.containsKey("bookingid"), Matchers.is(true));
    }
    @Then("verify  responseTen contains header content type")
    public void verify_response_ten_contains_header_content_type() {

        // calling method will take time so directly teh value fo final static method will save time while calling
        //    RestFullBookerResponse response =RestFullBookerRequestBookingURL.response;
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        //   System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"), Matchers.is(true));
    }
    @Then("verify  responseTen contains bookingId")
    public void verify_response_ten_contains_booking_id() {
        // calling method will take time so directly teh value fo final static method will save time while calling
        //  RestFullBookerResponse response =RestFullBookerRequestBookingURL.response;

        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        DELETED_BOOKING_ID= BOOKING_ID_TO_UPDATE=jsonPath.getString("bookingid");
        //a=b=c;
        // means right to left ie b=c,a=b

        //static variable withing a class can be accessed
        // System.out.println(BOOKING_ID_TO_UPDATE);//$.bookingid ->jasonpath

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
        MatcherAssert.assertThat(response.getBody().jsonPath().getString("bookingid"),Matchers.notNullValue());
    }
    @Then("verify  responseTen Json Schema")
    public void verify_response_ten_json_schema() {
        // calling method will take time so directly teh value fo final static method will save time while calling
        // RestFullBookerResponse response =RestFullBookerRequestBookingURL.response;
        //1 to 4 ,all request was made till "when"  ie so upto when hamcrest liberary can be used for the validation the response

        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/resource/task1/schema1.json")));
    }



}
