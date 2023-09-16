import React, { createContext, useReducer } from "react";
import { BrowserRouter, Link, Navigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import Normal from "./NormalApp";
import AdminApp from "./AdminApp";
import 'moment/locale/vi';

export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(
    MyUserReducer,
    cookie.load("user") || null
  );

  return (
    <>
      <MyUserContext.Provider value={[user, dispatch]}>
        <BrowserRouter>
          {user === null ? (
            <Normal />
          ) : user.userRole.id === 1 ? (
            <>
              <AdminApp />
              {/* <Navigate to="/" />; */}
            </>
          ) : (
            <Normal />
          )}
        </BrowserRouter>
      </MyUserContext.Provider>
    </>
  );
};

export default App;
