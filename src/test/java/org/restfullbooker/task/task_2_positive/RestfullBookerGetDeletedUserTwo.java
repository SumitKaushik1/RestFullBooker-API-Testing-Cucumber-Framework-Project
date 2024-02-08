package org.restfullbooker.task.task_2_positive;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.restfullbooker.task.task_1_positive.RestFullBookerCreateBookingTwo;

public class RestfullBookerGetDeletedUserTwo {
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



    //i want the  bookingidtodelete must be not changed that comes form other class in this class so final so once intitalized
    //cannot not be changed further

    //jvm made object will call the parameterized constructor below
    //it is final whatever teh value imported here must not be changed throughout below while making the request

    //jvm made object will call the parameterized constructor below
    //it is final whatever teh value imported here must not be changed throughout below while making the request


    private final  String BOOKING_ID_TO_DELETE;
    //it msut be used within the class only so private


    public RestfullBookerGetDeletedUserTwo() {

        //when the 1st scenerio of the feature file is called by jvm then form the object of it made
        // and teh class related to that is loaded int the metaspace and then
        //automactically the constructor is called the final data member is intialzed
        // ie we did not made the object it is the object that jvm made in background that object also

        // used to callt he methods here in below which @Given and aother annotation
        this.BOOKING_ID_TO_DELETE = RestFullBookerCreateBookingTwo.getDeletedBookingId();
    }


    @Given("Get bookingid  urlSix {string}")
    public void get_bookingid_url_six(String baseUri) {
        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri(baseUri+"/"+BOOKING_ID_TO_DELETE);

        //System.out.println(bookingidToUpdate);
       // requestSpecification.basePath("/booking/"+deletedbookingid);


         response = requestSpecification.get();
        // Printing Response as string
       // System.out.println(response.asString());

       // return response;


    }
    @Then("verify responseSix status code {string}")
    public void verify_response_six_status_code(String string) {

        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(404));
    }
    @Then("verify responseSix contains header content type")
    public void verify_response_six_contains_header_content_type() {
        MatcherAssert.assertThat(response.getHeaders().hasHeaderWithName("Content-type"),Matchers.is(true));
    }

}
