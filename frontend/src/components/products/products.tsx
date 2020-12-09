import React, { useState } from "react";
import { useHistory } from "react-router-dom";

import axiosInstance from "../../axios-instance";
import { Product } from "../../types/product";
import { clientInformationKey } from "../signup/signup";

const Products = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [customerId, setCustomerId] = useState<number>(Number.MAX_VALUE);

  const history = useHistory();

  const onBuyClickHandler = (productId: number) => {
    axiosInstance
      .get("/buy", {
        params: {
          product_id: productId,
          customer_id: customerId,
        },
      })
      .then((response) => {
        console.log("response: ", response);
        history.push("/", { [clientInformationKey]: response.data });
      });
  };

  React.useEffect(() => {
    const customerIdFromState = history.location.state
      ? (history.location.state as any)["customerId"]
      : undefined;
    setCustomerId(customerIdFromState);

    axiosInstance.get("/products").then((response) => {
      console.log(response);
      setProducts(response.data);
    });
  }, []);

  console.log(products);
  console.log("customer id: ", customerId);
  return (
    <div>
      {products.map((eachProduct, index) => {
        return (
          <div key={index}>
            {eachProduct.name} {eachProduct.description} Price:{" "}
            {eachProduct.price}{" "}
            <button onClick={() => onBuyClickHandler(eachProduct.id)}>
              To buy
            </button>
          </div>
        );
      })}
    </div>
  );
};

export default Products;
