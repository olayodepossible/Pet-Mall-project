import React from "react";
import "./styles/LandingPage.css";
import Navbar from "./components/Navbar";
import MovieRow from "./components/MovieRow";
import requests from "./adapter/RequestEndpoints";
import CarouselSlider from "./components/CarouselSlider";
import FlippableCard from "./components/FlippableCard";

export const LandingPage = () => {
  return (
    <div className="home">
      <Navbar />
      <CarouselSlider/>
      <MovieRow title="NETFLIX ORIGINALS" fetchUrl={requests.fetchNetflixOriginals} isLargeRow={true} />
      <FlippableCard/>
    </div>
  );
};
