package com.lucas.soap;

import javax.jws.WebService;


@WebService(endpointInterface = "com.lucas.soap.LibraryServices")

public class LibraryServices implements Interface {

    @Override
    public String listAllBooks() {
        return null;
    }

    @Override
    public String getBookInfo(Integer id) {
        return null;
    }

    @Override
    public String getBookInfoByISBN(Book book) {
        return null;
    }

    @Override
    public String addBook(Book book) {
        return null;
    }

    @Override
    public String updateBookInfo(Book book) {
        return null;
    }

    @Override
    public String deleteBook(Integer id) {

    }
}

