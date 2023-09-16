import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/backend-university-entrance";
// const SERVER = "http://localhost:8080";
const SERVER = "http://localhost:8088";

export const endpoints = {
  departments: `${SERVER_CONTEXT}/api/departments`,
  departmentDetail: (departmentId) => `${SERVER_CONTEXT}/api/departments/${departmentId}/`,
  livestreams: `${SERVER_CONTEXT}/api/livestreams`,
  users: `${SERVER_CONTEXT}/api/users`,
  deleteU: `${SERVER_CONTEXT}/api/users/users/delete`,
  "count-users": `${SERVER_CONTEXT}/api/countusers`,
  "count-comments": `${SERVER_CONTEXT}/api/countcomments`,
  banners: `${SERVER_CONTEXT}/api/banners`,
  "banners-full": `${SERVER_CONTEXT}/api/bannersFull`, 
  news: `${SERVER_CONTEXT}/api/news`,
  "count-news": `${SERVER_CONTEXT}/api/countnews`,
  login: `${SERVER_CONTEXT}/api/login/`,
  register: `${SERVER_CONTEXT}/api/users/`,
  "current-user": `${SERVER_CONTEXT}/api/current-user/`,
  "user-register": `${SERVER_CONTEXT}/api/user-register/`,
  recruiments: `${SERVER_CONTEXT}/api/recruiments/`,
  listNews: (admissionId) =>
    `${SERVER_CONTEXT}/api/recruiments/${admissionId}/news/`,
  listComments: (newsId) => `${SERVER_CONTEXT}/api/comment_news/${newsId}/`, //danh sách các comments trong từng news
  newsDetails: (newsId) => `${SERVER_CONTEXT}/api/news/${newsId}/`, //chi tiết news
  "add-comment":(newsId,userId) => `${SERVER_CONTEXT}/api/add-comment/${newsId}/${userId}/`, //them comments
};

//api có chứng thực
export const authApi = () => {
  return axios.create({
    baseURL: SERVER,
    headers: {
      Authorization: cookie.load("token"),
    },
  });
};

export const deleteUser = (userId) => {
  return axios.delete(`${SERVER}${SERVER_CONTEXT}/api/users/delete/${userId}/`);
};

export const updateBanner = (bannerid, rid, data) => {
  console.log(data);
  return axios.put(
    `${SERVER}${SERVER_CONTEXT}/api/update-banner/${rid}/${bannerid}/`
  );
};

export default axios.create({
  baseURL: SERVER,
});
