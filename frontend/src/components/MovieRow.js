import React, { useEffect, useState } from "react";
import { getData } from "../adapter/Axio";
import "../styles/MovieRow.css";
import { imageBaseUrl } from "../environment";
import { useDispatch } from "react-redux";
import { movieData } from "../features/movie/movieSlice";

const MovieRow = ({ title, fetchUrl, isLargeRow = false }) => {
  const [movies, setMovies] = useState([]);
  const dispatch = useDispatch();

  useEffect(() => {
    const fetchData = async () => {
      const request = await getData(fetchUrl);
      dispatch(movieData(request.data.results));
      setMovies(request.data.results);
      return request;
    };

    fetchData();
  }, [fetchUrl]);

  return (
    <div className="movieRow">
      <h2>{title}</h2>
      <div className="row__posters">
        {movies?.map(
          (movie) =>
            ((isLargeRow && movie.poster_path) || (!isLargeRow && movie.backdrop_path)) && (
              <img
                className={`row__poster ${isLargeRow && "row__posterLarge"}`}
                key={movie.id}
                src={`${imageBaseUrl}${isLargeRow ? movie.poster_path : movie.backdrop_path}`}
                alt={movie.name}
              />
            )
        )}
      </div>
    </div>
  );
};

export default MovieRow;
