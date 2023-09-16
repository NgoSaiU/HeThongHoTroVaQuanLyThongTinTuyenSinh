import cookie from "react-cookies";
import React, { useContext, useRef, useState } from "react";
import {
  MDBContainer,
  MDBTabs,
  MDBTabsItem,
  MDBTabsLink,
  MDBTabsContent,
  MDBTabsPane,
  MDBBtn,
  MDBIcon,
  MDBInput,
  MDBCheckbox,
} from "mdb-react-ui-kit";
import { MyUserContext } from "../App";
import { Navigate, useNavigate, useSearchParams } from "react-router-dom";
import Apis, { authApi, endpoints } from "../configs/Apis";
import MySpinner from "../components/MySpinner";

const AppLoginAndRegister = () => {
  const [user, dispatch] = useContext(MyUserContext);
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();

  const [userRegis, setUserRegis] = useState({
    firstName: "",
    lastName: "",
    username: "",
    password: "",
    confirmPass: "",
    email: "",
    phone: "",
  });

  const [loading, setLoading] = useState(false);
  const avatar = useRef();
  let nav = useNavigate();

  const change = (evt, field) => {
    setUserRegis((current) => {
      return { ...current, [field]: evt.target.value };
    });
  };

  const register = (evt) => {
    evt.preventDefault();

    const process = async () => {
      let formData = new FormData();

      for (let field in userRegis)
        if (field !== "confirmPass") formData.append(field, userRegis[field]);

      formData.append("avatar", avatar.current.files[0]);

      setLoading(true);
      let res = await Apis.post(endpoints["user-register"], formData);

      if (res.status === 201) {
        nav("/login");
      }
    };

    if (userRegis.password !== userRegis.confirmPass) {
      // ...
    } else {
      process();
    }
  };

  //Cho thanh đăng nhập là mặc định
  const [justifyActive, setJustifyActive] = useState("tab1");

  const handleJustifyClick = (value) => {
    if (value === justifyActive) {
      return;
    }

    setJustifyActive(value);
  };

  const [q] = useSearchParams();

  const login = (evt) => {
    evt.preventDefault();

    const process = async () => {
      try {
        let res = await Apis.post(endpoints["login"], {
          username: username,
          password: password,
        });
        cookie.save("token", res.data);
        let { data } = await authApi().get(endpoints["current-user"]);
        cookie.save("user", data);
        // console.info(data);

        dispatch({
          type: "login",
          payload: data,
        });
      } catch (err) {
        console.error(err);
      }
    };
    process();
  };

  if (user !== null) {
    let next = q.get("next") || "/";
    return <Navigate to={next} />;
  }

  return (
    <MDBContainer className="p-3 my-5 d-flex flex-column w-50">
      <MDBTabs
        pills
        justify
        className="mb-3 d-flex flex-row justify-content-between"
      >
        <MDBTabsItem>
          <MDBTabsLink
            onClick={() => handleJustifyClick("tab1")}
            active={justifyActive === "tab1"}
          >
            Login
          </MDBTabsLink>
        </MDBTabsItem>
        <MDBTabsItem>
          <MDBTabsLink
            onClick={() => handleJustifyClick("tab2")}
            active={justifyActive === "tab2"}
          >
            Register
          </MDBTabsLink>
        </MDBTabsItem>
      </MDBTabs>

      <MDBTabsContent>
        {/* Đăng nhập */}
        <MDBTabsPane show={justifyActive === "tab1"}>
          <div className="text-center mb-3">
            <p>Sign in with:</p>

            <div
              className="d-flex justify-content-between mx-auto"
              style={{ width: "40%" }}
            >
              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="facebook-f" size="sm" />
              </MDBBtn>

              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="twitter" size="sm" />
              </MDBBtn>

              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="google" size="sm" />
              </MDBBtn>

              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="github" size="sm" />
              </MDBBtn>
            </div>

            <p className="text-center mt-3">or:</p>
          </div>

          <MDBInput
            wrapperClass="mb-4"
            label="Username"
            id="form1"
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Password"
            id="form2"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />

          <div className="d-flex justify-content-between mx-4 mb-4">
            <MDBCheckbox
              name="flexCheck"
              value=""
              id="flexCheckDefault"
              label="Remember me"
            />
            <a href="!#">Forgot password?</a>
          </div>

          <MDBBtn className="mb-4 w-100" type="submit" onClick={login}>
            Sign in
          </MDBBtn>
          <p className="text-center">
            Not a member? <a href="#!">Register</a>
          </p>
        </MDBTabsPane>

        {/* Đăng ký */}
        <MDBTabsPane show={justifyActive === "tab2"}>
          <div className="text-center mb-3">
            <p>Sign un with:</p>

            <div
              className="d-flex justify-content-between mx-auto"
              style={{ width: "40%" }}
            >
              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="facebook-f" size="sm" />
              </MDBBtn>

              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="twitter" size="sm" />
              </MDBBtn>

              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="google" size="sm" />
              </MDBBtn>

              <MDBBtn
                tag="a"
                color="none"
                className="m-1"
                style={{ color: "#1266f1" }}
              >
                <MDBIcon fab icon="github" size="sm" />
              </MDBBtn>
            </div>

            <p className="text-center mt-3">or:</p>
          </div>

          <MDBInput
            wrapperClass="mb-4"
            label="First Name"
            id="form1"
            type="text"
            onChange={(e) => change(e, "firstName")}
            value={userRegis.firstName}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Last Name"
            id="form1"
            type="text"
            value={userRegis.lastName}
            onChange={(e) => change(e, "lastName")}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Email"
            id="form1"
            type="email"
            value={userRegis.email}
            onChange={(e) => change(e, "email")}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Phone"
            id="form1"
            type="tel"
            value={userRegis.phone}
            onChange={(e) => change(e, "phone")}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Username"
            id="form1"
            type="text"
            value={userRegis.username}
            onChange={(e) => change(e, "username")}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Password"
            id="form1"
            type="password"
            value={userRegis.password}
            onChange={(e) => change(e, "password")}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Confirm Password"
            id="form1"
            type="password"
            value={userRegis.confirmPass}
            onChange={(e) => change(e, "confirmPass")}
          />
          <MDBInput
            wrapperClass="mb-4"
            label="Avatar"
            id="form1"
            type="file"
            ref={avatar}
          />

          <div className="d-flex justify-content-center mb-4">
            <MDBCheckbox
              name="flexCheck"
              id="flexCheckDefault"
              label="I have read and agree to the terms"
            />
          </div>
          {loading === true ? (
            <MySpinner />
          ) : (
            <MDBBtn className="mb-4 w-100" onClick={register}>
              Sign up
            </MDBBtn>
          )}
        </MDBTabsPane>
      </MDBTabsContent>
    </MDBContainer>
  );
};

export default AppLoginAndRegister;
