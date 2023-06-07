import React, { useEffect, useState } from "react";
import { getData } from "../adapter/Axio";
import "../styles/TrendingPet.css";
import { useDispatch } from "react-redux";
import { petData } from "../features/pet/petSlice";

const TrendingPet = ({ title, fetchUrl }) => {
  const [pets, setPets] = useState([]);
  const dispatch = useDispatch();

  useEffect(() => {
    const fetchData = async () => {
      console.log("fetchUrl", fetchUrl);
      const request = await getData(fetchUrl);
      dispatch(petData(request.data.message));
      setPets(request.data.message);
      return request;
    };

    fetchData();
  }, [fetchUrl]);

  return (
    <div className="TrendingPet">
      <h2>{title}</h2>
      <div className="row__posters">
        {pets?.map((imageUrl, i) => (
          <img className="row__poster row__posterLarge" key={i} src={imageUrl} alt={title} />
        ))}
      </div>
    </div>
  );
};

export default TrendingPet;
