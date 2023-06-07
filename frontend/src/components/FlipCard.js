import "../styles/Card.css";
import { imageBaseUrl } from "../environment";

const FlipCard = ({ pet, index }) => {
  return (
    <div className="card__container">
      {/* {`${imageBaseUrl}${isLargeRow ? movie.poster_path : movie.backdrop_path}`} */}
      <div className="cards">
        <div className="card__front">{<img className="card__img" src={pet} alt="Pet-image" />}</div>
        <div className="card__back">Back - {index}</div>
      </div>
    </div>
  );
};

export default FlipCard;
