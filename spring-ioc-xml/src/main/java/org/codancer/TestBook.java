package org.codancer;

import org.codancer.bean.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDI.xml");

        Book book = (Book) context.getBean("book", Book.class);

        System.out.println(book.getAuthor() + " " + book.getBname());

        Book book2 = (Book) context.getBean("book2", Book.class);

        System.out.println(book2.getAuthor() + " " + book2.getBname());
    }
}
