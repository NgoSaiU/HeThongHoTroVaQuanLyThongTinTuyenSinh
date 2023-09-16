import React, { useEffect, useRef, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import Apis, { endpoints } from "../../configs/Apis";
import { Button, Col, Form, Row } from "react-bootstrap";
import MySpinner from "../../components/MySpinner";

const EditNews = () => {
  const { newsId } = useParams();
  const [news, setNews] = useState(null);
  const [rcm, setRcm] = useState([]);
  const [checked, setChecked] = useState(false);

  const [err, setErr] = useState(null);
  const [loading, setLoading] = useState(false);
  const avatar = useRef();
  const nav = useNavigate();

  const enable = (evt) => {
    setChecked(!checked);
  };

  useEffect(() => {
    const loadDpm = async () => {
      console.log(newsId);
      let e = endpoints["news"];
      if (newsId !== undefined) {
        e = `${e}?newsid=${newsId}`;
        let res = await Apis.get(e);
        setNews(res.data[0]);
        setChecked(Boolean(res.data[0].status));
      }
      e = endpoints["recruiments"];
      let res = await Apis.get(e);
      setRcm(res.data);
    };
    loadDpm();
  }, [newsId]);
  return (
    <>
      <main className="main-container sm">
        <div class="container">
          <div class="row">
            <div class="col-md-7 col-md-offset-4">
              <div class="form-container form-signup">
                <h1 className="text-center text-info mt-2">NEWS</h1>
                <Form>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Title</Form.Label>
                      <Form.Control
                        type="text"
                        placeholder="First Name"
                        defaultValue={news ? news.title : ""}
                        disabled={newsId === undefined ? false : true}
                        required
                      />
                    </Form.Group>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Content</Form.Label>
                      <Form.Control
                        type="text"
                        placeholder="Content"
                        defaultValue={news ? news.content : ""}
                        required
                      />
                    </Form.Group>
                  </Row>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      <Form.Label>Recruitment</Form.Label>
                      <Form.Select aria-label="Default select example">
                        {rcm.map((r) => {
                          return (
                            <option
                              value={r.id}
                              selected={r.id === news.id ? true : false}
                            >
                              {r.name}
                            </option>
                          );
                        })}
                      </Form.Select>
                    </Form.Group>
                    <Form.Group as={Col} className="mt-3">
                      <Form.Label>Status</Form.Label>
                      <div class="form-check form-switch">
                        <input
                          class="form-check-input"
                          type="checkbox"
                          role="switch"
                          id="active"
                          name="active"
                          onClick={enable}
                          checked={checked}
                        />
                      </div>
                    </Form.Group>
                  </Row>
                  <Row>
                    <Form.Group as={Col} className="mb-3">
                      {loading === true ? (
                        <MySpinner />
                      ) : (
                        <>
                          <Button variant="info" type="submit">
                            Submit
                          </Button>
                          <Link to="/newsadmin">
                            <Button className="ms-3" variant="danger">
                              Cancel
                            </Button>
                          </Link>
                        </>
                      )}
                    </Form.Group>
                  </Row>
                </Form>
              </div>
            </div>
          </div>
        </div>
      </main>
    </>
  );
};

export default EditNews;
