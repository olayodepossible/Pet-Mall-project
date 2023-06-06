import React from "react";
import { Carousel } from "react-responsive-carousel";
import { useSelector } from "react-redux";
import { imageBaseUrl } from "../environment";
import 'react-responsive-carousel/lib/styles/carousel.min.css';

const CarouselSlider = ({ isLargeRow = false }) => {
  const movies = useSelector((state) => state.movie.data);

  return (
    
      <Carousel showArrows={true} autoPlay infiniteLoop={true}>
        
          {movies?.map(
            (movie) =>
              ((isLargeRow && movie.poster_path) || (!isLargeRow && movie.backdrop_path)) && (
                <div style={styles.carosel} key={movie.id}>
                  <img style={{objectFit: "contain", height:"100%"}}
                    
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
  view_port: {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: "350px",
    height: "200px",
    backgroundColor: "red",
  },

  card_container: {
    display: "flex",
    flexDirection: "row",
    width: "fit-content",
  },

  carosel: {
    height: "40vh",
    
  }
};
