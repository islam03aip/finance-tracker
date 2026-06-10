import { useEffect, useState } from "react"
import { useParams } from "react-router-dom";
import { getIncome, updateIncome } from "../services/incomeService";

const IndvidualIncomePage = () =>{
    const {incomeId} = useParams();
    const [income, setIncome] = useState<any>(null);
    const [amount, setAmount] = useState("");

    const handleUpdate = async(e:any) =>{
        e.preventDefault();

        const updateData = {
            incomeId: Number(incomeId),
            amount: Number(amount)
        }
        try{
            await updateIncome(updateData);
            alert("Income updated!");
        }catch(error) {
            console.error(error);
        }
    };
    useEffect(() => {
            const fetchData = async() =>{
                try{
                    const data = await getIncome(Number(incomeId));
                    setIncome(data);
                    setAmount(data.amount)
                }catch(error){
                    console.error(error);
                }
            }
            fetchData();
    }, [incomeId]);
    if(!income) return <div>Not Found</div>;
    return(
        <div>
            <p>Income info</p>
            <p>{income.amount}</p>
            <p>{income.createdAt}</p>

            <div>
                <form onSubmit={handleUpdate}>
                    <input 
                        placeholder="Amount"
                        value={amount}
                        type="number"
                        onChange={(e) => setAmount(e.target.value)}
                    />
                    <button type="submit">
                        Update Income
                    </button>
                </form>
            </div>
        </div>
    )
}

export default IndvidualIncomePage;