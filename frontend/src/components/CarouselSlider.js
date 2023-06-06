import React from "react";
import { Carousel } from "react-responsive-carousel";
import { useSelector } from "react-redux";
import { imageBaseUrl } from "../environment";
import "react-responsive-carousel/lib/styles/carousel.min.css";

const CarouselSlider = ({ isLargeRow = false }) => {
  const movies = useSelector((state) => state.movie.data);

  return (
    <Carousel showArrows={true} autoPlay infiniteLoop={true}>
      {movies?.map(
        (movie) =>
          ((isLargeRow && movie.poster_path) || (!isLargeRow && movie.backdrop_path)) && (
            <div style={styles.carosel_container} key={movie.id}>
              <img
                style={{ objectFit: "contain", height: "100%" }}
                src={`${imageBaseUrl}${isLargeRow ? movie.poster_path : movie.backdrop_path}`}
                alt={movie.name}
              />
            </div>
          )
      )}
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
