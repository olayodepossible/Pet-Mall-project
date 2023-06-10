import React from 'react'
import "../styles/ShoppingCartProduct.css"

const ShoppingCartProduct = ({item, indexInCart, removeFromCart, updateAmountToPay }) => {


    const handleRemoveFromCart =(e) => {
        removeFromCart(item, indexInCart);
      }
    const handleQuantityChange = (e) =>  {
    item.quantityInCart = e.target.value;
    // Update total value
    // this.forceUpdate();
    updateAmountToPay(item);
    }

    console.log('item', item)

    return(
        <tr className="items-in-cart">
          <td><img src={item.imageUrl}></img></td>
          <td>{item.name}</td>
          <td>&#36;{item.price}</td>
          <td>
            <input type="number" name="quantity" min="1" max="10" onChange={handleQuantityChange} />
          </td>
          <td>£{item.price * item.quantityInCart}</td>
          <td><button className="fas fa-trash"
                onClick={handleRemoveFromCart}>
                  <img src="/asset/black-trash.jpeg" alt="trash can"  style={{width: "16px"}}/>
                </button></td>
        </tr>
      )
}

export default ShoppingCartProduct
