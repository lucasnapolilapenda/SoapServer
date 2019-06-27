package com.lucas.soap;

import javax.xml.ws.Endpoint;
import java.util.Scanner;

public class Publisher {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println ( "Welcome to Solos Library, please enter your endpoint to publish the services" );
        String urlOption = sc.next (  );
        Endpoint.publish ( urlOption , new LibraryServices ());
        System.out.println ( "in case of failure remember start Tomcat, enjoy it" );
    }
}
