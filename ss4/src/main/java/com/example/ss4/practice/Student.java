package com.example.ss4.practice;


public class Student {
    private int id;
    private String name;
    private double score;
    private String address;

    public Student(int id, String name, double score, String address) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getScore() { return score; }
    public String getAddress() { return address; }
}
