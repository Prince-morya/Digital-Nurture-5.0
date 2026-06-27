package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println("=== Library Management System ===");
        System.out.println("Spring Context + AOP + WebMVC dependencies loaded.");
        System.out.println("Compiler: Java 1.8\n");

        bookService.listBooks().forEach(b -> System.out.println("  - " + b));

        ((ClassPathXmlApplicationContext) context).close();
    }
}
