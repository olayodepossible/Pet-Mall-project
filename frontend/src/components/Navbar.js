import React, { useEffect, useState } from "react";
import "../styles/Navbar.css";
import { useNavigate } from "react-router-dom";
import Modal from "./Modal";


const Navbar = ({pageTitle, quantity, itemsInCart, removeFromCart, setItemsCart, isLogin, setIsLogin, isLandingPage=false}) => {

  const [show, handleShow] = useState(false);
  const [modalOpen, setModalOpen] = useState(false);
  const transitionNavBar = () => {
    window.scrollY > 100 ? handleShow(true) : handleShow(false);
  };

  console.log('isLogin - Nav', isLogin)

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
          {!isLandingPage && isLogin &&  
          <button  onClick={() => {setModalOpen(true);}}  style={{cursor: "pointer"}}>
            {quantity === 0 ? null : <span className="nav__cart__items">{quantity}</span> }
            <img className="nav__cart__img" src="/asset/cart_img.png" alt="cart"/>
          </button>
          }
        
          {
          !isLogin ? <button onClick={() => history("/pet-mall/login")}>Login</button> :
            <img
              onClick={() => history("/pet-mall/profile")}
              className="nav__avatar"
              src="/asset/Netflix-avatar.png"
              alt="avatar"
            />
          }
        </div>
        
      </div>

      {modalOpen && <Modal itemsInCart={itemsInCart} setOpenModal={setModalOpen} quantity={quantity} removeFromCart={removeFromCart}/>}
    </div>
  );
};

export default Navbar;
