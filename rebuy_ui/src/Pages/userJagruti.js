import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { RiLogoutCircleRLine } from "react-icons/ri";
import { FaUserAlt } from "react-icons/fa";
import { FcApproval } from "react-icons/fc";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
// import UserService from "../Service/UserService";
import "./User.css";

const User = () => {
  const [user, setUser] = useState([]);
  const userid = localStorage.setItem("userid", user.userid);
  localStorage.setItem("mobile", user.mobile);
  const logOut = () => {
    localStorage.clear();
    window.location.reload();
  };

  const getUser = () => {
    var emailID = localStorage.getItem("emailID");
    getUserByEmail(emailID)
      .then((response) => {
        toast.success("Log in successfull");
        setUser(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    getUser();
  }, []);

  return (
    <div className="user">
      <nav class="navbar navbar-expand-sm bg-* ">
        <div className="container-fluid">
          <a class="navbar-brand text-dark " href="/">
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

              {/* <li class="nav-item">
                <a class="nav-link  active" href="/FrontPage"><p className='text-dark'>Back </p></a>
              </li>  */}
              <li class="nav-item">
                <a class="nav-link  active" href="/Updateuser">
                  <p className="text-dark">Update </p>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link  active" href="/">
                  <p className="text-dark" onClick={logOut}>
                    Logout&nbsp;&nbsp;
                    <RiLogoutCircleRLine />
                  </p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <div
        className="card mt-12 p-0 overflow-hidden h-100 shadow me-50"
        style={{ marginLeft: "2rem", marginRight: "2rem" }}
      >
        <div className="card-header text-success ">
          <h1>Profile</h1>
        </div>
      </div>
      {/* style={{marginLeft:'2rem', marginRight:'2rem'}} */}
      <div className="container mt-5 p-0 overflow-hidden h-100 shadow me-5 ">
        <div className="row" style={{ height: "25rem", width: "35rem" }}>
          <div className="col-sm-10">
            <div className="row">
              <div className="col-sm-6">
                <label> Name :</label>
                <h4>
                  {user.firstName} {user.lastName}
                </h4>
              </div>
              <div className="col-lg-6 input-area">
                <label>Email :</label>
                <h4>{user.emailID}</h4>
              </div>
              <div className="col-lg-6 input-area">
                <label>Password :</label>
                <h4>{user.password}</h4>
              </div>
              <div className="col-lg-6 input-area mt-4">
                <label>Mobile Number :</label>
                <h4>{user.mobile}</h4>
              </div>
              {/* <div className="col-lg-6 input-area">
                 <label>Address :</label>
                 <h4>{user.address}</h4>
               </div> */}
              <div className="col-lg-6 input-area ">
                <label>CollegeName:</label>
                <h4>{user.CollegeName}</h4>
              </div>
            </div>
          </div>
          <div className="text-center">
            <button className="btn btn-success me-2" id="signin" type="submit">
              Add Product
            </button>
            <br></br>
            <hr></hr>
          </div>
        </div>
      </div>
      <ToastContainer position="top-center" />
    </div>
  );
};
export default User;
