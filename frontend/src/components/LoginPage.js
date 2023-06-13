import React, { useState } from "react";
import "../styles/LoginPage.css";
import SignUpPage from "./SignUpPage";

const LoginPage = ({setIsLogin}) => {
  const [signin, setSignIn] = useState(false);

  return (
    <div className="login">
      <div className="login__background">
        <div className="nav__contents">
          <div>
            <img
              className="login__logo"
              src="/pet-mall-logo.jpg"
              alt="logo"
            />
          </div>
          <div>
            <button className="login__button" onClick={() => setSignIn(true)}>
              Sign In
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
            <h1>Enjoy Unlimited access to a better pet care...</h1>

            <div className="login__input">
              <form>
                <input type="email" placeholder="Email Address" />
                <button className="login__getStarted" onClick={() => setSignIn(true)}>
                  GET STARTED
                </button>
              </form>
            </div>
          </>
        )}
      </div>
    </div>
  );
};

export default LoginPage;
