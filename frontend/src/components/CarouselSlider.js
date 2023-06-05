import React from "react";
import Card from "./Card";
import { Carousel } from "react-responsive-carousel";
import { useSelector } from "react-redux";
import { imageBaseUrl } from "../environment";

const CarouselSlider = ({ isLargeRow = false }) => {
  const movies = useSelector((state) => state.movie.data);
  console.log("movies == ", movies);
  return (
    <div>
      <Carousel showArrows={true}>
        <div className="row__poster">
          {movies?.map(
            (movie) =>
              ((isLargeRow && movie.poster_path) || (!isLargeRow && movie.backdrop_path)) && (
                <>
                  <img
                    className={`row__poster ${isLargeRow && "row__posterLarge"}`}
                    key={movie.id}
                    src={`${imageBaseUrl}${isLargeRow ? movie.poster_path : movie.backdrop_path}`}
                    alt={movie.name}
                  />
                  <p className="legend">Legend 1</p>
                </>
              )
          )}
        </div>
      </Carousel>
      {/* <div className="veiw_port" style={styles.view_port}>
        <div className="card_container" style={styles.card_container}>
          <Card num="1" />
          <Card num="2" />
          <Card num="3" />
          <Card num="4" />
          <Card num="5" />
        </div>
      </div> */}
    </div>
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
};
