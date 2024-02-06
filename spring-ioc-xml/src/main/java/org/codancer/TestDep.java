package org.codancer;

import org.codancer.di.Department;
import org.codancer.di.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDep {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDIObj.xml");

        Department  department = (Department) context.getBean("dep");
        department.info();

        Employee employee = (Employee) context.getBean("emp");
        System.out.println(employee.getAge());

        Employee employee1 = (Employee) context.getBean("emp2");
        System.out.println(employee1.getAge());

        Employee employee2 = (Employee) context.getBean("emp3");
        employee2.getDepartment().info();


        ApplicationContext context1 = new ClassPathXmlApplicationContext("beanDIArray.xml");
        Employee employee3 = (Employee) context1.getBean("emp");
        System.out.println(employee3);

        ApplicationContext context2 = new ClassPathXmlApplicationContext("beanDIList.xml");
        Department department1 = (Department) context2.getBean("dep");
        department1.info();
    }
}
