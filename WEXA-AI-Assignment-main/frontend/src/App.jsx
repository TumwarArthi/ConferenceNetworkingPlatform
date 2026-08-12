import { useState } from "react";
import axios from "axios";
import "./App.css";

function App() {

  const [id, setId] = useState("");
  const [result, setResult] = useState([]);
  const [title, setTitle] = useState("");

  const getSessions = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8082/recommend/sessions/${id}`
      );

      setResult(response.data);
      setTitle("🎤 Recommended Sessions");

    } catch (error) {
      alert("Error connecting to backend");
    }
  };


  const getRecruiters = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8082/recommend/recruiters/${id}`
      );

      setResult(response.data);
      setTitle("💼 Recommended Recruiters");

    } catch (error) {
      alert("Error connecting to backend");
    }
  };


  const getNetwork = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8082/recommend/network/${id}`
      );

      setResult(response.data);
      setTitle("🤝 Recommended Network");

    } catch (error) {
      alert("Error connecting to backend");
    }
  };


  return (

    <div className="container">

      <h1>🚀 Conference Networking Platform</h1>

      <p className="subtitle">
        AI powered recommendations using Graph Database
      </p>


      <input
        type="number"
        placeholder="Enter Attendee ID"
        value={id}
        onChange={(e)=>setId(e.target.value)}
      />


      <div className="buttons">

        <button onClick={getSessions}>
          Sessions
        </button>

        <button onClick={getRecruiters}>
          Recruiters
        </button>

        <button onClick={getNetwork}>
          Network
        </button>

      </div>



      <div className="result">

        <h2>{title}</h2>


        <div className="cards">

      {
        result.length === 0 ? (
    <p>No recommendations found</p>
  ) : (
  result.map((item,index)=>(

    <div className="card" key={index}>

      {title.includes("Sessions") && (
        <>
          <h3>🎤 {item.sessionName}</h3>
          <p>Topic: {item.topic}</p>
        </>
      )}


      {title.includes("Recruiters") && (
        <>
          <h3>💼 {item.recruiterName}</h3>
          <p>Company: {item.company}</p>
        </>
      )}


      {title.includes("Network") && (
        <>
          <h3>🤝 {item.name}</h3>
          <p>Recommended Connection</p>
        </>
      )}

    </div>

  ))
  )
}

</div>
      </div>


    <div className="info-section">

  <h2>Powered by CognoDB Graph Database</h2>

  <p>
    This platform uses graph relationships to provide intelligent
    recommendations.
  </p>

  <div className="graph-box">

    <p>👤 Attendee</p>
    <p>⬇ HAS_SKILL</p>
    <p>💡 Skill</p>
    <p>⬇ INTERESTED_IN</p>
    <p>🎤 Session</p>

  </div>

</div>

    </div>

  );
}

export default App;