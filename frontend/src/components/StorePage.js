import React, {useState, useEffect} from "react";
import { useParams } from "react-router-dom";
import Navbar from "./Navbar";
import FlippableCard from "./FlippableCards";
import { getPetMallData } from "../adapter/Axio";

const StorePage = () => {
  let params = useParams();
  console.log('first', params)
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
    setItemsCart([...itemsInCart, item.id])
    shoppingProducts[item.id].inCart = true;
    shoppingProducts[item.id].quantityInCart = 1;
    setQuantity(quantity + 1)
    setAmountToPay(amountToPay + shoppingProducts[item.id].price)
    setShoppingProducts([...shoppingProducts]);
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
