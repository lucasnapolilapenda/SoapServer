package com.lucas.soap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


class BookRepository {

    private static Map <Integer,Book> repository = new ConcurrentHashMap <> ();

    public static Map <Integer, Book> getRepository() {
        return repository;
    }

    public static void setRepository(Map <Integer, Book> repository) {
        BookRepository.repository = repository;
    }


}
