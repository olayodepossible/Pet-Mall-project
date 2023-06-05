import React, { useEffect, useState } from "react";
import "../styles/Navbar.css";
import { useNavigate } from "react-router-dom";
const Navbar = () => {
  const [show, handleShow] = useState(false);

  const transitionNavBar = () => {
    window.scrollY > 100 ? handleShow(true) : handleShow(false);
  };

  const history = useNavigate();

  useEffect(() => {
    window.addEventListener("scroll", transitionNavBar);
    return () => window.removeEventListener("scroll", transitionNavBar);
  }, []);

  return (
    <div className={`nav ${show && "nav__black"}`}>
      <div className="nav__contents">
        <img
          onClick={() => history("/")}
          className="nav__logo"
          src="https://lh3.googleusercontent.com/dheqqmTiQK8sOgDHjAmrg4IjAY5Io2gUd8y0nXegWZi8JpK14v3WCN8wa63UoLot7sFxqZ9ohHpsUUELkBONNiEfM96i-w6QzSiCSJ-6uQ"
          alt="logo"
        />
        <img
          onClick={() => history("/profile")}
          className="nav__avatar"
          src="https://upload.wikimedia.org/wikipedia/commons/0/0b/Netflix-avatar.png"
          alt="avatar"
        />
      </div>
    </div>
  );
};

export default Navbar;
