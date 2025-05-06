package com.example.ss1.bt8;

public class Todo {
    private String description;
    private boolean completed;

    public Todo(String description) {
        this.description = description;
        this.completed  = false;
    }

    public String getDescription() {
        return description;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
