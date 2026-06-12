import { api } from "./api";

export const getAllSpending = async () => {
    const response = await api.get("/spending/all");
    return response.data;
};
export const createSpending = async (data : any) => {
    const response = await api.post("/spending/create", data);
    return response.data;
};
export const updateSpending = async (spendingId: number, data : any) => {
    const response = await api.post(`/spending/update/${spendingId}`, data);
    return response.data;
};
export const getSpending = async (spendingId: number) => {
    const response = await api.get(`/spending/${spendingId}`);
    return response.data;
};
export const deleteSpending = async (spendingId: number) => {
    await api.post(`/spending/delete/${spendingId}`);
};
export const getSpendingsByCategory = async(categoryId: number) => {
    const response = await api.get(`spending/category/${categoryId}`);
    return response.data;
}