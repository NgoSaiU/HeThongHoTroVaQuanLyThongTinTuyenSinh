import { Image } from "react-bootstrap";

const InfoSchool = () => {

    const imageStyle = {
        maxWidth: '100%',
        height: 'auto',
    };

    return (
        <>
            <h2>GIỚI THIỆU CHUNG</h2>
            <p>Được thành lập vào năm 1990 và trở thành trường đại học công lập từ năm 2006, đến nay Trường Đại học Mở Thành phố Hồ Chí Minh là trường đại học đa ngành trực thuộc Bộ Giáo dục và Đào tạo, có nhiệm vụ đào tạo đại học và sau đại học, với các hình thức đào tạo chính quy và giáo dục thường xuyên, đào tạo các điểm vệ tinh,…nhằm đáp ứng nhu cầu học tập đa dạng của xã hội, góp phần tăng cường đội ngũ cán bộ khoa học-kỹ thuật cho đất nước.</p>
            
            <img style={imageStyle} src= "https://ou.edu.vn/wp-content/uploads/2022/09/Sumang-TNOU2022.png"></img>
        </>

    );

}

export default InfoSchool;