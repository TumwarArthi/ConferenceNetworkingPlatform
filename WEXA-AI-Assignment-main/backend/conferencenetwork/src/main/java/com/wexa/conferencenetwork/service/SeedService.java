package com.wexa.conferencenetwork.service;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeedService {

    @Autowired
    private Driver driver;
    
    public String loadSeedData() {

        try (Session session = driver.session()) {

            // Skills
            session.run("""
                MERGE (:Skill {id:1,name:'Java'})
                MERGE (:Skill {id:2,name:'Spring Boot'})
                MERGE (:Skill {id:3,name:'React'})
                MERGE (:Skill {id:4,name:'AWS'})
                MERGE (:Skill {id:5,name:'SQL'})
                MERGE (:Skill {id:6,name:'Docker'})
                MERGE (:Skill {id:7,name:'Kubernetes'})
                MERGE (:Skill {id:8,name:'JavaScript'})
                MERGE (:Skill {id:9,name:'Python'})
                MERGE (:Skill {id:10,name:'AI/ML'})
                RETURN 1
            """).consume();

            // Topics
            session.run("""
                MERGE (:Topic {id:1,name:'Artificial Intelligence'})
                MERGE (:Topic {id:2,name:'Cloud Computing'})
                MERGE (:Topic {id:3,name:'Web Development'})
                MERGE (:Topic {id:4,name:'DevOps'})
                MERGE (:Topic {id:5,name:'Cyber Security'})
                MERGE (:Topic {id:6,name:'Data Engineering'})
                MERGE (:Topic {id:7,name:'Microservices'})
                MERGE (:Topic {id:8,name:'System Design'})
                RETURN 1
            """).consume();
            
            session.run("""
            	    MERGE (:Company {id:1,name:'Google'})
            	    MERGE (:Company {id:2,name:'Microsoft'})
            	    MERGE (:Company {id:3,name:'Amazon'})
            	    MERGE (:Company {id:4,name:'OpenAI'})
            	    MERGE (:Company {id:5,name:'Infosys'})
            	    MERGE (:Company {id:6,name:'TCS'})
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MERGE (:Booth {id:1,name:'G101'})
            	    MERGE (:Booth {id:2,name:'M201'})
            	    MERGE (:Booth {id:3,name:'A301'})
            	    MERGE (:Booth {id:4,name:'O401'})
            	    MERGE (:Booth {id:5,name:'I501'})
            	    MERGE (:Booth {id:6,name:'T601'})
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MATCH (c:Company {id:1}),(b:Booth {id:1})
            	    MERGE (c)-[:HAS_BOOTH]->(b)

            	    MATCH (c:Company {id:2}),(b:Booth {id:2})
            	    MERGE (c)-[:HAS_BOOTH]->(b)

            	    MATCH (c:Company {id:3}),(b:Booth {id:3})
            	    MERGE (c)-[:HAS_BOOTH]->(b)

            	    MATCH (c:Company {id:4}),(b:Booth {id:4})
            	    MERGE (c)-[:HAS_BOOTH]->(b)

            	    MATCH (c:Company {id:5}),(b:Booth {id:5})
            	    MERGE (c)-[:HAS_BOOTH]->(b)

            	    MATCH (c:Company {id:6}),(b:Booth {id:6})
            	    MERGE (c)-[:HAS_BOOTH]->(b)

            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MERGE (:Speaker {id:1,name:'James Gosling',designation:'Java Architect'})
            	    MERGE (:Speaker {id:2,name:'Rod Johnson',designation:'Spring Creator'})
            	    MERGE (:Speaker {id:3,name:'Guido van Rossum',designation:'Python Creator'})
            	    MERGE (:Speaker {id:4,name:'Brendan Eich',designation:'JavaScript Creator'})
            	    MERGE (:Speaker {id:5,name:'Linus Torvalds',designation:'Linux Creator'})
            	    MERGE (:Speaker {id:6,name:'Martin Fowler',designation:'Software Architect'})
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MERGE (:Session {id:1,title:'Modern Java',time:'10:00 AM'})
            	    MERGE (:Session {id:2,title:'Spring Boot Masterclass',time:'11:00 AM'})
            	    MERGE (:Session {id:3,title:'Cloud with AWS',time:'12:00 PM'})
            	    MERGE (:Session {id:4,title:'DevOps Pipeline',time:'2:00 PM'})
            	    MERGE (:Session {id:5,title:'AI in Software',time:'3:00 PM'})
            	    MERGE (:Session {id:6,title:'Microservices',time:'4:00 PM'})
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MATCH (sp:Speaker{id:1}),(se:Session{id:1}) MERGE (sp)-[:PRESENTS]->(se)
            	    MATCH (sp:Speaker{id:2}),(se:Session{id:2}) MERGE (sp)-[:PRESENTS]->(se)
            	    MATCH (sp:Speaker{id:3}),(se:Session{id:5}) MERGE (sp)-[:PRESENTS]->(se)
            	    MATCH (sp:Speaker{id:4}),(se:Session{id:6}) MERGE (sp)-[:PRESENTS]->(se)
            	    MATCH (sp:Speaker{id:5}),(se:Session{id:3}) MERGE (sp)-[:PRESENTS]->(se)
            	    MATCH (sp:Speaker{id:6}),(se:Session{id:4}) MERGE (sp)-[:PRESENTS]->(se)
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MATCH (s:Session{id:1}),(t:Topic{id:7}) MERGE (s)-[:COVERS]->(t)
            	    MATCH (s:Session{id:2}),(t:Topic{id:3}) MERGE (s)-[:COVERS]->(t)
            	    MATCH (s:Session{id:3}),(t:Topic{id:2}) MERGE (s)-[:COVERS]->(t)
            	    MATCH (s:Session{id:4}),(t:Topic{id:4}) MERGE (s)-[:COVERS]->(t)
            	    MATCH (s:Session{id:5}),(t:Topic{id:1}) MERGE (s)-[:COVERS]->(t)
            	    MATCH (s:Session{id:6}),(t:Topic{id:8}) MERGE (s)-[:COVERS]->(t)
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MERGE (:Attendee {id:1,name:'Rahul',email:'rahul@gmail.com',company:'Infosys'})
            	    MERGE (:Attendee {id:2,name:'Priya',email:'priya@gmail.com',company:'TCS'})
            	    MERGE (:Attendee {id:3,name:'Arjun',email:'arjun@gmail.com',company:'Google'})
            	    MERGE (:Attendee {id:4,name:'Sneha',email:'sneha@gmail.com',company:'Amazon'})
            	    MERGE (:Attendee {id:5,name:'Kiran',email:'kiran@gmail.com',company:'Microsoft'})
            	    MERGE (:Attendee {id:6,name:'Neha',email:'neha@gmail.com',company:'OpenAI'})
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MERGE (:Recruiter {id:1,name:'Anita'})
            	    MERGE (:Recruiter {id:2,name:'Vikram'})
            	    MERGE (:Recruiter {id:3,name:'Rohit'})
            	    MERGE (:Recruiter {id:4,name:'Pooja'})
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MATCH (r:Recruiter {id:1})
            	    MATCH (c:Company {id:1})
            	    MERGE (r)-[:WORKS_FOR]->(c)

            	    MATCH (r:Recruiter {id:2})
            	    MATCH (c:Company {id:2})
            	    MERGE (r)-[:WORKS_FOR]->(c)

            	    MATCH (r:Recruiter {id:3})
            	    MATCH (c:Company {id:3})
            	    MERGE (r)-[:WORKS_FOR]->(c)

            	    MATCH (r:Recruiter {id:4})
            	    MATCH (c:Company {id:4})
            	    MERGE (r)-[:WORKS_FOR]->(c)

            	    RETURN 1
            	""").consume();    
            session.run("""
            	    MATCH (a:Attendee{id:1}),(s:Skill{id:1}) MERGE (a)-[:HAS_SKILL]->(s)
            	    MATCH (a:Attendee{id:1}),(s:Skill{id:2}) MERGE (a)-[:HAS_SKILL]->(s)

            	    MATCH (a:Attendee{id:2}),(s:Skill{id:3}) MERGE (a)-[:HAS_SKILL]->(s)

            	    MATCH (a:Attendee{id:3}),(s:Skill{id:4}) MERGE (a)-[:HAS_SKILL]->(s)

            	    MATCH (a:Attendee{id:4}),(s:Skill{id:5}) MERGE (a)-[:HAS_SKILL]->(s)

            	    MATCH (a:Attendee{id:5}),(s:Skill{id:6}) MERGE (a)-[:HAS_SKILL]->(s)

            	    MATCH (a:Attendee{id:6}),(s:Skill{id:7}) MERGE (a)-[:HAS_SKILL]->(s)

            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MATCH (a:Attendee{id:1}),(t:Topic{id:3}) MERGE (a)-[:INTERESTED_IN]->(t)
            	    MATCH (a:Attendee{id:2}),(t:Topic{id:4}) MERGE (a)-[:INTERESTED_IN]->(t)
            	    MATCH (a:Attendee{id:3}),(t:Topic{id:2}) MERGE (a)-[:INTERESTED_IN]->(t)
            	    MATCH (a:Attendee{id:4}),(t:Topic{id:1}) MERGE (a)-[:INTERESTED_IN]->(t)
            	    MATCH (a:Attendee{id:5}),(t:Topic{id:7}) MERGE (a)-[:INTERESTED_IN]->(t)
            	    MATCH (a:Attendee{id:6}),(t:Topic{id:8}) MERGE (a)-[:INTERESTED_IN]->(t)
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MATCH (a:Attendee{id:1}),(s:Session{id:2}) MERGE (a)-[:ATTENDING]->(s)
            	    MATCH (a:Attendee{id:2}),(s:Session{id:4}) MERGE (a)-[:ATTENDING]->(s)
            	    MATCH (a:Attendee{id:3}),(s:Session{id:3}) MERGE (a)-[:ATTENDING]->(s)
            	    MATCH (a:Attendee{id:4}),(s:Session{id:5}) MERGE (a)-[:ATTENDING]->(s)
            	    MATCH (a:Attendee{id:5}),(s:Session{id:1}) MERGE (a)-[:ATTENDING]->(s)
            	    MATCH (a:Attendee{id:6}),(s:Session{id:6}) MERGE (a)-[:ATTENDING]->(s)
            	    RETURN 1
            	""").consume();
            
            session.run("""
            	    MATCH (r:Recruiter{id:1}),(s:Skill{id:1})
            	    MERGE (r)-[:HIRING_FOR]->(s)

            	    MATCH (r:Recruiter{id:1}),(s:Skill{id:2})
            	    MERGE (r)-[:HIRING_FOR]->(s)

            	    MATCH (r:Recruiter{id:2}),(s:Skill{id:4})
            	    MERGE (r)-[:HIRING_FOR]->(s)

            	    MATCH (r:Recruiter{id:3}),(s:Skill{id:5})
            	    MERGE (r)-[:HIRING_FOR]->(s)

            	    MATCH (r:Recruiter{id:4}),(s:Skill{id:3})
            	    MERGE (r)-[:HIRING_FOR]->(s)

            	    RETURN 1
            	""").consume();

            return "Seed Data Loaded Successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    
    
    
}