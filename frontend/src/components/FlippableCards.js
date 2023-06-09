import "../styles/flippable-card.css";
import FlipCard from "./FlipCard";

const FlippableCards = ({dataList, btnAction, addToCart, isStorePage}) => {
  
  return (
    <div className="flippable-card-container">
      {dataList?.map((item, i) => (
        <FlipCard key={i} pet={item} index={i} btnAction={btnAction} addToCart={ addToCart} isStorePage={isStorePage}/>
      ))}
    </div>
  );
}

export default FlippableCards;
