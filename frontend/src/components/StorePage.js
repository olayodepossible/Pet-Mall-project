import React, {useState, useEffect} from "react";
import { useParams } from "react-router-dom";
import Navbar from "./Navbar";
import FlippableCard from "./FlippableCards";
import { getPetMallData } from "../adapter/Axio";

const StorePage = () => {
  let params = useParams();
  const [store, setStore] = useState({});
  const [cartItems, setCartItems] = useState([]);
  const [itemsInCart, setItemsCart] = useState([]);
  const [shoppingProducts, setShoppingProducts] = useState([]);
  const [quantity, setQuantity] = useState(0);
  const [amountToPay, setAmountToPay] = useState(0);
  
  const addToCart1 = (product) => {
    setCartItems([...cartItems, product]);
  };

  const addToCart = (item)  => {
    let cartItem = shoppingProducts.filter(i => i.id == item.id);
    setItemsCart([...itemsInCart, item.id])
    cartItem[0]["inCart"] = true;
    cartItem[0]["quantityInCart"] = 1;
    setQuantity(quantity + 1)
    setAmountToPay(amountToPay + cartItem.price)
    setShoppingProducts([...shoppingProducts, cartItem]);

  }

  const removeFromCart = (item, indexInCart) => {
    shoppingProducts[item.id].inCart = false;
    shoppingProducts[item.id].quantityInCart = 0;
    itemsInCart.splice(indexInCart, 1);
    setQuantity(quantity - 1)
    setAmountToPay(amountToPay - shoppingProducts[item.id].price)
    setItemsCart([...itemsInCart, item.id])
    setShoppingProducts([...shoppingProducts]);
  }

  useEffect(() => {
    const fetchData = async () => {
      try {
        const resp = await getPetMallData(`stores/owner?ownerId=${params.id}`);
        setStore(resp.data[0]);
        setShoppingProducts([...resp.data[0].storePets, ...resp.data[0].accessoryList].slice(0, 20));
        return resp;
        
      } catch (error) {
        console.error('Error:', error);
      }
       
    };
    fetchData();
  }, []);

  return (
    <div className="home">
      <Navbar pageTitle={store.name} dataList={shoppingProducts} amountToPay={amountToPay}  quantity={quantity} itemsInCart={itemsInCart} removeFromCart={removeFromCart} />
      <FlippableCard dataList={shoppingProducts} addToCart={addToCart} isStorePage={true}/>
    </div>
  );
};

export default StorePage;
