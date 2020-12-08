import React from "react";
import "./App.css";

import SignIn from "./components/signin/signin";
import SignUp from "./components/signup/signup";
import Home from "./components/home/home";
import Products from "./components/products/products";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <main>
        <Router>
          <Switch>
            <Route path="/" exact>
              <Home />
            </Route>
            <Route path="/signin">
              <SignIn />
            </Route>
            <Route path="/signup">
              <SignUp />
            </Route>
            <Route path="/products">
              <Products />
            </Route>
          </Switch>
        </Router>
      </main>
    </div>
  );
}

export default App;
