import React, { useEffect, useState } from "react";
import { getData } from "../adapter/Axio";
import "../styles/TrendingPet.css";

const TrendingPet = ({ title }) => {
  const [pets, setPets] = useState([]);
  

  useEffect(() => {
    const fetchData = async () => {
      try {
        const request = await getData("/germanshepherd/images");
        setPets(request.data.message);
        return request;
        
      } catch (error) {
        console.error(error);
      }
    };

    fetchData();
  }, []);

  return (
    <div className="TrendingPet">
    {pets? 
      <div>
        <h2>{title}</h2>
        <div className="row__posters">
          {pets?.map((imageUrl, i) => (
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
