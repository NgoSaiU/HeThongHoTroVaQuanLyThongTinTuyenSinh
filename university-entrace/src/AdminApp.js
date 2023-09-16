import React, { useState } from "react";
import NavAdmin from "./components/admin/NavAdmin";
import { Link } from "react-router-dom";
import Sidebar from "./components/admin/Sidebar";
import AdminRouter from "./routers/AdminRouter";

const   AdminApp = () => {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };
  return (
    <>
      <div className="admin">
        <div className="grid-container">
          <NavAdmin OpenSidebar={OpenSidebar} />
          <Sidebar
            openSidebarToggle={openSidebarToggle}
            OpenSidebar={OpenSidebar}
          />
          <AdminRouter />
        </div>
      </div>
    </>
  );
};

export default AdminApp;
