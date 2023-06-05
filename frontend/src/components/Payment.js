import React from "react";
import "../styles/Payment.css";
import { useNavigate } from "react-router-dom";

const Payment = () => {
  const history = useNavigate();

  return (
    <div className="payment__body">
      <div className="payment__logo">
        <button type="button" aria-label="Google Pay" className="payment__gpay-button"></button>

        <div className="payment__card__opt">
          <span>Or pay with card</span>
        </div>
      </div>

      <div className="payment__form">
        <form onSubmit={() => history("/")}>
          <div className="payment__group">
            <label>First name</label>
            <input id="first-name" name="first-name" className="payment__field" placeholder="First Name" />
          </div>
          <div className="payment__group">
            <label>Last name</label>
            <input id="last-name" name="last-name" className="payment__field" placeholder="Last Name" />
          </div>
          <div className="payment__group">
            <label>Address</label>
            <input id="address-line1" name="address_line1" className="payment__field" placeholder="Address" />
          </div>
          <div className="payment__group">
            <label>City</label>
            <input id="address-city" name="address_city" className="payment__field" placeholder="City" />
          </div>
          <div className="payment__group">
            <label>State</label>
            <input id="address-state" name="address_state" className="payment__field" placeholder="State" />
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
          <div className="payment__group ">
            <label>Country</label>
            <div className="payment__group__select">
              <select name="slct" id="slct">
                <option>Select Country</option>
                <option value="1">USA</option>
                <option value="2">England</option>
                <option value="3">Kenya</option>
              </select>
            </div>
          </div>

          <button className="payment__payNow" type="submit">
            Pay Now
          </button>
          <div className="payment__outcome">
            <div className="payment__error"></div>
            <div className="payment__success">Success! Your Stripe token is</div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Payment;
