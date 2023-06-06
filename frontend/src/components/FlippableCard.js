import {useState} from 'react';
import '../styles/flippable-card.css'
import {CSSTransition, TransitionGroup} from 'react-transition-group';
import FlipCard from './card/FlipCard';


function FlippableCard() {
    const [showFront, setShowFront] = useState(true);
    const [activeCard, setActiveCard] = useState(null);
    const handleCardClick = (id) => {
        setActiveCard(activeCard === id ? null : id);
      };
    const items = [1, 2, 3]

    
        
            
    return(
        <div className="flippable-card-container">
            {
                items.map((item, i) => (
                    
                    <FlipCard 
                        key={i}
                        item={item} 
                        id={i}
                        active={i === activeCard}
                        handleClick={handleCardClick}
                    />
                ))
            }
        </div>
    );
}

export default FlippableCard;