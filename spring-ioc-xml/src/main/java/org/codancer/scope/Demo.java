package org.codancer.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    private int age;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanscope.xml");

        Demo demo = (Demo) context.getBean("demo");

        System.out.println(demo);

        Demo demo1 = (Demo) context.getBean("demo");

        System.out.println(demo1);
    }
}
