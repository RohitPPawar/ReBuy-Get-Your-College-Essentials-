import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import {
  Card,
  CardBody,
  Form,
  FormGroup,
  Label,
  Input,
  Button,
  Container,
  Row,
  Col,
  CardHeader,
} from "reactstrap";

const AddProduct = () => {

  let navigate = useNavigate();

  let d;

  const [productDetails, setProductDetails] = useState({
    productName: "",
    actualPrice: "",
    description: "",
    image: "",
    sellingPrice: "",
    category: "",
    field: "",
    uploadedBy: "",
  });

  const resetData = () => {
    setProductDetails({
      productName: "",
      actualPrice: "",
      description: "",
      image: "",
      sellingPrice: "",
      category: "",
      field: "",
      uploadedBy: "",
    });
  };

  const handleChange = (event, property) => {
    const actualValue = event.target.value;
    setProductDetails({ ...productDetails, [property]: actualValue });
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    if (!productDetails.productName || !productDetails.sellingPrice) {
      toast.error("Please provide a name and price for the product");
      return;
    }

    console.log(productDetails);

    // logic to send data to server

    const response = axios
      .post("http://localhost:9000/product/", productDetails)
      .then((resp) => {
        console.log(resp.data);
        toast.success("Product Added successfully")
        resetData();
        navigate("/user");
      })
      .catch((error) => {
        console.log(error);
        toast.error("somthing went wrong  please try again")
      });
    console.log(productDetails);
  };

  const getUserDataFromLocalStorage = () => {
    try {
      const userData = localStorage.getItem("data");
      d = userData !== null ? JSON.parse(userData) : [];
      setProductDetails({
        uploadedBy: d.id,
      });
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getUserDataFromLocalStorage();
  }, []);

  return (
    <Container style={{ marginTop: 70 }}>
      <Row>
        <Col sm={{ size: 6, offset: 3 }}>
          <Card color="dark" outline>
            <CardHeader>
              <h4 style={{ color: "green" }}>Enter Product Details !!</h4>
            </CardHeader>
            <CardBody>
              <Form onSubmit={handleSubmit}>
                <FormGroup>
                  <Label for="productName">Name:</Label>
                  <Input
                    type="text"
                    id="product_name"
                    value={productDetails.productName}
                    onChange={(e) => handleChange(e, "productName")}
                  />
                </FormGroup>

                <FormGroup>
                  <Label for="actualPrice">Actual Price:</Label>
                  <Input
                    type="number"
                    id="actualPrice"
                    value={productDetails.actualPrice}
                    onChange={(e) => handleChange(e, "actualPrice")}
                  />
                </FormGroup>

                <FormGroup>
                  <Label for="sellingPrice">Selling Price:</Label>
                  <Input
                    type="number"
                    id="sellingPrice"
                    value={productDetails.sellingPrice}
                    onChange={(e) => handleChange(e, "sellingPrice")}
                  />
                </FormGroup>

                <FormGroup>
                  <Label for="category">Category:</Label>
                  <Input
                    type="select"
                    id="category"
                    value={productDetails.category}
                    onChange={(e) => handleChange(e, "category")}
                  >
                    <option disabled value="">
                      Select a category...
                    </option>
                    <option key="book" value="1">
                      Book
                    </option>
                    <option key="instrument" value="2">
                      Instrument
                    </option>
                    <option key="notes" value="1">
                      Notes
                    </option>
                  </Input>
                </FormGroup>

                <FormGroup>
                  <Label for="field">Field:</Label>
                  <Input
                    type="select"
                    id="field"
                    value={productDetails.field}
                    onChange={(e) => handleChange(e, "field")}
                  >
                    <option value="">Select a field...</option>
                    <option key="engineering" value="1">
                      Engineering
                    </option>
                    <option key="pharmacy" value="2">
                      Pharmacy
                    </option>
                    <option key="medical" value="1">
                      Medical
                    </option>
                  </Input>
                </FormGroup>

                <FormGroup>
                  <Label for="image">Image:</Label>
                  <Input
                    type="file"
                    id="image"
                    value={productDetails.image}
                    onChange={(e) => handleChange(e, "image")}
                  />
                </FormGroup>

                <FormGroup row>
                  <Label>Description</Label>
                  <Input
                    type="textarea"
                    value={productDetails.description}
                    onChange={(e) => handleChange(e, "description")}
                    placeholder="Enter product description"
                  />
                </FormGroup>

                <Button color="success" type="submit">
                  Add Product
                </Button>
              </Form>
            </CardBody>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default AddProduct;
