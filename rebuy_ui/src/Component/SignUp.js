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

const SignUp = () => {
  const navigate = useNavigate();

  const [data, setData] = useState({
    firstName: "",
    lastName: "",
    emailId: "",
    password: "",
    collegeName: "",
  });

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

  // code for get all student
  // const getAll = () => {
  //   getAllUser().then((resp) => {
  //     console.log("all User");
  //     console.log(resp);
  //   });
  // };

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
