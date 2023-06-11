import React from 'react'

const CartProduct = ({item, indexInCart, removeFromCart, updateAmountToPay}) => {

      const handleRemoveFromCart = (e) => {
        removeFromCart(item, indexInCart);
      }
      const handleQuantityChange = (e) => {
        item.quantityInCart = e.target.value;
        updateAmountToPay(item);
      }

    return(
        <tr className="items-in-cart">
          <td><img src={item.image}></img></td>
          <td>{item.name}</td>
          <td>£{item.price}</td>
          <td>
            <input type="number" name="quantity" min="1" max="10" onChange={handleQuantityChange} />
          </td>
          <td>£{item.price * item.quantityInCart}</td>
          <td><i className="fas fa-trash"
                onClick={handleRemoveFromCart}></i></td>
        </tr>
      )
}

export default CartProduct
