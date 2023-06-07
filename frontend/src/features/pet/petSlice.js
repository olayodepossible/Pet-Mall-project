import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: [],
};

export const movieSlice = createSlice({
  name: "pet",
  initialState,

  reducers: {
    petData: (state, action) => {
      state.data = action.payload;
    },
  },
});

export const { petData } = movieSlice.actions;

export default movieSlice.reducer;
