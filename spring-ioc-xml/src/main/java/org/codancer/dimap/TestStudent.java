package org.codancer.dimap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDImap.xml");

        Student student = (Student) context.getBean("stu");

        System.out.println(student.getTeacherMap().get("10010"));
    }
}
