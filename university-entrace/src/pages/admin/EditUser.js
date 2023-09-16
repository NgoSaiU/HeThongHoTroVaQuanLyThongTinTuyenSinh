import React, { useEffect, useRef, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import Apis, { endpoints } from "../../configs/Apis";

const EditUser = () => {
  const { userId } = useParams();
  const [user, setUser] = useState(null);
  const [checked, setChecked] = useState(false);

  const enable = (evt) => {
    setChecked(!checked);
  };

  useEffect(() => {
    const loadDpm = async () => {
      if (userId !== undefined) {
        let e = endpoints["users"];
        e = `${e}?userid=${userId}`;
        let res = await Apis.get(e);
        setUser(res.data[0]);
        setChecked(Boolean(res.data[0].active));
      }
    };
    loadDpm();
  }, [userId]);
  const [users, setUsers] = useState({
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
    confirmPass: "",
  });
  const [err, setErr] = useState(null);
  const [loading, setLoading] = useState(false);
  const avatar = useRef();
  const nav = useNavigate();

  const register = (evt) => {
    evt.preventDefault();

    if (userId !== undefined) {
      nav("/useradmin");
    } else {
      const process = async () => {
        let form = new FormData();

        for (let field in users)
          if (field !== "confirmPass") form.append(field, users[field]);

        form.append("avatar", avatar.current.files[0]);

        setLoading(true);
        let res = await Apis.post(endpoints["register"], form);
        if (res.status === 201) {
          nav("/useradmin");
        } else setErr("Hệ thống bị lỗi!");
      };

      if (users.password === users.confirmPass) process();
      else {
        setErr("Mật khẩu KHÔNG khớp!");
      }
    }
  };

  const change = (evt, field) => {
    // setUser({...user, [field]: evt.target.value})
    setUsers((current) => {
      return { ...current, [field]: evt.target.value };
    });
  };
  return (
    <>
      <main className="main-container sm">
        <form onSubmit={register}>
          <div class="mb-3">
            <label for="username" class="form-label">
              Username
            </label>
            <input
              type="text"
              class="form-control"
              id="username"
              name="username"
              defaultValue={user ? user.username : ""}
              onChange={(e) => change(e, "username")}
            />
          </div>
          <div class="mb-3">
            <label for="firstName" class="form-label">
              First Name
            </label>
            <input
              type="text"
              class="form-control"
              id="firstName"
              name="firstName"
              defaultValue={user ? user.firstName : ""}
              onChange={(e) => change(e, "firstName")}
            />
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">
              Last Name
            </label>
            <input
              type="text"
              class="form-control"
              id="lastName"
              name="lastName"
              defaultValue={user ? user.lastName : ""}
              onChange={(e) => change(e, "lastName")}
            />
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">
              Email
            </label>
            <input
              type="text"
              class="form-control"
              id="email"
              name="email"
              defaultValue={user ? user.email : ""}
              onChange={(e) => change(e, "email")}
            />
          </div>
          <div class="mb-3">
            <label for="phone" class="form-label">
              Phone
            </label>
            <input
              type="Phone"
              class="form-control"
              id="firstName"
              name="firstName"
              defaultValue={user ? user.phone : ""}
              onChange={(e) => change(e, "phone")}
            />
          </div>
          <div class="mb-3">
            <label for="phone" class="form-label">
              Password
            </label>
            <input
              type="text"
              class="form-control"
              id="password"
              name="password"
              defaultValue={user ? user.password : ""}
            />
          </div>
          <div class="mb-3">
            <label for="avatar" class="form-label">
              Avatar
            </label>
            <input
              type="file"
              class="form-control"
              id="avatar"
              name="avatar"
              // ref={user ? user.avatar : ""}
              ref={avatar}
            />
          </div>
          <div class="form-check form-switch">
            <input
              class="form-check-input"
              type="checkbox"
              role="switch"
              id="active"
              name="active"
              onClick={enable}
              checked={checked}
            />
            <label class="form-check-label" for="status">
              Active
            </label>
          </div>
          <div>
            <button type="submit" className="btn btn-primary">
              Submit
            </button>
          </div>
        </form>
      </main>
    </>
  );
};

export default EditUser;
