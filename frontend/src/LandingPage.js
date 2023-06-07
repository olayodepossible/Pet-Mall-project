import React from "react";
import "./styles/LandingPage.css";
import Navbar from "./components/Navbar";
import TrendingPet from "./components/TrendingPet";
import requests from "./adapter/RequestEndpoints";
import CarouselSlider from "./components/CarouselSlider";
import FlippableCard from "./components/FlippableCards";

export const LandingPage = () => {
  return (
    <div className="home">
      <Navbar />
      <CarouselSlider />
      <TrendingPet title="TRENDING-PET" fetchUrl={requests.fetchTrendingPet} />
      <FlippableCard fetchUrl={requests.fetchNetflixOriginals} />
    </div>
  );
};
