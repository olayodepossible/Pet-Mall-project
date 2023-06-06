import "../styles/Card.css";
import { imageBaseUrl } from "../environment";

const FlipCard = ({ movie, isLargeRow = false }) => {
  return (
    <div className="card__container">
      <div className="cards">
        <div className="card__front">
          {
            <img
              className={`row__poster ${isLargeRow && "row__posterLarge"}`}
              key={movie.id}
              src={`${imageBaseUrl}${isLargeRow ? movie.poster_path : movie.backdrop_path}`}
              alt={movie.name}
            />
          }
        </div>
        <div className="card__back">Back - {movie.name}</div>
      </div>
    </div>
  );
};

export default FlipCard;
