import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: null,
};

export const trendingPetSlice = createSlice({
  name: "trendingPet",
  initialState,

  reducers: {
    trendingPetData: (state, action) => {
      state.data = action.payload
    }
  },
});

export const { trendingPetData } = trendingPetSlice.actions;

export default trendingPetSlice.reducer;
