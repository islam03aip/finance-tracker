import { useState } from "react";
import { addIncome } from "../services/incomeService";

const AddIncomePage = () =>{
    const [amount, setAmount] = useState("");

    const handleSubmit = async(e:any) =>{
        e.preventDefault();

        const data ={
            amount: Number(amount)
        };

        try{
            await addIncome(data);
            alert("Income added!");
        }catch (error) {
            console.error(error);
        };
    }

    return(
        <form onSubmit={handleSubmit}>
            <input
            placeholder="Amount"
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            />
            <button type="submit">
                Add income
            </button>
        </form>
    )
}

export default AddIncomePage;