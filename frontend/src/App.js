import React, { useEffect } from "react";
import "./styles/App.css";
import { LandingPage } from "./LandingPage";
import { BrowserRouter as Router, Routes, Route, useParams } from "react-router-dom";
import { auth } from "./firebase";
import { useDispatch, useSelector } from "react-redux";
import { login, logout } from "./features/user/userSlice";
import UserProfile from "./components/UserProfile";
import Payment from "./components/Payment";
import Footer from "./components/Footer";
import StorePage from "./components/StorePage";

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
      {/* {!user ? (
        <LoginPage />
      ) : (
        <Router>
          <Routes>
            <Route exact path="/" element={<LandingPage />} />
            <Route exact path="/pet-mall/profile" element={<UserProfile />} />
            <Route exact path="/pet-mall/checkout" element={<Payment />} />
            <Route exact path="/pet-mall/store/:id" element={<StorePage />} />
          </Routes>
        </Router>
      )} */}
      <Router>
          <Routes>
            <Route exact path="/" element={<LandingPage />} />
            {/* <Route exact path="/pet-mall/profile" element={<UserProfile />} /> */}
            <Route exact path="/pet-mall/checkout" element={<Payment />} />
            <Route exact path="/pet-mall/store/:id" element={<StorePage />} />
          </Routes>
        </Router>
      <Footer />
    </div>
  );
}

export default App;
