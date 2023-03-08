<<<<<<< HEAD
import React, { useEffect } from "react";
import { useState } from "react";
import "../Pages/Home";
import { Navigate, useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
// import "react-toastify/dist/ReactToastify.css";
import { getAllUser, signUp } from "../Services/User_service";
import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Form,
  FormFeedback,
  FormGroup,
  Input,
  Label,
  Row,
} from "reactstrap";

// const navigate = useNavigate();
=======
import React from 'react'
import { useState } from 'react'
// import RegisterService from '../Services/RegisterService'
import customNavbar from './CustomNavbar';
import '../Pages/Home';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import userEvent from '@testing-library/user-event';
>>>>>>> f2b99fb952d47deab7262c3033bf13bac78e6f38

const SignUp = () => {
  const navigate = useNavigate();

<<<<<<< HEAD
  const [data, setData] = useState({
    firstName: "",
    lastName: "",
    emailId: "",
    password: "",
    collegeName: "",
  });
=======
    const [message, setMessage] = useState("");
    const navigate=useNavigate();
    const [register, setRegister] = useState({
        FirstName: "",
        LastName: "",
        Email: "",
        Password: "",
        Mobile: "",
        CollegeName:"",
        Address: "",
>>>>>>> f2b99fb952d47deab7262c3033bf13bac78e6f38

  // //   to print data on console
  //   useEffect(() => {
  //     console.log(data);
  //   }, [data]);

  const [error, setError] = useState({
    errors: {},
    isError: false,
  });

  // handle change
  const handleChange = (event, property) => {
    setData({ ...data, [property]: event.target.value });
  };

<<<<<<< HEAD
  //reseting the form
  const resetData = () => {
    setData({
      firstName: "",
      lastName: "",
      emailId: "",
      password: "",
      collegeName: "",
    });
  };

  //   sumbmiting the form

  const submitForm = (event) => {
    event.preventDefault();

    console.log(data);

    if (data.firstName.length === 0) {
      toast.error("Please enter Firstname");
    } else if (data.lastName.length === 0) {
      toast.error("Please enter lastName");
    } else if (data.emailId.length === 0) {
      toast.error("Please enter email");
    } else if (data.password.length === 0) {
      toast.error("Please enter password");
    } else if (data.collegeName.length === 0) {
      toast.error("Please enter Clg name");
    } else {
      //call server api to add user

      signUp(data)
        .then((resp) => {
          console.log(resp);
          resetData();
          console.log("success log");
          toast.success("User registerd sucessfully with id " + resp.id);
          navigate("/login");
=======

    const saveRegister=(e)=>{
                        if(userEvent.address.length===0){}

    }

    const handleReset=()=>{
        setRegister({
            FirstName: "",
            LastName: "",
            Email: "",
            Password: "",
            Mobile: "",
            CollegeName:"",
            Address: "",
    
>>>>>>> f2b99fb952d47deab7262c3033bf13bac78e6f38
        })
        .catch((e) => {
          console.log(e);
          console.log("error log");
          //error handling
          setError({
            errors: e,
            isError: true,
          });
        });
    }
  };

<<<<<<< HEAD
  // code for get all student
  // const getAll = () => {
  //   getAllUser().then((resp) => {
  //     console.log("all User");
  //     console.log(resp);
  //   });
  // };
=======
    const registerUser = (e) => {
        if(register.FirstName.length===0){toast.error("Please enter Firstname")}
        else if(register.LastName.length===0){ toast.error("Please enter lastName")}
        else if(register.Email.length===0){toast.error("Please enter email")}
        else if(register.Password.length===0){toast.error("Please enter password")}
        else if(register.Mobile.length===0){toast.error("Please enter mobile")}
        else if(register.CollegeName.length===0){toast.error("Please enter Clg name")}
    //     else{
    //     RegisterService.addUser(register)
    //         .then(response => {
    //              setMessage("Register Successfull.")
    //             //  localStorage.setItem("id",response.data.id)
    //             sessionStorage.setItem("id",response.data.value)
    //              navigate("/Service")
    //             })
    //         .catch(error => { console.log(error) })
    // }
    
}
    return (
        <div className='base'>
            <customNavbar/>
            <div className="container mt-3">
                <div className="row">
                    <div className="col-md-4  offset-md-4 mt-5">
                        <div className="card mt-5">
                            <div className="card-header text-center fs-3 text-success">Sign Up
                                {
                                    message && <p className='text-success'>{message}</p>
                                }
                            </div>
                            <div className="card-body">
                                {/* <div className="mb-2 ">
                                    <label>FirstName</label>
                                    <input type="text" className='form-control' name='firstname'
                                        value={register.FirstName} onChange={(e) => handleChange(e)} />
                                </div> */}
                               

                            <div className='mb-2'> <lable>FirstName</lable>
                            <input type ='text' className='form-control  name =firstname' ></input>
                            </div>
                               

                                <div className="mb-2">
                                    <label>LastName</label>
                                    <input type="text" className='form-control' name='lastname'
                                        value={register.surname} onChange={(e) => handleChange(e)} />
                                </div>
                                <div className="mb-2">
                                    <label>Email</label>
                                    <input type="email" className='form-control' name='email'
                                        value={register.email} onChange={(e) => handleChange(e)} />
                                </div>
                                <div className="mb-2">
                                    <label>Password</label>
                                    <input type="password" className='form-control' name='password'
                                        value={register.password} onChange={(e) => handleChange(e)} />
                                </div>
                                <div className="mb-3">
                                    <label>Confirm Password</label>
                                    <input type="password" className='form-control' name='cpassword' />
                                </div>
                               
                                <div className="mb-2" h>
                                    <label>CollegeName</label>
                                    <input type="text" className='form-control' name='ClgName'
                                        />
                                </div>
                                {/* value={register.CollegeName} onChange={(e) => handleChange(e)} */}

                                
                                <div className="text-center">
                                    <button className='btn btn-success me-2' onClick={registerUser}>RegisterUser</button>
                                    <button type='reset' className="btn btn-danger me-2" onClick={handleReset} >Reset</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <ToastContainer position="top-center"/>
        </div>
>>>>>>> f2b99fb952d47deab7262c3033bf13bac78e6f38

  return (
    <>
      <Container style={{ marginTop: 60 }}>
        <Row>
          {/* {JSON.stringify(data)}    */}

          <Col sm={{ size: 6, offset: 3 }}>
            <Card color="dark" outline>
              <CardHeader>
                <h4 style={{ color: "green" }}>Register Here!!</h4>
              </CardHeader>

              <CardBody>
                {/* form creation */}

                <Form onSubmit={submitForm}>
                  <FormGroup>
                    <Label for="firstName">FirstName</Label>
                    <Input
                      type="text"
                      placeholder="Enter FirstName"
                      id="firstName"
                      onChange={(e) => handleChange(e, "firstName")}
                      value={data.firstName}
                      // invalid={
                      //   error.errors.reponse?.data?.firstName ? true : false
                      // }
                    ></Input>
                    {/* <FormFeedback>
                      {error.errors.response?.data?.firstName}
                    </FormFeedback> */}
                  </FormGroup>

                  <FormGroup>
                    <Label for="lastName">LastName</Label>
                    <Input
                      type="text"
                      placeholder="Enter LastName"
                      id="lastName"
                      onChange={(e) => handleChange(e, "lastName")}
                      value={data.lastName}
                    ></Input>
                  </FormGroup>

                  <FormGroup>
                    <Label for="email">Email</Label>
                    <Input
                      type="email"
                      placeholder="Enter Email"
                      id="emailId"
                      onChange={(e) => handleChange(e, "emailId")}
                      value={data.emailId}
                    ></Input>
                  </FormGroup>

                  <FormGroup>
                    <Label for="password">Password</Label>
                    <Input
                      type="password"
                      placeholder="Enter Password"
                      id="password"
                      onChange={(e) => handleChange(e, "password")}
                      value={data.password}
                    ></Input>
                  </FormGroup>

                  <FormGroup>
                    <Label for="clgName">College Name</Label>
                    <Input
                      type="text"
                      placeholder="Enter College Name"
                      id="collegeName"
                      onChange={(e) => handleChange(e, "collegeName")}
                      value={data.collegeName}
                    ></Input>
                  </FormGroup>
                </Form>
                <Container>
                  <Button
                    outline
                    type="submit"
                    color="success"
                    onClick={submitForm}
                  >
                    Register
                  </Button>
                  <Button
                    outline
                    color="danger"
                    className="ms-2"
                    onClick={resetData}
                  >
                    Reset
                  </Button>
                </Container>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
};

export default SignUp;
