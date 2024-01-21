package org.restfullbooker.task_1_positive._4_getbooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.restfullbooker.task_1_positive._2_createbooking.RestfullBookerCreateBookingTestCases.bookingidToUpdate;

public class RestfullBookerGetBookingURL {
    static Response restfullBookerGetBookingURL() throws JsonProcessingException {

        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
         //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header  response is json no need to specify that otherwise it will give error

        // Adding URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");

        System.out.println(bookingidToUpdate);
        requestSpecification.basePath("/booking/"+bookingidToUpdate);


        Response response = requestSpecification.get();
        // Printing Response as string
        System.out.println(response.asString());

        return response;


    }


}
