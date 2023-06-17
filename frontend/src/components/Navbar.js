import React, { useEffect, useState } from "react";
import "../styles/Navbar.css";
import { useNavigate } from "react-router-dom";
import Modal from "./Modal";


const Navbar = ({user, pageTitle, quantity, itemsInCart, removeFromCart, setItemsCart, isLogin, setIsLogin, isLandingPage=false}) => {

  const [show, handleShow] = useState(false);
  const [modalOpen, setModalOpen] = useState(false);
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
        <div >
          <img
            onClick={(e) => { e.preventDefault(); return history("/")}}
            className="nav__logo"
            src="/pet-mall-logo.jpg"
            alt="logo"
          />

          <p>
            <span className="nav__title">ALX-PET-MALL</span>
            <span className="nav__page__title">{!isLandingPage && pageTitle }</span>
          </p>
        </div>
       

        <div className="nav__contents" style={{columnGap: "45px"}}>
          <div>
            <button onClick={(e) => { e.preventDefault(); return history("/pet-mall/about")}}  style={{ display: "inline-block", padding: "5px 15px", cursor: "pointer"}}>About</button>
          </div>
          {!isLandingPage && isLogin &&  
            <>
            <div>
            <button onClick={(e) => { e.preventDefault(); return history("/pet-mall/store/vets")}}  style={{ display: "inline-block", padding: "5px 15px", cursor: "pointer"}}>{ user.privilege === "ROLE_STORE_ADMIN" ? "Add Vet" : "View Vet"}</button>
            </div>
           
            
            { quantity === 0 ? null : <div>
              <button  onClick={(e) => { e.preventDefault(); return setModalOpen(!modalOpen)}}  style={{cursor: "pointer", display: "inline-block"}}>
                <span className="nav__cart__items">{quantity}</span> 
                <img className="nav__cart__img" src="/asset/cart_img.png" alt="cart"/>
              </button>
            </div>}
            </>
          }
          
        
          {
          !isLogin ? <div><button onClick={(e) => { e.preventDefault(); return history("/pet-mall/login")}}  style={{ display: "inline-block", padding: "5px 15px", cursor: "pointer"}}>Login</button> </div> :
           <div>
              <img
                  onClick={() => history("/pet-mall/profile")}
                  className="nav__avatar"
                  src="/asset/Netflix-avatar.png"
                  alt="avatar"
                />
            </div>
          }
        </div>
        
      </div>

      {modalOpen && <Modal itemsInCart={itemsInCart} setOpenModal={setModalOpen} quantity={quantity} removeFromCart={removeFromCart}/>}
    </div>
  );
};

export default Navbar;
