import "./card.css";
import "./flip-transition.css";

const FlipCard = ({onClick})  => {
  return (
    <div className="card" onClick={onClick}>
      <div className="card-back">Back</div>
      <div className="card-front">Front</div>
    </div>
  );
}

export default FlipCard;