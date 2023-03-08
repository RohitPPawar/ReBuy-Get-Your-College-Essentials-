import React from "react";
import { useParams } from "react-router-dom";
import { useState } from "react";
import { Link } from "react-router-dom";
import CustomNavbar from "./CustomNavbar";
import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  Form,
  FormGroup,
  Input,
  Label,
  Row,
} from "reactstrap";

const LoginForm = () => {
  const { Userid } = useParams();

  console.log(Userid);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");


  return (
    <>
      <Container style={{ marginTop: 60 }}>
        <Row>
          <Col sm={{ size: 5, offset: 3 }}>
            <Card color="dark" outline >
              <CardHeader>
                <h4 style={{ color: "green" }}>Login!!</h4>
              </CardHeader>

              <CardBody>
                {/* form creation */}

                <Form>
                  <FormGroup>
                    <Label for="email">Email</Label>
                    <Input
                      type="email"
                      placeholder="Enter Email"
                      id="email"
                    ></Input>
                  </FormGroup>

                  <FormGroup>
                    <Label for="password">Password</Label>
                    <Input
                      type="password"
                      placeholder="Enter Password"
                      id="password"
                    ></Input>
                  </FormGroup>
                </Form>
                <Container>
                  <Button color="success">Login</Button>
                  <Link className="btn btn-warning ms-2" to={"/SignUp"}>
                    Register
                  </Link>
                </Container>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
};

export default LoginForm;
