import React, { useState } from "react";
import "./styles/App.css";
import { ProductPage } from "./components/ProductPage";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import Payment from "./components/Payment";
import Footer from "./components/Footer";
import StorePage from "./components/StorePage";
import LandingPage from "./components/LandingPage"
import UserPage from "./components/UserPage";
import SignUpPage from "./components/SignUpPage";
import UserLoginPage from "./components/UserLoginPage";
import AboutPage from "./components/AboutPage";
import VetPage from "./components/VetPage";

function App() {
  const user = useSelector((state) => state.user.data);
  const[isLogin, setIsLogin] = useState(false)
  

  return (
    <div className="app">
    
        <Router>
          <Routes>
            <Route exact path="/" element={<LandingPage setIsLogin={setIsLogin}/>}/>
            <Route exact path="/pet-mall" element={<ProductPage  setIsLogin={setIsLogin} isLogin={isLogin}/>} />
            <Route exact path="/pet-mall/login" element={<UserLoginPage setIsLogin={setIsLogin}/>}/>
            <Route exact path="/pet-mall/signup" element={<SignUpPage setIsLogin={setIsLogin}/>}/>
            <Route exact path="/pet-mall/about" element={<AboutPage />}/>
            <Route exact path="/pet-mall/profile" element={<UserPage isLogin={isLogin} setIsLogin={setIsLogin}/>} />
            <Route exact path="/pet-mall/checkout" element={<Payment isLogin={isLogin} user={user}/>} />
            <Route exact path="/pet-mall/store/:id" element={<StorePage isLogin={isLogin} user={user}/>} />
            <Route exact path="/pet-mall/store/vets" element={<VetPage isLogin={isLogin} />} />
          </Routes>
        </Router> 
      <Footer />
    </div>
  );
}

export default App;
