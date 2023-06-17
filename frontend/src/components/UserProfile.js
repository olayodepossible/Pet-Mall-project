import React from "react";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import "../styles/UserProfile.css";
import { product } from "../features/ProductData";

const UserProfile = ({setIsLogin}) => {
  const user = useSelector((state) => state.user.data);
  const history = useNavigate();

  return (
    <div className="profilePage">
      <div>
        <img
          onClick={() => history("/")}
          className="nav__logo"
          src="/pet-mall-logo.jpg"
          alt="logo"
        />

        <p>
          <span style={{margin: "18px 0 0 100px"}} className="nav__title">ALX-PET-MALL</span>
        </p>
      </div>
      <div className="profilePage__body">
        <h1>Edit Profile</h1>
        <div className="profile__info">
          <img src="/asset/Netflix-avatar.png" alt="avatar" />
          <div className="profile__details">
            <h2>{"abc@test.com"}</h2>
            <div className="profile__plans">
              <h3>Products</h3>
              {product?.map((item) => {
                return (
                  <div key={item.plan} className="userPlans">
                    <div className="plan">
                      <h5>{item.plan}</h5>
                      <h6>{item.amount}</h6>
                    </div>
                    <button onClick={() => history("/pet-mall/checkout")}>Buy Now</button>
                  </div>
                );
              })}
              <button onClick={() => {setIsLogin(false); return history("/")}} className="profile__signout">
                Sign Out
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserProfile;
