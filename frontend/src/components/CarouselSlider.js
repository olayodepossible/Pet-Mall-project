import React, { useEffect, useState } from "react";
import { Carousel } from "react-responsive-carousel";
import { getData, getPetMallData } from "../adapter/Axio";
import { useDispatch } from "react-redux";
import { petData } from "../features/pet/petSlice";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import requests from "../adapter/RequestEndpoints";

const CarouselSlider = () => {
  const [petImages, setPetImages] = useState([]);
  const dispatch = useDispatch();

  useEffect(() => {
    const fetchData = async () => {

      try {
        const req = await getData("/bulldog/images");
        const petResp = await getPetMallData("/pets/store");
        dispatch(petData(petResp.data));
        const pet = req.data.message.slice(0, 11);
        setPetImages([...pet]);

        return req;
        
      } catch (error) {
        console.error('Error:', error);
        return;
      }
      
    };
    fetchData();
  }, []);

  return (
    <>
    {
      petImages.length !== 0 ? 
      <Carousel autoPlay infiniteLoop={true}>
      {petImages?.map((imageUrl, i) => (
        <div style={styles.carosel_container} key={i}>
          <img style={styles.carosel__image} src={imageUrl} alt="pet" />
        </div>

      )) }
      </Carousel>
      : <div style={styles.carosel_container}>
     
        <p style={styles.carosel_loadiing}>Loading...</p>
        </div>
        }
        </>
  );
};

export default CarouselSlider;

const styles = {
  carosel_container: {
    height: "40vh",
    marginTop: "20px",
  },
  carosel__image: {
    objectFit: "contain", 
    height: "100%" 
  },
  carosel_loadiing:{
    paddingLeft: "10px",
    marginTop: "100px",
  }
};
