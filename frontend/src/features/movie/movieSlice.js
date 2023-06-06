import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: []
};

export const movieSlice = createSlice({
  name: "movie",
  initialState,

  reducers: {
    movieData: (state, action) => {
      state.data = action.payload;
    },
  },
});

export const { movieData } = movieSlice.actions;

export default movieSlice.reducer;
