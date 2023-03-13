import React from "react";
import Footer from "./Footer";

const AboutUs = () => {
  return (
    <div className="text-center " style={{ marginTop: "100px" }}>
      <div className="about">
        {/* <h1 className='fw-bold text-primary mt-5'>About Us</h1> */}
      </div>
      <div className="container">
        <div className="row">
          <div className="col-12 sm-5 ">
            <pre
              class="text-black"
              style={{ fontSize: 20 , backgroundColor:" #b8b0b0" ,opacity:"70%"}}
              className="p-3   text-dark "
            >
              This web application will provide a common platform for any<br/>
              teacher or student from any educational background to buy or sell
              any kind of study material.<br/> This will ensure reusability of a
              product.<br/> The project functionalities are <br/>
              1)Role-based authentication.<br/> 
              2)Admin will analyze the product, verify the user and payment activity. <br/>
              3) Users can buy as well as sell any educational product. <br/>
              This project is built on spring boot, react
              and MySQL technologies.<br/> In the future, this application will be
              run by a community of students,<br/> so that they can learn as well as
              earn.
            </pre>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};
export default AboutUs;
