import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { getSpending, updateSpending } from "../services/spendingService";

const IndividualSpendingPage = () => {
    const { spendingId } = useParams();
    const [spending, setSpending] = useState<any>(null);
    const [name, setName] = useState("");
    const [amount, setAmount] = useState("");
    const [category, setCategory] = useState("");

    const handleUpdate = async(e : any) => {
            e.preventDefault();
    
            const data = {
                name,
                amount: Number(amount),
                category
            };
            try {
                await updateSpending(Number(spendingId), data);
                alert("Spending updated!");
            } catch (error) {
                console.error(error);
            }
    };

    useEffect(() => {
        const fetchData = async () => {
            if (!spendingId) return;

            try {
                const data = await getSpending(Number(spendingId));
                setSpending(data);

                setName(data.name);
                setAmount(data.amount);
            }catch(error){
                console.error(error);
            }
        };
        fetchData();
    }, [spendingId]);
    if (!spending) return <div>Not Found</div>;
    return (
        <div>
            <h1>{spending.name}</h1>
            <p>{spending.amount}</p>
            <p>{spending.category?.name}</p>
            <Link to="/spending/all">Back to Spendings Page</Link>
            <form onSubmit={handleUpdate}>
                <input 
                    type="text"
                    placeholder="Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <input 
                    type="number"
                    placeholder="Amount"
                    value={amount}
                    onChange={(e) => setAmount(e.target.value)}
                />
                <input 
                    type="text"
                    placeholder="Category"
                    value={category}
                    onChange={(e) => setCategory(e.target.value)}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default IndividualSpendingPage;