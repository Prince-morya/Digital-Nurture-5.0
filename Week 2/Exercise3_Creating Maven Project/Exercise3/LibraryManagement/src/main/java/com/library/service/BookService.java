package com.library.service;

import com.library.repository.BookRepository;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<String> listBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(String title) {
        bookRepository.addBook(title);
    }
}
