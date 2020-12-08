import React, { useState } from "react";

import axiosInstance from "../../axios-instance";

const Products = () => {
  const [products, setProducts] = useState<{}>();

  React.useEffect(() => {
    axiosInstance.get("/products").then((response) => {
      console.log(response);
      setProducts(response.data);
    });
  }, []);

  console.log(products);
  return <div>Products</div>;
};

export default Products;
