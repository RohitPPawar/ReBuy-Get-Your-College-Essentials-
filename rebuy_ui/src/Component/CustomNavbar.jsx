import React from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
} from "reactstrap";

export default function CustomNavbar() {
  return (
    <div>
      <nav class="navbar navbar-expand-sm navbar-light bg-dark fixed-top navbar-expand-lg ">
        <div class="container-fluid">
          <a className="navbar-brand text-light " href="/home" id="logo">
            Re-buy
          </a>

          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0 ">
              <li class="nav-item">
                <a class="nav-link  active  text-light" href="/">
                  Home
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link  active  text-light" href="/Login">
                  Login
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link  active text-light" href="/SignUp">
                  Sign Up
                </a>
              </li>

              {/* <li class="nav-item">
      <a class="nav-link  active text-light" href="/RegisterUser">Register User</a>
    </li> */}
              <li class="nav-item">
                <a class="nav-link active text-light" href="/Admin">
                  Admin
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link active text-light" href="/AboutUs">
                  About Us
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
}
