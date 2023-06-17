import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: null,
};

export const sliderSlice = createSlice({
  name: "slider",
  initialState,

  reducers: {
    sliderData: (state, action) => {
      state.data = action.payload
    }
  },
});

export const { sliderData } = sliderSlice.actions;

export default sliderSlice.reducer;
