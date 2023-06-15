import React from "react";
import "../styles/Payment.css";
import { useNavigate } from "react-router-dom";

const Payment = ({user}) => {
  const history = useNavigate();

  return (
    <div className="payment__container">
      <div>
          <img
            onClick={(e) => {e.preventDefault(); return history("/pet-mall")}}
            className="nav__logo"
            src="/pet-mall-logo.jpg"
            alt="logo"
          />

          <p>
            <span style={{margin: "18px 0 0 100px"}}  className="nav__title">ALX-PET-MALL</span>
          </p>
      </div>
      <div className="payment__body">
        <div className="payment__logo">
          <button type="button" aria-label="Google Pay" className="payment__gpay-button"></button>

          <div className="payment__card__opt">
            <span>Or pay with card</span>
          </div>
        </div>

        <div className="payment__form">
          <form onSubmit={(e) => { e.preventDefault(); return history("/pet-mall")}}>
            <div className="payment__group">
              <label>First name</label>
              <input id="first-name" name="first-name" className="payment__field" placeholder="First Name" defaultValue={user.firstName} />
            </div>
            <div className="payment__group">
              <label>Last name</label>
              <input id="last-name" name="last-name" className="payment__field" placeholder="Last Name" defaultValue={user.lastName }  />
            </div>
            <div className="payment__group">
              <label>Address</label>
              <input id="address-line1" name="address_line1" className="payment__field" placeholder="Address" defaultValue={user.address }  />
            </div>
            <div className="payment__group">
              <label>City</label>
              <input id="address-city" name="address_city" className="payment__field" placeholder="City"  defaultValue={user.city } />
            </div>
            <div className="payment__group">
              <label>Country</label>
              <input id="address-state" name="address_state" className="payment__field" placeholder="State" defaultValue={user.country }  />
            </div>
            <div className="payment__group">
              <label>Card</label>
              <input id="address-state" name="address_state" className="payment__field" placeholder="Card Number" />
            </div>
            <div className="payment__group">
              <label>CVV</label>
              <input id="address-state" name="address_state" className="payment__field" placeholder="Cvv" />
            </div>
            <div className="payment__group">
              <label>ZIP</label>
              <input id="address-zip" name="address_zip" className="payment__field" placeholder="ZIP Code" />
            </div>
              <button className="payment__payNow" type="submit">
                Pay Now
              </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Payment;
