import { api } from "./api";

export const addUser = async(data:any) =>{
    const response = await api.post("/api/auth/register", data);
    return response.data;
}