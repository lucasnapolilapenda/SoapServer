package com.lucas.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class SoapClient {

    public static void main (String[] args) throws MalformedURLException {
        URL wsdURL = new URL ("http://localhost:8080/Soaps_war/calculation?wsdl");

        QName qname = new QName ("http://soap.lucas.com/", "ServicesCalculationService");

        Service service = Service.create ( wsdURL, qname );

        InterfaceCalculation sc = service.getPort ( InterfaceCalculation.class );

        Scanner input = new Scanner (System.in  );
        Numbers sum = new Numbers ();
        sum.number1 = input.nextInt ();
        sum.number2 = input.nextInt ();


        System.out.println (sc.adding ( sum )  );
        System.out.println (sc.substract ( sum )  );
    }



}
