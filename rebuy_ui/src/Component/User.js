import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { RiLogoutCircleRLine } from "react-icons/ri";
import { FaUserAlt } from "react-icons/fa";
import { FcApproval } from "react-icons/fc";
import { json, Link, useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "./User.css";
import UserService from "../Services/UserService";
import { Button } from "reactstrap";
import AddProduct from "./AddProduct";
import Table from "reactstrap";
const User = () => {
  let navigate = useNavigate();

  const [user, setUser] = useState([]);
  let d;

  const getUserDataFromLocalStorage = () => {
    try {
      const userData = localStorage.getItem("data");
      d = userData !== null ? JSON.parse(userData) : [];
      setUser(d);
      console.log(user);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getUserDataFromLocalStorage();
  }, []);

  const addProductClicked = () => {
    navigate("/addProduct");
  };

  const logout = () => {
    console.log("logout");
  };

  return (
    <div className="user ">
      <nav class="navbar navbar-expand-sm bg-*">
        <div className="container-fluid mb-5 mt-5">
          <a class="navbar-brand text-dark  " href="/">
            Re-Buy it
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
                <a class="nav-link  active" href="/User">
                  <p className="text-dark fw-bold">
                    <FaUserAlt />
                    &nbsp;&nbsp;{user.firstName} <FcApproval />
                  </p>
                </a>
              </li>

              <li class="nav-item">
                <a class="nav-link  active" href="/Updateuser">
                  <p className="text-dark">Update </p>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link  active" href="/">
                  <p className="text-dark" />
                  <p className="text-dark">
                    Logout
                    <RiLogoutCircleRLine />
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div>
        <div
          className="card mt-12 p-0 overflow-hidden h-100 shadow me-50"
          style={{ marginLeft: "2rem", marginRight: "2rem" }}
        >
          <div className="card-header text-success ">
            <h1>Profile</h1>
          </div>
        </div>
        <div className="container mt-5 p-0 overflow-hidden h-100 shadow me-5 ">
          <div className="row" style={{ height: "25rem", width: "60rem" }}>
            <div className="col-sm-10">
              <div className="row" style={{ marginLeft: "10rem" }}>
                <br />
                <div class="labels">
                  <div class="label-item">
                    <label>Name:</label>
                    <span>
                      {user.firstName} {user.lastName}
                    </span>
                  </div>
                  <div class="label-item">
                    <label>Email:</label>
                    <span>{user.emailId}</span>
                  </div>
                  <div class="label-item">
                    <label>College Name:</label>
                    <span>{user.collegeName}</span>
                  </div>
                </div>

                <br />

                <div>
                  <div className="button-container">
                    <Button
                      style={{ marginLeft: "17rem" }}
                      className="btn-success"
                    >
                      MobileNo
                    </Button>
                    &nbsp; &nbsp;
                    <Button
                      className="btn btn-success "
                      onClick={addProductClicked}
                    >
                      Add Product
                    </Button>
                    &nbsp; &nbsp;{" "}
                    <Button className="btn btn-success">Address</Button>
                  </div>
                </div>
              </div>
              <ToastContainer position="top-center" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default User;
