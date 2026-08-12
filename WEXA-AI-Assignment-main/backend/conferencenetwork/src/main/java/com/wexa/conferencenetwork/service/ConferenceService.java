package com.wexa.conferencenetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wexa.conferencenetwork.model.SessionRecommendation;
import com.wexa.conferencenetwork.model.RecruiterRecommendation;
import com.wexa.conferencenetwork.model.NetworkRecommendation;

import com.wexa.conferencenetwork.repository.ConferenceRepository;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository repository;


    public List<SessionRecommendation> recommendSessions(int attendeeId) {
        return repository.getRecommendedSessions(attendeeId);
    }


    public List<RecruiterRecommendation> recommendRecruiters(int attendeeId) { 
        return repository.getRecommendedRecruiters(attendeeId);
    }
    


    public List<NetworkRecommendation> recommendNetwork(int attendeeId) {
        return repository.getRecommendedNetwork(attendeeId);
    }
}