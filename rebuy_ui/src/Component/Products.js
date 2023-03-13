import axios from "axios";
import React, { useEffect, useState } from "react";
import { Button, Card, CardBody, CardImg, CardText, CardTitle } from "reactstrap";
function Products() {
  const [products, setProducts] = useState([]);
  let content = null;
  let productData;

  const getAllProducts = () => {
    const productData = axios
      .get("http://localhost:9000/product/")
      .then((resp) => {
        const allProducts = resp.data;
        setProducts(resp.data);
        localStorage.setItem("products", JSON.stringify(allProducts));
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const getAllProductsFromLocalStorage = () => {
    try {
      const d = localStorage.getItem("products");
      productData = d !== null ? JSON.parse(d) : [];
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getAllProducts();
    getAllProductsFromLocalStorage();
  }, []);

  return (
    <div className="mt-5">
      <Card>
        <CardBody>
          <div className="row justify-content-evenly">
            {products.map((product) => (
              <div className="col-3 col-md-3 col-lg-3 mx-0 mb-4" key={product.id}>
                <div class="shadow p-3 mb-5 bg-white rounded">
                <Card style={{ width: "100%",padding:"20px",margin:"10px" }} className="card p-0 overflow-hidden h-100 shaddow" >
                  <CardImg variant="top" style={{height:"250px"}} src={product.image} className="card-img-top img-fluid"/>
                  <CardBody>
                    <CardTitle>{product.productName}</CardTitle>
                    <CardText>
                        {/* About : {product.description} */}
                        <br/>
                        Price : {product.sellingPrice}
                    </CardText>
                    <Button className="btn btn-warning">Add To Cart </Button>
                  </CardBody>
                </Card>
                </div>
              </div>
            ))}
          </div>
        </CardBody>
      </Card>
    </div>
  );
}
export default Products;
