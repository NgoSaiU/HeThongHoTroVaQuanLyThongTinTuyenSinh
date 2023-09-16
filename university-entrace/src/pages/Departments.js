import React, { useEffect, useState } from "react";
import { ListGroup } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../components/MySpinner";
import { Link } from "react-router-dom";

const Departments = () => {

  const [departments, setDepartments] = useState(null);

  useEffect(() => {
    let loadDpm = async () => {
      let res = await Apis.get(endpoints["departments"]);

      // console.log(res.data);

      setDepartments(res.data);
    }
    loadDpm();
  }, []);


  if (departments === null)
    return <MySpinner />

  // if (departments.length === 0) return <MySpinner />;


  return (
    <>
      <div className="container">
        <ListGroup>
          {departments.map((d) => {
            let h = `/department/${d.id}`;
            return (
              <Link to = {h}>
                <ListGroup.Item style={{ textDecoration: 'none' }} key={d.departmentId} className="hover">
                  {d.name}
                </ListGroup.Item>
              </Link>
            );
          })}
        </ListGroup>
      </div>

    </>
  );
};

export default Departments;
