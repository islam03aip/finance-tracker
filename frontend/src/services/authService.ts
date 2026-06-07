import { api } from "./api";

export const addUser = async(data:any) =>{
    const response = await api.post("/api/auth/register", data);
    return response.data;
}

export const loginUser = async(data:any) =>{
    const response = await api.post("/api/auth/login", data);
    return response.data;
}

export const getReqUser = async() => {
    const response = await api.get("/api/auth/me");
    return response.data;
}

export const logout = async() => {
    const response = await api.post("/api/auth/logout");
    return response.data;
}

export const getUserStatus = async() => {
    const response = await api.get("/api/auth/status");
    return response.data;
}