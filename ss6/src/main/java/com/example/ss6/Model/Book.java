package com.example.ss6.Model;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class Book {
    private String bookCode;
    private String title;
    private String author;
    private String category;
    private int quantity;

    public Book() {
    }

    public Book(String bookCode, String title, String author, String category, int quantity) {
        this.bookCode = bookCode;
        this.title    = title;
        this.author   = author;
        this.category = category;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
