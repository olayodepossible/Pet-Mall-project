import React, { useEffect, useState } from "react";
import "../styles/Navbar.css";
import { useNavigate } from "react-router-dom";


const Navbar = ({pageTitle, cartItems, isLandingPage=false}) => {
  const [show, handleShow] = useState(false);
console.log('pageTitile', cartItems)
  const transitionNavBar = () => {
    window.scrollY > 100 ? handleShow(true) : handleShow(false);
  };

  const history = useNavigate();

  useEffect(() => {
    window.addEventListener("scroll", transitionNavBar);
    return () => window.removeEventListener("scroll", transitionNavBar);
  }, []);

  return (
    <div className={`nav ${isLandingPage ? show && "nav__black" : "nav__black" }`}>
      <div className="nav__contents">
        <div>
          <img
            onClick={() => history("/")}
            className="nav__logo"
            src="/pet-mall-logo.jpg"
            alt="logo"
          />

          <p>
            <span className="nav__title">ALX-PET-MALL</span>
            <span className="nav__page__title">{!isLandingPage && pageTitle }</span>
          </p>
        </div>

        <div>
        {!isLandingPage &&  
        <button  onClick={() => history("/")}>
          {cartItems ? <span className="nav__cart__items">{cartItems.length}</span> : null}
          <img className="nav__cart__img" src="/asset/cart_img.png" alt="cart"/>
        </button>}
       
          <img
            onClick={() => history("/pet-mall/profile")}
            className="nav__avatar"
            src="/asset/Netflix-avatar.png"
            alt="avatar"
          />
        </div>
      </div>
    </div>
  );
};

export default Navbar;
