import React from "react";
import Banner from "../components/Banner";
import { Container } from "react-bootstrap";
import InfoSchool from "./InfoSchool";


const Home = () => {
  return (
    <>
      <Banner />
      <Container> 
        <InfoSchool />
      </Container>
    </>
  );
};

export default Home;
