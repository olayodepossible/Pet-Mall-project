import { configureStore } from "@reduxjs/toolkit";
import userReducer from "../features/user/userSlice";
import petReducer from "../features/pet/petSlice";

export const store = configureStore({
  reducer: {
    user: userReducer,
    pet: petReducer,
  },
});
