import React, { useState } from 'react'
import "../styles/UserPage.css"
import { useNavigate } from 'react-router-dom'
import { useSelector } from 'react-redux'

const UserPage = ({setIsLogin}) => {

    const user = useSelector((state) => state.user.data);
    const history = useNavigate();

    const stats = [
        {count: 56799, tag: "Following"},
        {count: 243, tag: "Followers"},
       {count: 4225246, tag:"Likes"},
    ]

    const numCommasToUnit = (numCommas) => {
    switch (numCommas) {
        case 0:
        return '';
        case 1:
        return 'K';
        case 2:
        return 'M';
        case 3:
        return 'B';
        case 4:
        return 'T';
        default:
        return '';
    }
    }

    const prettifyStat = (num) => {
    const asInt = parseInt(num);//ensure stat isn't a float
    const asStr = asInt.toString();
    const numDigits = asStr.length;
    const numCommas = parseInt((numDigits - 1) / 3);
    const dotIndex = ((numDigits - 1) % 3) + 1;
    if (numDigits > 3) {
        const unit = numCommasToUnit(numCommas);
        return `${asStr.slice(0, dotIndex)}.${asStr.slice(dotIndex, 3)}${unit}`;
    }
    return num;
    }

    const handleLogout = () => {
        setIsLogin(false);
        history("/pet-mall")
    };

  return (
    <>
        <div>
          <img
            onClick={() => history("/pet-mall")}
            className="nav__logo"
            src="/pet-mall-logo.jpg"
            alt="logo"
          />

          <p>
            <span style={{margin: "18px 0 0 100px"}}  className="nav__title">ALX-PET-MALL</span>
          </p>
      </div>

      <div className="profile-wrapper">
        <div className="profile-header">
            <img src={user.profileImage} width="60" height="60" className="avatar" alt='profile'/>
            <div className="profile-info">
                <h1 className="display-name">{user.firstName + " " +user.lastName}</h1>
            </div>
            <div><h5>{`${user.address}, ${user.city}. ${user.country}`}</h5></div>
            {/* <div className="profile-stats">
                {
    
                    stats.map( (item, i)=>  
                    <div className="profile-stat">
                        <strong id="followingCount">{prettifyStat(item.count)}</strong>
                        <span>{item.tag}</span>
                    </div>)

                }
            </div> */}
            <div className="profile-controls">
            <div className="stacked-button">
                <button className="" onClick={handleLogout} id="following"> Logout</button>
            </div>
            <div className="follow-ext-menu-wrapper">
                <div className="follow-ext-menu">
                <div className="follow-ext-menu-inner">
                    <button className="follow-ext-menu-item"><svg viewBox="0 0 512 512" fill="#424242" width="16" title="share">
                        <path d="M503.691 189.836L327.687 37.851C312.281 24.546 288 35.347 288 56.015v80.053C127.371 137.907 0 170.1 0 322.326c0 61.441 39.581 122.309 83.333 154.132 13.653 9.931 33.111-2.533 28.077-18.631C66.066 312.814 132.917 274.316 288 272.085V360c0 20.7 24.3 31.453 39.687 18.164l176.004-152c11.071-9.562 11.086-26.753 0-36.328z" />
                    </svg>Share</button>
                    <button className="follow-ext-menu-item"><svg viewBox="0 0 640 512" fill="#424242" width="16" title="user-slash">
                        <path d="M633.8 458.1L362.3 248.3C412.1 230.7 448 183.8 448 128 448 57.3 390.7 0 320 0c-67.1 0-121.5 51.8-126.9 117.4L45.5 3.4C38.5-2 28.5-.8 23 6.2L3.4 31.4c-5.4 7-4.2 17 2.8 22.4l588.4 454.7c7 5.4 17 4.2 22.5-2.8l19.6-25.3c5.4-6.8 4.1-16.9-2.9-22.3zM96 422.4V464c0 26.5 21.5 48 48 48h350.2L207.4 290.3C144.2 301.3 96 356 96 422.4z" />
                    </svg>Report</button>
                </div>
                </div>
            </div>
            </div>
        </div>
        <div className="profile-body">
            <div className="profile-tabs">
            <button className="profile-tab selected"><svg viewBox="0 0 576 512" width="24" title="images">
                <path d="M480 416v16c0 26.51-21.49 48-48 48H48c-26.51 0-48-21.49-48-48V176c0-26.51 21.49-48 48-48h16v208c0 44.112 35.888 80 80 80h336zm96-80V80c0-26.51-21.49-48-48-48H144c-26.51 0-48 21.49-48 48v256c0 26.51 21.49 48 48 48h384c26.51 0 48-21.49 48-48zM256 128c0 26.51-21.49 48-48 48s-48-21.49-48-48 21.49-48 48-48 48 21.49 48 48zm-96 144l55.515-55.515c4.686-4.686 12.284-4.686 16.971 0L272 256l135.515-135.515c4.686-4.686 12.284-4.686 16.971 0L512 208v112H160v-48z" />
                </svg></button>
            <button className="profile-tab"><svg viewBox="0 0 512 512" width="24" title="th">
                <path d="M149.333 56v80c0 13.255-10.745 24-24 24H24c-13.255 0-24-10.745-24-24V56c0-13.255 10.745-24 24-24h101.333c13.255 0 24 10.745 24 24zm181.334 240v-80c0-13.255-10.745-24-24-24H205.333c-13.255 0-24 10.745-24 24v80c0 13.255 10.745 24 24 24h101.333c13.256 0 24.001-10.745 24.001-24zm32-240v80c0 13.255 10.745 24 24 24H488c13.255 0 24-10.745 24-24V56c0-13.255-10.745-24-24-24H386.667c-13.255 0-24 10.745-24 24zm-32 80V56c0-13.255-10.745-24-24-24H205.333c-13.255 0-24 10.745-24 24v80c0 13.255 10.745 24 24 24h101.333c13.256 0 24.001-10.745 24.001-24zm-205.334 56H24c-13.255 0-24 10.745-24 24v80c0 13.255 10.745 24 24 24h101.333c13.255 0 24-10.745 24-24v-80c0-13.255-10.745-24-24-24zM0 376v80c0 13.255 10.745 24 24 24h101.333c13.255 0 24-10.745 24-24v-80c0-13.255-10.745-24-24-24H24c-13.255 0-24 10.745-24 24zm386.667-56H488c13.255 0 24-10.745 24-24v-80c0-13.255-10.745-24-24-24H386.667c-13.255 0-24 10.745-24 24v80c0 13.255 10.745 24 24 24zm0 160H488c13.255 0 24-10.745 24-24v-80c0-13.255-10.745-24-24-24H386.667c-13.255 0-24 10.745-24 24v80c0 13.255 10.745 24 24 24zM181.333 376v80c0 13.255 10.745 24 24 24h101.333c13.255 0 24-10.745 24-24v-80c0-13.255-10.745-24-24-24H205.333c-13.255 0-24 10.745-24 24z" />
                </svg></button>
            <button className="profile-tab">
                <svg viewBox="0 0 512 512" width="24" title="list">
                <path d="M80 368H16a16 16 0 0 0-16 16v64a16 16 0 0 0 16 16h64a16 16 0 0 0 16-16v-64a16 16 0 0 0-16-16zm0-320H16A16 16 0 0 0 0 64v64a16 16 0 0 0 16 16h64a16 16 0 0 0 16-16V64a16 16 0 0 0-16-16zm0 160H16a16 16 0 0 0-16 16v64a16 16 0 0 0 16 16h64a16 16 0 0 0 16-16v-64a16 16 0 0 0-16-16zm416 176H176a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h320a16 16 0 0 0 16-16v-32a16 16 0 0 0-16-16zm0-320H176a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h320a16 16 0 0 0 16-16V80a16 16 0 0 0-16-16zm0 160H176a16 16 0 0 0-16 16v32a16 16 0 0 0 16 16h320a16 16 0 0 0 16-16v-32a16 16 0 0 0-16-16z" />
                </svg>
            </button>
            </div>
            <div className="profile-body-section">
            {
                user?.pets?
                <>
                { user.pets.map( (item, i) => <img key={i} src={item.imageUrl} width="110" />)} 
                </>
                :
                <>
                <img src="https://images.unsplash.com/photo-1638628281370-2d2b76686a4f?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM4NTAwMQ&ixlib=rb-1.2.1&q=85" width="110" />
                <img src="https://images.unsplash.com/photo-1635110060340-097353a501c6?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM4NTEwMQ&ixlib=rb-1.2.1&q=85" width="110" />
                <img src="https://images.unsplash.com/photo-1639891906817-a24d436359bb?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM4NTAwMQ&ixlib=rb-1.2.1&q=85" width="110" />
                <img src="https://images.unsplash.com/photo-1639433506654-51d94fd9899e?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM4NTE1Nw&ixlib=rb-1.2.1&q=85" width="110" />
                <img src="https://images.unsplash.com/photo-1637781127773-5ce8c6d7638b?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM4NTUzMg&ixlib=rb-1.2.1&q=85" width="110" />
                <img src="https://images.unsplash.com/photo-1639230464573-a1bae9ff0996?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM4NTYyNg&ixlib=rb-1.2.1&q=85" width="110" />
            
                </>
            }
            
            </div>
        </div>
    </div>
    </>
    
  )
}

export default UserPage