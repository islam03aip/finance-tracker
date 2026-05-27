import { useEffect, useState } from "react"
import { getAllSpending } from "../services/spendingService"
import { Link, useNavigate } from "react-router-dom";
import { deleteSpending } from "../services/spendingService";

const SpendingsPage = () => {
    const [spendings, setSpendings] = useState([]);
    const navigate = useNavigate();
    const handleDelete = async (id:Number) => {
        try {
            await deleteSpending(Number(id));
        } catch(error){
            console.error(error);
        }
        navigate(0);
    }
    useEffect(() => {
        const fetchData = async () => {
            const data = await getAllSpending();
            setSpendings(data);
        };
        fetchData();
    }, []);

    return (
        <div>
            <h1>Spendings</h1>
            {spendings.map((s: any) => (
                <div key={s.id}>
                    <Link to={`/spending/${s.id}`}>
                        {s.name} - {s.amount} - {s.category?.name};
                    </Link>
                    <button onClick={() => handleDelete(s.id)}>Delete</button>
                </div>
            ))}
            <Link to = "/spending/create">Add Spending</Link>
        </div>
    );
};

export default SpendingsPage;