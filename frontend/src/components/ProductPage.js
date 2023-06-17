import React from "react";
import { useSelector } from "react-redux";
import "../styles/LandingPage.css";
import Navbar from "./Navbar";
import TrendingPet from "./TrendingPet";
import CarouselSlider from "./CarouselSlider";
import FlippableCard from "./FlippableCards";

export const ProductPage = ({isLogin, setIsLogin}) => {
  const pets = useSelector((state) => state.pet.data);
  const trendingPet = useSelector((state) => state.trendingPet.data);
  const sliderData = useSelector((state) => state.sliderData.data)

  return (
    <div className="home">
      <Navbar isLandingPage={true} setIsLogin={setIsLogin} isLogin={isLogin}/>
      <CarouselSlider sliderData={sliderData}/>
      <TrendingPet trendingPets={trendingPet} title="TRENDING-PET" />
      <FlippableCard  dataList={pets} btnAction={"Visit Store"}/>
    </div>
  );
};
