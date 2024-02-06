package org.codancer;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



public class School {
    private String name;

    private List<Teacher> teacherList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public School(String name, List<Teacher> teacherList) {
        this.name = name;
        this.teacherList = teacherList;
    }

    public School() {

    }
}
