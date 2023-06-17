import React from "react";
import { useSelector } from "react-redux";
import "./styles/LandingPage.css";
import Navbar from "./components/Navbar";
import TrendingPet from "./components/TrendingPet";
import requests from "./adapter/RequestEndpoints";
import CarouselSlider from "./components/CarouselSlider";
import FlippableCard from "./components/FlippableCards";

export const LandingPage = ({isLogin, setIsLogin}) => {
  const pets = useSelector((state) => state.pet.data);

  return (
    <div className="home">
      <Navbar isLandingPage={true} setIsLogin={setIsLogin} isLogin={isLogin}/>
      <CarouselSlider />
      <TrendingPet title="TRENDING-PET" />
      <FlippableCard  dataList={pets} btnAction={"Visit Store"}/>
    </div>
  );
};
