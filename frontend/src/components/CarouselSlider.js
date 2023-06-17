import React from "react";
import { Carousel } from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";

const CarouselSlider = ({sliderData}) => {
  

  return (
    <>
    {
      sliderData.length !== 0 ? 
      <Carousel autoPlay infiniteLoop={true}>
      {sliderData?.map((imageUrl, i) => (
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
