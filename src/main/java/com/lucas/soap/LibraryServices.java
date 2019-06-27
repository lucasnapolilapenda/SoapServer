package com.lucas.soap;
/** Library Solos Rest.
 * @author Lucas Napoli
 * @author https://github.com/lucasnapolilapenda/SoapServer
 * @version 1.1
 * @since 1.0
 */



import javax.jws.WebService;
import java.util.LinkedList;
import java.util.Set;

/**
 * Represents all services implementation
 */
@WebService(endpointInterface = "com.lucas.soap.LibraryServices")

public class LibraryServices implements Interface {

    /**
     *
     * @return
     *     returns java.lang.String
     *     List of books
     */
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

    /**
     *
     * @return
     *     returns java.lang.String
     *     Info by ID
     * @param id is an integer to find a book
     *
     */
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

    /**
     *
     * @return
     *     returns java.lang.String
     *     Info by isbn
     * @param isbn is String with the properties
     */
    @Override
    public String getBookInfoByISBN(String isbn) {
        String bookInfo = "";

        Set <Integer> ids = BookRepository.getRepository().keySet ();
        LinkedList <Book> bookList = new LinkedList <> (  );

        for(Integer id : ids) {
            Book book = new Book ();
            book.setId (BookRepository.getRepository ().get ( id ).getId ());
            book.setIsbn (BookRepository.getRepository ().get ( id ).getIsbn ());
            book.setTitle (BookRepository.getRepository ().get ( id ).getTitle ());
            book.setAuthor (BookRepository.getRepository ().get ( id ).getAuthor ());
            book.setPublisher (BookRepository.getRepository ().get ( id ).getPublisher ());
            book.setDescription (BookRepository.getRepository ().get ( id ).getDescription ());
            bookList.add ( book );
        }
            for (Book book : bookList) {
            if (book.getIsbn ().equals ( isbn )) {
                bookInfo = "id: " + book.getId ( ) + "\n" +
                        "isbd: " + book.getIsbn ( ) + "\n" +
                        "title: " + book.getTitle ( ) + "\n" +
                        "author: " + book.getAuthor ( ) + "\n" +
                        "publisher: " + book.getPublisher ( ) + "\n" +
                        "description: " + book.getDescription ( ) + "\n";
                return bookInfo;
            }
        }

        return "Book does not exist";
    }

    /**
     *
     * @return
     *     returns java.lang.String
     *     Add Book
     * @param book is book as object with the properties
     */
    @Override
    public String addBook(Book book) {

        Book newBook = bookCreation ( book );

        Response response = new Response ();
        if (BookRepository.getRepository ().get ( book.getId ()) != null ) {
            response.setMessage ( "Book already exists, please use a different Id value" );
            return response.getMessage ();
        }

        BookRepository.getRepository ().put(newBook.getId(), newBook);
        response.setMessage ( "Book added successfully" );
        return response.getMessage ();

    }

    /**
     *
     * @return
     *     returns java.lang.String
     *     Update Book
     * @param book is book as object with the properties
     */
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


    /**
     *
     * @return
     *     returns java.lang.String
     *     Delete Book
     * @param id is an integer to find a book
     */
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

    /**
     *
     * @return
     *     returns java.lang.String
     *     Book object creation
     * @param book
     */

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

    /**
     *
     * @return
     *     returns java.lang.String
     *     Message with out book
     * @param id is book as object with the properties
     */

    private String messageWo (Integer id) {

        Response response = new Response ();
        response.setStatus ( false );
        response.setMessage ( "Book Does not Exist" );
        return response.getMessage ();
    }
}

