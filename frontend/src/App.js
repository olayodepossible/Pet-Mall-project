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
import UserPage from "./components/UserPage";
import SignUpPage from "./components/SignUpPage";
import UserLoginPage from "./components/UserLoginPage";

function App() {
  const user = useSelector((state) => state.user.data);
  const dispatch = useDispatch();
  const[isLogin, setIsLogin] = useState(false)
  

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
            <Route exact path="/" element={<LandingPage  setIsLogin={setIsLogin} isLogin={isLogin}/>} />
            <Route exact path="/pet-mall/login" element={<LoginPage setIsLogin={setIsLogin}/>}/>
            <Route exact path="/pet-mall/login-page" element={<UserLoginPage setIsLogin={setIsLogin}/>}/>
            <Route exact path="/pet-mall/signup" element={<SignUpPage setIsLogin={setIsLogin}/>}/>
            <Route exact path="/pet-mall/profile" element={<UserPage isLogin={isLogin} setIsLogin={setIsLogin}/>} />
            <Route exact path="/pet-mall/checkout" element={<Payment isLogin={isLogin}/>} />
            <Route exact path="/pet-mall/store/:id" element={<StorePage isLogin={isLogin}/>} />
          </Routes>
        </Router> 
      <Footer />
    </div>
  );
}

export default App;
