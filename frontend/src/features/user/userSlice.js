import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: null,
};

export const userSlice = createSlice({
  name: "user",
  initialState,

  reducers: {
    login: (state, action) => {
      state.data = action.payload;
    },

    logout: (state) => {
      state.data = null;
    },
    signUpData: (state, action) => {
      state.data = action.payload
    }
  },
});

export const { login, logout, signUpData } = userSlice.actions;

export default userSlice.reducer;
