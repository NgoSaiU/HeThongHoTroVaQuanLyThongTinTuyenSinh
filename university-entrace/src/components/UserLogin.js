import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { MyUserContext } from "../App";
import { Button } from "react-bootstrap";

const UserLogin = () => {
  const [user, dispatch] = useContext(MyUserContext);

  const logout = () => {
    dispatch({
      type: "logout",
    });
  };

  // if (user !== null) {
  //   let next = q.get("next") || "/";
  //   return <Navigate to={next} />
  // }

  return (
    <>
      {/* <div>
        {user === null ? <Link to="/login2">Đăng nhập</Link> :<>
          <Link to="/">Chao</Link>
          <Button> Đăng xuất</Button>

        </>}
        </div> */}

      {/* <Link to="/login3">

        {user === null ? <i class="fas fa-sign-in"></i> : <>
          <i class="fas fa-sign-out-alt" onClick={logout} to ="/" > Chao {user.username}</i>


        </>}
      </Link> */}

      {user === null ? (
        <>
          <Link to="/login">
            <i class="fas fa-sign-in"></i>
          </Link>
        </>
      ) : (
        <>
          <ul class="navbar-nav mb-2 mb-lg-0">
            <li class="nav-item dropdown">
              <Link
                class="nav-link"
                href="#"
                id="navbarDropdown"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                <i class="icon fas fa-user"></i>
              </Link>
              <ul
                class="dropdown-menu dropdown-menu-end"
                aria-labelledby="navbarDropdown"
              >
                <li>
                  <Link class="dropdown-item" href="#">
                    Change Password
                  </Link>
                </li>
                <li>
                  <Link class="dropdown-item" to="user_info">
                    Thông tin cá nhân
                  </Link>
                </li>
                <li>
                  <Link to="/" class="dropdown-item" onClick={logout}>
                    Logout
                  </Link>
                </li>
              </ul>
            </li>
          </ul>
        </>
      )}
    </>
  );
};

export default UserLogin;
