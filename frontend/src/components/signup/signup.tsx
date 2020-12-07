import React, { FormEvent } from "react";
import styles from "./signup.module.css";

import axiosInstance from "../../axios-instance";
import { useHistory } from "react-router-dom";

enum PaymentMethod {
  "Debit Card",
  "Credit Card",
  "Bank Transfer",
}

const SignUp = () => {
  const [formValue, setFormValue] = React.useState<{
    name: string;
    email: string;
    password: string;
    paymentMethod: PaymentMethod;
    balance: number;
  }>({
    name: "",
    email: "",
    password: "",
    paymentMethod: PaymentMethod["Debit Card"],
    balance: 0,
  });

  const history = useHistory();

  const onFormSubmit = (e: FormEvent<HTMLElement>) => {
    e.preventDefault();
    console.log(e.target);
    axiosInstance
      .post("/adduser", {
        name: formValue.name,
        email: formValue.email,
        paymentMethod: formValue.paymentMethod,
        balance: formValue.balance,
        password: formValue.password,
      })
      .then((response) => {
        console.log("response: ", response);
        history.push("/", response.data);
      });
  };

  const onChangeName = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormValue((prev) => ({ ...prev, name: e.target.value }));
  };

  const onChangeEmail = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormValue((prev) => ({ ...prev, email: e.target.value }));
  };
  const onChangePassword = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormValue((prev) => ({ ...prev, password: e.target.value }));
  };
  const onChangePaymentMethod = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setFormValue((prev) => ({
      ...prev,
      paymentMethod: (e.target.value as unknown) as PaymentMethod,
    }));
  };

  const onChangeBalance = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormValue((prev) => ({ ...prev, balance: +e.target.value }));
  };

  const options = [];
  for (let method in PaymentMethod) {
    if (isNaN(Number(method))) {
      options.push(
        <option value={method} key={method}>
          {method}
        </option>
      );
    }
  }

  return (
    <div>
      <form className={styles.form} onSubmit={onFormSubmit}>
        <input
          type="text"
          value={formValue.name}
          placeholder="Name"
          onChange={onChangeName}
        />
        <input
          type="email"
          value={formValue.email}
          placeholder="Email"
          onChange={onChangeEmail}
        />
        <input
          type="password"
          value={formValue.password}
          placeholder="password"
          onChange={onChangePassword}
        />
        <label>
          Payment Method
          <select
            value={formValue.paymentMethod}
            onChange={onChangePaymentMethod}
          >
            {options}
          </select>
        </label>
        <input
          type="number"
          value={formValue.balance}
          placeholder="Balance"
          onChange={onChangeBalance}
        />
        <input type="submit" className={styles.button} />
      </form>
    </div>
  );
};

export default SignUp;
