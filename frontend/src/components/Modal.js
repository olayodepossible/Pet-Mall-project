import React from 'react'
import "../styles/Modal.css"
import ShoppingCartProduct from './ShoppingCartProduct';

const Modal = ({quantity, dataList, itemsInCart, removeFromCart, setOpenModal }) => {
    let totalPrice = 0;

    let cartItems = itemsInCart.map((item, index) => {
        // Return key which defines an order of items inside a cart. The order in a cart is different than in database
        return <ShoppingCartProduct key={index} 
                 item={item}
                 indexInCart={index}
                 removeFromCart={removeFromCart}
                 updateAmountToPay={updateAmountToPay} />  
    });

    const updateAmountToPay = (item) => {
        // this.forceUpdate();
    }
      
        
    let amountToPay = 0;
    for (let i=0; i< dataList.length; i++) {
        amountToPay += dataList[i].price * dataList[i].quantityInCart;
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
            <span id="empty-cart">{(itemsInCart.length == 0) ? "Shopping cart is empty" : ""}</span>
            <h3 id="cart-total">Cart Total</h3>
            <div id="totals">
            <span>Cart Totals</span>
            <span>Number of items: {quantity}</span>
            <span>Total: £{amountToPay}</span>
            </div>
            <button id="checkout" 
            disabled={itemsInCart.length == 0 ? true : false} >Checkout</button>
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
