package com.lucas.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface InterfaceCalculation {

    @WebMethod
    int adding(Numbers number);

    @WebMethod
    int substract (Numbers number);

}

