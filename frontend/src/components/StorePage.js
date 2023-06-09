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

  const addToCart = (product) => {
    setCartItems([...cartItems, product]);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const resp = await getPetMallData(`stores/owner?ownerId=${params.id}`);
        setStore(resp.data[0]);
        return resp;
        
      } catch (error) {
        console.error('Error:', error);
      }
      
      
    };
    fetchData();
  }, []);

  return (
    <div className="home">
      <Navbar pageTitle={store.name} cartItems={cartItems}/>
      <FlippableCard dataList={store.storePets} btnAction={"Add to Cart"} addToCart={addToCart} isStorePage={true}/>
    </div>
  );
};

export default StorePage;
