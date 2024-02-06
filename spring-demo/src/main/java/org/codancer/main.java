package org.codancer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beanSchool.xml");
        School school = (School) context.getBean("school");
        System.out.println(school.getName());

        for (Teacher teacher: school.getTeacherList()) {
            System.out.println(teacher.getName());
        }
    }
}
