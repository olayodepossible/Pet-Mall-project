import { useSelector } from "react-redux";
import "../styles/flippable-card.css";
import FlipCard from "./FlipCard";

function FlippableCards() {
  const pets = useSelector((state) => state.pet.data);

  return (
    <div className="flippable-card-container">
      {pets.map((item, i) => (
        <FlipCard key={i} pet={item} index={i} />
      ))}
    </div>
  );
}

export default FlippableCards;
