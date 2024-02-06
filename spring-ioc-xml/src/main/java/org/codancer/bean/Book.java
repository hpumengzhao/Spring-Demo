package org.codancer.bean;

public class Book {

    private String author;
    private String bname;


    public Book() {

    }
    public Book(String author, String bname) {
        this.author = author;
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
