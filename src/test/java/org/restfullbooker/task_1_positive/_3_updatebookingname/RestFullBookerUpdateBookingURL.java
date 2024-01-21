package org.restfullbooker.task_1_positive._3_updatebookingname;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import static org.restfullbooker.task_1_positive._2_createbooking.RestfullBookerCreateBookingTestCases.bookingidToUpdate;

public class RestFullBookerUpdateBookingURL {

        public static Response  restFullBookerUpdateBookingURL() throws JsonProcessingException {

            JSONObject bookingDetails=new JSONObject();
            bookingDetails.put("firstname","James");
            //BookingDetails bookingDetails=new BookingDetails("James");
            //directly passing the object to body
            //when two clases closely packed so no need to creat the inner class as the seperate classs and try to import
            // instead make it as the inner nested  class and and you can save a one .java file


            //giving me error so we has to change the suitable string using the Gson then pass to the body of response
            Gson gson=new Gson();
            String payload= gson.toJson(bookingDetails);
            System.out.println(payload);


            RequestSpecification requestSpecification= RestAssured.given();
            // Setting content type to specify format in which request payload will be sent.
            // ContentType is an ENUM.
            requestSpecification.contentType(ContentType.JSON);
           // requestSpecification.accept(ContentType.JSON);//header is set
            //note bydefault the accept header response is json no need to specify that otherwise it will give error


            //we can change the resource by two things
            //1. either we should have the token by supplying the username and password
            //2. we have to directly use the basic authorization by supplying the username and passowrd
            //System.out.println(token);
          // requestSpecification.cookie(token);

            requestSpecification.auth().preemptive().basic("admin","password123");

             /*

                   what is meant by preemptive in this -->requestSpecification.auth().preemptive().basic("admin","password123");

            SK
            In this context, "preemptive" refers to sending the HTTP Basic authentication credentials preemptively with the request, rather than waiting for a 401 Unauthorized response first.

                    Specifically:

            By default, RestAssured will not send authentication credentials until it receives a 401 Unauthorized response from the server.
                    Adding .preemptive() configures it to send the Basic auth credentials up front with the first request.
            This avoids having to make an initial unauthenticated request and get a 401 before sending the credentials.
            So "preemptive" here means sending the Basic authentication proactively before getting a 401, rather than waiting for the Unauthorized response first.

            It's a way to configure RestAssured to automatically authenticate the first request, avoiding an extra round trip to get the 401 error. The credentials are sent preemptively.

            Copy

            how whole process happnes

            SK
            Here is an overview of how the preemptive authentication process works with RestAssured:

            When making a request, RestAssured checks if preemptive auth is enabled.
            If so, it will automatically add an Authorization header containing the Base64 encoded credentials (username:password) to the request before sending it.
            For example:

            Copy code

            Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=
                    The server receives the request with the Authorization header and can authenticate the user without having to return a 401 Unauthorized first.
            If authentication succeeds, the server will return a 200 OK or whatever the normal response should be.
            If it fails, the server may still return a 401 or another error response.
            So the key points are:

            Preemptive auth sends the credentials up front, without waiting for a 401.
            This avoids an extra request/response round trip to get the 401 before authenticating.
            The Authorization header is added automatically by RestAssured before sending the request.
            Server can authenticate immediately without prompting for credentials.
                    So preemptive mode streamlines the auth process by sending credentials proactively.

            Copy

            how process happens in non preemptive

            SK
            Here is how the authentication process works without preemptive mode:

            RestAssured makes a request to the server without any authentication credentials.
                    The server returns a 401 Unauthorized status code, indicating authentication is required.
                    RestAssured sees the 401 response and automatically sends the credentials.
            It will re-send the original request, this time with an Authorization header containing the Base64 encoded username:password.
                    For example:

            Copy code

            GET /api/resource

            401 Unauthorized

            GET /api/resource
            Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=
                    The server authenticates the credentials and returns a 200 OK if they are valid.
                    So in summary, without preemptive mode:

            No credentials are sent on the first request.
            Server returns 401 asking for authentication.
                    RestAssured automatically resends request with credentials.
                    Extra round trip of unauthenticated request/401 response.
                    Overall slower due to extra call to get 401 before authenticating.
            So non-preemptive auth requires an extra call to prompt for credentials before sending them.
             Preemptive mode avoids this by sending credentials up front.*/



            // Adding URI
            requestSpecification.baseUri("https://restful-booker.herokuapp.com");
            System.out.println(bookingidToUpdate);
            requestSpecification.basePath("/booking/"+bookingidToUpdate);

            // Adding body as string
            requestSpecification.body(payload);

            Response response = requestSpecification.patch();
            // Printing Response as string
            System.out.println(response.asString());

            return response;


        }




}
