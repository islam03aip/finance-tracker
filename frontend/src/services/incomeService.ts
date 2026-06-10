import { api } from "./api"

export const getAllIncome = async() => {
    const response = await api.get("/income/all");
    return response.data;
}

export const addIncome = async(data:any) =>{
    const response = await api.post("/income/add", data);
    return response.data;
}

export const getIncome = async(incomeId:number) =>{
    const response = await api.get(`/income/${incomeId}`);
    return response.data;
}

export const updateIncome = async(data:any) =>{
    const response = await api.post(`/income/update/${data.incomeId}`, data);
    return response.data;
}

export const deleteIncome = async(incomeId:number) => {
    await api.post(`/income/delete/${incomeId}`);
}