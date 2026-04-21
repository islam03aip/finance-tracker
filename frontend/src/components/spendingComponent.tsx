import { useEffect, useState } from "react"
import { getAllSpending } from "../services/spendingService"

const SpendingPage = () => {
    const [spendings, setSpendings] = useState([]);
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
                    {s.name} - {s.amount};
                </div>
            ))}
        </div>
    );
};

export default SpendingPage;