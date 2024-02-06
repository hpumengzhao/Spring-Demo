package org.codancer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // get by id
        User user1 = (User)context.getBean("user");
        user1.run();

        // get by class
        User user2 = context.getBean(User.class);
        user2.run();

        // get by id & class
        User user3 = context.getBean("user", User.class);
        user3.run();
    }
}
