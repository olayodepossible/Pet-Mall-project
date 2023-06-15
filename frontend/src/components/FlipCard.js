import "../styles/Card.css";
import { useNavigate } from "react-router-dom";

const FlipCard = ({ pet, btnAction, addToCart, isStorePage, isLogin}) => {
  const history = useNavigate();

  const handleAddToCart = (e) => {
    isLogin ? addToCart(pet) : history("/pet-mal/login")
  }



  return (
    <div className="card__container">
      <div className="cards">
        <div className="card__front">{<img className="card__img" src={pet.imageUrl} alt="" />}</div>
        <div className="card__back">

          {isStorePage && <div className="items">
            <img src={pet.imageUrl}></img>
            <div className="info">
              <h3>{pet.name?.length ? pet.name.substr(0, 12 - 1) + "..." : pet.name}</h3>
              <span>£ {pet.price}</span>
              <button onClick={handleAddToCart}
                disabled={pet.inCart}
                className={pet.inCart ? "button-disabled" : ""}>
                {pet.inCart ? "Item in a cart" : "Add to cart"}
              </button>
            </div>
          </div>}


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
            {
              !isStorePage && <p>
              <span>
                Price: <span>&#36;</span>
              </span>
              <span>{pet.price}</span>
            </p>
            }
            

          </div>
          {!isStorePage && <button  onClick={(e) => { e.preventDefault(); return  history(`/pet-mall/store/${pet.ownerId}`) }} className="card__button">{btnAction}</button> }
          
        </div>
      </div>
    </div>
  );
};

export default FlipCard;