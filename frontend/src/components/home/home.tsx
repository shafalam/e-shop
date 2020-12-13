import React from "react";
import { useHistory } from "react-router-dom";

import { clientInformationKey } from "../signup/signup";

import { PaymentMethod } from "../signup/signup";

const Home = () => {
  const history = useHistory();

  const clientDetails = history.location.state
    ? (history.location.state as any)[clientInformationKey]
    : undefined;

  console.log(clientDetails);

  if (!clientDetails) {
    history.push("/signin");
  }

  const buyClickHandler = () => {
    history.push("/products", {
      customerId: clientDetails.id,
    });
  };

  return (
    <div>
      {clientDetails ? (
        <div>
          <p>Hello, {clientDetails.name},</p>
          <p>
            Your payment method is: {PaymentMethod[clientDetails.paymentMethod]}
            ,
          </p>
          <p>
            You balance is:
            {clientDetails.balance}
          </p>
          Your Buying history
          <div>
            {clientDetails.buyingHistory.map((each: any, index: number) => {
              return (
                <div key={index}>
                  <p>Product {each.name}</p>
                  Price: {each.price}
                </div>
              );
            })}
          </div>
        </div>
      ) : undefined}

      <button onClick={buyClickHandler}>To buy</button>
    </div>
  );
};

export default Home;
