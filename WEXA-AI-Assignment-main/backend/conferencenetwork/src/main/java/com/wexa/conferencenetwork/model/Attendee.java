package com.wexa.conferencenetwork.model;

public class Attendee {

    private int id;
    private String name;
    private String email;
    private String company;

    public Attendee() {
    }

    public Attendee(int id, String name, String email, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}