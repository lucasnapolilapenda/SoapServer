package com.lucas.soap;

import javax.jws.WebService;
import java.util.Set;


@WebService(endpointInterface = "com.lucas.soap.LibraryServices")

public class LibraryServices implements Interface {

    @Override
    public String listAllBooks() {

        String bookList = "";
        Set <Integer> ids = BookRepository.getRepository().keySet ();
        Book[] p = new Book[ids.size()];
        int i=0;
        for(Integer id : ids){
            p[i] = BookRepository.getRepository ().get(id);
            i++;
        }

        for (Book book : p) {
            bookList = ("ISBN: " + book.getIsbn () + "  " +
                        "Title: " + book.getTitle () +
                        "\n".concat ( bookList ));
            System.out.println ( " " );
        }


        return bookList;
    }

    @Override
    public String getBookInfo(Integer id) {

        if (BookRepository.getRepository ().get ( id ) == null) {
            return messageWo ( id );
        }


        String bookIsbn = BookRepository.getRepository ().get(id).isbn;
        String bookTitle = BookRepository.getRepository ().get(id).title;
        String bookAuthor = BookRepository.getRepository ().get(id).author;
        String bookPublisher = BookRepository.getRepository ().get(id).publisher;
        String bookDescription = BookRepository.getRepository ().get(id).description;

        String bookInfo = "id: " + id.toString () + "\n" +
                "isbd: " + bookIsbn + "\n" +
                "title: " + bookTitle + "\n" +
                "author: " + bookAuthor + "\n" +
                "publisher: " + bookPublisher + "\n" +
                "description: " + bookDescription + "\n";

        return bookInfo;

    }

    @Override
    public String getBookInfoByISBN(String isbn) {
        return null;
    }

    @Override
    public String addBook(Book book) {

        Book newBook = bookCreation ( book );

        Response response = new Response ();
        if (BookRepository.getRepository ().get ( book.getId ()) != null ) {
            response.setMessage ( "Book already exists" );
            return response.getMessage ();
        }

        BookRepository.getRepository ().put(newBook.getId(), newBook);
        response.setMessage ( "Book added successfully" );
        return response.getMessage ();

    }

    @Override
    public String updateBookInfo(Book book) {

            Book newBook = bookCreation ( book );

            Response response = new Response ();
            if (BookRepository.getRepository ().get ( book.getId ()) == null ) {
                response.setMessage ( "Book does not exists" );
                return response.getMessage ();
            }

            BookRepository.getRepository ().put(newBook.getId(), newBook);
            response.setMessage ( "Book updated successfully" );
            return response.getMessage ();
    }

    @Override
    public String deleteBook(Integer id) {

        Response response = new Response ();
        if (BookRepository.getRepository ().get ( id ) == null) {
        return messageWo ( id );
        }


        BookRepository.getRepository ().remove ( id );
        response.setStatus ( true );
        response.setMessage ( "Book deleted successfully" );
        return response.getMessage ();
    }

    private Book bookCreation (Book book){
        Book newBook = new Book ();
        newBook.setId ( book.getId () );
        newBook.setIsbn (book.getIsbn ());
        newBook.setTitle ( book.getTitle () );
        newBook.setAuthor ( book.getAuthor () );
        newBook.setPublisher ( book.getPublisher () );
        newBook.setDescription ( book.getDescription () );

        return newBook;
    }

    private String messageWo (Integer id) {

        Response response = new Response ();
        response.setStatus ( false );
        response.setMessage ( "Book Does not Exist" );
        return response.getMessage ();

    }



}

