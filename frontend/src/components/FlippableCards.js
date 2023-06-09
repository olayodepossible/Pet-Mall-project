import "../styles/flippable-card.css";
import FlipCard from "./FlipCard";

const FlippableCards = ({dataList, btnAction}) => {
  
  return (
    <div className="flippable-card-container">
      {dataList?.map((item, i) => (
        <FlipCard key={i} pet={item} index={i} btnAction={btnAction}/>
      ))}
    </div>
  );
}

export default FlippableCards;
