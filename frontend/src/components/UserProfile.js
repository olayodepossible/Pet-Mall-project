import React from "react";
import Navbar from "./Navbar";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { auth } from "../firebase";
import "../styles/UserProfile.css";
import { product } from "../features/ProductData";
import { signOut } from "firebase/auth";

const UserProfile = () => {
  const user = useSelector((state) => state.user.data);
  const history = useNavigate();

  return (
    <div className="profilePage">
      <Navbar />
      <div className="profilePage__body">
        <h1>Edit Profile</h1>
        <div className="profile__info">
          <img src="https://upload.wikimedia.org/wikipedia/commons/0/0b/Netflix-avatar.png" alt="avatar" />
          <div className="profile__details">
            <h2>{user.email}</h2>
            <div className="profile__plans">
              <h3>Plans</h3>
              {product?.map((item) => {
                return (
                  <div key={item.plan} className="userPlans">
                    <div className="plan">
                      <h5>{item.plan}</h5>
                      <h6>{item.amount}</h6>
                    </div>
                    <button onClick={() => history("/checkout")}>Subscribe</button>
                  </div>
                );
              })}
              <button onClick={() => signOut(auth)} className="profile__signout">
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
