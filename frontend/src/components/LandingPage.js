import React, { useState, useRef, useEffect} from "react";
import { useNavigate } from 'react-router-dom'
import "../styles/LoginPage.css";
import { getData, getPetMallData } from "../adapter/Axio";
import { useDispatch } from "react-redux";
import { petData } from "../features/pet/petSlice";
import { sliderData } from "../features/sliderData/sliderSlice";
import { trendingPetData } from "../features/trendingPet/trendingPetSlice";
import SignUpPage from "./SignUpPage";
import UserLoginPage from "./UserLoginPage";

const LandingPage = ({setIsLogin}) => {

  const history = useNavigate();

  const [signup, setSignUp] = useState(false);
  const [showLogin, setShowLogin] = useState(false);

  const [petImages, setPetImages] = useState([]);
  const dispatch = useDispatch();

  const emailRef = useRef(null);

  const handleShowLogin = (e) => {
    e.preventDefault(); 
    setShowLogin(!showLogin)
  }

  const handleShowSign = (e) => {
    e.preventDefault(); 
    setSignUp(!signup)
    setShowLogin(!showLogin)
  }

  useEffect(() => {
    const fetchData = async () => {

      try {
        const req = await getData("/bulldog/images");
        dispatch(sliderData(req.data.message.slice(0, 11)));

        const request = await getData("/germanshepherd/images");
        dispatch(trendingPetData(request.data.message));
    
        const petResp = await getPetMallData("/pets/store");
        dispatch(petData(petResp.data));

        return req
        
      } catch (error) {
        console.error('Error:', error);
        return;
      }
      
    };
    fetchData();
  }, []);


  return (
    <div className="login">
      <div className="login__background">
        <div className="nav__contents">
          <div>
            <img
            onClick={(e) => {e.preventDefault(); return history("/")}}
              className="login__logo"
              src="/pet-mall-logo.jpg"
              alt="logo"
            />
          </div>
          <div>
            <button className="login__button" onClick={handleShowSign }>
              {signup ? "Login" :"Sign Up"}
            </button>
          </div>
          
        </div>
        <div className="login__gradient" />
      </div>
      <div className="login_body">
        {signup ? (
          <SignUpPage signup={signup}  setSignUp={setSignUp} setIsLogin={setIsLogin}/>
        ) : (
          <>
              <h1 style={{display: `${showLogin ? 'none': ""}`}}>Enjoy Unlimited Access to a better Pet care...</h1>
              <div className="login__input" style={{display: `${showLogin ? 'none': ""}`}}>
                <div>
                  <button className="login__getStarted" onClick={(e) => {e.preventDefault(); return history("/pet-mall")}}>
                    GET STARTED
                  </button>
                </div>
              </div>
            {showLogin ? <UserLoginPage setIsLogin={setIsLogin} setShowLogin={setShowLogin} setSignUp={setSignUp}/> : null}

          </>
        )}
      </div>
    </div>
  );
};

export default LandingPage;
