package com.example.ss8.Model;



public class Feedback {
    private String name;
    private String phone;
    private String address;
    private String content;

    public Feedback() {
    }
    public Feedback(String name, String phone, String address, String content) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.content = content;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


}
