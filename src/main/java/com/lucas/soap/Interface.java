package com.lucas.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;



@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Interface {

    @WebMethod
    String listAllBooks();

    @WebMethod
    String getBookInfo (Integer id);

    @WebMethod
    String getBookInfoByISBN (String isbn);

    @WebMethod
    String addBook (Book book);

    @WebMethod
    String updateBookInfo (Book book);

    @WebMethod
    String deleteBook (Integer id);

}
