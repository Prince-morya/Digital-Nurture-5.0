package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("Spring context loaded successfully.");

        BookService bookService = (BookService) context.getBean("bookService");
        bookService.displayInfo();

        BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
        System.out.println("Books in repository:");
        bookRepository.getAllBooks().forEach(book -> System.out.println("  - " + book));

        ((ClassPathXmlApplicationContext) context).close();
    }
}
