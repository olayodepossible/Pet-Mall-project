import React from "react";
import "../styles/TrendingPet.css";

const TrendingPet = ({ title, trendingPets }) => {
  
  return (
    <div className="trending__pet">
    {trendingPets? 
      <div>
        <h2>{title}</h2>
        <div className="row__posters">
          {trendingPets?.map((imageUrl, i) => (
            <img className="row__poster row__posterLarge" key={i} src={imageUrl} alt={title} />
          ))}
        </div>
      </div>
      :
      <h2>{title} loading...</h2>
      }
    </div>
  );
};

export default TrendingPet;
