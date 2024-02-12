package org.restfullbooker.task.task_4_positive;

import io.restassured.response.Response;

public class RestfullBookerDeleteBookingIdTwo {


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
}
