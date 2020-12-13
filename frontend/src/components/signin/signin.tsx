import React from "react";
import { useHistory } from "react-router-dom";

const SignIn = () => {
  const history = useHistory();

  const signUpButtonHandler = () => {
    history.push("/signup");
  };

  return (
    <div>
      <form>
        <input type="text" value="" placeholder="email" />
        <input type="password" placeholder="password" />
        <label>
          <input type="submit" value="Sign in" />
        </label>
      </form>
      New user ? <button onClick={signUpButtonHandler}>Sign up</button>
    </div>
  );
};

export default SignIn;
