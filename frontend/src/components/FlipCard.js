import "../styles/Card.css";
import { useNavigate } from "react-router-dom";

const FlipCard = ({ pet, btnAction }) => {
  const history = useNavigate();

  return (
    <div className="card__container">
      <div className="cards">
        <div className="card__front">{<img className="card__img" src={pet.imageUrl} alt="" />}</div>
        <div className="card__back">
          <div className="card__pet__details">
            <p>
              <span>Name: </span>
              <span>{pet.name}</span>
            </p>
            <p>
              <span>Gender: </span>
              <span>{pet.gender}</span>
            </p>
            <p>
              <span>Age: </span>
              <span>{pet.age}</span>
            </p>
            <p>
              <span>Description: </span>
              <span>{pet.description}</span>
            </p>
            <p>
              <span>Breed: </span>
              <span>{pet.breed}</span>
            </p>
            <p>
              <span>
                Price: <span>&#36;</span>
              </span>
              <span>{pet.price}</span>
            </p>

          </div>
          <button onClick={() => history(`pet-mall/store/${pet.ownerId}`)} className="card__button">{btnAction}</button>
        </div>
      </div>
    </div>
  );
};

export default FlipCard;
