import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Apis, { endpoints } from "../configs/Apis";

const DepartmentDetail = () => {

    const { departmentId } = useParams();

    const [department, setDepartments] = useState(null);
    useEffect(() => {
        let loadDepartments = async () => {
            let { data } = await Apis.get(endpoints['departmentDetail'](departmentId));

            console.info(data);
            setDepartments(data);
        }
        loadDepartments();


    }, []);

    return (
        <>

            <h1 className="text-center text-info mt-2">CHI TIẾT KHOA({departmentId})</h1>
            <Row>

                <Col md={5} xs={6}>
                    <h2 className="text-danger">{newsD.title}</h2>
                    <p>{newsD.content}</p>
                </Col>

            </Row>
            <hr />
        </>
    );
}

export default DepartmentDetail;