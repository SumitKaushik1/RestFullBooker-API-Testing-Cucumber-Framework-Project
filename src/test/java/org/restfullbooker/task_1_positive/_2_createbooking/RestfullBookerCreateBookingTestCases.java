package org.restfullbooker.task_1_positive._2_createbooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONObject;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.restfullbooker.pojoresponse.BookingDetailsResponse;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.restfullbooker.task_1_positive._2_createbooking.RestFullBookerRequestBookingURL.restFullBookerRequestBookingURL;


public class RestfullBookerCreateBookingTestCases {



    public static String  bookingidToUpdate;
    public static String deletedbookingid;


    @Test
    void  resfullBookerResponseContainBookingId() throws JsonProcessingException {

        Response response =restFullBookerRequestBookingURL();
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        // Assume you have a method that returns a response string
        // Replace this with the actual method or API call that returns your response

        Gson gson=new Gson();

        //convert the response to class
        BookingDetailsResponse bookingDetailsResponse=gson.fromJson(response.asPrettyString(), BookingDetailsResponse.class);
        //asPreety string comes in the json format string easy to convert into the object
        System.out.println("mybookingDetailsResponse"+bookingDetailsResponse);

        //since the jasonRespone takes only teh map so map is made with object
        Map<String,Object> map=new HashMap<>();
        map.put("bookingid",bookingDetailsResponse.getBookingid());

        // Parse the response string into a JSONObject
        //we can check each key and value fo teh reespone (in jason format ) using this
        JSONObject jsonResponse = new JSONObject(map);

        // Check if the JSONObject contains the "token" key
        MatcherAssert.assertThat(jsonResponse.containsKey("bookingid"), Matchers.is(true));

    }







    @Test
    void  resfullBookerCreateBookingStatusOk() throws JsonProcessingException {

        Response response= restFullBookerRequestBookingURL();


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));

    }


    @Test
    void  resfullBookerCreateBokingHeaderContentType() throws JsonProcessingException {

        Response response = restFullBookerRequestBookingURL();
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"), Matchers.is(true));




    }



    @Test
    void  resfullBookerTokenBodyJsonSchema() throws JsonProcessingException {

        Response response = restFullBookerRequestBookingURL();
        //1 to 4 ,all request was made till "when"  ie so upto when hamcrest liberary can be used for the validation the response

        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/java/resource/task1/schema1.json")));



    }



    @Test
    void resfullBookerCreateBookingBookingId () throws JsonProcessingException {




        Response response = restFullBookerRequestBookingURL();

        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        deletedbookingid=bookingidToUpdate=jsonPath.getString("bookingid");
        //a=b=c;
       // means right to left ie b=c,a=b

        //static variable withing a class can be accessed
        System.out.println(bookingidToUpdate);//$.bookingid ->jasonpath

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
        MatcherAssert.assertThat(response.getBody().jsonPath().getString("bookingid"),Matchers.notNullValue());
    }

}
