import { useState } from "react";
import { useSelector } from "react-redux";
import "../styles/flippable-card.css";
import FlipCard from "./FlipCard";

function FlippableCards() {
  const movies = useSelector((state) => state.movie.data);
  const [showFront, setShowFront] = useState(true);
  const [activeCard, setActiveCard] = useState(null);
  const handleCardClick = (id) => {
    setActiveCard(activeCard === id ? null : id);
  };

  return (
    <div className="flippable-card-container">
      {movies.map((item, i) => (
        <FlipCard key={item.id} movie={item} />
      ))}
    </div>
  );
}

export default FlippableCards;
