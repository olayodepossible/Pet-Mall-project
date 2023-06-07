import "../styles/Card.css";
import { imageBaseUrl } from "../environment";

const FlipCard = ({ movie }) => {
  return (
    <div className="card__container">
      {/* {`${imageBaseUrl}${isLargeRow ? movie.poster_path : movie.backdrop_path}`} */}
      <div className="cards">
        <div className="card__front">
          {<img className="card__img" key={movie.id} src={`${imageBaseUrl}${movie.backdrop_path}`} alt={movie.name} />}
        </div>
        <div className="card__back">Back - {movie.name}</div>
      </div>
    </div>
  );
};

export default FlipCard;
