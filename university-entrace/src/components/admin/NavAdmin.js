import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { MyUserContext } from "../../App";

function NavAdmin({ OpenSidebar }) {
  const [user, dispatch] = useContext(MyUserContext);

  const logout = () => {
    dispatch({
      type: "logout",
    });
  };
  return (
    <header className="header">
      <div className="menu-icon">
        <i class="icon fas fa-school" onClick={OpenSidebar}></i>
      </div>
      <div className="header-left"></div>
      <div className="header-right">
        <ul class="navbar-nav mb-2 mb-lg-0">
          <li class="nav-item dropdown">
            <Link
              class="nav-link dropdown-toggle"
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
                <Link to="/" class="dropdown-item" onClick={logout}>
                  Logout
                </Link>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </header>
  );
}

export default NavAdmin;
