import React from "react";
import "../styles/vani.css";
const VaniCard = ({ item }) => {
  return (
    <div className="card__container">
      <div className="cards">
        <div className="card__front">Front - {item}</div>
        <div className="card__back">Back - {item}</div>
      </div>
    </div>
  );
};

export default VaniCard;
