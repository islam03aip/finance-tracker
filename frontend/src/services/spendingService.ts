import { api } from "./api";

export const getAllSpending = async() => {
    const response = await api.get("/spending/all");
    return response.data;
}