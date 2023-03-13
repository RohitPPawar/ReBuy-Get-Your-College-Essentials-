import React from "react";

function Footer() {
  return (
    <div className="myFooter">
      <div
        className="container-fluid bg-light "
        id="contact"
        style={{ margin: "0 0px 0px 0px" }}
      >
        <div className="container-fluid">
          <div className="row p-3 ">
            <div className="col-12 col-sm-3 col-md-3 ml-5"></div>

            <div className="col-12 col-sm-6 col-md-2 pr-3">
              <h6 className="text-black text-uppercase ">About Us</h6>
              <p className="mt-2">
                <a href="/service" className="text-black ">
                  Our Services
                </a>
              </p>
              <p className="">
                <a href="/working" className="text-black ">
                  How it works
                </a>
              </p>
              <p className="mt-2">
                <a href="/blog" className="text-black ">
                  Blogs
                </a>
              </p>
            </div>

            <div className="col-12 col-sm-6 col-md-3">
              <h6 className="text-black text-uppercase">CONTACT US</h6>
              <p className="text-black mt-4">
                We provide 24X7 service <br></br>Write any of your query here..!
              </p>
              <p className="mt-2">
                <a
                  href="https://mail.google.com/mail/&ogbl"
                  className="text-black"
                >
                  rebuy@gmail.com
                </a>
              </p>
            </div>

            <div className="col-12 col-sm-6 col-md-2 ">
              <h6 className="text-black text-uppercase">
                SUBSCRIBE TO OUR NEWS
              </h6>
              <div className="col-12 p-0 ">
                <div className="p-0 m-0"></div>
              </div>
            </div>
          </div>
        </div>
        <div className="row ">
          <div class=" col text-black text-center ">
            <p>
              © 2023 All Rights Reserved. Development by{" "}
              <a href="/" className="text-danger">
                Rebuy
              </a>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Footer;
