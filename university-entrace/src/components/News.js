import React, { useEffect, useState } from "react";
import {Alert } from "react-bootstrap";
// import { Card, Col, Row } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "./MySpinner";
// import Moment from "react-moment";

const News = () => {
  const [news, setNews] = useState([]);

  // useEffect(() => {
  //   const loadNews = async () => {
  //     let res = await Apis.get(endpoints["news"]);
  //     setNews(res.data.slice(0, 4));
  //   };
  //   loadNews();
  // }, []);

  // if (news.length === 0) return <MySpinner />;

  // if (news === null)
  //   return <Alert variant="info" className="mt-5" >Không có tin tức nào</Alert>


  return (
    <>
    <h1>News</h1>
      {/* <Row className="pb-3">
        <h2 className="">Thông tin tuyển sinh</h2>
        <div>
          <Row id="row-content" lg={3}>
            {news.map((n) => {
              return (
                <Col>
                  <Card className="shadow-lg p-2">
                    <Card.Body d-flex>
                      <Card.Link href="#">{n.title}</Card.Link>
                      <Moment format="DD/MM/YYYY">{n.createdAt}</Moment>
                    </Card.Body>
                  </Card>
                </Col>
              );
            })}
          </Row>
        </div>
      </Row> */}
    </> 
  );
};

export default News;