import React, { useEffect, useState } from "react";
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
import LoginPage from "./components/LoginPage"

function App() {
  const user = useSelector((state) => state.user.data);
  const dispatch = useDispatch();
  const[isLogin, setIsLogin] = useState(false)
  console.log('isLogin', isLogin)
  

  useEffect(() => {
    const unsubscribe = auth.onAuthStateChanged((userAuth) => {
      userAuth ? dispatch(login({ uid: userAuth.uid, email: userAuth.email })) : dispatch(logout());
    });

    return unsubscribe;
  }, [dispatch]);

  return (
    <div className="app">
    
        <Router>
          <Routes>
          <Route exact path="/pet-mal/login" element={<LoginPage setIsLogin={setIsLogin}/>}/>
            <Route exact path="/" element={<LandingPage  setIsLogin={setIsLogin} isLogin={isLogin}/>} />
            <Route exact path="/pet-mall/profile" element={<UserProfile isLogin={isLogin} setIsLogin={setIsLogin}/>} />
            <Route exact path="/pet-mall/checkout" element={<Payment isLogin={isLogin}/>} />
            <Route exact path="/pet-mall/store/:id" element={<StorePage isLogin={isLogin}/>} />
          </Routes>
        </Router> 
      <Footer />
    </div>
  );
}

export default App;
