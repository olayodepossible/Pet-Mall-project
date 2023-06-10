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

    return(
        <tr className="items-in-cart">
          <td><img src={this.props.item.image}></img></td>
          <td>{this.props.item.name}</td>
          <td>£{this.props.item.price}</td>
          <td>
            <input type="number" name="quantity" min="1" max="10" onChange={this.handleQuantityChange} />
          </td>
          <td>£{this.props.item.price * this.props.item.quantityInCart}</td>
          <td><i className="fas fa-trash"
                onClick={this.handleRemoveFromCart}></i></td>
        </tr>
      )
}

export default ShoppingCartProduct
