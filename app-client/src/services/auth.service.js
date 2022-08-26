import axios from "axios";
import authHeader from "./auth-header";

const BASE_API_URL = "http://localhost:8080/";
const API_URL = "http://localhost:8080/api/auth/";

const register = (username, email, password) => {
    return axios.post(API_URL + "signup", {
        username,
        email,
        password,
    });
};
const login = (username, password) => {
    return axios
        .post(API_URL + "signin", {
            username,
            password,
        })
        .then((response) => {
            // if (response.data.accessToken) {
            // console.log(response.data);
            localStorage.setItem("user", JSON.stringify(response.data));

            // }
            return response.data;
        });
};
const logout = () => {
    localStorage.removeItem("user");
};
const getCurrentUser = () => {
    return axios.get(BASE_API_URL + "api/users/profile", { headers: authHeader() })
    // return JSON.parse(localStorage.getItem("user"));
};
const AuthService = {
    register,
    login,
    logout,
    getCurrentUser,
};
export default AuthService;