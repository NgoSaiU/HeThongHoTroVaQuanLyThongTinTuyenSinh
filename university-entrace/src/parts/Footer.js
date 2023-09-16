import React from "react";
import { Col, Container, ListGroup, Row } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faLocationPin,
  faPhoneFlip,
  faFax,
  faEnvelope,
} from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <>
      <div id="footer">
        <Container>
          <Row xl={3} sm={1} id="row-container">
            <Col>
              <h5 className="text-uppercase" id="title-footer">
                HaRuTa Company
              </h5>
              <ListGroup id="list">
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faLocationPin} id="item-icon" />
                  35-37 Hồ Hảo Hớn, P.Cô Giang, Q1, Tp.HCM
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faPhoneFlip} id="item-icon" />
                  028.39207627; 08.39300072
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faFax} id="item-icon" />
                  Hotline: 1800585884
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faEnvelope} id="item-icon" />
                  tuyensinh@ou.edu.vn
                </ListGroup.Item>
              </ListGroup>
            </Col>
            <Col>
              <h5 className="text-uppercase" id="title-footer">
                CƠ SỞ TRỰC THUỘC
              </h5>
              <ListGroup id="list">
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <Link className="text-decoration-none text-black" href="#">
                    Cơ sở 1: 97 Võ Văn Tần P6 Q3 Tp.HCM
                  </Link>
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <Link className="text-decoration-none text-black" href="#">
                    Cơ sở 2: 35-37 Hồ Hảo Hớn, Phường Cô Giang, Quận 1, Tp. Hồ
                    Chí Minh.
                  </Link>
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <Link className="text-decoration-none text-black" href="#">
                    Cơ sở 3: 371 Nguyễn Kiệm, Phường 3, Quận Gò Vấp, Tp. Hồ Chí
                    Minh.
                  </Link>
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <Link className="text-decoration-none text-black" href="#">
                    Cơ sở 4: 02 Mai Thị Lựu, Phường Đa Kao, Quận 1, Tp. Hồ Chí
                    Minh.
                  </Link>
                </ListGroup.Item>
              </ListGroup>
            </Col>
            <Col>
              <h5 className="text-uppercase" id="title-footer">
                HaRuTa Company
              </h5>
              <ListGroup id="list">
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faLocationPin} id="item-icon" />
                  35-37 Hồ Hảo Hớn, P.Cô Giang, Q1, Tp.HCM
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faPhoneFlip} id="item-icon" />
                  028.39207627; 08.39300072
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faFax} id="item-icon" />
                  Hotline: 1800585884
                </ListGroup.Item>
                <ListGroup.Item
                  className="bg-transparent border-0"
                  id="list-item"
                >
                  <FontAwesomeIcon icon={faEnvelope} id="item-icon" />
                  tuyensinh@ou.edu.vn
                </ListGroup.Item>
              </ListGroup>
            </Col>
          </Row>
        </Container>
        <div className="text-center mt-5 pt-3 pb-3" id="copyright">
          Copyright &copy;2023 All rights reserved | This is made by{" "}
          <i className="fa fa-heart color-danger"></i>
          <span> HaRuTa</span>.
        </div>
      </div>
    </>
  );
};

export default Footer;
