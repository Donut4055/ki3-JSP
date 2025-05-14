package com.example.ss8.Model;


public class ProductC {
    private String name;
    private String color;
    private String size;


    public ProductC() {
    }
    public ProductC(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

}
