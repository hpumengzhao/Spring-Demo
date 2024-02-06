package org.codancer.dimap;

import java.util.Map;

public class Student {

    private int sid;
    private String sname;

    private Map<String, Teacher> teacherMap;
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public void run() {
        System.out.println(sid + " " + sname);
        System.out.println(teacherMap);
    }
}
