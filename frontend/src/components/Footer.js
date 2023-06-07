import React from "react";
import "../styles/Footer.css";

const Footer = () => {
  return (
    <div className="footer footer__black">
      <div className="footer__contents">
        <img
          className="footer__logo"
          src="https://lh3.googleusercontent.com/dheqqmTiQK8sOgDHjAmrg4IjAY5Io2gUd8y0nXegWZi8JpK14v3WCN8wa63UoLot7sFxqZ9ohHpsUUELkBONNiEfM96i-w6QzSiCSJ-6uQ"
          alt="logo"
        />
        <span className="footer__copyright">
          Copyright &copy; 2020 by&nbsp;&nbsp; O'possible. &nbsp;All rights reserved.
        </span>
      </div>
    </div>
  );
};

export default Footer;
