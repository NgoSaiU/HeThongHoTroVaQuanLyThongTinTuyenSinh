import React from "react";
import Header from "./parts/Header";
import Footer from "./parts/Footer";
import NavbarRouter from "./routers/NavbarRouter";
import {} from "./assets/styles/global.scss";

const NormalApp = () => {
  return (
    <>
      <Header />
      <div id="content">
        <NavbarRouter />
      </div>
      <Footer />
    </>
  );
};

export default NormalApp;
