import { useRef } from "react";
import "./Card.css";
import "./flip-transition.css";
import {CSSTransition} from 'react-transition-group';

const FlipCard = ({ item, id, active, handleClick})  => {
  const nodeRef = useRef(null)
  console.log("Card status == ", active);
  console.log("Card status id == ", id);
  
  return (
   
    <div className="  row__poster row__posterLarge" onClick={() => { console.log("cliked", id); handleClick(id)}} ref={nodeRef}>
      <CSSTransition
        key={id}
        in={active}
        timeout={300}
        classNames='flip'
        nodeRef={nodeRef}
      >
        <div className="card" ref={nodeRef} >
          <div className="card-back">Back - {item}</div>
          <div className="card-front">Front - {item}</div>
        </div>
      </CSSTransition>
    </div>
  );
}

export default FlipCard;