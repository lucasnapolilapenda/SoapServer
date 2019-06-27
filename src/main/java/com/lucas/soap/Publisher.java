package com.lucas.soap;
/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SoapServer
 * @version 1.1
 * @since 1.0
 */

import javax.xml.ws.Endpoint;
import java.util.Scanner;
/**
 * Point of entry, represents publisher implementation
 */

public class Publisher {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println ( "Welcome to Solos Library, please enter your endpoint to publish the services" );
        String urlOption = sc.next (  );
        Endpoint.publish ( urlOption , new LibraryServices ());
        System.out.println ( "in case of failure remember start Tomcat, enjoy it" );
    }
}
