import React, { useRef } from "react";
import { useDispatch } from "react-redux";
import "../styles/SignUpPage.css";
import { useNavigate } from "react-router-dom";
import { postPetMallData } from "../adapter/Axio";
import { signUpData } from "../features/user/userSlice";

const SignUpPage = ({showLogin, setShowLogin, setEmail, setIsLogin}) => {
  const dispatch = useDispatch();

  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  const usernameRef = useRef(null);
  const firstNameRef = useRef(null); 
  const lastNameRef = useRef(null); 
  const addressRef = useRef(null); 
  const cityRef = useRef(null);
  const countryRef = useRef(null);
  const userTypeRef = useRef(null); 
  const specialtyRef = useRef(null);
  const uploadedImage = useRef(null);
  const imageUploader = useRef(null);

  const history = useNavigate();

  const handleRegister = async (e) => {
    e.preventDefault();
    const data = {
      "address": addressRef.current.value,
      "city": cityRef.current.value,
      "country": countryRef.current.value,
      "email": emailRef.current.value,
      "firstName": firstNameRef.current.value,
      "lastName": lastNameRef.current.value,
      "password": passwordRef.current.value,
      "profileImage": "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?crop=entropy&cs=srgb&fm=jpg&ixid=MnwxNDU4OXwwfDF8cmFuZG9tfHx8fHx8fHx8MTY0MDM2ODA0NA&ixlib=rb-1.2.1&q=85",
      "specialty": specialtyRef.current.value,
      "userType": userTypeRef.current.value,
      "username": usernameRef.current.value
    }
    
    try {
      const resp = await postPetMallData(`users/register`, data);
      dispatch(signUpData(resp.data)) 
      setIsLogin(true)
      history("/pet-mall/profile")
    } catch (error) {
      console.log('error', error)
      history("/pet-mall")
    }
  };

  

  // const handleImageUpload = e => {
  //   const file = e.target.files[0].getAsDataURL();
  //   // profileImage
  //   const reader = new FileReader();
  //   if (file) {
  //     // const { current } = uploadedImage;
  //     // current.file = file;
  //     reader.onload = e => {
  //       // current.src = e.target.result;
  //       // console.log('reader.readAsDataURL(file)', e.target.result)
  //     };
  //     reader.readAsArrayBuffer(file);
  //     // reader.readAsDataURL(file);
  //   }
  //   console.log('readAsDataURL(file)', file)
    
  // };


  return (
    <div className="signupPage">
      <form>
        <h1>Sign In</h1>
        <input type="text" placeholder="Username" ref={usernameRef} />
        <input type="text" placeholder="First Name" ref={firstNameRef} />
        <input type="text" placeholder="Last Name" ref={lastNameRef} />
        <input type="email" placeholder="Email" ref={emailRef} />
        <input type="password" placeholder="Password" ref={passwordRef} />
        <input type="text" placeholder="Address" ref={addressRef} />
        <input type="text" placeholder="City" ref={cityRef} />
        <select type="text" placeholder="Country" ref={countryRef} >
          <option> Select Country</option>
          <option value="USA">USA</option>
          <option value="Kenya">Kenya</option>
          <option value="UK">UK</option>
          <option value="Nigeria">Nigeria</option>
        </select>
      
        <select type="text" placeholder="Customer" ref={userTypeRef} >
          <option> Select Type</option>
          <option value="client">Customer</option>
          <option value="store_owner">Store Owner</option>
          <option value="vet">Doctor</option>
        </select>
        {/* <input id="photo-upload" type="file" ref={imageUploader} onChange={handleImageUpload} multiple={false} />  */}
        <input type="text" placeholder="Specialty" ref={specialtyRef} />
        <button type="submit" onClick={handleRegister}> Register</button>

      </form>
      
    </div>
  );
};

export default SignUpPage;
