package org.codancer.di;

import java.util.List;

public class Department {
    private String name;

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void info() {
        System.out.println("dep name is " + name);
        if (employeeList == null) {
            return ;
        }
        for (Employee employee: employeeList) {
            System.out.println(employee.getName());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
