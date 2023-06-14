import "../styles/flippable-card.css";
import FlipCard from "./FlipCard";

const FlippableCards = ({dataList, btnAction, addToCart, isStorePage, isLogin}) => {
  
  return (
    <div className="flippable-card-container">
      {dataList?.map((item, i) => (
        <FlipCard key={i} pet={item} index={i} btnAction={btnAction} addToCart={ addToCart} isStorePage={isStorePage} isLogin={isLogin}/>
      ))}
    </div>
  );
}

export default FlippableCards;
