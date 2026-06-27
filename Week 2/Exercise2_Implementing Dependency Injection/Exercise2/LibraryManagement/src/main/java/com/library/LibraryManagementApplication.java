package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("=== Current Books ===");
        bookService.listBooks().forEach(b -> System.out.println("  - " + b));

        bookService.addBook("Head First Design Patterns");

        System.out.println("\n=== After Adding New Book ===");
        bookService.listBooks().forEach(b -> System.out.println("  - " + b));

        ((ClassPathXmlApplicationContext) context).close();
    }
}
