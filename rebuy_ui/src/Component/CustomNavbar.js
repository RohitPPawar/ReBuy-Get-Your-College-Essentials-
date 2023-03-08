import React from 'react'
import { NavLink, NavLink as ReactLink} from 'react-router-dom'
import Product from '../Pages/Products'
import { props} from 'react'
export default function CustomNavbar(props) {
  return (
    <div>
  
  <nav className="navbar navbar-expand-sm navbar-light bg-dark fixed-top navbar-expand-lg " tag='ReactLink'>

<div className="container-fluid">
  
  <a className="navbar-brand text-light " href="#" id='logo'>
   Re-buy it</a>
<button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
  <span className="navbar-toggler-icon"></span>
</button>
<div className="collapse navbar-collapse" id="navbarSupportedContent">
  <ul className="navbar-nav ms-auto mb-2 mb-lg-0 ">

  <li className="nav-item" >
      <a className="nav-link  active  text-light" href="/">Home</a>
    </li>
    <li className="nav-item">
      <a className="nav-link  active text-light" href="/Product">Product</a>
    </li>
    <li className="nav-item">
      <a className="nav-link  active  text-light" onClick={props.login} href="/Login">Login</a>
    </li>
    <li className="nav-item">
      <a className="nav-link  active text-light" href="/SignUp">Sign Up</a>
    </li>
  
    {/* <li className="nav-item">
      <a className="nav-link  active text-light" href="/RegisterUser">Register User</a>
    </li> */}
    <li className="nav-item">
      <a className="nav-link active text-light" href="/Admin">Admin</a>
    </li>
    <li className="nav-item">
      <a className="nav-link active text-light" href="/AboutUs">About Us</a>
    </li>
    <li> 
      <span class="material-symbols-outlined">
           shopping_cart</span>
    </li>
    <li className="nav-item">
      <a className="nav-link active text-light" href="/Cart"><span class="material-symbols-outlined">
           shopping_cart</span></a>
    </li>
  </ul>
</div>
</div>
</nav>
</div>

  )
}
