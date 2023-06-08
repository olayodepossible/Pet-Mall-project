import React from "react";
import "../styles/Footer.css";

const Footer = () => {
  return (
    <div className="footer footer__black">
      <div className="footer__contents">
        <div>
          <img
            className="footer__logo"
            src="/pet-mall-logo.jpg"
            alt="logo"
          />
        </div>

        <div>
          <span>Contact: &nbsp;</span>
          <img
              className="footer__mail"
              src="/asset/Gmail_Logo.png"
              alt="logo"
            />
            <span className="">
            possibleolayode5344@gmail.com
            </span>
        </div>
        
        <div>
          <span className="footer__copyright">
            2023 &copy; &nbsp; O'possible.
          </span>
        </div>
      </div>
    </div>
  );
};

export default Footer;
