package com.lucas.soap;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

@BindingType("")
@WebService()
public class HelloWord {
    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        System.out.println ( result );
        return result;
    }
}