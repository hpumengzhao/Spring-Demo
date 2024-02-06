package org.codancer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Springi18n {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objects = new Object[0];
        System.out.println(context.getMessage("test", objects, Locale.ENGLISH));
    }
}
