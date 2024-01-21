package org.restfullbooker.task_1_positive._1_createtoken;


import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.restfullbooker.pojorequest.Customer;

import static io.restassured.RestAssured.given;
import static org.restfullbooker.task_1_positive.APIConstants.*;

public class RestFullBookerRequestTokenURL {

    //public is not need bz withing package allowed no specifier

    //final must be initalized (even static is allowed)

    //since every time it has to call ie the time waste so we make the static ie it can use directly teh static variable in the metaspace


     static final Response response = restFullBookerRequestTokenURLRequest();
     //static variable can be intialized by the static method only
    // non final variable be initilized by the static block , final variable is not initialized by the static block
    //can only be initialized by the that instance only


   private static Response  restFullBookerRequestTokenURLRequest(){
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
        //each request url must have different request specification so ti must have different object for each
        //request specification


        requestSpecification.baseUri(BASE_URI);
        requestSpecification.basePath(BASE_PATH1);
        requestSpecification.contentType(ContentType.JSON);//header is set
        requestSpecification.body(payload);//it will set as the class for payload (no map and string )
        // , class for more than 150 test case
        /* Response response=*/ // and it can be dynamic
        //since the payload is the object type so the body has the overloaded method which has argument Object
        //Response response=


        return  requestSpecification.when().post();
    }
}
