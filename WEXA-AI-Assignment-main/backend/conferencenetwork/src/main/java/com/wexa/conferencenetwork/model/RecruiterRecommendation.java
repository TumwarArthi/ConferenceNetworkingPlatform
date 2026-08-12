package com.wexa.conferencenetwork.model;

public class RecruiterRecommendation {

    private String recruiterName;
    private String company;

    public RecruiterRecommendation(String recruiterName, String company) {
        this.recruiterName = recruiterName;
        this.company = company;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public String getCompany() {
        return company;
    }
}