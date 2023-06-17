import { configureStore } from "@reduxjs/toolkit";
import userReducer from "../features/user/userSlice";
import petReducer from "../features/pet/petSlice";
import trendingPetReducer from "../features/trendingPet/trendingPetSlice";
import sliderReducer from "../features/sliderData/sliderSlice"

export const store = configureStore({
  reducer: {
    user: userReducer,
    pet: petReducer,
    trendingPet: trendingPetReducer,
    sliderData: sliderReducer
  },
});
