# 🚀 Conference Networking Platform

A full-stack application designed to help conference attendees discover **relevant sessions, career opportunities, and people to connect with**.

The project combines **React, Spring Boot, and CognoDB** to build recommendations using relationships between attendees, skills, topics, recruiters, sessions, and companies.

## 📌 What This Project Does

The platform takes an attendee's skills and interests and uses graph relationships to find useful recommendations.

### 🎤 Sessions

Shows conference sessions related to the topics an attendee is interested in.

```text
Attendee → Interest → Topic → Session
```

### 💼 Recruiters

Finds recruiters and companies looking for skills that match the attendee.

```text
Attendee → Skill → Recruiter → Company
```

### 🤝 Networking

Finds other attendees who have similar skills and can be potential networking connections.

```text
Attendee → Skill ← Attendee
```

## 🛠 Technologies

| Area            | Technology         |
| --------------- | ------------------ |
| Frontend        | React, Vite, Axios |
| Backend         | Java, Spring Boot  |
| Build Tool      | Maven              |
| Database        | CognoDB            |
| Query Language  | openCypher         |
| Database Driver | Neo4j Java Driver  |

## 🏗 Application Flow

```text
       React UI
          │
          ▼
      REST APIs
          │
          ▼
    Spring Boot
          │
          ▼
 Neo4j Java Driver
          │
          ▼
       CognoDB
```

## 📊 Graph Structure

The application works with the following main nodes:

* Attendee
* Skill
* Topic
* Session
* Recruiter
* Company

Some of the important connections are:

```text
Attendee ── HAS_SKILL ──> Skill

Attendee ── INTERESTED_IN ──> Topic

Session ── COVERS ──> Topic

Recruiter ── HIRING_FOR ──> Skill

Recruiter ── WORKS_FOR ──> Company
```

These relationships are used to generate recommendations.

## 🔗 Available APIs

### Initialize Sample Data

```http
GET /seed
```

### Session Suggestions

```http
GET /recommend/sessions/{attendeeId}
```

Example:

```text
/recommend/sessions/1
```

### Recruiter Suggestions

```http
GET /recommend/recruiters/{attendeeId}
```

Example:

```text
/recommend/recruiters/1
```

### Networking Suggestions

```http
GET /recommend/network/{attendeeId}
```

Example:

```text
/recommend/network/1
```

## 📁 Folder Organization

```text
ConferenceNetworkingPlatform
│
├── backend
│   ├── src
│   └── pom.xml
│
├── frontend
│   ├── src
│   └── package.json
│
├── screenshots
│
└── README.md
```

## ⚙️ Configuration

The backend requires CognoDB connection details.

Configure:

```text
COGNODB_URI
COGNODB_USERNAME
COGNODB_PASSWORD
```

Keep credentials in environment variables instead of committing them to GitHub.

## ▶️ Start the Backend

Open a terminal in the backend directory:

```bash
cd backend
mvn spring-boot:run
```

Backend URL:

```text
http://localhost:8082
```

## ▶️ Start the Frontend

Open another terminal:

```bash
cd frontend
npm install
npm run dev
```

Frontend URL:

```text
http://localhost:5173
```

## 💡 Why Use a Graph Database?

The recommendation features depend on connections between different entities.

For example, an attendee's skill can lead to a recruiter, which can lead to a company. A graph database makes these relationships straightforward to represent and traverse.

```text
Attendee
   ↓
Skill
   ↓
Recruiter
   ↓
Company
```

The same approach can be used to discover sessions and potential networking connections.

## 🔮 Possible Improvements

* Authentication and user profiles
* Better recommendation ranking
* Graph visualization
* Conference schedule management
* Attendee messaging
* Personalized user dashboard

## 👩‍💻 Project

**Conference Networking Platform**

A graph-based recommendation application built using **Spring Boot, React, and CognoDB** as part of a WEXA AI assignment.
