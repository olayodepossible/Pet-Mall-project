import React, { useRef } from "react";
import "../styles/SignUpPage.css";
import { useNavigate } from "react-router-dom";
// import { fireStoreSignIn, fireStoreSignUp } from "../firebase";

const SignUpPage = ({setIsLogin}) => {
  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  const history = useNavigate();

  const register = (e) => {
    e.preventDefault();
    setIsLogin(true)
    history("/")
    // fireStoreSignUp(emailRef.current.value, passwordRef.current.value);
  };

  const signin = (e) => {
    e.preventDefault();
    setIsLogin(true)
    history("/")
    // fireStoreSignIn(emailRef.current.value, passwordRef.current.value);
  };
  return (
    <div className="signupPage">
      <form>
        <h1>Sign In</h1>
        <input type="email" placeholder="Email" ref={emailRef} />
        <input type="password" placeholder="Password" ref={passwordRef} />
        <button type="submit" onClick={signin}>
          Sign In
        </button>

        <h4>
          <span className="signupPage__gray">New here? </span>
          <span className="signupPage__link" onClick={register}>
            Sign Up now.
          </span>
        </h4>
      </form>
    </div>
  );
};

export default SignUpPage;
