import React, {useState, useEffect} from "react";
import Navbar from "./Navbar";
import FlippableCard from "./FlippableCards";
import { getPetMallData } from "../adapter/Axio";

const StorePage = ({storeId}) => {

  const [store, setStore] = useState({});

  useEffect(() => {
    const fetchData = async () => {
      const resp = await getPetMallData(`/stores/${storeId}`);
      setStore(resp.data);
      return resp;
      ;
    };
    fetchData();
  }, []);

  return (
    <div className="home">
      <Navbar pageTitle={store.name}/>
      <FlippableCard dataList={store.storePets} btnAction={"Add to Cart"}/>
    </div>
  );
};

export default StorePage;
