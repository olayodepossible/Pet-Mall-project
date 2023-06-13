import React, { useState, useCallback } from 'react'
import "../styles/Modal.css"
import ShoppingCartProduct from './ShoppingCartProduct';
import { useNavigate } from "react-router-dom";

const Modal = ({quantity, itemsInCart, removeFromCart, setOpenModal}) => {
    const history = useNavigate();
    const [, updateState] = useState();
    const handleForceupdateMethod = useCallback(() => updateState({}), []);
   
    const updateAmountToPay = () => {
        handleForceupdateMethod();
    }

    let cartItems = itemsInCart.map((item, index) => {
        // Return key which defines an order of items inside a cart. The order in a cart is different than in database
        return <ShoppingCartProduct key={index} 
                 item={item}
                 indexInCart={index}
                 removeFromCart={removeFromCart}
                 updateAmountToPay={updateAmountToPay} />  
    });
  
    let amountToPay = 0;
    for (let i=0; i< itemsInCart.length; i++) {
        amountToPay += itemsInCart[i].price * itemsInCart[i].quantityInCart;
    }
    

    return (
        <div id="overlay">
            <section id="shopping-cart">
                <div id="cart-header">
                <span id="cart-title">Shopping Cart</span>
                <span className="modal__CloseBtn1">
                    <button onClick={() => { setOpenModal(false);}}>&times;</button>
                </span>
                </div>
                <table>
                    <thead>
                        <tr>
                        <th>Product</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {cartItems}
                    </tbody>
                </table>
                <span id="empty-cart">{(itemsInCart.length === 0) ? "Shopping cart is empty" : ""}</span>
                <h3 id="cart-total">Cart Total</h3>
                <div id="totals">
                <span>Cart Totals</span>
                <span>Number of items: {quantity}</span>
                <span>Total: &#36;{amountToPay}</span>
                </div>
                <button id="checkout"  onClick={() => history("/pet-mall/checkout")}
                disabled={itemsInCart.length === 0 ? true : false} >Checkout</button>
            </section>
        </div>
    )  
      
    // return (
    //     <div className="modal__Container">
    //         <div className="modal__CloseBtn1">
    //             <button onClick={() => { setOpenModal(false);}}>&times;</button>
    //         </div>
    //         <div className="modal__title">
    //             <h2>Cart</h2>
    //         </div>
    //         <div className="modal__body">
                
    //             {cartItems && (
    //             <ul>
    //                 {cartItems.map((item, index) => (
                       
    //                 <li key={index}>
    //                 <span style={{display: "none"}}>{totalPrice += item.price }</span> 
    //                     <span>{item.name}</span> = <span>{item.price}</span>
    //                 </li>
    //                 ))}
    //             </ul>
    //     )}
    //         </div>
    //         <div className="modal__footer">
    //             <button onClick={() => { setOpenModal(false);}} id="cancelBtn">Back</button>
    //             <button>Pay Now  <span>{totalPrice}</span></button>
    //         </div>
    //     </div>
    //   );
}

export default Modal
