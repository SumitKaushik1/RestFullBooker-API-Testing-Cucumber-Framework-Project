package org.restfullbooker.task_1_positive;

import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restfullbooker.pojorequest.BookingDetails;



import static org.restfullbooker.task_1_positive.RestFullBookerCreateToken_1.TOKEN;



//we need differnet request clases bz the we need the different class for each request
public class RestfullBookerCreateBooking_2 {

    // private bz i want to intialize the response in this classs i donot want ot share that resposne accross
    //any other class of even not to same package

    //every request has seperate respone we need different variable for each request
    private static  Response response;
    //bydefault set to null instance variable

    //i want this token must be used in this class only so private  and it must be constant ie once intialzie
    //cannot be changed so capital letter
    private final static  String  BOOKING_TOKEN=TOKEN;

    @Given("Get payload from {string}")
    public void get_payload_from(String baseUri) {

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
        System.out.println(BOOKING_TOKEN);
        requestSpecification.cookie(BOOKING_TOKEN);
        //requestSpecification.cookie("aafd2ca64353106");
        // Adding URI

         requestSpecification.baseUri(baseUri);
       // requestSpecification.baseUri(BASE_URI);
       // requestSpecification.basePath(BASE_PATH_BOOKING);
        // Adding body as string
        requestSpecification.body(payload);

         response = requestSpecification.post();
        // Printing Response as string
        System.out.println(response.asString());



    }













}
