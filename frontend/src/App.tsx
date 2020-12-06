import React from 'react';
import './App.css';

import SignIn from "./components/signin/signin"
import SignUp from "./components/signup/signup"


import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";


function App() {
  return (
    <div className="App">
      <main>
        <Router>
          <Switch>
            <Route path="/signin">
              <SignIn />
            </Route>
            <Route path="/signup">
              <SignUp />
            </Route>
          </Switch>
        </Router>

      </main>
    </div>
  );
}

export default App;
