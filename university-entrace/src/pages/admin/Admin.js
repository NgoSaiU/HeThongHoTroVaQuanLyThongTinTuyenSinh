import React, { useEffect, useState } from "react";
import { Card, Col, Row } from "react-bootstrap";
import Apis, { endpoints } from "../../configs/Apis";
import {
  BarChart,
  Bar,
  Cell,
  XAxis,
  YAxis,
  CartesianGrid,
  Tooltip,
  Legend,
  ResponsiveContainer,
  LineChart,
  Line,
} from "recharts";

const Admin = () => {
  const [users, setUsers] = useState([]);
  const [cmts, setCmts] = useState([]);
  const [news, setNews] = useState([]);
  const data = [
    {
      name: "Jan",
      comment: 2400,
      amt: 2400,
    },
    {
      name: "Feb",
      comment: 1398,
      amt: 2210,
    },
    {
      name: "Mar",
      comment: 9800,
      amt: 2290,
    },
    {
      name: "Apr",
      comment: 3908,
      amt: 2000,
    },
    {
      name: "May",
      comment: 4800,
      amt: 2181,
    },
    {
      name: "Jun",
      comment: 3800,
      amt: 2500,
    },
    {
      name: "Jul",
      comment: 4300,
      amt: 2100,
    },
    {
      name: "Aug",
      comment: 4300,
      amt: 2100,
    },
    {
      name: "Sep",
      comment: 4300,
      amt: 2100,
    },
    {
      name: "Oct",
      comment: 4300,
      amt: 2100,
    },
    {
      name: "Nov",
      comment: 4300,
      amt: 2100,
    },
    {
      name: "Dec",
      comment: 4300,
      amt: 2100,
    },
  ];

  useEffect(() => {
    const loadDpm = async () => {
      let e = endpoints["count-users"];
      let res = await Apis.get(e);
      setUsers(res.data);
      e = endpoints["count-comments"];
      res = await Apis.get(e);
      setCmts(res.data);
      e = endpoints["count-news"];
      res = await Apis.get(e);
      setNews(res.data);
    };
    loadDpm();
  }, []);
  return (
    <>
      <main className="main-container">
        <div className="main-cards">
          <Col className="m-3">
            <Card>
              <Card.Header>
                <Card.Text>Users</Card.Text>
                <i class="icon fas fa-users"></i>
              </Card.Header>
              <Card.Body>
                <Card.Text>{users}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
          <Col className="m-3">
            <Card className="bg-success">
              <Card.Header>
                <Card.Text>Commenst</Card.Text>
                <i class="icon fas fa-comment-dots"></i>
              </Card.Header>
              <Card.Body>
                <Card.Text>{cmts}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
          <Col className="m-3">
            <Card className="bg-danger">
              <Card.Header>
                <Card.Text>News</Card.Text>
                <i class="icon fas fa-users"></i>
              </Card.Header>
              <Card.Body>
                <Card.Text>{news}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
        </div>
        <div className="charts">
          <ResponsiveContainer width="100%" height="100%">
            <BarChart
              width={500}
              height={300}
              data={data}
              margin={{
                top: 5,
                right: 30,
                left: 20,
                bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Bar dataKey="comment" fill="#8884d8" />
            </BarChart>
          </ResponsiveContainer>

          <ResponsiveContainer width="100%" height="100%">
            <LineChart
              width={500}
              height={300}
              data={data}
              margin={{
                top: 5,
                right: 30,
                left: 20,
                bottom: 5,
              }}
            >
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Line
                type="monotone"
                dataKey="amt"
                stroke="#8884d8"
                activeDot={{ r: 8 }}
              />
            </LineChart>
          </ResponsiveContainer>
        </div>
      </main>
    </>
  );
};

export default Admin;
