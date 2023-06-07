import React, { useEffect, useState } from "react";
import { Carousel } from "react-responsive-carousel";
import { getData, getPetMallData } from "../adapter/Axio";
import "react-responsive-carousel/lib/styles/carousel.min.css";

const CarouselSlider = ({ isLargeRow = false }) => {
  const [petImages, setPetImages] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const req = await getData("https://dog.ceo/api/breed/bulldog/images");
      // const pet = await getPetMallData("/users/");
      // console.log("PET ==> ", pet);
      const pet = req.data.message.slice(0, 11);
      setPetImages([...pet]);

      return req;
    };
    fetchData();
  }, []);

  console.log("reqim - test", petImages[0]);
  return (
    <Carousel autoPlay infiniteLoop={true}>
      {petImages?.map((imageUrl, i) => (
        <div style={styles.carosel_container} key={i}>
          <img style={{ objectFit: "contain", height: "100%" }} src={imageUrl} alt="pet image" />
        </div>
      ))}
    </Carousel>
  );
};

export default CarouselSlider;

const styles = {
  carosel_container: {
    height: "40vh",
    marginTop: "20px",
  },
};
