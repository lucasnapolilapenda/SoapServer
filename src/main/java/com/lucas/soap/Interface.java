package com.lucas.soap;


import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface Interface {

    @WebMethod
    String listAllBooks();

    @WebMethod
    String getBookInfo (Integer id);

    @WebMethod
    String getBookInfoByISBN (Book book);

    @WebMethod
    String addBook (Book book);

    @WebMethod
    String updateBookInfo (Book book);

    @WebMethod
    Void deleteBook (Integer id);

}
