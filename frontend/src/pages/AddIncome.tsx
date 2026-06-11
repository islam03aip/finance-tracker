import { useState } from "react";
import { addIncome } from "../services/incomeService";
import { Link } from "react-router-dom";

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
        <div>
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
            <Link to="/income/all">
                Back to Income page
            </Link>
        </div>
    )
}

export default AddIncomePage;