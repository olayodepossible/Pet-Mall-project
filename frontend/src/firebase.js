import { initializeApp } from "firebase/app";
import { getAuth, signInWithEmailAndPassword, createUserWithEmailAndPassword } from "firebase/auth";
import { getFirestore } from "firebase/firestore";

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyDa0SP-9MhRonhjpRWNIlqLEvLeGuAo65s",
  authDomain: "netflix-clone-54781.firebaseapp.com",
  projectId: "netflix-clone-54781",
  storageBucket: "netflix-clone-54781.appspot.com",
  messagingSenderId: "739026699504",
  appId: "1:739026699504:web:97a581fb795e66f00dee35",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const db = getFirestore(app);
export const auth = getAuth();
export const fireStoreSignUp = (email, password) => {
  createUserWithEmailAndPassword(auth, email, password)
    .then((authUser) => authUser.user)
    .catch((error) => alert(error.message));
};

export const fireStoreSignIn = (email, password) => {
  signInWithEmailAndPassword(auth, email, password)
    .then((authUser) => authUser.user)
    .catch((error) => alert(error.message));
};

export default db;
