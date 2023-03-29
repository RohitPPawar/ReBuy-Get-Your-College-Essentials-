import React from "react";

function productCard(props) {
  return (
    <div className="border mb-4 rounded overflow-hidden">
      <div
        className="card border mb-4 rounded overflow-hidden"
        style="width: 18rem;"
      >
        <img
          className="card-img-top"
          src="F:/Cdac/Projects/ReBuy/rebuy_backend/images/IMG_20220520_195215.jpg"
          alt="Card image cap"
        />
        <div className="card-body">
          <h5 className="card-title">{props.products.productName}</h5>
          <p className="card-text">{props.products.description}</p>
          <a href="#" className="btn btn-primary">
            add to cart
          </a>
        </div>
      </div>
    </div>
  );
}
export default productCard;
