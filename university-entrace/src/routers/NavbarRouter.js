import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "../pages/Home";
import Departments from "../pages/Departments";
import Admissions from "../pages/Admissions";
import Programs from "../pages/Programs";
import Contact from "../pages/Contact";
import Login from "../pages/Login";
import Signup from "../pages/Signup";
import Signup2 from "../pages/Signup2";
import UserAdmin from "../pages/admin/UserAdmin";
import AppLoginAndRegister from "../pages/Login_Register";
import UserInfor from "../pages/UserInfo";
import AdmissionDetails from "../pages/AdmissionDetail";
import AdmisNewsComments from "../pages/AdmisNewsComments";
import DepartmentDetail from "../pages/DepartmentDetail";
// import HomeAdmin from "../pages/admin/HomeAdmin";

const NavbarRouter = () => {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="admissions" element={<Admissions />} />

        <Route path="admissions/:admissionId" element={<AdmissionDetails />} />

        <Route
          path="admissions/:admissionId/news/:newsId"
          element={<AdmisNewsComments />}
        />
        
        <Route path="department/:departmentId" element={<DepartmentDetail />} />
        <Route path="programs" element={<Programs />} />
        <Route path="departments" element={<Departments />} />
        <Route path="contact" element={<Contact />} />

        <Route path="login" element={<Login />} />

        <Route path="LoginAndRegister" element={<AppLoginAndRegister />} />
        <Route path="signup" element={<Signup />} />
        <Route path="signup2" element={<Signup2 />} />
        <Route path="useradmin" element={<UserAdmin />} />
        <Route path="user_info" element={<UserInfor />} />
        {/* <Route path="homeAdmin" element={<HomeAdmin />} /> */}
      </Routes>
    </>
  );
};

export default NavbarRouter;
