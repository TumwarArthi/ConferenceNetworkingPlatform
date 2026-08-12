package com.wexa.conferencenetwork.model;

public class SessionRecommendation {

    private String sessionName;
    private String topic;

    public SessionRecommendation(String sessionName, String topic) {
        this.sessionName = sessionName;
        this.topic = topic;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getTopic() {
        return topic;
    }
}