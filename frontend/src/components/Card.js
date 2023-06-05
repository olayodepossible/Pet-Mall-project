import React from "react";

const Card = ({ num }) => {
  return <div style={styles.card}>Cards - {num}</div>;
};

export default Card;

const styles = {
  card: {
    width: "350px",
    height: "200px",
    backgroundColor: "blue",
    border: "2px solid black",
    fontSize: "2.5em",
    color: "white",
  },
};
