package edu.charusat.tasks;

import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String title;
    public Task(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be blank.");
        this.title = title.trim();
    }
    public String getTitle() { return title; }
    @Override public String toString() { return title; }
}
