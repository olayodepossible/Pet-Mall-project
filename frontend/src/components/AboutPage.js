import React from 'react'
import { useNavigate } from 'react-router-dom'
import "../styles/About.css"


const AboutPage = () => {

    const history = useNavigate();

  return (
    <div>
        <div>
                <img
                    onClick={(e) => {e.preventDefault(); return history("/pet-mall")}}
                    className="nav__logo"
                    src="/pet-mall-logo.jpg"
                    alt="logo"
                />

                <p>
                    <span style={{margin: "18px 0 0 100px"}}  className="nav__title">ALX-PET-MALL</span>
                </p>
        </div>

        

        <main id="home" className="profile-wrapper" style={{width: "70vw"}}>
            <h4 className="lg-heading"> <span className="text-secondary">About Page</span></h4>
            <h1 className="lg-heading">
                Akinfemiwa <span className="text-secondary">Abayomi</span>
            </h1>
            <h2 className="sm-heading">
                Software Engineer, Web Developer & Enterpreneur
            </h2>
            <p style={{lineHeight: "25px", textAlign: "justify"}}>
            This Product is an E-commerce service that look into another part of the world of product and services (The Pet Business) not yet popular in Africa and probably some Asian Continent.
            It aim to automate the process of buying and selling of everything that has to do with Animal (Pet), ranging from getting access to them, their storage, menu, and medical care.
            The product target all users (Pet-owner, Enterpreneur, Vet-Doctors), in order to make services available at cheaper rate, easy accessibility, open up competiton by presenting diverse choice to customer to choose from, and make good choices.
            It is an idea brought to reality through a <b>Portfolio Project for Holberton School.</b>
            </p>
            
            <div className="icon">
                <a href="https://github.com/olayodepossible/Pet-Mall-project" target="_blank">
                <img src="/asset/github.png" alt="avatar"/>
                </a>
                
                <a
                href="https://www.linkedin.com/in/olayodeakinfemiwa-
                027979186/"
                target="_blank"
                >
                <img src="/asset/linkedin.png" alt="avatar"/>
                </a>
                <a href="https://twitter.com/Com__Possible" target="_blank">
                <img  src="/asset/twitter-sign.png" alt="avatar"/>
                </a>
            </div>
        </main>
    </div>
  )
}

export default AboutPage