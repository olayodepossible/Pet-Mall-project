import React, { useRef } from "react";
import "../styles/SignUpPage.css";
import { useNavigate } from "react-router-dom";
import { postPetMallData } from "../adapter/Axio";
import { useDispatch } from "react-redux";
import { signUpData } from "../features/user/userSlice";


const UserLoginPage = ({setSignIn, setShowLogin, setEmail = "", setIsLogin}) => {
    const dispatch = useDispatch();
  
  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  
  const history = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const resp = await postPetMallData(`users/login`, {"username": emailRef.current.value, "password": passwordRef.current.value});
      dispatch(signUpData(resp.data))
      setIsLogin(true)
      history("/pet-mall/profile")
      
    } catch (error) {
      console.log('error', error)
      history("/pet-mall/login")
    }
    
  };
  


  return (
    <div className="signupPage login__container">
      <form>
        <h1>Log In</h1>
        <input type="email" placeholder="Email" ref={emailRef} defaultValue={setEmail }  />
        <input type="password" placeholder="Password" ref={passwordRef} />
        <button type="submit" onClick={handleLogin}>
          Login
        </button>

        <h4>
          <span className="signupPage__gray">New here? </span>
          <span className="signupPage__link" onClick={() => {setSignIn(true)}}>
            Sign Up now.
          </span>
        </h4>
      </form>
    </div>
  );
};

export default UserLoginPage;
