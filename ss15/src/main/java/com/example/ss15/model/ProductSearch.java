package com.example.ss15.model;


public class ProductSearch {
    private String code;
    private String name;

    public ProductSearch() {}
    public ProductSearch(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

