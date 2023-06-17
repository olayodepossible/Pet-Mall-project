import React, { useState, useRef} from "react";
import { useNavigate } from 'react-router-dom'
import "../styles/LoginPage.css";
import SignUpPage from "./SignUpPage";
import UserLoginPage from "./UserLoginPage";

const LoginPage = ({setIsLogin}) => {

  const history = useNavigate();

  const [signin, setSignIn] = useState(false);
  const [showLogin, setShowLogin] = useState(false);

  const emailRef = useRef(null);

  const handleShowLogin = (e) => {
    e.preventDefault(); 
    setShowLogin(true)
  }

  const handleShowSign = (e) => {
    e.preventDefault(); 
    setSignIn(!signin)
    setShowLogin(true)
  }

  return (
    <div className="login">
      <div className="login__background">
        <div className="nav__contents">
          <div>
            <img
            onClick={(e) => {e.preventDefault(); return history("/pet-mall")}}
              className="login__logo"
              src="/pet-mall-logo.jpg"
              alt="logo"
            />
          </div>
          <div>
            <button className="login__button" onClick={handleShowSign }>
              {signin ? "Login" :"Sign Up"}
            </button>
          </div>
          
        </div>
        <div className="login__gradient" />
      </div>
      <div className="login_body">
        {signin ? (
          <SignUpPage  setIsLogin={setIsLogin}/>
        ) : (
          <>
              <h1 style={{display: `${showLogin ? 'none': ""}`}}>Enjoy Unlimited Access to a better Pet care...</h1>
              <div className="login__input" style={{display: `${showLogin ? 'none': ""}`}}>
                <form>
                  <input type="email" placeholder="Email Address" ref={emailRef}/>
                  <button className="login__getStarted" onClick={handleShowLogin}>
                    GET STARTED
                  </button>
                </form>
              </div>
            {showLogin ? <UserLoginPage setIsLogin={setIsLogin} setShowLogin={setShowLogin} setSignIn={setSignIn} setEmail={emailRef?.current?.value ? emailRef.current.value : ""}/> : null}

          </>
        )}
      </div>
    </div>
  );
};

export default LoginPage;
