package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Clean Code");
        books.add("The Pragmatic Programmer");
        books.add("Effective Java");
    }

    public List<String> getAllBooks() {
        return books;
    }

    public void addBook(String title) {
        books.add(title);
        System.out.println("Added: " + title);
    }
}
