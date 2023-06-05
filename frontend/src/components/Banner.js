import React, { useEffect, useState } from "react";
import { getData, getPetMallData } from "../adapter/Axio";
import requests from "../adapter/RequestEndpoints";
import "../styles/Banner.css";

const Banner = () => {
  const [movie, setMovie] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const req = await getData(requests.fetchNetflixOriginals);
      // const pet = await getPetMallData("/users/");
      // console.log("PET ==> ", pet);
      setMovie(req.data.results[Math.floor(Math.random() * req.data.results.length - 1)]);
      return requests;
    };
    fetchData();
  }, []);

  const truncateString = (string, num) => (string?.length ? string.substr(0, num - 1) + "..." : string);

  return (
    <header
      className="banner"
      style={{
        backgroundSize: "cover",
        backgroundImage: `url("https://image.tmdb.org/t/p/original/${movie?.backdrop_path}")`,
        backgroundPosition: "center center",
      }}
    >
      <div className="banner__contents">
        <h1 className="banner__title">{movie?.title || movie?.name || movie?.original_name}</h1>
        <div className="banner__buttons">
          <button className="banner__button">Play</button>
          <button className="banner__button">My List</button>
        </div>
        <h1 className="banner__description">{truncateString(movie?.overview, 150)}</h1>
      </div>
      <div className="banner--fadeBottom" />
    </header>
  );
};

export default Banner;
