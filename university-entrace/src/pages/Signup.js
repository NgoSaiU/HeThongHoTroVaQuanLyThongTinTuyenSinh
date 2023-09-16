import React, { useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Alert, Button } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../components/MySpinner";

const Signup = () => {
  const [user, setUser] = useState({
    firstName: "",
    lastName: "",
    phone: "",
    email: "",
    username: "",
    password: "",
    confirmPassword: "",
  });
  const [err, setErr] = useState(null);
  const [loading, setLoading] = useState(false);
  const avatar = useRef();
  const nav = useNavigate();

  const register = (evt) => {
    evt.preventDefault();

    const process = async () => {
      let form = new FormData();

      for (let field in user)
        if (field !== "confirmPassword") form.append(field, user[field]);

      form.append("avatar", avatar.current.files[0]);

      setLoading(true);
      let res = await Apis.post(endpoints["register"], form);
      if (res.status === 201) {
        nav("/Login");
      } else setErr("Hệ thống bị lỗi!");
    };

    if (user.password === user.confirmPass) process();
    else {
      setErr("Mật khẩu KHÔNG khớp!");
    }
  };
  const change = (evt, field) => {
    // setUser({...user, [field]: evt.target.value})
    setUser((current) => {
      return { ...current, [field]: evt.target.value };
    });
  };

  return (
    <>
      <div class="form-bg">
        <div class="container">
          <div class="row">
            <div class="col-md-7 col-md-offset-4">
              <div class="form-container form-signup">
                {err === null ? "" : <Alert variant="danger">{err}</Alert>}
                <form onSubmit={register} class="form-horizontal">
                  <table className="table">
                    <tr>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>first name</label>
                          <input
                            class="form-control"
                            type="text"
                            onChange={(e) => change(e, "firstName")}
                            placeholder="Tên"
                            required
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>last name</label>
                          <input
                            class="form-control"
                            type="text"
                            onChange={(e) => change(e, "lastName")}
                            placeholder="Họ và chữ lót"
                            required
                          />
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>phone</label>
                          <input
                            class="form-control"
                            type="text"
                            onChange={(e) => change(e, "phone")}
                            placeholder="Điện thoại"
                          />
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>Username</label>
                          <input
                            class="form-control"
                            value={user.username}
                            onChange={(e) => change(e, "username")}
                            type="text"
                            placeholder="Tên đăng nhập"
                            required
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>email</label>
                          <input
                            class="form-control"
                            type="email"
                            onChange={(e) => change(e, "email")}
                            placeholder="Email"
                          />
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>create password</label>
                          <input
                            class="form-control"
                            value={user.password}
                            onChange={(e) => change(e, "password")}
                            type="password"
                            placeholder="Mật khẩu"
                            required
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>confirm password</label>
                          <input
                            class="form-control"
                            value={user.confirmPass}
                            onChange={(e) => change(e, "confirmPassword")}
                            type="password"
                            placeholder="Xác nhận mật khẩu"
                            required
                          />
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>confirm password</label>
                          <input
                            class="form-control"
                            type="file"
                            ref={avatar}
                          />
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div class="form-check bg-transparent">
                          <input
                            class="form-check-input"
                            type="checkbox"
                            value="accept"
                            id="accept"
                          />
                          <label class="form-check-label" for="">
                            I accept all terms & conditions
                          </label>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td colSpan="2" className="text-lg-center">
                        {loading === true ? (
                          <MySpinner />
                        ) : (
                          <Button variant="info" type="submit">
                            Signup Now
                          </Button>
                        )}
                      </td>
                    </tr>
                    <tr>
                      <td colSpan="2">
                        <div class="form-group mt-4 text-lg-center bg-transparent">
                          Already, have an account?
                          <Link className="link-primary to-signup" to="/login">
                            Login
                          </Link>
                        </div>
                      </td>
                    </tr>
                    <tr className="text-lg-center">
                      <td>
                        <Link
                          class="btn btn-primary btn-lg w-auto btn-icon"
                          href="#!"
                        >
                          <i class="fab fa-facebook-f me-2"></i>Continue with
                          Facebook
                        </Link>
                      </td>
                      <td>
                        <Link
                          class="btn btn-primary btn-lg w-auto btn-icon"
                          href="#!"
                        >
                          <i class="fab fa-google me-2"></i>Continue with Google
                        </Link>
                      </td>
                    </tr>
                  </table>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Signup;
