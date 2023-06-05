import React, { useEffect } from "react";
import { LandingPage } from "./LandingPage";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginPage from "./components/LoginPage";
import { auth } from "./firebase";
import { useDispatch, useSelector } from "react-redux";
import { login, logout } from "./features/user/userSlice";
import UserProfile from "./components/UserProfile";
import Payment from "./components/Payment";
import CarouselSlider from "./components/CarouselSlider";

function App() {
  const user = useSelector((state) => state.user.data);
  const dispatch = useDispatch();

  useEffect(() => {
    const unsubscribe = auth.onAuthStateChanged((userAuth) => {
      userAuth ? dispatch(login({ uid: userAuth.uid, email: userAuth.email })) : dispatch(logout());
    });

    return unsubscribe;
  }, [dispatch]);

  return (
    <div className="app">
      {!user ? (
        <LoginPage />
      ) : (
        <Router>
          <Routes>
            <Route exact path="/" element={<LandingPage />} />
            <Route exact path="/profile" element={<UserProfile />} />
            <Route exact path="/checkout" element={<Payment />} />
            <Route exact path="/cards" element={<CarouselSlider />} />
          </Routes>
        </Router>
      )}
    </div>
  );
}

export default App;
