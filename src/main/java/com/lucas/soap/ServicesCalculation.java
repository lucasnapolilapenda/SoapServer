package com.lucas.soap;

import javax.jws.WebService;


@WebService(endpointInterface = "com.lucas.soap.InterfaceCalculation")

public class ServicesCalculation implements InterfaceCalculation {


    @Override
    public int adding(Numbers number) {
        int number1 = number.getNumber1 ();
        int number2 = number.getNumber2 ();
        return number1 + number2;
    }

    @Override
    public int substract(Numbers number) {
        int number1 = number.getNumber1 ();
        int number2 = number.getNumber2 ();
        return number1 - number2;
    }
}
