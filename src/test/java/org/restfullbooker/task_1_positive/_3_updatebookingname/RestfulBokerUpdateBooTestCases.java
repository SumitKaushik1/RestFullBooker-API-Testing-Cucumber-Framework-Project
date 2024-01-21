package org.restfullbooker.task_1_positive._3_updatebookingname;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

import static org.restfullbooker.task_1_positive._3_updatebookingname.RestFullBookerUpdateBookingURL.restFullBookerUpdateBookingURL;

public class RestfulBokerUpdateBooTestCases {
    @Test
    void  resfullBookerUpdateBookingStatusOk() throws JsonProcessingException {

        Response response= restFullBookerUpdateBookingURL();


        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(200));

    }

    @Test
    void  resfullBoookerUpdateBokingHeaderContentType() throws JsonProcessingException {

        Response response =restFullBookerUpdateBookingURL();
        //3. (by content ype you get-> true),true since both true matched so assertion is passed
        System.out.println(response.getHeaders().toString());
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"),Matchers.is(true));




    }


    @Test
    void  resfullBoookerUpdateBookingJsonSchema() throws JsonProcessingException {

        Response response =restFullBookerUpdateBookingURL();
        //1 to 4 ,all request was made till "when"  ie so upto when hamcrest liberary can be used for the validation the response

        //5. in this then() has to used which return the implementation class of validation reponse which  can help easily to validate the schema
        ValidatableResponse validatableResponse =response.then();



        validatableResponse.assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/test/java/resource/task1/schema2.json")));



    }







    @Test
    void resfullBookerUpdataBookingFirstName () throws JsonProcessingException {




        Response response = restFullBookerUpdateBookingURL();

        //  System.out.println(response1.asString());
        //it means with jasonpath you can get the values of response body and
        // with hemcrest you can assert the values of response headers and the respone body,status code,

        //2. to get value from the response use the jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        String firstname=jsonPath.getString("firstname");

        //static variable withing a class can be accessed
        System.out.println("firstName"+firstname);//$.firstname ->jasonpath

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
        MatcherAssert.assertThat(response.getBody().jsonPath().getString("firstname"),Matchers.notNullValue());
    }



}
