import React from "react";
import { Link } from "react-router-dom";

function Sidebar({ openSidebarToggle, OpenSidebar }) {
  return (
    <aside
      id="sidebar"
      className={openSidebarToggle ? "sidebar-responsive" : ""}
    >
      <div className="sidebar-title">
        <div className="sidebar-brand">
          <i class="icon_header fas fa-id-card"></i> HARUTA
        </div>
        <span className="icon close_icon" onClick={OpenSidebar}>
          X
        </span>
      </div>

      <ul className="sidebar-list">
        <li className="sidebar-list-item">
          <Link to="/">
            <i className="fas fa-columns icon"></i> Dashboard
          </Link>
        </li>
        <li className="sidebar-list-item">
          <Link to="/banners">
            <i class="icon fas fa-archive"></i> Banners
          </Link>
        </li>
        <li className="sidebar-list-item">
          <Link to="/newsadmin">
            <i class="icon fas fa-th"></i> News
          </Link>
        </li>
        <li className="sidebar-list-item">
          <Link to="/useradmin">
            <i class="icon fas fa-users-cog"></i>Users
          </Link>
        </li>
      </ul>
    </aside>
  );
}

export default Sidebar;
