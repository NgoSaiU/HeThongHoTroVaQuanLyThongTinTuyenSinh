import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../App";
import { Link, useParams } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";
import MySpinner from "../components/MySpinner";
import { Card, Col, Row } from "react-bootstrap";

const AdmissionDetails = () => {

    // const [user,] = useContext(MyUserContext);
    const { admissionId } = useParams(); //id cua recruiment
    // const [product, setProduct] = useState(null); //danh sachh cac news
    const [news, setNews] = useState(null); //danh sach cac news

    useEffect(() => {
        let loadNews = async () => {
            // let { data } = await Apis.get(endpoints['listNews'](admissionId));
            // setProduct(data);

            let res = await Apis.get(endpoints['listNews'](admissionId));

            console.log(res.data);

            setNews(res.data);
        }
        loadNews();

    }, []);

    if (news === null)
        return <MySpinner />


    return <>
        <div className="container">

  
     
        <Row>
            {news.map(p => {
                let h = `/admissions/${admissionId}/news/${p.id}`;
                
                return <Col xs={12} md={3}>
                    <Link to={h}>
                        <Card>
                            <Card.Img variant="top" src={p.image} />
                            <Card.Body>
                            <Card.Title>{p.title}</Card.Title>
                            <Card.Text>{p.content} </Card.Text>
                            </Card.Body>
                        </Card>
                    </Link>
                </Col>

            })}

        </Row>
        </div>

    </>

}

export default AdmissionDetails;