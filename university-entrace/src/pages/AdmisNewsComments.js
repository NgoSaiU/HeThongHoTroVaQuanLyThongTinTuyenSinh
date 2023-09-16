import { useContext, useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import Apis, { authApi, endpoints } from "../configs/Apis";
import { Button, Col, Form, ListGroup, Row } from "react-bootstrap";
import MySpinner from "../components/MySpinner";
import Moment from "react-moment";
import { MyUserContext } from "../App";

const AdmisNewsComments = () => {

    const [user,] = useContext(MyUserContext);

    const { admissionId } = useParams();
    const { newsId } = useParams();

    const [comments, setComments] = useState(null);
    const [newsD, setNewsD] = useState(null);
    const [contentComment, setContentComment] = useState();


    useEffect(() => {
        let loadNews = async () => {
            let { data } = await Apis.get(endpoints['newsDetails'](newsId));

            console.info(data);
            setNewsD(data);
        }

        let loadComments = async () => {
            let { data } = await Apis.get(endpoints['listComments'](newsId));

            console.info(data);
            setComments(data);
        }

        loadComments();
       loadNews();
 
    }, []);

    const addComment = () => {
        const process = async () => {
            let { data } = await authApi().post(endpoints['add-comment'](newsId, user.id), {
                "content": contentComment,
                "news": newsD.id
            });

            setComments([...comments, data]);
        }

        process();
    }
    if (newsD === null)
        return <MySpinner />;

    // if (comments === null)
    //     return <MySpinner />;

    let url = `/Login?next=/admissions/${admissionId}/news/${newsId}`; //quay lai trang hienj tai

    return <>
        < div className="container">

         

            hien thi thong tin chi tiet news va nhung binh luan cua no
            <h1 className="text-center text-info mt-2">CHI TIẾT SẢN PHẨM ({newsId})</h1>
            <Row>

                <Col md={5} xs={6}>
                    <h2 className="text-danger">{newsD.title}</h2>
                    <p>{newsD.content}</p>
                </Col>

            </Row>
            <hr />



            {user === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để bình luận! </p> : <>
                <Form.Control as="textarea" aria-label="With textarea" value={contentComment} onChange={e => setContentComment(e.target.value)} placeholder="Nội dung bình luận" />
                <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>
            </>}
            <hr />


            <ListGroup>
                {comments === null ? (
                    <>
                        <h3>Không có bình  luận</h3>
                    </>
                ) : (
                    <>
                        {comments.map((c) => <ListGroup.Item id={c.id}>
                            {c.userId.lastName} {c.userId.firstName}- {c.content} - <Moment locale="vi" fromNow>{c.createdDate}</Moment>
                        </ListGroup.Item>)
                        }
                    </>
                )}
            </ListGroup>


        </div>
    </>

}

export default AdmisNewsComments;