package com.wexa.conferencenetwork.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wexa.conferencenetwork.model.SessionRecommendation;
import com.wexa.conferencenetwork.model.RecruiterRecommendation;
import com.wexa.conferencenetwork.model.NetworkRecommendation;

@Repository
public class ConferenceRepository {

    @Autowired
    private Driver driver;

    public List<SessionRecommendation> getRecommendedSessions(int attendeeId) {

    	List<SessionRecommendation> sessions = new ArrayList<>();
    	
        try (Session session = driver.session()) {

            Result result = session.run("""
                    MATCH (a:Attendee {id:$id})
                    -[:INTERESTED_IN]->
                    (t:Topic)
                    <-[:COVERS]-
                    (s:Session)

                    RETURN DISTINCT s.title AS title,
            						t.name AS topic
                    """,
                    Map.of("id", attendeeId));

            while (result.hasNext()) {
                Record record = result.next();
                sessions.add(
                	    new SessionRecommendation(
                	        record.get("title").asString(),
                	        record.get("topic").asString()
                	    )
                	);
            }
        }

        return sessions;
    }
    
    public List<RecruiterRecommendation> getRecommendedRecruiters(int attendeeId) {

    	List<RecruiterRecommendation> recruiters = new ArrayList<>();
    	
        try (Session session = driver.session()) {

            Result result = session.run("""
                MATCH (a:Attendee {id:$id})-[:HAS_SKILL]->(s:Skill)
                <-[:HIRING_FOR]-
                (r:Recruiter)
                -[:WORKS_FOR]->
                (c:Company)

                RETURN DISTINCT r.name AS recruiter,
                                c.name AS company
                """,
                Map.of("id", attendeeId));

            while (result.hasNext()) {
                Record record = result.next();
                recruiters.add(
                	    new RecruiterRecommendation(
                	        record.get("recruiter").asString(),
                	        record.get("company").asString()
                	    )
                	);
            }
        }

        return recruiters;
    }
    
    public List<NetworkRecommendation> getRecommendedNetwork(int attendeeId) {

    	List<NetworkRecommendation> attendees = new ArrayList<>();

        try (Session session = driver.session()) {

        	Result result = session.run("""
        		    MATCH (a:Attendee {id:$id})-[:HAS_SKILL]->(s:Skill)
        			<-[:HAS_SKILL]-
        			(other:Attendee)

        			WHERE other.id <> $id

        			RETURN DISTINCT other.name AS attendee 
           		    """,
        		    Map.of("id", attendeeId));
        	
            while (result.hasNext()) {
                Record record = result.next();
                attendees.add(
                	    new NetworkRecommendation(
                	        record.get("attendee").asString()
                	    )
                	);
            }

        }

        return attendees;
    }
}