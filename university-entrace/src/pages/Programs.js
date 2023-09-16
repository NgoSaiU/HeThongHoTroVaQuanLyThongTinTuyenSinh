import React, { useEffect, useState } from "react";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../components/MySpinner";
import { ListGroup } from "react-bootstrap";

const Programs = () => {

  const [livestreams, setLivestreams] = useState(null);


  useEffect(() => {
    let loadLivestream = async () => {
      let res = await Apis.get(endpoints["livestreams"]);

      // console.log(res.data);

      setLivestreams(res.data);
    }
    loadLivestream();
  }, []);


  if (livestreams === null)
    return <MySpinner />
    
  return (
    <>
      <div className="container">
        <ListGroup>
          {livestreams.map((d) => {
            return (
              <ListGroup.Item key={d.livestreamsId} className="hover">
                {d.name}
              </ListGroup.Item>
            );
          })}
        </ListGroup>
      </div>

    </>
  );
};

export default Programs;
