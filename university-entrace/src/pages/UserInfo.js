import { useContext, useState } from "react";
import { MyUserContext } from "../App";
import { Link } from "react-router-dom";
import { Button } from "react-bootstrap";

const UserInfor = () => {
  const [user, dispatch] = useContext(MyUserContext);
  const [isPasswordVisible, setIsPasswordVisible] = useState(false);
  console.log(user);
  const enable = (evt) => {
    setIsPasswordVisible(!isPasswordVisible);
  };
  //cập nhật thông tin người dùng
  return (
    <>
      <div class="form-bg">
        <div class="container">
          <div class="row">
            <div class="col-md-7 col-md-offset-4">
              <div class="form-container form-signup">
                <form class="form-horizontal">
                  <table className="table">
                    <tr>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>first name</label>
                          <input
                            class="form-control"
                            type="text"
                            placeholder="Tên"
                            value={user.firstName}
                            disabled
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>last name</label>
                          <input
                            class="form-control"
                            type="text"
                            placeholder="Họ và chữ lót"
                            value={user.lastName}
                            disabled
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
                            placeholder="Điện thoại"
                            value={user.phone}
                            disabled
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>Username</label>
                          <input
                            class="form-control"
                            type="text"
                            placeholder="Tên đăng nhập"
                            value={user.username}
                            disabled
                          />
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <div class="form-group bg-transparent">
                          <label>email</label>
                          <input
                            class="form-control"
                            type="email"
                            placeholder="Email"
                            value={user.email}
                            disabled
                          />
                        </div>
                      </td>
                      <td>
                        <div class="form-group bg-transparent">
                          <div className="d-flex align-items-center">
                            <label>Password</label>

                            <div class="ms-2 form-check form-switch">
                              <input
                                class="form-check-input"
                                type="checkbox"
                                role="switch"
                                id="active"
                                name="active"
                                onClick={enable}
                                checked={isPasswordVisible}
                              />
                            </div>
                          </div>
                          <input
                            class="form-control"
                            type={isPasswordVisible ? "text" : "password"}
                            placeholder="Mật khẩu"
                            value={user.password}
                            disabled
                          />
                        </div>
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

export default UserInfor;
