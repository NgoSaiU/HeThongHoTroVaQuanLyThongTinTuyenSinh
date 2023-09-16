import { useRef, useState } from "react";
import { Alert, Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../components/MySpinner";

const Signup2 = () => {
  const [user, setUser] = useState({
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

    const process = async () => {
      let form = new FormData();

      for (let field in user)
        if (field !== "confirmPass") form.append(field, user[field]);

      form.append("avatar", avatar.current.files[0]);

      setLoading(true);
      let res = await Apis.post(endpoints["register"], form);
      if (res.status === 201) {
        nav("/login");
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
                <h1 className="text-center text-info mt-2">SIGNUP</h1>

                {err === null ? "" : <Alert variant="danger">{err}</Alert>}
                <Form onSubmit={register}>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>First Name</Form.Label>
                      <Form.Control
                        type="text"
                        onChange={(e) => change(e, "firstName")}
                        placeholder="First Name"
                        required
                      />
                    </Form.Group>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Last Name</Form.Label>
                      <Form.Control
                        type="text"
                        onChange={(e) => change(e, "lastName")}
                        placeholder="Last Name"
                        required
                      />
                    </Form.Group>
                  </Row>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Email</Form.Label>
                      <Form.Control
                        type="email"
                        onChange={(e) => change(e, "email")}
                        placeholder="Email"
                      />
                    </Form.Group>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Phone</Form.Label>
                      <Form.Control
                        type="tel"
                        onChange={(e) => change(e, "phone")}
                        placeholder="Phone"
                      />
                    </Form.Group>{" "}
                  </Row>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Username</Form.Label>
                      <Form.Control
                        value={user.username}
                        onChange={(e) => change(e, "username")}
                        type="text"
                        placeholder="Username"
                        required
                      />
                    </Form.Group>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Avatar</Form.Label>
                      <Form.Control type="file" ref={avatar} />
                    </Form.Group>{" "}
                  </Row>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Create Password</Form.Label>
                      <Form.Control
                        value={user.password}
                        onChange={(e) => change(e, "password")}
                        type="password"
                        placeholder="Create Password"
                        required
                      />
                    </Form.Group>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Confirm Password</Form.Label>
                      <Form.Control
                        value={user.confirmPass}
                        onChange={(e) => change(e, "confirmPass")}
                        type="password"
                        placeholder="Confirm Password"
                        required
                      />
                    </Form.Group>
                  </Row>
                  <Form.Group className="mb-3">
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
                  </Form.Group>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      {loading === true ? (
                        <MySpinner />
                      ) : (
                        <Button variant="info" type="submit">
                          Signup Now
                        </Button>
                      )}
                    </Form.Group>
                  </Row>
                </Form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Signup2;
