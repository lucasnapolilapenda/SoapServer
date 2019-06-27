package com.lucas.soap;
/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SoapServer
 * @version 1.1
 * @since 1.0
 */

import javax.xml.ws.Endpoint;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Point of entry, represents publisher implementation
 */

public class Publisher {
    public static void main (String[] args) {
        showMenu ();
    }

    /**Display the menu. This starts when the app load
     * @throws NumberFormatException manage Integer input
     * @throws InputMismatchException manage Integer input
     */


    public static void showMenu()  {
        try {
            int exit = 0;
            do {
                System.out.println ( "" );
                System.out.println ( "****** Welcome to Solo's Library ******" );
                System.out.println ( "" );
                System.out.println ( "Please, Select one Option - Int Required from 0 to 2" );
                System.out.println ( "1. Help / About" );
                System.out.println ( "2. Endpoint to publish the services" );
                System.out.println ( "0. Quit" );
                System.out.println ( "" );

                Scanner sc = new Scanner ( System.in );
                int response = Integer.valueOf ( sc.nextLine ( ) );
                System.out.println ( response );
                switch (response) {
                    case 0:
                        //salir
                        exit = 0;
                        break;
                    case 1:
                        new Publisher().help ();
                        break;
                    case 2:
                        new Publisher ().publisherCreator ();
                        break;

                    default:
                        System.out.println ( );
                        System.out.println ( "Please, Select one Option" );
                        System.out.println ( );
                        break;
                }

            } while (exit != 0);
        } catch (InputMismatchException | NumberFormatException ex) {
            System.out.println ( "Please, check the input, all (int) required values" );
            showMenu ();
        }
    }

    /**
     *  PublisherCreator
     *  @throws IllegalArgumentException manage Integer input
     */


    public void publisherCreator (){
        try {
            Scanner sc = new Scanner ( System.in );
            System.out.println ( ":::::: Publisher Setting Module  :::::::" );
            System.out.println ( "Please, enter the URL" );
            String urlOption = sc.next ( );
            System.out.println ( "Thanks" );
            Endpoint.publish ( urlOption, new LibraryServices ( ) );
            showMenu ( );
        }catch (IllegalArgumentException ex) {
            System.out.println ( "Please, enter a valid URL" );
            showMenu ( );
        }
    }

    /**
     * Help information
     */

    public void help() {
        System.out.println ( "***** Welcome to Solo's Library System Version SOAP *****" );
        System.out.println (    "\n In this System you can search, add and delete books. " +
                "\n This the publisher in the back end " +
                "\n Thanks for using Lucas Software and enjoy it" );

        System.out.println ( "Please, type any KEY to come back to the Menu" );
        Scanner sc = new Scanner ( System.in );
        sc.next ( );
        showMenu ( );
    }


}