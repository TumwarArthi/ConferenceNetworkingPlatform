package com.wexa.conferencenetwork.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wexa.conferencenetwork.model.SessionRecommendation;
import com.wexa.conferencenetwork.model.RecruiterRecommendation;
import com.wexa.conferencenetwork.model.NetworkRecommendation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wexa.conferencenetwork.service.ConferenceService;
import com.wexa.conferencenetwork.service.SeedService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ConferenceController {
	
    @Autowired
    private SeedService seedService;

    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/seed")
    public String seedDatabase() {
        return seedService.loadSeedData();
    }

    @GetMapping("/recommend/sessions/{id}")
    public List<SessionRecommendation> recommendSessions(@PathVariable int id) {
        return conferenceService.recommendSessions(id);
    }
    
    @GetMapping("/recommend/recruiters/{id}")
    public List<RecruiterRecommendation> recommendRecruiters(@PathVariable int id) {
        return conferenceService.recommendRecruiters(id);
    }
    @GetMapping("/recommend/network/{id}")
    public List<NetworkRecommendation> recommendNetwork(@PathVariable int id) {
        return conferenceService.recommendNetwork(id);
    }

}