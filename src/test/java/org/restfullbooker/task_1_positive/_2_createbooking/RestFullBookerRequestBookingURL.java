package org.restfullbooker.task_1_positive._2_createbooking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restfullbooker.pojorequest.BookingDetails;

import static org.restfullbooker.task_1_positive._1_createtoken.RestfulBookerTokenTestCases.token;


public class RestFullBookerRequestBookingURL {


/*
    static  Response request() throws JsonProcessingException {
            *//* payload.setUsername("admin");
                     payload.setPassword("password123");*//*

                   *//*  String payload = "{\n" +
                             "    \"username\" : \"admin\",\n" +
                             "    \"password\" : \"password123\"\n" +
                             "}";*//*
        //serialisation means to convert the object in the byte of streams (ie the jason format or xml format) then \
        // 10110 is send on the network




          // since booking deatils must have two types of constructor one is the non-parameterized for the 30 line and
        // paramterized for the 31 th line
      //  BookingDetails.BookingDates bookingDates=new BookingDetails().new BookingDates("2018-01-01","2019-01-01");

     BookingDates bookingDates= new BookingDates("2018-01-01","2019-01-01");

        BookingDetails bookingDetails=new BookingDetails("Jim","Brown",111,true,bookingDates,"Breakfast");//directly passing the object to body
        //when two clases closely packed so no need to creat the inner class as the seperate classs and try to import
        // instead make it as the inner nested  class and and you can save a one .java file


        //giving me error so we has to change the suitable string using the Gson then pass to the body of response
        Gson gson=new Gson();
        String payload= gson.toJson(bookingDetails);
        RequestSpecification requestSpecification= given();

        ObjectMapper objectMapper = new ObjectMapper();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);//header is set
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.cookie("token",token);



        String payloadl = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
       System.out.println(payload);
        requestSpecification.body(payloadl);//it will set as the class for payload (no map and string )
        // , class for more than 150 test case
        *//* Response response=*//* // and it can be dynamic
        //since the payload is the object type so the body has the overloaded method which has argument Object
        //Response response=
                return requestSpecification.when().post();

    }*/





    static  Response restFullBookerRequestBookingURL() throws JsonProcessingException{

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

        Response response = requestSpecification.post();
        // Printing Response as string
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
        System.out.println(payload);


        RequestSpecification requestSpecification= RestAssured.given();
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);
        //requestSpecification.accept(ContentType.JSON);//header is set
        //note bydefault the accept header response is json no need to specify that otherwise it will give error
         System.out.println(token);
       requestSpecification.cookie(token);
        //requestSpecification.cookie("aafd2ca64353106");
        // Adding URI
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        // Adding body as string
        requestSpecification.body(payload);

        Response response = requestSpecification.post();
        // Printing Response as string
        System.out.println(response.asString());

        return response;


    }
}
