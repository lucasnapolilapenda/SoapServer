package com.lucas.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class SoapClient {

    @WebServiceRef(wsdlLocation="http://localhost:8080/Soaps_war/calculation?wsdl")
    static InterfaceCalculation service;


    public static void main (String[] args) throws MalformedURLException {



        Scanner input = new Scanner (System.in  );
        Numbers sum = new Numbers ();
        sum.number1 = input.nextInt ();
        sum.number2 = input.nextInt ();

        SoapClient sc = new SoapClient ();
        sc.call (sum);

        System.out.println (sc.adding ( sum )  );
        System.out.println (sc.substract ( sum )  );
    }

    private void call(Numbers sum) {
        service.ge
    }


}
