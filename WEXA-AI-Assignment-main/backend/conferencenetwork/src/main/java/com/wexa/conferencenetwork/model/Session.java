package com.wexa.conferencenetwork.model;

public class Session {

    private int id;
    private String title;
    private String time;

    public Session() {
    }

    public Session(int id, String title, String time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}