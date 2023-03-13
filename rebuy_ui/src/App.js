import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./Pages/Home";
import SignUp from "./Component/SignUp";
import AboutUs from "./Pages/AboutUs";
import CustomNavbar from "./Component/CustomNavbar";
import LoginForm from "./Component/LoginForm";
import Admin from "./Component/Admin";
import Products from "./Component/Products";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import User from "./Component/User";
import AddProduct from "./Component/AddProduct";

function App() {
  return (
    <div className="App  ">
      <CustomNavbar />

      <BrowserRouter>
        <ToastContainer />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/Login" element={<LoginForm />}></Route>
          <Route path="/SignUp" element={<SignUp />} />
          <Route path="/AboutUs" element={<AboutUs />} />
          <Route path="/Admin" element={<Admin />} />
          <Route path="/user" element={<User />} />
          <Route path="/addProduct" element={<AddProduct />}></Route>
          <Route path="/Product" element={<Products />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
