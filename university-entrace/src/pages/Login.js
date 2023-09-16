import cookie from "react-cookies";
import React, { useContext, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Button from "react-bootstrap/esm/Button";
import { MyUserContext } from "../App";
import { Navigate, useSearchParams } from "react-router-dom";
import Apis, { authApi, endpoints } from "../configs/Apis";

const Login = () => {
  const [user, dispatch] = useContext(MyUserContext);
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();

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

        const role1 = data.userRole.name; //lay role của user

        console.log(role1);

        // console.info(data); //xuat thong tin user

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
    let next = q.get("next") || "/"; //dang nhap thanh cong sẽ chuyển sang trang home
    return <Navigate to={next} />;
  }

  return (
    <>
      <div class="form-bg">
        <div class="container">
          <div class="row">
            <div class="col-md-4 col-md-offset-4">
              <div class="form-container">
                <div class="form-icon">
                  <i class="fa fa-user"></i>
                </div>
                <h3 class="title">Login</h3>
                <form class="form-horizontal">
                  <div class="form-group">
                    <label>email</label>
                    <input
                      class="form-control"
                      type="email"
                      placeholder="email address"
                      value={username}
                      onChange={(e) => setUsername(e.target.value)}
                    />
                  </div>
                  <div class="form-group">
                    <label>password</label>
                    <input
                      class="form-control"
                      type="password"
                      placeholder="password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                    />
                  </div>
                  <div class="form-check bg-transparent">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      value="accept"
                      id="accept"
                    />
                    <label
                      class="form-check-label"
                      for=""
                      name="flexCheck"
                      value=""
                      id="flexCheckDefault"
                    >
                      Remember me
                    </label>
                  </div>
                  <Button type="submit" class="btn btn-default" onClick={login}>
                    Login
                  </Button>
                  <div class="form-group mt-4 text-lg-center">
                    Don't have an account?
                    <Link className="link-primary to-signup" to="/signup2">
                      Signup
                    </Link>
                  </div>
                  <div className="">
                    <Link class="btn btn-primary btn-lg btn-block" href="#!">
                      <i class="fab fa-facebook-f me-2"></i>Continue with
                      Facebook
                    </Link>
                    <Link
                      class="btn btn-primary btn-lg btn-block mt-2"
                      href="#!"
                    >
                      <i class="fab fa-google me-2"></i>Continue with Google
                    </Link>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
