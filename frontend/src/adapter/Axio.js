import axios from "axios";
import { apiBaseUrl, local_url } from "../environment";

const defaultOptions = {
  baseURL: apiBaseUrl,
  headers: {
    "content-type": "application/json",
  },
};
const defaultOptions2 = {
  baseURL: local_url,
  headers: {
    "content-type": "application/json",
  },
};

const axiosInstance = axios.create(defaultOptions);
const axiosInstance2 = axios.create(defaultOptions2);
// axiosInstance.interceptors.request.use(function (config) {
//   const token = cookie.get("access_token");
//   config.headers["authorization"] = token ? `Bearer ${token}` : "";
//   return config;
// });

export const getPetMallData = (url) => {
  return axiosInstance2.get(`${url}`);
};
export const getData = (url) => {
  return axiosInstance.get(`${url}`);
};

export const postData = (url, requestData) => {
  return axiosInstance.post(`${url}`, requestData);
};

export const updateData = (url, requestData) => {
  return axiosInstance.put(`${url}`, requestData);
};

export const deleteData = (url) => {
  return axiosInstance.delete(`${url}`);
};

export const postPaginateData = (url) => {
  return axiosInstance.post(url, []);
};

export const getPaginateData = (url) => {
  return axiosInstance.get(url);
};

// export const removeToken = (key) => {
//   cookie.remove(key);
// };
